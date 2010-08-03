/**
 * 
 */
package org.coode.oppl.lint;

import java.util.Collection;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owl.lint.Lint;
import org.semanticweb.owl.lint.LintException;
import org.semanticweb.owl.lint.LintReport;
import org.semanticweb.owl.lint.LintVisitor;
import org.semanticweb.owl.lint.LintVisitorEx;
import org.semanticweb.owl.lint.configuration.LintConfiguration;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

import uk.ac.manchester.cs.owl.lint.commons.NonConfigurableLintConfiguration;
import uk.ac.manchester.cs.owl.lint.commons.SimpleMatchBasedLintReport;

/**
 * An OPPL Script that can be used as a basis for the LInt
 * 
 * @author Luigi Iannone
 * 
 */
public class OPPLLintScript implements Lint<OWLObject> {
	private String name;
	private final String description;
	private final OPPLScript opplScript;
	private final Variable returnVariable;
	private final OWLOntologyManager ontologyManager;
	private final String explanationTemplate;

	/**
	 * @param opplScript
	 * @param returnVariable
	 */
	public OPPLLintScript(String name, OPPLScript opplScript, Variable returnVariable,
			String description, String explanationTemplate, OWLOntologyManager ontologyManager) {
		if (name == null) {
			throw new NullPointerException("The name cannot be null");
		}
		if (opplScript == null) {
			throw new NullPointerException("The OPPL Script cannot be null cannot be null");
		}
		if (returnVariable == null) {
			throw new NullPointerException("The return variable cannot be null");
		}
		if (description == null) {
			throw new NullPointerException("The description cannot be null");
		}
		if (explanationTemplate == null) {
			throw new NullPointerException("The explanation template cannot be null");
		}
		if (ontologyManager == null) {
			throw new NullPointerException("The ontology manager cannot be null");
		}
		this.name = name;
		this.opplScript = opplScript;
		this.returnVariable = returnVariable;
		this.description = description;
		this.explanationTemplate = explanationTemplate;
		this.ontologyManager = ontologyManager;
	}

	public Set<OWLObject> getDetectedObjects(OWLOntology ontology,
			OWLOntologyManager ontologyManager) throws OPPLException {
		this.getOPPLScript().getQuery().execute();
		Set<BindingNode> leaves = this.getOPPLScript().getConstraintSystem().getLeaves();
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		for (BindingNode leaf : leaves) {
			OWLObject assignmentValue = leaf.getAssignmentValue(this.getReturnVariable());
			toReturn.add(assignmentValue);
		}
		return toReturn;
	}

	public Variable getReturnVariable() {
		return this.returnVariable;
	}

	/**
	 * Retrieves the OPPLScript upon which this OPPLLintScript has beeen built.
	 * 
	 * @return an OPPLScript.
	 */
	public OPPLScript getOPPLScript() {
		return this.opplScript;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format(
				"%s; %s RETURN %s; %s ",
				this.getName(),
				this.getOPPLScript().render(),
				this.getReturnVariable().getName(),
				this.getDescription());
		return formatter.out().toString();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	/**
	 * @return the explanationTemplate
	 */
	public String getExplanationTemplate() {
		return this.explanationTemplate;
	}

	public void addVariable(Variable variable) {
		// Do nothing this method should go in th main OPPLScript interface
	}

	protected final String getExplanation(OWLObject object) {
		Variable returnVariable = this.getReturnVariable();
		this.getOPPLScript().getConstraintSystem().getLeaves();
		ManchesterSyntaxRenderer manchesterSyntaxRenderer = this.getOPPLScript().getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
				this.getOPPLScript().getConstraintSystem());
		object.accept(manchesterSyntaxRenderer);
		String toReturn = "IMPOSSIBLE TO GENERATE AN EXPLANATION FOR "
				+ manchesterSyntaxRenderer.toString();
		boolean found = false;
		// In theory each object should be matched only one but technically
		// there is no way to enforce that given the genericness of a script,
		// hence we will limit to consider the first match when generating the
		// explanation String
		Iterator<BindingNode> iterator = this.getOPPLScript().getConstraintSystem().getLeaves().iterator();
		while (!found && iterator.hasNext()) {
			BindingNode bindingNode = iterator.next();
			found = bindingNode.getAssignmentValue(returnVariable).equals(object);
			if (found) {
				toReturn = this.getExplanationTemplate();
				String replacement;
				for (Variable v : this.getOPPLScript().getVariables()) {
					manchesterSyntaxRenderer = this.getOPPLScript().getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
							this.getOPPLScript().getConstraintSystem());
					OWLObject assignmentValue = bindingNode.getAssignmentValue(v);
					if (assignmentValue == null) {
						replacement = "UNKNOWN VALUE FOR " + v.getName();
					} else {
						assignmentValue.accept(manchesterSyntaxRenderer);
						replacement = manchesterSyntaxRenderer.toString();
					}
					toReturn = toReturn.replaceAll("\\" + v.getName(), replacement);
				}
			}
		}
		return toReturn;
	}

	/**
	 * @see org.semanticweb.owl.lint.Lint#detected(java.util.Set)
	 */
	public LintReport<OWLObject> detected(Collection<? extends OWLOntology> targets)
			throws LintException {
		LintReport<OWLObject> toReturn = new SimpleMatchBasedLintReport<OWLObject>(this);
		for (OWLOntology ontology : targets) {
			Set<OWLObject> detectedObjects;
			try {
				detectedObjects = this.getDetectedObjects(ontology, this.getOntologyManager());
				for (OWLObject object : detectedObjects) {
					toReturn.add(object, ontology, this.getExplanation(object));
				}
			} catch (OPPLException e) {
				throw new LintException(e);
			}
		}
		return toReturn;
	}

	public void accept(LintVisitor visitor) {
		visitor.visitGenericLint(this);
	}

	public <P> P accept(LintVisitorEx<P> visitor) {
		return visitor.visitGenericLint(this);
	}

	public LintConfiguration getLintConfiguration() {
		return NonConfigurableLintConfiguration.getInstance();
	}
}

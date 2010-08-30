/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.patterns;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.OPPLScriptVisitor;
import org.coode.oppl.OPPLScriptVisitorEx;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.coode.oppl.variabletypes.CLASSVariable;
import org.coode.oppl.variabletypes.CONSTANTVariable;
import org.coode.oppl.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariable;
import org.coode.oppl.visitors.InputVariableCollector;
import org.coode.parsers.ErrorListener;
import org.coode.patterns.utils.Utils;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAnnotationAxiom;
import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLAxiomVisitorEx;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyExpression;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyExpression;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLPropertyExpression;
import org.semanticweb.owl.model.OWLPropertyRange;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.SWRLRule;
import org.semanticweb.owl.util.NamespaceUtil;

/**
 * @author Luigi Iannone
 * 
 *         Jun 10, 2008
 */
public class PatternModel implements OPPLScript, PatternOPPLScript {
	private final static class PatternOPPLScriptValidator implements
			OPPLScriptValidator {
		public PatternOPPLScriptValidator() {
		}

		public boolean accept(OPPLScript script) {
			boolean toReturn = script.getQuery() == null;
			if (toReturn) {
				List<OWLAxiomChange> actions = script.getActions();
				Iterator<OWLAxiomChange> it = actions.iterator();
				while (toReturn && it.hasNext()) {
					OWLAxiomChange action = it.next();
					toReturn = action instanceof AddAxiom;
				}
			}
			return toReturn;
		}

		public String getValidationRuleDescription() {
			return "The Script can only have ADD as its actions and cannot have any query";
		}
	}

	class ClassPatternDetector implements OWLAxiomVisitorEx<Boolean>,
			OPPLScriptVisitorEx<Boolean> {
		private OWLClass thisClass = PatternModel.this.ontologyManager
				.getOWLDataFactory().getOWLClass(
						PatternModel.this.getConstraintSystem()
								.getThisClassVariable().getURI());
		private boolean detected = false;

		public Boolean visit(OWLSubClassAxiom axiom) {
			return axiom.getSubClass().equals(this.thisClass);
		}

		public Boolean visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLReflexiveObjectPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLDisjointClassesAxiom axiom) {
			return axiom.getDescriptions().contains(this.thisClass);
		}

		public Boolean visit(OWLDataPropertyDomainAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLImportsDeclaration axiom) {
			return false;
		}

		public Boolean visit(OWLAxiomAnnotationAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLObjectPropertyDomainAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLEquivalentObjectPropertiesAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLDifferentIndividualsAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLDisjointDataPropertiesAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLDisjointObjectPropertiesAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLObjectPropertyRangeAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLObjectPropertyAssertionAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLFunctionalObjectPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLObjectSubPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLDisjointUnionAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLDeclarationAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLEntityAnnotationAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLOntologyAnnotationAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLSymmetricObjectPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLDataPropertyRangeAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLFunctionalDataPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLEquivalentDataPropertiesAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLClassAssertionAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLEquivalentClassesAxiom axiom) {
			return axiom.getDescriptions().contains(this.thisClass);
		}

		public Boolean visit(OWLDataPropertyAssertionAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLTransitiveObjectPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLDataSubPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLSameIndividualsAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
			return false;
		}

		public Boolean visit(OWLInverseObjectPropertiesAxiom axiom) {
			return false;
		}

		public Boolean visit(SWRLRule rule) {
			return false;
		}

		/**
		 * @return the detected
		 */
		public boolean isDetected() {
			return this.detected;
		}

		public Boolean visit(OPPLQuery q) {
			return false;
		}

		public Boolean visit(Variable v) {
			return false;
		}

		public Boolean visitActions(List<OWLAxiomChange> changes) {
			boolean found = false;
			Iterator<OWLAxiomChange> it = changes.iterator();
			while (!found && it.hasNext()) {
				found = it.next().getAxiom().accept(this);
			}
			return found;
		}

		public Boolean visit(OPPLQuery q, Boolean p) {
			return false;
		}

		public Boolean visit(Variable v, Boolean p) {
			return false;
		}

		public Boolean visitActions(List<OWLAxiomChange> changes, Boolean p) {
			boolean found = false;
			Iterator<OWLAxiomChange> it = changes.iterator();
			while (!found && it.hasNext()) {
				found = it.next().getAxiom().accept(this);
			}
			return found;
		}
	}

	/**
	 * Extracts the definition
	 * 
	 * @author Luigi Iannone
	 * 
	 *         Jun 26, 2008
	 */
	static class DefinitorialExtractor implements OWLAxiomVisitorEx<OWLObject>,
			OPPLScriptVisitorEx<OWLDescription> {
		protected OWLDescription extractedDescription = null;
		protected OWLPropertyExpression<? extends OWLPropertyExpression<?, ?>, ? extends OWLPropertyRange> extractedProperty = null;
		protected OWLObject owlObject;
		protected OWLDataFactory dataFactory;
		protected ReferenceReplacement referenceReplacement;
		protected VariableType variableType;

		public OWLObject getExtractedObject() {
			OWLObject toReturn = null;
			// TODO needs a different way to switch from case to visitor
			switch (this.variableType) {
			case CLASS:
				toReturn = this.extractedDescription;
				break;
			case OBJECTPROPERTY:
			case DATAPROPERTY:
				toReturn = this.extractedProperty;
				break;
			default:
				throw new RuntimeException("Unsupported variable type: "
						+ this.variableType
						+ " for pattern used in functional mode");
			}
			return toReturn;
		}

		/**
		 * @param owlObject
		 * @param referenceReplacement
		 * @param replacemnts
		 */
		public DefinitorialExtractor(OWLObject owlObject,
				VariableType variableType, OWLDataFactory dataFactory,
				ReferenceReplacement referenceReplacement) {
			this.owlObject = owlObject;
			this.dataFactory = dataFactory;
			this.referenceReplacement = referenceReplacement;
			this.variableType = variableType;
		}

		/**
		 * @return the extractedDescription
		 */
		public OWLDescription getExtractedDescription() {
			return this.extractedDescription;
		}

		public OWLDescription visit(OWLSubClassAxiom axiom) {
			// TODO Auto-generated method stub
			return null;
		}

		public OWLDescription visit(OWLEquivalentClassesAxiom axiom) {
			OWLDescription toReturn = null;
			if (this.variableType.equals(VariableType.CLASS)) {
				OWLEquivalentClassesAxiom replacedAxiom = (OWLEquivalentClassesAxiom) axiom
						.accept(this.referenceReplacement);
				Set<OWLDescription> descriptions = new HashSet<OWLDescription>(
						replacedAxiom.getDescriptions());
				descriptions.remove(this.owlObject);
				toReturn = !descriptions.isEmpty() ? descriptions.iterator()
						.next() : null;
			}
			return toReturn;
		}

		public OWLObject visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLReflexiveObjectPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDisjointClassesAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDataPropertyDomainAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLImportsDeclaration axiom) {
			return null;
		}

		public OWLObject visit(OWLAxiomAnnotationAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLObjectPropertyDomainAxiom axiom) {
			return null;
		}

		public OWLObjectPropertyExpression visit(
				OWLEquivalentObjectPropertiesAxiom axiom) {
			OWLObjectPropertyExpression toReturn = null;
			if (this.variableType.equals(VariableType.OBJECTPROPERTY)) {
				OWLEquivalentObjectPropertiesAxiom replacedAxiom = (OWLEquivalentObjectPropertiesAxiom) axiom
						.accept(this.referenceReplacement);
				Set<OWLObjectPropertyExpression> properties = new HashSet<OWLObjectPropertyExpression>(
						replacedAxiom.getProperties());
				properties.remove(this.owlObject);
				toReturn = !properties.isEmpty() ? properties.iterator().next()
						: null;
				this.extractedProperty = toReturn;
			}
			return toReturn;
		}

		public OWLObject visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDifferentIndividualsAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDisjointDataPropertiesAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDisjointObjectPropertiesAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLObjectPropertyRangeAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLObjectPropertyAssertionAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLFunctionalObjectPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLObjectSubPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDisjointUnionAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDeclarationAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLEntityAnnotationAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLOntologyAnnotationAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLSymmetricObjectPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDataPropertyRangeAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLFunctionalDataPropertyAxiom axiom) {
			return null;
		}

		public OWLDataPropertyExpression visit(
				OWLEquivalentDataPropertiesAxiom axiom) {
			OWLDataPropertyExpression toReturn = null;
			if (this.variableType.equals(VariableType.DATAPROPERTY)) {
				OWLEquivalentDataPropertiesAxiom replacedAxiom = (OWLEquivalentDataPropertiesAxiom) axiom
						.accept(this.referenceReplacement);
				Set<OWLDataPropertyExpression> properties = new HashSet<OWLDataPropertyExpression>(
						replacedAxiom.getProperties());
				properties.remove(this.owlObject);
				toReturn = !properties.isEmpty() ? properties.iterator().next()
						: null;
				this.extractedProperty = toReturn;
			}
			return toReturn;
		}

		public OWLObject visit(OWLClassAssertionAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDataPropertyAssertionAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLTransitiveObjectPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLDataSubPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLSameIndividualsAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
			return null;
		}

		public OWLObject visit(OWLInverseObjectPropertiesAxiom axiom) {
			return null;
		}

		public OWLObject visit(SWRLRule rule) {
			return null;
		}

		public OWLDescription visit(OPPLQuery q) {
			return null;
		}

		public OWLDescription visit(Variable v) {
			return null;
		}

		public OWLDescription visitActions(List<OWLAxiomChange> changes) {
			OWLDescription toReturn = null;
			for (OWLAxiomChange axiomChange : changes) {
				OWLAxiom axiom = axiomChange.getAxiom();
				OWLObject description = axiom.accept(this);
				toReturn = toReturn == null ? (OWLDescription) description
						: this.dataFactory.getOWLObjectIntersectionOf(toReturn,
								(OWLDescription) description);
			}
			return toReturn;
		}

		public OWLDescription visit(OPPLQuery q, OWLDescription p) {
			return null;
		}

		public OWLDescription visit(Variable v, OWLDescription p) {
			return null;
		}

		public OWLDescription visitActions(List<OWLAxiomChange> changes,
				OWLDescription p) {
			return this.visitActions(changes);
		}
	}

	static class ReplacementExtractor {
		public static List<List<Object>> permutations(
				List<List<Object>> elements) {
			return permutations(new ArrayList<Object>(), elements);
		}

		private static List<List<Object>> permutations(List<Object> path,
				List<List<Object>> elements) {
			List<List<Object>> toReturn = new ArrayList<List<Object>>();
			if (!elements.isEmpty()) {
				List<Object> elem = elements.iterator().next();
				elements.remove(elem);
				for (Object string : elem) {
					List<Object> newPath = new ArrayList<Object>(path);
					newPath.add(string);
					toReturn.addAll(permutations(newPath, elements));
				}
			} else {
				return new ArrayList<List<Object>>(Collections
						.singleton(new ArrayList<Object>(path)));
			}
			return toReturn;
		}
	}

	private List<PatternOPPLScript> dependencies = new ArrayList<PatternOPPLScript>();
	protected String rendering = null;
	private URI uri = null;
	private final OPPLScript opplStatement;
	private final OWLOntologyManager ontologyManager;
	protected boolean valid = true;
	private final Set<PatternModelChangeListener> listeners = new HashSet<PatternModelChangeListener>();
	protected String unresolvedOPPLStatementString = null;
	private Variable returnVariable = null;
	public final static String NAMESPACE = "http://www.co-ode.org/patterns#";
	protected final AbstractPatternModelFactory factory;

	public AbstractPatternModelFactory getPatternModelFactory() {
		return this.factory;
	}

	public OWLOntologyManager getOWLOntologyManager() {
		return this.ontologyManager;
	}

	public PatternModel(OPPLScript opplScript,
			OWLOntologyManager ontologyManager, AbstractPatternModelFactory f)
			throws UnsuitableOPPLScriptException {
		ArgCheck.checkNullArgument("The OPPL script", opplScript);
		ArgCheck.checkNullArgument("The ontology manager cannot be null",
				ontologyManager);
		if (!getScriptValidator().accept(opplScript)) {
			throw new UnsuitableOPPLScriptException(opplScript,
					getScriptValidator().getValidationRuleDescription());
		}
		this.opplStatement = opplScript;
		this.ontologyManager = ontologyManager;
		this.factory = f;
	}

	private final static OPPLScriptValidator SCRIPT_VALIDATOR = new PatternOPPLScriptValidator();

	public List<Variable> getVariables() {
		List<Variable> toReturn = new ArrayList<Variable>();
		if (this.opplStatement != null) {
			toReturn = this.opplStatement.getVariables();
		}
		return toReturn;
	}

	@Override
	public String toString() {
		// String statementRendering;
		// if (this.unresolvedOPPLStatementString == null) {
		// statementRendering = this.opplStatement.toString();
		// } else {
		// statementRendering = this.unresolvedOPPLStatementString;
		// }
		return this.opplStatement.toString() + " " + this.rendering;
	}

	/**
	 * @return the string rendering of this PatternModel. Override/use this
	 *         method in tools like Protege that have different strategies to
	 *         render OWL objects
	 */
	public String render() {
		StringBuffer buffer = new StringBuffer(this.getOpplStatement().render());
		buffer.append('\n');
		buffer.append(this.getRendering());
		Variable v = this.getReturnVariable();
		if (v != null) {
			buffer.append(";\n RETURN ");
			buffer.append(this.getConstraintSystem().render(v));
		}
		return buffer.toString();
	}

	/**
	 * @return the rendering
	 */
	public String getRendering() {
		return this.rendering;
	}

	/**
	 * @param rendering
	 *            the rendering to set
	 */
	public void setRendering(String rendering) {
		this.rendering = rendering;
		StringTokenizer tokenizer = new StringTokenizer(rendering, " \n\t\r\f");
		boolean foundUndefinedVariable = false;
		while (!foundUndefinedVariable && tokenizer.hasMoreTokens()) {
			String nextToken = tokenizer.nextToken();
			if (nextToken.startsWith("?")) {
				boolean found = false;
				Iterator<Variable> it = this.getVariables().iterator();
				while (!found && it.hasNext()) {
					Variable variable = it.next();
					found = variable.getName().equals(nextToken.trim());
				}
				foundUndefinedVariable = !found;
			}
		}
		this.valid = !foundUndefinedVariable;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return this.valid;
	}

	public void addChangeListener(PatternModelChangeListener l) {
		this.listeners.add(l);
	}

	public void removeChangeListener(PatternModelChangeListener l) {
		this.listeners.remove(l);
	}

	/**
	 * @return the uri
	 */
	public URI getUri() {
		return this.uri;
	}

	/**
	 * @param uri
	 *            the uri to set
	 */
	public void setUri(URI uri) {
		this.uri = uri;
	}

	/**
	 * @return the opplStatement
	 */
	public OPPLScript getOpplStatement() {
		return this.opplStatement;
	}

	public String getPatternLocalName() {
		String toReturn = null;
		if (this.uri != null) {
			NamespaceUtil nsUtil = new NamespaceUtil();
			String[] split = nsUtil.split(this.uri.toString(), null);
			if (split.length == 2) {
				toReturn = split[1];
			}
		}
		return toReturn;
	}

	public PatternConstraintSystem getConstraintSystem() {
		return this.opplStatement == null ? this.factory
				.createConstraintSystem()
				: (PatternConstraintSystem) this.opplStatement
						.getConstraintSystem();
	}

	public String getDefinitorialPortionStrings(List<List<Object>> replacements)
			throws PatternException {
		if (this.isFunctional()) {
			String toReturn = "";
			List<List<Object>> replacementTuples = ReplacementExtractor
					.permutations(replacements);
			List<OWLObject> replacedObjects = this
					.getDefinitorialPortions(replacementTuples);
			if (!replacedObjects.isEmpty()) {
				if (this.getReturnVariable().getType().equals(
						VariableType.CLASS)) {
					ManchesterSyntaxRenderer renderer = this.factory
							.getRenderer(this.getConstraintSystem());
					Set<OWLDescription> descriptions = new HashSet<OWLDescription>();
					for (OWLObject object : replacedObjects) {
						descriptions.add((OWLDescription) object);
					}
					this.ontologyManager.getOWLDataFactory()
							.getOWLObjectIntersectionOf(descriptions).accept(
									renderer);
					toReturn = renderer.toString();
				} else {
					for (OWLObject object : replacedObjects) {
						ManchesterSyntaxRenderer renderer = this.factory
								.getRenderer(this.getConstraintSystem());
						object.accept(renderer);
						toReturn += renderer.toString() + " ";
					}
				}
			}
			return toReturn.trim();
		} else {
			throw new NonFunctionalPatternException(this.getPatternLocalName());
		}
	}

	/**
	 * @param replacementTuples
	 * @param replacedObjects
	 * @throws PatternException
	 */
	public List<OWLObject> getDefinitorialPortions(
			List<List<Object>> replacementTuples) throws PatternException {
		List<OWLObject> toReturn = new ArrayList<OWLObject>();
		for (List<Object> tuple : replacementTuples) {
			ReferenceReplacement referenceReplacement = new ReferenceReplacement(
					this.getPatternLocalName(), this.getInputVariables(),
					tuple, this.getConstraintSystem(), this.ontologyManager
							.getOWLDataFactory());
			DefinitorialExtractor extractor = this.createDefinitorialExtractor(
					this.getReturnVariable(), referenceReplacement);
			OWLDescription extractedDescription = this.opplStatement
					.accept(extractor);
			if (extractedDescription != null) {
				toReturn.add(extractedDescription);
			}
		}
		return toReturn;
	}

	private DefinitorialExtractor createDefinitorialExtractor(
			Variable variable, ReferenceReplacement referenceReplacement) {
		final OWLDataFactory dataFactory = this.ontologyManager
				.getOWLDataFactory();
		OWLObject owlObject = null;
		VariableTypeVisitorEx<OWLObject> visitor = new VariableTypeVisitorEx<OWLObject>() {
			public OWLObject visit(SingleValueGeneratedVariable<?> v) {
				switch (v.getType()) {
				case CLASS:
					return dataFactory.getOWLClass(v.getURI());
				case DATAPROPERTY:
					return dataFactory.getOWLDataProperty(v.getURI());
				case OBJECTPROPERTY:
					return dataFactory.getOWLObjectProperty(v.getURI());
				case CONSTANT:
					throw new RuntimeException("Unsupported variable type: "
							+ v.getType()
							+ " for pattern used in functional mode");
				case INDIVIDUAL:
					throw new RuntimeException("Unsupported variable type: "
							+ v.getType()
							+ " for pattern used in functional mode");
				default:
					return null;
				}
				// XXX what's the correct behaviour here?
			}

			public OWLObject visit(INDIVIDUALVariable v) {
				throw new RuntimeException("Unsupported variable type: "
						+ v.getType() + " for pattern used in functional mode");
			}

			public OWLObject visit(DATAPROPERTYVariable v) {
				return dataFactory.getOWLDataProperty(v.getURI());
			}

			public OWLObject visit(OBJECTPROPERTYVariable v) {
				return dataFactory.getOWLObjectProperty(v.getURI());
			}

			public OWLObject visit(CONSTANTVariable v) {
				throw new RuntimeException("Unsupported variable type: "
						+ v.getType() + " for pattern used in functional mode");
			}

			public OWLObject visit(CLASSVariable v) {
				return dataFactory.getOWLClass(v.getURI());
			}
		};
		owlObject = variable.accept(visitor);
		// switch (v.getType()) {
		// case CLASS:
		// owlObject = dataFactory.getOWLClass(v.getURI());
		// break;
		// case OBJECTPROPERTY:
		// owlObject = dataFactory.getOWLObjectProperty(v.getURI());
		// break;
		// case DATAPROPERTY:
		// owlObject = dataFactory.getOWLDataProperty(v.getURI());
		// break;
		// default:
		// throw new RuntimeException("Unsupported variable type: "
		// + v.getType() + " for pattern used in functional mode");
		// }
		return new DefinitorialExtractor(owlObject, variable.getType(),
				dataFactory, referenceReplacement);
	}

	public void setUnresolvedOPPLStatement(String unresolvedString) {
		this.unresolvedOPPLStatementString = unresolvedString;
	}

	/**
	 * @param patternModel
	 * @return true if this PatternModel instance depends on the input one,
	 *         false otherwise
	 */
	public boolean dependsOn(PatternOPPLScript patternModel) {
		boolean toReturn = this.isDependent();
		if (toReturn) {
			toReturn = false;
			Iterator<PatternOPPLScript> it = this.dependencies.iterator();
			while (!toReturn && it.hasNext()) {
				PatternOPPLScript aPatternModel = it.next();
				toReturn = aPatternModel.getName().equals(
						patternModel.getName())
						|| aPatternModel.dependsOn(patternModel);
			}
		}
		return toReturn;
	}

	public boolean isDependent() {
		return !this.dependencies.isEmpty();
	}

	/**
	 * @param ontologies
	 * @return the set of PatternModel instances that depend on this. Please
	 *         notice that InstantiatedPatternModel instances will be returned
	 *         as well
	 */
	public Set<PatternOPPLScript> getDependingPatterns(
			Set<OWLOntology> ontologies, ErrorListener errorListener) {
		Set<PatternOPPLScript> toReturn = new HashSet<PatternOPPLScript>();
		for (OWLOntology ontology : ontologies) {
			Set<PatternModel> existingPatterns = Utils.getExistingPatterns(
					ontology, this.factory);
			for (PatternModel patternModel : existingPatterns) {
				if (patternModel.dependsOn(this)) {
					toReturn.add(patternModel);
					toReturn.addAll(patternModel
							.getInstantiations(errorListener));
				}
			}
		}
		toReturn.addAll(this.getInstantiations(errorListener));
		return toReturn;
	}

	public Set<InstantiatedPatternModel> getInstantiations(
			ErrorListener errorListener) {
		Set<InstantiatedPatternModel> toReturn = new HashSet<InstantiatedPatternModel>();
		Set<OWLOntology> ontologies = this.ontologyManager.getOntologies();
		PatternExtractor patternExtractor = this.factory
				.getPatternExtractor(errorListener);
		for (OWLOntology ontology : ontologies) {
			Set<OWLClass> referencedClasses = ontology.getReferencedClasses();
			for (OWLClass owlClass : referencedClasses) {
				Set<OWLAnnotationAxiom> annotationAxioms = owlClass
						.getAnnotationAxioms(ontology);
				for (OWLAnnotationAxiom annotationAxiom : annotationAxioms) {
					OPPLScript extractedPatternModel = (OPPLScript) annotationAxiom
							.getAnnotation().accept(patternExtractor);
					if (extractedPatternModel != null
							&& extractedPatternModel instanceof InstantiatedPatternModel
							&& ((InstantiatedPatternModel) extractedPatternModel)
									.getInstantiatedPatternLocalName().equals(
											this.getPatternLocalName())) {
						toReturn
								.add((InstantiatedPatternModel) extractedPatternModel);
					}
				}
			}
		}
		return toReturn;
	}

	public Set<? extends OWLAxiom> getOWLAxioms(OWLOntology ontology,
			ErrorListener errorListener) {
		Set<OWLOntologyAnnotationAxiom> toReturn = new HashSet<OWLOntologyAnnotationAxiom>();
		boolean found = false;
		OWLOntologyAnnotationAxiom ontologyAnnotationAxiom = null;
		Iterator<OWLOntologyAnnotationAxiom> annotationIterator = ontology
				.getOntologyAnnotationAxioms().iterator();
		while (!found && annotationIterator.hasNext()) {
			ontologyAnnotationAxiom = annotationIterator.next();
			found = this.uri.equals(ontologyAnnotationAxiom.getAnnotation()
					.getAnnotationURI());
		}
		if (found) {
			toReturn.add(ontologyAnnotationAxiom);
		}
		return toReturn;
	}

	public OWLOntology getOriginatingOntology() {
		OWLOntology toReturn = null;
		Set<OWLOntology> ontologies = this.ontologyManager.getOntologies();
		boolean found = false;
		Iterator<OWLOntology> it = ontologies.iterator();
		OWLOntology ontology = null;
		OWLOntologyAnnotationAxiom ontologyAnnotationAxiom = null;
		while (!found && it.hasNext()) {
			ontology = it.next();
			Iterator<OWLOntologyAnnotationAxiom> annotationIterator = ontology
					.getOntologyAnnotationAxioms().iterator();
			while (!found && annotationIterator.hasNext()) {
				ontologyAnnotationAxiom = annotationIterator.next();
				found = this.uri.equals(ontologyAnnotationAxiom.getAnnotation()
						.getAnnotationURI());
			}
		}
		if (found) {
			toReturn = ontology;
		}
		return toReturn;
	}

	/**
	 * Sets the return variable
	 * 
	 * @param returnVariable
	 */
	public void setReturnVariable(Variable returnVariable) {
		this.returnVariable = returnVariable;
	}

	/**
	 * @return the returnVariable
	 */
	public Variable getReturnVariable() {
		return this.returnVariable;
	}

	/**
	 * @return true if the patterns returns a value, false otherwise
	 */
	public boolean isFunctional() {
		return this.returnVariable != null;
	}

	/**
	 * @return true if the pattern is applicable to OWL classes (must edit the
	 *         semantics of the class it applies to), false otherwise
	 */
	public boolean isClassPattern() {
		ClassPatternDetector classPatternDetector = new ClassPatternDetector();
		return this.accept(classPatternDetector);
	}

	/**
	 * 
	 * @return the pattern local name
	 * @see org.coode.oppl.OPPLScript#getName()
	 */
	public String getName() {
		return this.getPatternLocalName();
	}

	public void addDependency(PatternOPPLScript dependency) {
		this.dependencies.add(dependency);
	}

	public List<Variable> getInputVariables() {
		InputVariableCollector visitor = new InputVariableCollector(
				new ArrayList<Variable>());
		for (Variable variable : this.getVariables()) {
			variable.accept(visitor);
		}
		return visitor.getCollectedVariables();
	}

	public boolean hasScopedVariables() {
		List<Variable> variables = this.getVariables();
		Iterator<Variable> it = variables.iterator();
		boolean found = false;
		while (!found && it.hasNext()) {
			Variable v = it.next();
			found = v.getVariableScope() != null;
		}
		return found;
	}

	public void accept(OPPLScriptVisitor visitor) {
		this.getOpplStatement().accept(visitor);
	}

	public <P> P accept(OPPLScriptVisitorEx<P> visitor) {
		return this.getOpplStatement().accept(visitor);
	}

	public List<OWLAxiomChange> getActions() {
		return this.getOpplStatement().getActions();
	}

	public OPPLQuery getQuery() {
		return this.getOpplStatement().getQuery();
	}

	@Deprecated
	public void addVariable(Variable variable) {
		if (this.opplStatement != null) {
			this.opplStatement.addVariable(variable);
		}
	}

	/**
	 * @return the scriptValidator
	 */
	public static final OPPLScriptValidator getScriptValidator() {
		return SCRIPT_VALIDATOR;
	}
}

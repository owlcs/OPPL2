/**
 * 
 */
package org.coode.oppl.utils;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeVisitor;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.model.RemoveImport;
import org.semanticweb.owlapi.model.RemoveOntologyAnnotation;
import org.semanticweb.owlapi.model.SetOntologyID;

/**
 * Utility class for collecting the evaluation results and dumping them into a
 * String
 * 
 * @author Luigi Iannone
 * 
 */
public class EvaluationResults {
	private final class ChangeRenderer implements OWLOntologyChangeVisitor {
		private String rendered = "";

		public void visit(AddAxiom change) {
			rendered = "";
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			String renderedString = renderAxiom(change.getAxiom());
			formatter.format("ADD %s", renderedString);
			rendered = out.toString();
		}

		/**
		 * @param change
		 * @return
		 */
		private String renderAxiom(OWLAxiom axiom) {
			rendered = "";
			ManchesterSyntaxRenderer renderer = getOpplScript().getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
					getOpplScript().getConstraintSystem());
			axiom.accept(renderer);
			String renderedString = renderer.toString();
			return renderedString;
		}

		public void visit(RemoveAxiom change) {
			rendered = "";
			Formatter formatter = new Formatter();
			String renderedString = renderAxiom(change.getAxiom());
			formatter.format("REMOVE %s", renderedString);
			rendered = formatter.toString();
		}

		public void visit(SetOntologyID change) {
			rendered = "CHANGE ONTOLOGY ID to " + change.getNewOntologyID();
		}

		public void visit(RemoveImport change) {
			rendered = "REMOVE IMPORT " + change.getImportDeclaration();
		}

		public void visit(AddImport change) {
			rendered = "ADD IMPORT " + change.getImportDeclaration();
		}

		public void visit(AddOntologyAnnotation change) {
			rendered = "ADD Ontology Annotation " + change.getAnnotation();
		}

		public void visit(RemoveOntologyAnnotation change) {
			rendered = "REMOVE Ontology Annotation " + change.getAnnotation();
		}

		@Override
		public String toString() {
			return rendered;
		}
	}

	private final OPPLScript opplScript;
	private final List<OWLAxiomChange> changes = new ArrayList<OWLAxiomChange>();
	private final ChangeRenderer changeRenderer;

	public EvaluationResults(OPPLScript opplScript, List<OWLAxiomChange> changes) {
		if (opplScript == null) {
			throw new NullPointerException("The OPPL Script cannot be null");
		}
		if (changes == null) {
			throw new NullPointerException("The changes cannot be null");
		}
		this.opplScript = opplScript;
		this.changes.addAll(changes);
		changeRenderer = new ChangeRenderer();
	}

	/**
	 * @return the opplScript
	 */
	public OPPLScript getOpplScript() {
		return opplScript;
	}

	/**
	 * @return the changes
	 */
	public List<OWLAxiomChange> getChanges() {
		return new ArrayList<OWLAxiomChange>(changes);
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		Formatter formatter = new Formatter(out, Locale.getDefault());
		formatter.format("Script: %s \n Bindings ", getOpplScript());
		if (getOpplScript().getConstraintSystem().getLeaves() != null) {
			formatter.format(
					" count %d \n",
					getOpplScript().getConstraintSystem().getLeaves().size());
			for (BindingNode bindingNode : getOpplScript().getConstraintSystem().getLeaves()) {
				for (Assignment assignment : bindingNode.getAssignments()) {
					ManchesterSyntaxRenderer renderer = EvaluationResults.this.getOpplScript().getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
							EvaluationResults.this.getOpplScript().getConstraintSystem());
					assignment.getAssignment().accept(renderer);
					formatter.format(
							"%s = %s\n",
							assignment.getAssignedVariable(),
							renderer.toString());
				}
			}
			formatter.format("\n");
		} else {
			formatter.format(" (none) \n");
		}
        if (!changes.isEmpty()) {
            formatter.format("Change count %d \n", changes.size());
            for (OWLAxiomChange change : changes) {
				change.accept(changeRenderer);
				formatter.format("%s \n", changeRenderer.toString());
			}
		}
		return out.toString();
	}
}

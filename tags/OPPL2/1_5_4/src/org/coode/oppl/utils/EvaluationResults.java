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
			this.rendered = "";
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			String renderedString = this.renderAxiom(change.getAxiom());
			formatter.format("ADD %s", renderedString);
			this.rendered = out.toString();
		}

		/**
		 * @param change
		 * @return
		 */
		private String renderAxiom(OWLAxiom axiom) {
			this.rendered = "";
			ManchesterSyntaxRenderer renderer = EvaluationResults.this.getOpplScript().getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
					EvaluationResults.this.getOpplScript().getConstraintSystem());
			axiom.accept(renderer);
			String renderedString = renderer.toString();
			return renderedString;
		}

		public void visit(RemoveAxiom change) {
			this.rendered = "";
			Formatter formatter = new Formatter();
			String renderedString = this.renderAxiom(change.getAxiom());
			formatter.format("REMOVE %s", renderedString);
			this.rendered = formatter.toString();
		}

		public void visit(SetOntologyID change) {
			this.rendered = "CHANGE ONTOLOGY ID to " + change.getNewOntologyID();
		}

		public void visit(RemoveImport change) {
			this.rendered = "REMOVE IMPORT " + change.getImportDeclaration();
		}

		public void visit(AddImport change) {
			this.rendered = "ADD IMPORT " + change.getImportDeclaration();
		}

		public void visit(AddOntologyAnnotation change) {
			this.rendered = "ADD Ontology Annotation " + change.getAnnotation();
		}

		public void visit(RemoveOntologyAnnotation change) {
			this.rendered = "REMOVE Ontology Annotation " + change.getAnnotation();
		}

		@Override
		public String toString() {
			return this.rendered;
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
		this.changeRenderer = new ChangeRenderer();
	}

	/**
	 * @return the opplScript
	 */
	public OPPLScript getOpplScript() {
		return this.opplScript;
	}

	/**
	 * @return the changes
	 */
	public List<OWLAxiomChange> getChanges() {
		return new ArrayList<OWLAxiomChange>(this.changes);
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		Formatter formatter = new Formatter(out, Locale.getDefault());
		formatter.format("Script: %s \n Bindings ", this.getOpplScript());
		if (this.getOpplScript().getConstraintSystem().getLeaves() != null) {
			formatter.format(
					" count %d \n",
					this.getOpplScript().getConstraintSystem().getLeaves().size());
			for (BindingNode bindingNode : this.getOpplScript().getConstraintSystem().getLeaves()) {
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
		if (!this.getChanges().isEmpty()) {
			formatter.format("Change count %d \n", this.getChanges().size());
			for (OWLAxiomChange change : this.getChanges()) {
				change.accept(this.changeRenderer);
				formatter.format("%s \n", this.changeRenderer.toString());
			}
		}
		return out.toString();
	}
}

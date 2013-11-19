/**
 * 
 */
package org.coode.oppl.utils;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.model.RemoveImport;
import org.semanticweb.owlapi.model.RemoveOntologyAnnotation;
import org.semanticweb.owlapi.model.SetOntologyID;
import org.semanticweb.owlapi.util.OWLOntologyChangeVisitorAdapterEx;

/** Utility class for collecting the evaluation results and dumping them into a
 * String
 * 
 * @author Luigi Iannone */
public class EvaluationResults {
    private final class ChangeRenderer extends OWLOntologyChangeVisitorAdapterEx<String> {
        public ChangeRenderer() {}

        @Override
        public String visit(AddAxiom change) {
            return String.format("ADD %s", renderAxiom(change.getAxiom()));
        }

        /** @param change
         * @return */
        private String renderAxiom(OWLAxiom axiom) {
            ConstraintSystem cs = getOpplScript().getConstraintSystem();
            ManchesterSyntaxRenderer renderer = cs.getOPPLFactory()
                    .getManchesterSyntaxRenderer(cs);
            axiom.accept(renderer);
            return renderer.toString();
        }

        @Override
        public String visit(RemoveAxiom change) {
            return String.format("REMOVE %s", renderAxiom(change.getAxiom()));
        }

        @Override
        public String visit(SetOntologyID change) {
            return String.format("CHANGE ONTOLOGY ID to %s", change.getNewOntologyID());
        }

        @Override
        public String visit(RemoveImport change) {
            return String.format("REMOVE IMPORT %s", change.getImportDeclaration());
        }

        @Override
        public String visit(AddImport change) {
            return String.format("ADD IMPORT %s", change.getImportDeclaration());
        }

        @Override
        public String visit(AddOntologyAnnotation change) {
            return String.format("ADD Ontology Annotation %s", change.getAnnotation());
        }

        @Override
        public String visit(RemoveOntologyAnnotation change) {
            return String.format("REMOVE Ontology Annotation %s", change.getAnnotation());
        }
    }

    private final OPPLScript opplScript;
    private final List<OWLAxiomChange> changes = new ArrayList<OWLAxiomChange>();
    private final ChangeRenderer changeRenderer;

    /** @param opplScript
     * @param changes */
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

    /** @return the opplScript */
    public OPPLScript getOpplScript() {
        return opplScript;
    }

    /** @return the changes */
    public List<OWLAxiomChange> getChanges() {
        return new ArrayList<OWLAxiomChange>(changes);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("Script: %s \n Bindings ", getOpplScript()));
        ConstraintSystem cs = getOpplScript().getConstraintSystem();
        if (cs.getLeaves() != null) {
            out.append(String.format(" count %d \n", cs.getLeaves().size()));
            for (BindingNode bindingNode : cs.getLeaves()) {
                for (Assignment assignment : bindingNode.getAssignments()) {
                    ManchesterSyntaxRenderer renderer = cs.getOPPLFactory()
                            .getManchesterSyntaxRenderer(cs);
                    assignment.getAssignment().accept(renderer);
                    out.append(String.format("%s = %s\n",
                            assignment.getAssignedVariable(), renderer));
                }
            }
            out.append("\n");
        } else {
            out.append(" (none) \n");
        }
        if (!changes.isEmpty()) {
            out.append(String.format("Change count %d \n", changes.size()));
            for (OWLAxiomChange change : changes) {
                out.append(String.format("%s \n", change.accept(changeRenderer)));
            }
        }
        return out.toString();
    }
}
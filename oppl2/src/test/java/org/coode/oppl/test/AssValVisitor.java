package org.coode.oppl.test;

import java.util.Collections;
import java.util.Set;

import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;

@SuppressWarnings("javadoc")
public class AssValVisitor implements VariableTypeVisitorEx<Set<? extends OWLObject>> {
    private final OWLOntology o;

    public AssValVisitor(OWLOntology o) {
        this.o = o;
    }

    @Override
    public Set<? extends OWLObject> visitINDIVIDUALVariableType(INDIVIDUALVariableType v) {
        return o.getIndividualsInSignature();
    }

    @Override
    public Set<? extends OWLObject> visitDATAPROPERTYVariableType(
            DATAPROPERTYVariableType v) {
        return o.getDataPropertiesInSignature();
    }

    @Override
    public Set<? extends OWLObject> visitOBJECTPROPERTYVariableType(
            OBJECTPROPERTYVariableType v) {
        return o.getObjectPropertiesInSignature();
    }

    @Override
    public Set<? extends OWLObject> visitCONSTANTVariableType(CONSTANTVariableType v) {
        return Collections.emptySet();
    }

    @Override
    public Set<? extends OWLObject> visitCLASSVariableType(CLASSVariableType v) {
        return o.getClassesInSignature();
    }

    @Override
    public Set<? extends OWLObject> visitANNOTATIONPROPERTYVariableType(
            ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
        return o.getAnnotationPropertiesInSignature();
    }
}

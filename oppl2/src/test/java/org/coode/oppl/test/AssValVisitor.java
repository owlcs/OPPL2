package org.coode.oppl.test;

import java.util.stream.Stream;

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
public class AssValVisitor implements VariableTypeVisitorEx<Stream<? extends OWLObject>> {

    private final OWLOntology o;

    public AssValVisitor(OWLOntology o) {
        this.o = o;
    }

    @Override
    public Stream<? extends OWLObject> visitINDIVIDUALVariableType(INDIVIDUALVariableType v) {
        return o.individualsInSignature();
    }

    @Override
    public Stream<? extends OWLObject> visitDATAPROPERTYVariableType(DATAPROPERTYVariableType v) {
        return o.dataPropertiesInSignature();
    }

    @Override
    public Stream<? extends OWLObject> visitOBJECTPROPERTYVariableType(
        OBJECTPROPERTYVariableType v) {
        return o.objectPropertiesInSignature();
    }

    @Override
    public Stream<? extends OWLObject> visitCONSTANTVariableType(CONSTANTVariableType v) {
        return Stream.empty();
    }

    @Override
    public Stream<? extends OWLObject> visitCLASSVariableType(CLASSVariableType v) {
        return o.classesInSignature();
    }

    @Override
    public Stream<? extends OWLObject> visitANNOTATIONPROPERTYVariableType(
        ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
        return o.annotationPropertiesInSignature();
    }
}

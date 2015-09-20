package org.coode.parsers;

/**
 * Void implementation of a TypeVisitor. Does nothing by default. Developer can
 * override the methods they are interested in leaving the others untouched.
 * 
 * @author Luigi Iannone
 */
public class TypeVistorAdapter implements TypeVisitor {

    @Override
    public void visitNonOWLType(Type type) {}

    @Override
    public void visitOWLAxiomType(OWLAxiomType owlAxiomType) {}

    @Override
    public void visitOWLType(OWLType owlType) {}
}

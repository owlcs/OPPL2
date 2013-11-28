package org.coode.parsers;

/** @author Luigi Iannone */
public interface TypeVisitor {
    /** @param owlType */
    void visitOWLType(OWLType owlType);

    /** @param owlAxiomType */
    void visitOWLAxiomType(OWLAxiomType owlAxiomType);

    /** @param type */
    void visitNonOWLType(Type type);
}

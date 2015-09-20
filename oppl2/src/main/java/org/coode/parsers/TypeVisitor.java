package org.coode.parsers;

/**
 * @author Luigi Iannone
 */
public interface TypeVisitor {

    /**
     * @param owlType
     *        owlType
     */
    void visitOWLType(OWLType owlType);

    /**
     * @param owlAxiomType
     *        owlAxiomType
     */
    void visitOWLAxiomType(OWLAxiomType owlAxiomType);

    /**
     * @param type
     *        type
     */
    void visitNonOWLType(Type type);
}

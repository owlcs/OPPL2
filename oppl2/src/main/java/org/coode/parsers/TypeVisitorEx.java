package org.coode.parsers;

/** @author Luigi Iannone
 * @param <O> */
public interface TypeVisitorEx<O> {
    /** @param owlType
     * @return visitor value */
    O visitOWLType(OWLType owlType);

    /** @param owlAxiomType
     * @return visitor value */
    O visitOWLAxiomType(OWLAxiomType owlAxiomType);

    /** @param type
     * @return visitor value */
    O visitNonOWLType(Type type);
}

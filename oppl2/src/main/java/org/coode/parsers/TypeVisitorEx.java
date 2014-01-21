package org.coode.parsers;

/** @author Luigi Iannone
 * @param <O>
 *            type */
public interface TypeVisitorEx<O> {
    /** @param owlType
     *            owlType
     * @return visitor value */
    O visitOWLType(OWLType owlType);

    /** @param owlAxiomType
     *            owlAxiomType
     * @return visitor value */
    O visitOWLAxiomType(OWLAxiomType owlAxiomType);

    /** @param type
     *            type
     * @return visitor value */
    O visitNonOWLType(Type type);
}

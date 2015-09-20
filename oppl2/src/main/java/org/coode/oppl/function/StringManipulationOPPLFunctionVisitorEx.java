package org.coode.oppl.function;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public interface StringManipulationOPPLFunctionVisitorEx<O> {

    /**
     * @param lowercase
     *        lowercase
     * @return visitor value
     */
    O visitToLowerCaseStringManipulationOPPLFunction(
        ToLowerCaseStringManipulationOPPLFunction lowercase);

    /**
     * @param uppercase
     *        uppercase
     * @return visitor value
     */
    O visitToUpperCaseStringManipulationOPPLFunction(
        ToUpperCaseStringManipulationOPPLFunction uppercase);
}

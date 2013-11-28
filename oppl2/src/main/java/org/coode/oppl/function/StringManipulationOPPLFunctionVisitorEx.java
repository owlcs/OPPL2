package org.coode.oppl.function;

/** @author Luigi Iannone
 * @param <O> */
public interface StringManipulationOPPLFunctionVisitorEx<O> {
    /** @param toLowerCaseStringManipulationOPPLFunction
     * @return visitor value */
            O
            visitToLowerCaseStringManipulationOPPLFunction(
                    ToLowerCaseStringManipulationOPPLFunction toLowerCaseStringManipulationOPPLFunction);

    /** @param upperCaseStringManipulationOPPLFunction
     * @return visitor value */
            O
            visitToUpperCaseStringManipulationOPPLFunction(
                    ToUpperCaseStringManipulationOPPLFunction upperCaseStringManipulationOPPLFunction);
}

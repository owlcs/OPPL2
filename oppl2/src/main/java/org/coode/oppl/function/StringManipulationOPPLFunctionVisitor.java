package org.coode.oppl.function;

/**
 * @author Luigi Iannone
 */
public interface StringManipulationOPPLFunctionVisitor {

    /**
     * @param lowerCase
     *        lowerCase
     */
    void visitToLowerCaseStringManipulationOPPLFunction(
        ToLowerCaseStringManipulationOPPLFunction lowerCase);

    /**
     * @param upperCase
     *        upperCase
     */
    void visitToUpperCaseStringManipulationOPPLFunction(
        ToUpperCaseStringManipulationOPPLFunction upperCase);
}

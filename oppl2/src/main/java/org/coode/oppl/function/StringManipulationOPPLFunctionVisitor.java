package org.coode.oppl.function;

/** @author Luigi Iannone */
public interface StringManipulationOPPLFunctionVisitor {
    /** @param toLowerCaseStringManipulationOPPLFunction */
            void
            visitToLowerCaseStringManipulationOPPLFunction(
                    ToLowerCaseStringManipulationOPPLFunction toLowerCaseStringManipulationOPPLFunction);

    /** @param upperCaseStringManipulationOPPLFunction */
            void
            visitToUpperCaseStringManipulationOPPLFunction(
                    ToUpperCaseStringManipulationOPPLFunction upperCaseStringManipulationOPPLFunction);
}

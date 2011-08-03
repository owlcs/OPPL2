package org.coode.oppl.function;

public interface StringManipulationOPPLFunctionVisitorEx<O> {
	O visitToLowerCaseStringManipulationOPPLFunction(
			ToLowerCaseStringManipulationOPPLFunction toLowerCaseStringManipulationOPPLFunction);

	O visitToUpperCaseStringManipulationOPPLFunction(
			ToUpperCaseStringManipulationOPPLFunction upperCaseStringManipulationOPPLFunction);
}

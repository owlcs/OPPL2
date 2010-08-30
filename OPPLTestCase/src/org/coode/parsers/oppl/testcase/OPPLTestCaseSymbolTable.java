/**
 * 
 */
package org.coode.parsers.oppl.testcase;

import org.coode.parsers.Scope;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.semanticweb.owlapi.model.OWLDataFactory;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLTestCaseSymbolTable extends OPPLSymbolTable {
	/**
	 * @param globalScope
	 * @param dataFactory
	 */
	public OPPLTestCaseSymbolTable(Scope globalScope, OWLDataFactory dataFactory) {
		super(globalScope, dataFactory);
	}
}

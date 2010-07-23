/**
 * 
 */
package org.coode.patterns.protege.utils;

import java.io.StringReader;

import org.coode.patterns.protege.ProtegePatternModelFactory;
import org.coode.patterns.syntax.PatternParser;
import org.protege.editor.owl.model.OWLModelManager;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeParserFactory {
	public static PatternParser initProtegeParser(String formulaBody,
			OWLModelManager manager) {
		PatternParser parser = new PatternParser(new StringReader(formulaBody),
				manager.getOWLOntologyManager(), manager.getReasoner());
		parser.setPatternModelFactory(new ProtegePatternModelFactory(manager,
				formulaBody));
		return parser;
	}
}

/**
 * 
 */
package org.coode.parsers.oppl.testcase.protege;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser.AbstractParserFactory;
import org.coode.parsers.oppl.testcase.ParserFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeParserFactory implements AbstractParserFactory {
	private final OWLEditorKit owlEditorKit;

	/**
	 * @param owlEditorKit
	 */
	public ProtegeParserFactory(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL Editor Kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.OPPLTestCaseParser.AbstractParserFactory
	 *      #build(org.coode.parsers.ErrorListener)
	 */
	public OPPLTestCaseParser build(ErrorListener errorListener) {
		OWLOntology activeOntology = this.getOWLEditorKit().getOWLModelManager().getActiveOntology();
		OWLOntologyManager ontologyManager = this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager();
		OWLReasoner reasoner = this.getOWLEditorKit().getOWLModelManager().getReasoner() instanceof NoOpReasoner ? null
				: this.getOWLEditorKit().getOWLModelManager().getReasoner();
		ParserFactory parserFactory = new ParserFactory(activeOntology, ontologyManager, reasoner);
		return parserFactory.build(errorListener);
	}

	/**
	 * @see org.coode.parsers.oppl.testcase.OPPLTestCaseParser.AbstractParserFactory
	 *      #getOPPLTestCaseFactory()
	 */
	public AbstractOPPLTestCaseFactory getOPPLTestCaseFactory() {
		return new ProtegeOPPLTestCaseFactory(this.getOWLEditorKit());
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}
}

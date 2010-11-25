/**
 *
 */
package org.coode.oppl.lint.protege;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.lint.ActingOPPLLintScript;
import org.coode.oppl.lint.OPPLLintAbstractFactory;
import org.coode.oppl.lint.OPPLLintScript;
import org.coode.oppl.protege.ProtegeOPPLFactory;
import org.protege.editor.owl.OWLEditorKit;

/**
 * @author Luigi Iannone
 * 
 */
public class ProtegeOPPLLintFactory implements OPPLLintAbstractFactory {
	private final OWLEditorKit owlEditorKit;

	public ProtegeOPPLLintFactory(OWLEditorKit owlEditorKit) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.owlEditorKit = owlEditorKit;
	}

	/**
	 * @see org.coode.oppl.lint.OPPLLintAbstractFactory#buildOPPLLintScript(java.lang.String,
	 *      org.coode.oppl.OPPLScript, org.coode.oppl.Variable,
	 *      java.lang.String)
	 */
	public OPPLLintScript buildOPPLLintScript(String name, OPPLScript opplScript, Variable<?> v,
			String explanationTemplate, String description, boolean inferenceRequired,
			RuntimeExceptionHandler handler) {
		return opplScript.getActions().isEmpty() ? new OPPLLintScript(name, opplScript, v,
				explanationTemplate, description,
				this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager(),
				inferenceRequired, handler) : new ActingOPPLLintScript(name, opplScript, v,
				explanationTemplate, description,
				this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager(),
				inferenceRequired, handler);
	}

	public OPPLAbstractFactory getOPPLFactory() {
		return new ProtegeOPPLFactory(this.getOWLEditorKit());
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}
}

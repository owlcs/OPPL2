/**
 * 
 */
package org.coode.oppl.syntax;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.semanticweb.owl.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public class ManchesterOWLSyntaxTree extends CommonTree {
	private Type evalType = null;
	private OWLObject owlObject;

	public ManchesterOWLSyntaxTree(Token token) {
		super(token);
	}

	/**
	 * @return the evalType
	 */
	public Type getEvalType() {
		return this.evalType;
	}

	/**
	 * @param evalType
	 *            the evalType to set
	 */
	public void setEvalType(Type evalType) {
		this.evalType = evalType;
	}

	@Override
	public String toString() {
		return this.token.getText()
				+ " type: "
				+ (this.getEvalType() == null ? "(none)" : this.getEvalType()
						.toString());
	}

	/**
	 * @return the owlObject
	 */
	public OWLObject getOWLObject() {
		return this.owlObject;
	}

	/**
	 * @param owlObject
	 *            the owlObject to set
	 */
	public void setOWLObject(OWLObject owlObject) {
		this.owlObject = owlObject;
	}
}

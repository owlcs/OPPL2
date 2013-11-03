package org.coode.parsers;

import org.semanticweb.owlapi.model.OWLLiteral;

public class OWLLiteralSymbol extends Symbol {
    private final OWLLiteral owlConstant;

    /** @param name
     * @param constant */
    public OWLLiteralSymbol(String name, OWLLiteral constant) {
        super(name, OWLType.OWL_CONSTANT);
        if (constant == null) {
            throw new NullPointerException("The constant cannot be null");
        }
        owlConstant = constant;
    }

    /** @return the owlConstant */
    public OWLLiteral getOWLLiteral() {
        return owlConstant;
    }

    @Override
    public <O> O accept(SymbolVisitorEx<O> visitor) {
        return visitor.visitOWLLiteral(this);
    }

    @Override
    public void accept(SymbolVisitor visitor) {
        visitor.visitOWLLiteral(this);
    }
}

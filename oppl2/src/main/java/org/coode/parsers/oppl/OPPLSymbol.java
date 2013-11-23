package org.coode.parsers.oppl;

public interface OPPLSymbol {
    void accept(OPPLSymbolVisitor visitor);

    <O> O accept(OPPLSymbolVisitorEx<O> visitor);
}

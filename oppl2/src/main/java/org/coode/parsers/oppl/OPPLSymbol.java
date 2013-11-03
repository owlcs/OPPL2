package org.coode.parsers.oppl;

public interface OPPLSymbol {
	public void accept(OPPLSymbolVisitor visitor);

	public <O> O accept(OPPLSymbolVisitorEx<O> visitor);
}

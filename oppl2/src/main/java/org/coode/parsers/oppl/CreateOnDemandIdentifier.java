package org.coode.parsers.oppl;

import org.coode.parsers.Symbol;
import org.coode.parsers.SymbolVisitor;
import org.coode.parsers.SymbolVisitorEx;

/** @author Luigi Iannone */
public class CreateOnDemandIdentifier extends Symbol implements OPPLSymbol {
    /** @param name */
    public CreateOnDemandIdentifier(String name) {
        super(name, CreateOnDemand.get());
    }

    @Override
    public void accept(OPPLSymbolVisitor visitor) {
        visitor.visitCreateOnDemandIdentifier(this);
    }

    @Override
    public <O> O accept(OPPLSymbolVisitorEx<O> visitor) {
        return visitor.visitCreateOnDemandIdentifier(this);
    }

    @Override
    public void accept(SymbolVisitor visitor) {
        if (OPPLSymbolVisitor.class.isAssignableFrom(visitor.getClass())) {
            ((OPPLSymbolVisitor) visitor).visitCreateOnDemandIdentifier(this);
        } else {
            super.accept(visitor);
        }
    }

    @Override
    public <O> O accept(SymbolVisitorEx<O> visitor) {
        O toReturn = super.accept(visitor);
        if (OPPLSymbolVisitorEx.class.isAssignableFrom(visitor.getClass())) {
            toReturn = ((OPPLSymbolVisitorEx<O>) visitor)
                    .visitCreateOnDemandIdentifier(this);
        }
        return toReturn;
    }
}

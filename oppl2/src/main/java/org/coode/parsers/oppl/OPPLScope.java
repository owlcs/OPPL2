package org.coode.parsers.oppl;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Set;

import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.OWLEntityCheckerScope;
import org.coode.parsers.OWLEntityRenderer;
import org.coode.parsers.Scope;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;

/** @author Luigi Iannone */
public class OPPLScope implements Scope {
    private final OWLEntityCheckerScope owlEntityCheckerScope;

    /** @param owlEntityChecker
     * @param entityFinder
     * @param owlEntityRenderer */
    public OPPLScope(DisposableOWLEntityChecker owlEntityChecker,
            EntityFinder entityFinder, OWLEntityRenderer owlEntityRenderer) {
        checkNotNull(owlEntityChecker, "owlEntityChecker");
        checkNotNull(entityFinder, "entityFinder");
        checkNotNull(owlEntityRenderer, "owlEntityRenderer");
        owlEntityCheckerScope = new OWLEntityCheckerScope(owlEntityChecker, entityFinder,
                owlEntityRenderer);
    }

    @Override
    public void define(Symbol symbol) {}

    @Override
    public Set<Symbol> getAllSymbols() {
        return owlEntityCheckerScope.getAllSymbols();
    }

    @Override
    public Set<Symbol> getAllSymbols(Type type) {
        return owlEntityCheckerScope.getAllSymbols();
    }

    @Override
    public Scope getEnclosingScope() {
        return null;
    }

    @Override
    public String getScopeName() {
        return "global OPPL scope";
    }

    @Override
    public Set<Symbol> match(String prefix) {
        return owlEntityCheckerScope.match(prefix);
    }

    @Override
    public Symbol resolve(String name) {
        Symbol toReturn = owlEntityCheckerScope.resolve(name);
        if (toReturn == null && name.startsWith("!")) {
            toReturn = new CreateOnDemandIdentifier(name);
        }
        return toReturn;
    }

    @Override
    public void dispose() {
        owlEntityCheckerScope.dispose();
    }
}

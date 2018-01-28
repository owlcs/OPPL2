package org.coode.parsers.oppl.patterns;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Scope;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.patterns.PatternConstraintSystem;
import org.coode.patterns.PatternException;
import org.coode.patterns.PatternOPPLScript;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 */
public class OPPLPatternScope implements Scope {

    private final Scope delegate;
    private final OWLOntologyManager ontologyManager;

    /**
     * @param scope scope
     * @param ontologyManager ontologyManager
     */
    public OPPLPatternScope(Scope scope, OWLOntologyManager ontologyManager) {
        delegate = checkNotNull(scope, "scope");
        this.ontologyManager = checkNotNull(ontologyManager, "ontologyManager");
    }

    @Override
    public void define(Symbol symbol) {
        delegate.define(symbol);
    }

    @Override
    public Set<Symbol> getAllSymbols() {
        return delegate.getAllSymbols();
    }

    @Override
    public Set<Symbol> getAllSymbols(Type type) {
        return delegate.getAllSymbols(type);
    }

    @Override
    public Scope getEnclosingScope() {
        return delegate.getEnclosingScope();
    }

    @Override
    public String getScopeName() {
        return delegate.getScopeName();
    }

    @Override
    public Set<Symbol> match(String prefix) {
        return delegate.match(prefix);
    }

    @Override
    public Symbol resolve(String name) {
        Symbol toReturn = delegate.resolve(name);
        return toReturn;
    }

    /**
     * @return the delegate
     */
    protected Scope getDelegate() {
        return delegate;
    }

    /**
     * @param reference reference
     * @param patternName patternName
     * @param constraintSystem constraintSystem
     * @param listener listener
     * @param args args
     * @return variable
     */
    public Variable<?> resolvePatternReference(OPPLSyntaxTree reference, String patternName,
        PatternConstraintSystem constraintSystem, ErrorListener listener, List<Object>... args) {
        return this.resolvePatternReference(reference, patternName, constraintSystem,
            Collections.<String>emptySet(), listener, args);
    }

    /**
     * @param reference reference
     * @param patternName patternName
     * @param constraintSystem constraintSystem
     * @param visited visited
     * @param listener listener
     * @param args args
     * @return variable
     */
    public Variable<?> resolvePatternReference(OPPLSyntaxTree reference, String patternName,
        PatternConstraintSystem constraintSystem, Collection<String> visited,
        ErrorListener listener, List<Object>... args) {
        Variable<?> toReturn = null;
        try {
            String resolvedPattern = constraintSystem.resolvePattern(patternName, visited,
                new ArrayList<PatternOPPLScript>(), listener, args);
            toReturn = constraintSystem.getVariable(resolvedPattern);
        } catch (PatternException e) {
            if (listener != null) {
                listener.illegalToken(reference,
                    "Could not resolve the reference: " + e.getMessage());
            }
        }
        return toReturn;
    }

    /**
     * @return the ontologyManager
     */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    @Override
    public void dispose() {
        delegate.dispose();
    }
}

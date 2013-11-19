package org.coode.parsers.oppl.patterns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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

/** @author Luigi Iannone */
public class OPPLPatternScope implements Scope {
    private final Scope delegate;
    private final OWLOntologyManager ontologyManager;

    /** @param scope
     * @param ontologyManager */
    public OPPLPatternScope(Scope scope, OWLOntologyManager ontologyManager) {
        if (scope == null) {
            throw new NullPointerException("The delegate  scope cannot be null");
        }
        if (ontologyManager == null) {
            throw new NullPointerException("The ontology manager cannot be null");
        }
        delegate = scope;
        this.ontologyManager = ontologyManager;
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

    /** @return the delegate */
    protected Scope getDelegate() {
        return delegate;
    }

    public Variable<?> resolvePatternReference(OPPLSyntaxTree reference,
            String patternName, PatternConstraintSystem constraintSystem,
            ErrorListener listener, List<Object>... args) {
        return this.resolvePatternReference(reference, patternName, constraintSystem,
                Collections.<String> emptySet(), listener, args);
    }

    public Variable<?> resolvePatternReference(OPPLSyntaxTree reference,
            String patternName, PatternConstraintSystem constraintSystem,
            Collection<? extends String> visited, ErrorListener listener,
            List<Object>... args) {
        Variable<?> toReturn = null;
        try {
            String resolvedPattern = constraintSystem.resolvePattern(patternName,
                    getOntologyManager(), new HashSet<String>(visited),
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

    /** @return the ontologyManager */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    @Override
    public void dispose() {
        delegate.dispose();
    }
}

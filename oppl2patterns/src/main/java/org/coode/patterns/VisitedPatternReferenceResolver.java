package org.coode.patterns;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.patterns.OPPLPatternParser.PatternReferenceResolver;

/** @author Luigi Iannone */
public final class VisitedPatternReferenceResolver implements PatternReferenceResolver {
    private final Set<String> visited = new HashSet<String>();

    /** @param visitedPatterns */
    public VisitedPatternReferenceResolver(Collection<? extends String> visitedPatterns) {
        assert visitedPatterns != null;
        visited.addAll(visitedPatterns);
    }

    @Override
    public void resolvePattern(OPPLSyntaxTree reference, String patternName,
            PatternConstraintSystem constraintSystem,
            OPPLPatternsSymbolTable symbolTable, List<Object>... args) {
        symbolTable.resolvePattern(reference, patternName, constraintSystem, visited,
                args);
    }

    /** @return the visited */
    public Set<String> getVisited() {
        return new HashSet<String>(visited);
    }
}

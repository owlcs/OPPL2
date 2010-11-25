package org.coode.patterns;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.patterns.OPPLPatternParser.PatternReferenceResolver;

public final class VisitedPatternReferenceResolver implements PatternReferenceResolver {
	private final Set<String> visited = new HashSet<String>();

	public VisitedPatternReferenceResolver(Collection<? extends String> visitedPatterns) {
		assert visitedPatterns != null;
		this.visited.addAll(visitedPatterns);
	}

	public void resolvePattern(OPPLSyntaxTree reference, String patternName,
			PatternConstraintSystem constraintSystem, OPPLPatternsSymbolTable symbolTable,
			List<Object>... args) {
		symbolTable.resolvePattern(
				reference,
				patternName,
				constraintSystem,
				this.getVisited(),
				args);
	}

	/**
	 * @return the visited
	 */
	public Set<String> getVisited() {
		return new HashSet<String>(this.visited);
	}
}
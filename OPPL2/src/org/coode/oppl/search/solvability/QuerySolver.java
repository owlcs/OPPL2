package org.coode.oppl.search.solvability;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;

public interface QuerySolver {
	Set<OWLClass> getSubClasses(OWLClassExpression superClass);

	Set<OWLClass> getSuperClasses(OWLClassExpression subClass);
}

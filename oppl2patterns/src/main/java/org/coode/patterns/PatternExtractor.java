/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.patterns;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.patterns.OPPLPatternParser.PatternReferenceResolver;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 */
public class PatternExtractor extends OWLObjectVisitorExAdapter<PatternOPPLScript>
    implements OWLAnnotationObjectVisitorEx<PatternOPPLScript> {

    private final OWLOntologyManager ontologyManager;
    private final OWLOntology ontology;
    private final ErrorListener errorListener;
    private final Set<OWLAnnotation> visited = new HashSet<>();

    /**
     * @param ontology
     *        ontology
     * @param owlOntologyManager
     *        owlOntologyManager
     * @param errorListener
     *        errorListener
     * @param visited
     *        visited
     */
    public PatternExtractor(OWLOntology ontology, OWLOntologyManager owlOntologyManager,
        ErrorListener errorListener, Set<OWLAnnotation> visited) {
        super(null);
        this.ontology = checkNotNull(ontology, "ontology");
        ontologyManager = checkNotNull(owlOntologyManager, "owlOntologyManager");
        this.errorListener = checkNotNull(errorListener, "errorListener");
        this.visited.addAll(visited);
    }

    /**
     * @param ontology
     *        ontology
     * @param owlOntologyManager
     *        owlOntologyManager
     * @param listener
     *        listener
     */
    public PatternExtractor(OWLOntology ontology, OWLOntologyManager owlOntologyManager,
        ErrorListener listener) {
        this(ontology, owlOntologyManager, listener, Collections
            .<OWLAnnotation> emptySet());
    }

    @Override
    public PatternOPPLScript visit(OWLAnnotation annotation) {
        PatternOPPLScript toReturn = null;
        if (visited.isEmpty() || !visited.contains(annotation)) {
            if (PatternModel.NAMESPACE.equals(annotation.getProperty().getIRI()
                .getNamespace())) {
                String value = annotation.getValue().accept(
                    new OWLObjectVisitorExAdapter<String>(null) {

                        @Override
                        public String visit(OWLLiteral literal) {
                            return literal.getLiteral();
                        }
                    });
                if (value != null) {
                    String patternName = annotation.getProperty().getIRI().getFragment();
                    ParserFactory parserFactory = new ParserFactory(getOntology(),
                        getOntologyManager());
                    OPPLPatternParser parser = parserFactory.build(getErrorListener());
                    Set<String> visitedPatternNames = getVisitedPatternNames();
                    visitedPatternNames.add(patternName);
                    getPatternReferenceResolver(visitedPatternNames);
                    ParserFactory factory = new ParserFactory(ontology, ontologyManager);
                    factory.build(visitedPatternNames, errorListener);
                    toReturn = parser.parse(value);
                    if (toReturn != null) {
                        toReturn.setIRI(annotation.getProperty().getIRI());
                    }
                }
            }
        } else {
            getErrorListener().reportThrowable(
                new RuntimeException("Cyclic reference detected "), 0, 0, 0);
        }
        return toReturn;
    }

    protected Set<String> getVisitedPatternNames() {
        Set<String> toReturn = new HashSet<>();
        for (OWLAnnotation patternAnnotation : visited) {
            IRI iri = patternAnnotation.getProperty().getIRI();
            if (iri != null && PatternModel.NAMESPACE.equals(iri.getNamespace())) {
                toReturn.add(iri.getFragment());
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

    /**
     * @return the ontology
     */
    public OWLOntology getOntology() {
        return ontology;
    }

    /**
     * @return the errorListener
     */
    public ErrorListener getErrorListener() {
        return errorListener;
    }

    private PatternReferenceResolver getPatternReferenceResolver(
        final Collection<? extends String> done) {
        return new PatternReferenceResolver() {

            @Override
            public void resolvePattern(OPPLSyntaxTree reference, String patternName,
                PatternConstraintSystem constraintSystem,
                OPPLPatternsSymbolTable symbolTable, List<Object>... args) {
                symbolTable.resolvePattern(reference, patternName, constraintSystem,
                    new HashSet<>(done), args);
            }
        };
    }
}

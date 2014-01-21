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
package org.coode.patterns.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternManager;
import org.coode.patterns.PatternModel;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/** @author Luigi Iannone Jun 10, 2008 */
public class Utils {
    /** @param ontology
     *            ontology
     * @param factory
     *            factory
     * @return set of existing patterns */
    public static Set<PatternModel> getExistingPatterns(OWLOntology ontology,
            AbstractPatternModelFactory factory) {
        Set<PatternModel> toReturn = new HashSet<PatternModel>();
        PatternExtractor patternExtractor = factory.getPatternExtractor(PatternManager
                .getDefaultErrorListener());
        for (OWLAnnotation anOntologyAnnotation : ontology.getAnnotations()) {
            PatternModel statementModel = (PatternModel) anOntologyAnnotation
                    .accept(patternExtractor);
            if (statementModel != null) {
                toReturn.add(statementModel);
            }
        }
        return toReturn;
    }

    /** @param patternName
     *            patternName
     * @param ontology
     *            ontology
     * @param factory
     *            factory
     * @return found pattern */
    public static PatternModel find(String patternName, OWLOntology ontology,
            AbstractPatternModelFactory factory) {
        Iterator<OWLAnnotation> it = ontology.getAnnotations().iterator();
        boolean found = false;
        PatternModel extractedPattern = null;
        while (!found && it.hasNext()) {
            OWLAnnotation annotation = it.next();
            IRI annotationIRI = annotation.getProperty().getIRI();
            if (annotationIRI.toString().equals(PatternModel.NAMESPACE + patternName)) {
                PatternExtractor patternExtractor = factory
                        .getPatternExtractor(PatternManager.getDefaultErrorListener());
                extractedPattern = (PatternModel) annotation.accept(patternExtractor);
                found = extractedPattern != null
                        && extractedPattern.getPatternLocalName().equals(patternName);
            }
        }
        return extractedPattern;
    }

    /** @param patternName
     *            patternName
     * @param ontologyManager
     *            ontologyManager
     * @param factory
     *            factory
     * @return pattern */
    public static PatternModel find(String patternName,
            OWLOntologyManager ontologyManager, AbstractPatternModelFactory factory) {
        Iterator<OWLOntology> it = ontologyManager.getOntologies().iterator();
        boolean found = false;
        PatternModel toReturn = null;
        while (!found && it.hasNext()) {
            toReturn = find(patternName, it.next(), factory);
            found = toReturn != null;
        }
        return toReturn;
    }

    /** @param ontology
     *            ontology
     * @return set of existing pattern names */
    public static Set<String> getExistingPatternNames(OWLOntology ontology) {
        Set<String> toReturn = new HashSet<String>();
        for (OWLAnnotation annotation : ontology.getAnnotations()) {
            IRI iri = annotation.getProperty().getIRI();
            if (PatternModel.NAMESPACE.equals(iri.getNamespace())) {
                toReturn.add(iri.getFragment());
            }
        }
        return toReturn;
    }

    /** @param ontologyManager
     *            ontologyManager
     * @return existing pattern names */
    public static Set<String> getExistingPatternNames(OWLOntologyManager ontologyManager) {
        Set<String> toReturn = new HashSet<String>();
        Set<OWLOntology> ontologies = ontologyManager.getOntologies();
        for (OWLOntology ontology : ontologies) {
            toReturn.addAll(getExistingPatternNames(ontology));
        }
        return toReturn;
    }

    /** @param ontologyManager
     *            ontologyManager
     * @param prefix
     *            prefix
     * @return existing pattern names */
    public static Set<String> getExistingPatternNames(OWLOntologyManager ontologyManager,
            String prefix) {
        Set<String> toReturn = getExistingPatternNames(ontologyManager);
        Iterator<String> it = toReturn.iterator();
        while (it.hasNext()) {
            if (!it.next().startsWith(prefix)) {
                it.remove();
            }
        }
        return toReturn;
    }

    /** @param annotationAxioms
     *            annotationAxioms
     * @return true if pttern is generated */
    public static boolean isPatternGenerated(
            Collection<? extends OWLAnnotation> annotationAxioms) {
        boolean isPatternGenerated = false;
        Iterator<? extends OWLAnnotation> it = annotationAxioms.iterator();
        while (!isPatternGenerated && it.hasNext()) {
            OWLAnnotation axiomAnnotationAxiom = it.next();
            IRI iri = axiomAnnotationAxiom.getProperty().getIRI();
            isPatternGenerated = iri.getNamespace().startsWith(PatternModel.NAMESPACE);
        }
        return isPatternGenerated;
    }

    /** @param annotations
     *            annotations
     * @param manager
     *            manager
     * @param factory
     *            factory
     * @return generating pattern model */
    public static PatternModel getGeneratingPatternModel(
            Collection<? extends OWLAnnotation> annotations, OWLOntologyManager manager,
            AbstractPatternModelFactory factory) {
        PatternModel toReturn = null;
        boolean isPatternGenerated = false;
        String name = null;
        Iterator<? extends OWLAnnotation> it = annotations.iterator();
        while (!isPatternGenerated && it.hasNext()) {
            OWLAnnotation annotation = it.next();
            IRI annotationURI = annotation.getProperty().getIRI();
            String uriString = annotationURI.toString();
            isPatternGenerated = uriString.startsWith(PatternModel.NAMESPACE);
            if (isPatternGenerated) {
                OWLAnnotationValue value = annotation.getValue();
                IRI patternIRI = value.accept(new OWLObjectVisitorExAdapter<IRI>(null) {
                    @Override
                    public IRI visit(OWLLiteral literal) {
                        return IRI.create(literal.getLiteral());
                    }
                });
                if (patternIRI != null) {
                    String fragment = patternIRI.getFragment();
                    if (fragment != null) {
                        name = fragment;
                    }
                }
            }
        }
        if (name != null) {
            toReturn = Utils.find(name, manager, factory);
        }
        return toReturn;
    }

    /** @param patternName
     *            patternName
     * @param annotations
     *            annotations
     * @return true if generated */
    public static boolean isPatternGenerated(final String patternName,
            Collection<? extends OWLAnnotation> annotations) {
        boolean isPatternGenerated = false;
        Iterator<? extends OWLAnnotation> it = annotations.iterator();
        while (!isPatternGenerated && it.hasNext()) {
            OWLAnnotation annotation = it.next();
            isPatternGenerated = annotation.getProperty().getIRI().toString()
                    .startsWith(PatternModel.NAMESPACE)
                    && annotation.getValue().accept(
                            new OWLObjectVisitorExAdapter<Boolean>(false) {
                                @Override
                                public Boolean visit(OWLLiteral literal) {
                                    return literal.getLiteral().endsWith(
                                            patternName + "PatternInstantiation");
                                }
                            });
        }
        return isPatternGenerated;
    }

    /** @param annotations
     *            annotations
     * @return generated pattern name */
    public static String getGeneratedPatternName(
            Collection<? extends OWLAnnotation> annotations) {
        boolean isPatternGenerated = false;
        String toReturn = null;
        Iterator<? extends OWLAnnotation> it = annotations.iterator();
        OWLAnnotation annotation = null;
        while (!isPatternGenerated && it.hasNext()) {
            annotation = it.next();
            isPatternGenerated = annotation.getProperty().getIRI().toString()
                    .startsWith(PatternModel.NAMESPACE);
            if (isPatternGenerated) {
                OWLAnnotationValue value = annotation.getValue();
                IRI patternIRI = value.accept(new OWLObjectVisitorExAdapter<IRI>(null) {
                    @Override
                    public IRI visit(OWLLiteral literal) {
                        return IRI.create(literal.getLiteral());
                    }
                });
                toReturn = patternIRI.getFragment();
            }
        }
        return toReturn;
    }
}

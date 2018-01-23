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

import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternManager;
import org.coode.patterns.PatternModel;
import org.semanticweb.owlapi.io.XMLUtils;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone Jun 10, 2008
 */
public class Utils {

    /**
     * @param ontology ontology
     * @param factory factory
     * @return set of existing patterns
     */
    public static Set<PatternModel> getExistingPatterns(OWLOntology ontology,
        AbstractPatternModelFactory factory) {
        PatternExtractor patternExtractor =
            factory.getPatternExtractor(PatternManager.getDefaultErrorListener());
        return asSet(ontology.annotations().map(a -> (PatternModel) a.accept(patternExtractor)));
    }

    /**
     * @param patternName patternName
     * @param ontology ontology
     * @param factory factory
     * @return found pattern
     */
    public static PatternModel find(String patternName, OWLOntology ontology,
        AbstractPatternModelFactory factory) {
        PatternExtractor patternExtractor =
            factory.getPatternExtractor(PatternManager.getDefaultErrorListener());
        return ontology.annotations().filter(Utils::annotationInPatternNamespace)
            .map(a -> (PatternModel) a.accept(patternExtractor)).filter(Objects::nonNull)
            .filter(e -> e.getPatternLocalName().equals(patternName)).findFirst().orElse(null);
    }

    /**
     * @param patternName patternName
     * @param ontologyManager ontologyManager
     * @param factory factory
     * @return pattern
     */
    public static PatternModel find(String patternName, OWLOntologyManager ontologyManager,
        AbstractPatternModelFactory factory) {
        return ontologyManager.ontologies().map(p -> find(patternName, p, factory))
            .filter(Objects::nonNull).findAny().orElse(null);
    }

    /**
     * @param ontology ontology
     * @return set of existing pattern names
     */
    public static Set<String> getExistingPatternNames(OWLOntology ontology) {
        return asSet(ontology.annotations().filter(Utils::annotationInPatternNamespace)
            .map(a -> a.getProperty().getIRI().getFragment()));
    }

    protected static boolean annotationInPatternNamespace(OWLAnnotation a) {
        return a.getProperty().getIRI().getNamespace().equals(PatternModel.NAMESPACE);
    }

    /**
     * @param ontologyManager ontologyManager
     * @return existing pattern names
     */
    public static Set<String> getExistingPatternNames(OWLOntologyManager ontologyManager) {
        return asSet(
            ontologyManager.ontologies().map(Utils::getExistingPatternNames).flatMap(Set::stream));
    }

    /**
     * @param ontologyManager ontologyManager
     * @param prefix prefix
     * @return existing pattern names
     */
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

    /**
     * @param annotationAxioms annotationAxioms
     * @return true if pttern is generated
     */
    public static boolean isPatternGenerated(Collection<? extends OWLAnnotation> annotationAxioms) {
        boolean isPatternGenerated = false;
        Iterator<? extends OWLAnnotation> it = annotationAxioms.iterator();
        while (!isPatternGenerated && it.hasNext()) {
            OWLAnnotation axiomAnnotationAxiom = it.next();
            IRI iri = axiomAnnotationAxiom.getProperty().getIRI();
            isPatternGenerated = iri.getNamespace().startsWith(PatternModel.NAMESPACE);
        }
        return isPatternGenerated;
    }

    /**
     * @param annotations annotations
     * @param manager manager
     * @param factory factory
     * @return generating pattern model
     */
    public static PatternModel getGeneratingPatternModel(
        Collection<? extends OWLAnnotation> annotations, OWLOntologyManager manager,
        AbstractPatternModelFactory factory) {
        PatternModel toReturn = null;
        boolean isPatternGenerated = false;
        String name = null;
        Iterator<? extends OWLAnnotation> it = annotations.iterator();
        while (!isPatternGenerated && it.hasNext()) {
            OWLAnnotation annotation = it.next();
            isPatternGenerated = annotationInPatternNamespace(annotation);
            if (isPatternGenerated) {
                String patternIRIFragment = annotation.getValue().mapLiteral(OWLLiteral::getLiteral)
                    .map(XMLUtils::getNCNameSuffix).orElse("");
                if (!patternIRIFragment.isEmpty()) {
                    name = patternIRIFragment;
                }
            }
        }
        if (name != null) {
            toReturn = Utils.find(name, manager, factory);
        }
        return toReturn;
    }

    /**
     * @param patternName patternName
     * @param annotations annotations
     * @return true if generated
     */
    public static boolean isPatternGenerated(final String patternName,
        Collection<? extends OWLAnnotation> annotations) {
        boolean isPatternGenerated = false;
        Iterator<? extends OWLAnnotation> it = annotations.iterator();
        while (!isPatternGenerated && it.hasNext()) {
            OWLAnnotation annotation = it.next();
            isPatternGenerated = isPatternGenerated(annotation, patternName);
        }
        return isPatternGenerated;
    }

    private static Boolean patternGenerated(String name, String literal) {
        return Boolean.valueOf(literal.endsWith(name + "PatternInstantiation"));
    }

    private static boolean isPatternGenerated(OWLAnnotation a, String patternName) {
        if (!annotationInPatternNamespace(a)) {
            return false;
        }
        return a.literalValue().map(l -> patternGenerated(patternName, l.getLiteral()))
            .orElse(Boolean.FALSE).booleanValue();
    }

    /**
     * @param annotations annotations
     * @return generated pattern name
     */
    public static String getGeneratedPatternName(Collection<? extends OWLAnnotation> annotations) {
        boolean isPatternGenerated = false;
        String toReturn = null;
        Iterator<? extends OWLAnnotation> it = annotations.iterator();
        OWLAnnotation annotation = null;
        while (!isPatternGenerated && it.hasNext()) {
            annotation = it.next();
            isPatternGenerated =
                annotation.getProperty().getIRI().toString().startsWith(PatternModel.NAMESPACE);
            if (isPatternGenerated) {
                toReturn = annotation.getValue().mapLiteral(OWLLiteral::getLiteral)
                    .map(XMLUtils::getNCNameSuffix).orElse("");
            }
        }
        return toReturn;
    }
}

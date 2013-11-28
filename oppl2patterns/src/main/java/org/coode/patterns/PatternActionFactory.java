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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ActionType;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.RemoveAxiom;

/** @author Luigi Iannone Jul 3, 2008 */
public class PatternActionFactory {
    /** createdBy short name */
    public static final String CREATED_BY = "createdBy";

    /** @param thisClass
     * @param actionType
     * @param axiom
     * @param instantiatedPatternModel
     * @param owlDataFactory
     * @param annotationIRI
     * @param ontology
     * @param handler
     * @return changes */
    public static Collection<? extends OWLAxiomChange> createChange(OWLClass thisClass,
            ActionType actionType, OWLAxiom axiom,
            InstantiatedPatternModel instantiatedPatternModel,
            OWLDataFactory owlDataFactory, IRI annotationIRI, OWLOntology ontology,
            RuntimeExceptionHandler handler) {
        instantiatedPatternModel.instantiate(instantiatedPatternModel
                .getConstraintSystem().getThisClassVariable(), thisClass);
        return createChange(actionType, axiom, instantiatedPatternModel, owlDataFactory,
                annotationIRI, ontology, handler);
    }

    /** @param instantiatedAxiom
     * @param actionType
     * @param changes
     * @param instantiatedPatternModel
     * @param owlDataFactory
     * @param ontology
     * @param annotationIRI */
    private static void addChange(OWLAxiom instantiatedAxiom, ActionType actionType,
            List<OWLAxiomChange> changes,
            InstantiatedPatternModel instantiatedPatternModel,
            OWLDataFactory owlDataFactory, OWLOntology ontology, IRI annotationIRI) {
        OWLAxiomChange axiomChange = null;
        if (instantiatedPatternModel.getConstraintSystem()
                .getAxiomVariables(instantiatedAxiom).isEmpty()) {
            switch (actionType) {
                case ADD:
                    OWLAnnotation annotation = owlDataFactory.getOWLAnnotation(
                            owlDataFactory.getOWLAnnotationProperty(IRI
                                    .create(PatternModel.NAMESPACE
                                            + PatternActionFactory.CREATED_BY)),
                            owlDataFactory.getOWLLiteral(annotationIRI.toString()));
                    axiomChange = new AddAxiom(ontology,
                            instantiatedAxiom.getAnnotatedAxiom(Collections
                                    .singleton(annotation)));
                    changes.add(axiomChange);
                    break;
                case REMOVE:
                    axiomChange = new RemoveAxiom(ontology, instantiatedAxiom);
                    changes.add(axiomChange);
                    break;
                default:
                    break;
            }
        }
    }

    /** @param actionType
     * @param axiom
     * @param instantiatedPatternModel
     * @param owlDataFactory
     * @param annotationIRI
     * @param ontology
     * @param handler
     * @return changes */
    public static Collection<? extends OWLAxiomChange> createChange(
            ActionType actionType, OWLAxiom axiom,
            InstantiatedPatternModel instantiatedPatternModel,
            OWLDataFactory owlDataFactory, IRI annotationIRI, OWLOntology ontology,
            RuntimeExceptionHandler handler) {
        List<OWLAxiomChange> toReturn = new ArrayList<OWLAxiomChange>();
        Set<BindingNode> bindingNodes = instantiatedPatternModel.extractBindingNodes();
        if (instantiatedPatternModel.getPatternModel().getInputVariables().isEmpty()
                && !instantiatedPatternModel.getPatternModel().isClassPattern()
                || !bindingNodes.isEmpty()) {
            if (instantiatedPatternModel.getPatternModel().getInputVariables().isEmpty()
                    && !instantiatedPatternModel.getPatternModel().isClassPattern()) {
                // empty variables
                addChange(axiom, actionType, toReturn, instantiatedPatternModel,
                        owlDataFactory, ontology, annotationIRI);
            } else {
                instantiatedPatternModel.getConstraintSystem().setLeaves(bindingNodes);
                for (BindingNode bindingNode : bindingNodes) {
                    ValueComputationParameters parameters = new SimpleValueComputationParameters(
                            instantiatedPatternModel.getConstraintSystem(), bindingNode,
                            handler);
                    PartialOWLObjectInstantiator instatiator = new PartialOWLObjectInstantiator(
                            parameters);
                    OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instatiator);
                    addChange(instantiatedAxiom, actionType, toReturn,
                            instantiatedPatternModel, owlDataFactory, ontology,
                            annotationIRI);
                }
            }
        }
        return toReturn;
    }
}

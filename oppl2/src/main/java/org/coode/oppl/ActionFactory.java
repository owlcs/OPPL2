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
package org.coode.oppl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.RemoveAxiom;

/**
 * Adapts actions to appropriate changes
 * 
 * @author Luigi Iannone
 */
public class ActionFactory {

    /**
     * @param actionType actionType
     * @param axiom axiom
     * @param cs cs
     * @param ontology ontology
     * @param runtimeExcpetionHandler runtimeExcpetionHandler
     * @return list of changes
     */
    public static Stream<OWLAxiomChange> createChanges(ActionType actionType, OWLAxiom axiom,
        ConstraintSystem cs, OWLOntology ontology,
        RuntimeExceptionHandler runtimeExcpetionHandler) {
        Set<OWLAxiomChange> toReturn = new HashSet<>();
        Set<BindingNode> leaves = cs.getLeaves();
        if (leaves != null) {
            for (BindingNode bindingNode : leaves) {
                SimpleValueComputationParameters parameters =
                    new SimpleValueComputationParameters(cs, bindingNode, runtimeExcpetionHandler);
                PartialOWLObjectInstantiator instatiator =
                    new PartialOWLObjectInstantiator(parameters);
                OWLAxiom instantiatedAxiom = (OWLAxiom) axiom.accept(instatiator);
                switch (actionType) {
                    case ADD:
                        toReturn.add(new AddAxiom(ontology, instantiatedAxiom));
                        break;
                    case REMOVE:
                        toReturn.add(new RemoveAxiom(ontology, instantiatedAxiom));
                        break;
                    default:
                        break;
                }
            }
        } else if (cs.getAxiomVariables(axiom).isEmpty()) {
            switch (actionType) {
                case ADD:
                    toReturn.add(new AddAxiom(ontology, axiom));
                    break;
                case REMOVE:
                    toReturn.add(new RemoveAxiom(ontology, axiom));
                    break;
                default:
                    break;
            }
        }
        return toReturn.stream();
    }

    /**
     * @param actionType actionType
     * @param axiom axiom
     * @param cs cs
     * @param ontologies ontologies
     * @param runtimeExceptionHandler runtimeExceptionHandler
     * @return the List of OWLAxiomChange
     */
    public static Stream<OWLAxiomChange> createChanges(ActionType actionType, OWLAxiom axiom,
        ConstraintSystem cs, Stream<OWLOntology> ontologies,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        return ontologies
            .flatMap(o -> createChanges(actionType, axiom, cs, o, runtimeExceptionHandler));
    }
}

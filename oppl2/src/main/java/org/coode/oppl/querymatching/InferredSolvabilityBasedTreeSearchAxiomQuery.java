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
package org.coode.oppl.querymatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.search.OPPLInferredOWLAxiomSearchTree;
import org.coode.oppl.search.OPPLOWLAxiomSearchNode;
import org.coode.oppl.search.solvability.InferredSolvabilitySearchTree;
import org.coode.oppl.search.solvability.SolvabilitySearchNode;
import org.coode.oppl.utils.PositionBasedVariableComparator;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLAxiom;

/** @author Luigi Iannone */
public class InferredSolvabilityBasedTreeSearchAxiomQuery extends AbstractAxiomQuery {
    private final ConstraintSystem constraintSystem;
    private final Map<BindingNode, Set<OWLAxiom>> instantiations = new HashMap<BindingNode, Set<OWLAxiom>>();

    public InferredSolvabilityBasedTreeSearchAxiomQuery(
            ConstraintSystem constraintSystem,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        super(runtimeExceptionHandler);
        if (constraintSystem == null) {
            throw new NullPointerException("The constraint system cannot be null");
        }
        this.constraintSystem = constraintSystem;
    }

    @Override
    protected Set<BindingNode> match(OWLAxiom axiom) {
        clearInstantions();
        List<List<? extends OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<? extends OPPLOWLAxiomSearchNode>>();
        VariableExtractor variableExtractor = new VariableExtractor(
                getConstraintSystem(), false);
        Set<Variable<?>> extractedVariables = variableExtractor.extractVariables(axiom);
        SortedSet<Variable<?>> sortedVariables = new TreeSet<Variable<?>>(
                new PositionBasedVariableComparator(axiom, getConstraintSystem()
                        .getOntologyManager().getOWLDataFactory()));
        sortedVariables.addAll(extractedVariables);
        OPPLOWLAxiomSearchNode start = new OPPLOWLAxiomSearchNode(axiom, new BindingNode(
                new HashSet<Assignment>(), sortedVariables));
        solutions.addAll(doMatch(start));
        return extractLeaves(solutions);
    }

    private List<List<? extends OPPLOWLAxiomSearchNode>> doMatch(
            OPPLOWLAxiomSearchNode start) {
        List<List<? extends OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<? extends OPPLOWLAxiomSearchNode>>();
        OWLAxiom axiom = start.getAxiom();
        // Solvability based search is not worth applying if the axiom is not of
        // a specific kind.
        if (axiom.getAxiomType() == AxiomType.SUBCLASS_OF
                || axiom.getAxiomType() == AxiomType.OBJECT_PROPERTY_ASSERTION) {
            solutions.addAll(solvabilityBasedMatching(start.getAxiom(),
                    start.getBinding()));
        } else {
            solutions.addAll(nonSolvabilityBasedMatch(start));
        }
        return solutions;
    }

    private List<List<OPPLOWLAxiomSearchNode>> nonSolvabilityBasedMatch(
            OPPLOWLAxiomSearchNode start) {
        List<List<OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
        OPPLInferredOWLAxiomSearchTree searchTree = new OPPLInferredOWLAxiomSearchTree(
                getConstraintSystem(), getRuntimeExceptionHandler());
        searchTree.exhaustiveSearchTree(start, solutions);
        return solutions;
    }

    private List<List<SolvabilitySearchNode>> solvabilityBasedMatching(OWLAxiom axiom,
            BindingNode bindingNode) {
        InferredSolvabilitySearchTree searchTree = new InferredSolvabilitySearchTree(
                getConstraintSystem(), getRuntimeExceptionHandler());
        List<List<SolvabilitySearchNode>> solutions = new ArrayList<List<SolvabilitySearchNode>>();
        SolvabilitySearchNode start = searchTree.buildSolvabilitySearchNode(axiom,
                bindingNode);
        searchTree.exhaustiveSearchTree(start, solutions);
        return solutions;
    }

    private Set<BindingNode> extractLeaves(
            List<List<? extends OPPLOWLAxiomSearchNode>> solutions) {
        Set<BindingNode> toReturn = new HashSet<BindingNode>();
        for (List<? extends OPPLOWLAxiomSearchNode> path : solutions) {
            OPPLOWLAxiomSearchNode searchLeaf = path.get(path.size() - 1);
            BindingNode leaf = searchLeaf.getBinding();
            toReturn.add(leaf);
        }
        return toReturn;
    }

    private void clearInstantions() {
        instantiations.clear();
    }

    public Map<BindingNode, Set<OWLAxiom>> getInstantiations() {
        return new HashMap<BindingNode, Set<OWLAxiom>>(instantiations);
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }
}

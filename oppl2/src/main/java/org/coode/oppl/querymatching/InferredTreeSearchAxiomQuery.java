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

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.search.OPPLInferredOWLAxiomSearchTree;
import org.coode.oppl.search.OPPLOWLAxiomSearchNode;
import org.coode.oppl.utils.PositionBasedVariableComparator;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;

/** @author Luigi Iannone */
public class InferredTreeSearchAxiomQuery extends AbstractAxiomQuery {
    private final ConstraintSystem constraintSystem;
    private final Map<BindingNode, Set<OWLAxiom>> instantiations = new HashMap<BindingNode, Set<OWLAxiom>>();

    /** @param constraintSystem
     *            constraintSystem
     * @param runtimeExceptionHandler
     *            runtimeExceptionHandler */
    public InferredTreeSearchAxiomQuery(ConstraintSystem constraintSystem,
            RuntimeExceptionHandler runtimeExceptionHandler) {
        super(runtimeExceptionHandler);
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
    }

    @Override
    protected Set<BindingNode> match(OWLAxiom axiom) {
        clearInstantions();
        List<List<OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
        VariableExtractor variableExtractor = new VariableExtractor(
                getConstraintSystem(), false);
        Set<Variable<?>> extractedVariables = variableExtractor.extractVariables(axiom);
        SortedSet<Variable<?>> sortedVariables = new TreeSet<Variable<?>>(
                new PositionBasedVariableComparator(axiom, getConstraintSystem()
                        .getOntologyManager().getOWLDataFactory()));
        sortedVariables.addAll(extractedVariables);
        OPPLOWLAxiomSearchNode start = new OPPLOWLAxiomSearchNode(axiom, new BindingNode(
                sortedVariables));
        solutions.addAll(doMatch(start));
        return extractLeaves(solutions);
    }

    private List<List<OPPLOWLAxiomSearchNode>> doMatch(OPPLOWLAxiomSearchNode start) {
        OPPLInferredOWLAxiomSearchTree searchTree = new OPPLInferredOWLAxiomSearchTree(
                getConstraintSystem(), getRuntimeExceptionHandler());
        List<List<OPPLOWLAxiomSearchNode>> solutions = new ArrayList<List<OPPLOWLAxiomSearchNode>>();
        searchTree.exhaustiveSearchTree(start, solutions);
        return solutions;
    }

    private Set<BindingNode> extractLeaves(List<List<OPPLOWLAxiomSearchNode>> solutions) {
        Set<BindingNode> toReturn = new HashSet<BindingNode>();
        for (List<OPPLOWLAxiomSearchNode> path : solutions) {
            OPPLOWLAxiomSearchNode searchLeaf = path.get(path.size() - 1);
            BindingNode leaf = searchLeaf.getBinding();
            toReturn.add(leaf);
        }
        return toReturn;
    }

    private void clearInstantions() {
        instantiations.clear();
    }

    /** @return instantiations */
    public Map<BindingNode, Set<OWLAxiom>> getInstantiations() {
        return new HashMap<BindingNode, Set<OWLAxiom>>(instantiations);
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }
}

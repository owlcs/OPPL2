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

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.queryplanner.AssertedAxiomPlannerItem;
import org.coode.oppl.queryplanner.ComplexityEstimate;
import org.coode.oppl.queryplanner.ConstraintQueryPlannerItem;
import org.coode.oppl.queryplanner.InferredAxiomQueryPlannerItem;
import org.coode.oppl.queryplanner.QueryPlannerItem;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.VariableExtractor;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;
import org.semanticweb.owlapi.model.OWLRuntimeException;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class OPPLQueryImpl implements OPPLQuery {

    private final List<OWLAxiom> axioms = new ArrayList<>();
    private final List<OWLAxiom> assertedAxioms = new ArrayList<>();
    private final Set<AbstractConstraint> constraints = new HashSet<>();
    private final ConstraintSystem constraintSystem;
    private boolean dirty = true;
    private final OWLOntologyChangeListener listener = changes -> OPPLQueryImpl.this.setDirty(true);
    private final OPPLAbstractFactory factory;

    /**
     * @param query query
     * @param factory factory
     */
    public OPPLQueryImpl(OPPLQuery query, OPPLAbstractFactory factory) {
        this(query.getConstraintSystem(), factory);
        for (OWLAxiom assertedAxiom : query.getAssertedAxioms()) {
            addAssertedAxiom(assertedAxiom);
        }
        for (OWLAxiom axiom : query.getAxioms()) {
            addAxiom(axiom);
        }
        for (AbstractConstraint constraint : query.getConstraints()) {
            addConstraint(constraint);
        }
    }

    /**
     * @param constraintSystem constraintSystem
     * @param factory factory
     */
    public OPPLQueryImpl(ConstraintSystem constraintSystem, OPPLAbstractFactory factory) {
        this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
        constraintSystem.getOntologyManager().addOntologyChangeListener(listener);
        this.factory = checkNotNull(factory);
    }

    @Override
    public void addAssertedAxiom(OWLAxiom axiom) {
        checkNotNull(axiom, "axiom");
        assertedAxioms.add(axiom);
    }

    @Override
    public void addAxiom(OWLAxiom axiom) {
        checkNotNull(axiom, "axiom");
        axioms.add(axiom);
    }

    @Override
    public void addConstraint(AbstractConstraint constraint) {
        checkNotNull(constraint, "constraint");
        constraints.add(constraint);
    }

    @Override
    public List<OWLAxiom> getAxioms() {
        return new ArrayList<>(axioms);
    }

    @Override
    public List<OWLAxiom> getAssertedAxioms() {
        return new ArrayList<>(assertedAxioms);
    }

    @Override
    public List<AbstractConstraint> getConstraints() {
        return new ArrayList<>(constraints);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("SELECT ");
        int i = 0;
        for (OWLAxiom axiom : assertedAxioms) {
            ManchesterSyntaxRenderer renderer =
                factory.getManchesterSyntaxRenderer(constraintSystem);
            buffer.append("ASSERTED ");
            axiom.accept(renderer);
            buffer.append(renderer.toString());
            if (i < assertedAxioms.size() - 1) {
                buffer.append(",");
            }
            buffer.append('\n');
            i++;
        }
        i = 0;
        for (OWLAxiom axiom : axioms) {
            ManchesterSyntaxRenderer renderer =
                factory.getManchesterSyntaxRenderer(constraintSystem);
            axiom.accept(renderer);
            buffer.append(renderer.toString());
            if (i < axioms.size() - 1) {
                buffer.append(",");
            }
            buffer.append('\n');
            i++;
        }
        if (constraints.size() > 0) {
            buffer.append(" WHERE ");
            i = 0;
            for (AbstractConstraint c : constraints) {
                buffer.append(c.render(getConstraintSystem()));
                if (i < constraints.size() - 1) {
                    buffer.append(",");
                }
                buffer.append('\n');
                i++;
            }
        }
        return buffer.toString();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        StringBuffer buffer = new StringBuffer("SELECT ");
        int i = 0;
        for (OWLAxiom axiom : assertedAxioms) {
            ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(shortFormProvider);
            buffer.append("ASSERTED ");
            axiom.accept(renderer);
            buffer.append(renderer.toString());
            if (i < assertedAxioms.size() - 1) {
                buffer.append(",");
            }
            buffer.append('\n');
            i++;
        }
        i = 0;
        for (OWLAxiom axiom : axioms) {
            ManchesterSyntaxRenderer renderer = new ManchesterSyntaxRenderer(shortFormProvider);
            axiom.accept(renderer);
            buffer.append(renderer.toString());
            if (i < axioms.size() - 1) {
                buffer.append(",");
            }
            buffer.append('\n');
            i++;
        }
        if (constraints.size() > 0) {
            buffer.append(" WHERE ");
            i = 0;
            for (AbstractConstraint c : constraints) {
                buffer.append(c.render(shortFormProvider));
                if (i < constraints.size() - 1) {
                    buffer.append(",");
                }
                buffer.append('\n');
                i++;
            }
        }
        return buffer.toString();
    }

    @Override
    public String render(ConstraintSystem cs) {
        return render();
    }

    @Override
    public String render() {
        StringBuffer buffer = new StringBuffer("SELECT ");
        int i = 0;
        for (OWLAxiom axiom : assertedAxioms) {
            ManchesterSyntaxRenderer renderer =
                factory.getManchesterSyntaxRenderer(constraintSystem);
            buffer.append("ASSERTED ");
            axiom.accept(renderer);
            buffer.append(renderer.toString());
            if (i < assertedAxioms.size() - 1) {
                buffer.append(",");
            }
            buffer.append('\n');
            i++;
        }
        i = 0;
        for (OWLAxiom axiom : axioms) {
            ManchesterSyntaxRenderer renderer =
                factory.getManchesterSyntaxRenderer(constraintSystem);
            axiom.accept(renderer);
            buffer.append(renderer.toString());
            if (i < axioms.size() - 1) {
                buffer.append(",");
            }
            buffer.append('\n');
            i++;
        }
        if (constraints.size() > 0) {
            buffer.append("\nWHERE ");
            i = 0;
            for (AbstractConstraint c : constraints) {
                buffer.append(c.render(getConstraintSystem()));
                if (i < constraints.size() - 1) {
                    buffer.append(",");
                }
                buffer.append('\n');
                i++;
            }
        }
        return buffer.toString();
    }

    @Override
    public ConstraintSystem getConstraintSystem() {
        return constraintSystem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (assertedAxioms == null ? 0 : assertedAxioms.hashCode());
        result = prime * result + (axioms == null ? 0 : axioms.hashCode());
        result = prime * result + (constraints == null ? 0 : constraints.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        OPPLQueryImpl other = (OPPLQueryImpl) obj;
        if (assertedAxioms == null) {
            if (other.assertedAxioms != null) {
                return false;
            }
        } else if (!assertedAxioms.equals(other.assertedAxioms)) {
            return false;
        }
        if (axioms == null) {
            if (other.axioms != null) {
                return false;
            }
        } else if (!axioms.equals(other.axioms)) {
            return false;
        }
        if (constraints == null) {
            if (other.constraints != null) {
                return false;
            }
        } else if (!constraints.equals(other.constraints)) {
            return false;
        }
        return true;
    }

    @Override
    public void execute(Collection<? extends BindingNode> leaves,
        RuntimeExceptionHandler runtimeExceptionHandler, ExecutionMonitor executionMonitor) {
        try {
            constraintSystem.setLeaves(leaves);
            doExecute(runtimeExceptionHandler, false, executionMonitor);
            setDirty(false);
        } catch (OWLRuntimeException e) {
            runtimeExceptionHandler.handleOWLRuntimeException(e);
        }
    }

    @Override
    public void execute(RuntimeExceptionHandler runtimeExceptionHandler,
        ExecutionMonitor executionMonitor) {
        if (isDirty()) {
            try {
                doExecute(runtimeExceptionHandler, true, executionMonitor);
                setDirty(executionMonitor.isCancelled());
            } catch (OWLRuntimeException e) {
                runtimeExceptionHandler.handleOWLRuntimeException(e);
            }
        }
    }

    /**
     * @param runtimeExceptionHandler runtimeExceptionHandler
     * @param resetConstraintSystem resetConstraintSystem
     * @param executionMonitor executionMonitor
     * @throws OWLRuntimeException OWLRuntimeException
     */
    private void doExecute(RuntimeExceptionHandler runtimeExceptionHandler,
        boolean resetConstraintSystem, ExecutionMonitor executionMonitor)
        throws OWLRuntimeException {
        if (resetConstraintSystem) {
            getConstraintSystem().reset();
        }
        Set<BindingNode> currentLeaves = getConstraintSystem().getLeaves();
        List<QueryPlannerItem> queryPlannerItems = new ArrayList<>();
        for (OWLAxiom axiom : assertedAxioms) {
            queryPlannerItems.add(new AssertedAxiomPlannerItem(getConstraintSystem(), axiom));
        }
        for (OWLAxiom axiom : axioms) {
            // TODO: can be optimised using de-composition in simpler axioms see
            // http://www.webont.org/owled/2011/papers/owled2011_submission_4.pdf
            // Table 1
            queryPlannerItems.add(new InferredAxiomQueryPlannerItem(getConstraintSystem(), axiom));
        }
        final ComplexityEstimate complexityEstimate =
            new ComplexityEstimate(constraintSystem, runtimeExceptionHandler);
        Comparator<QueryPlannerItem> comparator = (anItem, anotherItem) -> {
            int toReturn = 0;
            if (anItem == null) {
                toReturn = anotherItem == null ? toReturn : -1;
            } else {
                int difference = (int) Math.signum(anItem.accept(complexityEstimate).floatValue()
                    - anotherItem.accept(complexityEstimate).floatValue());
                toReturn =
                    difference == 0 ? anItem.hashCode() - anotherItem.hashCode() : difference;
            }
            return toReturn;
        };
        Collections.sort(queryPlannerItems, comparator);
        int increment = (int) Math.ceil((double) 100 / (double) queryPlannerItems.size());
        int progress = 0;
        // I want to sort the constraints separately as their matching can only
        // happen on existing leaves.
        List<ConstraintQueryPlannerItem> constraintsItems = new ArrayList<>();
        for (AbstractConstraint c : constraints) {
            constraintsItems.add(new ConstraintQueryPlannerItem(getConstraintSystem(), c));
        }
        Iterator<QueryPlannerItem> iterator = queryPlannerItems.iterator();
        while (!executionMonitor.isCancelled() && iterator.hasNext()) {
            QueryPlannerItem queryPlannerItem = iterator.next();
            currentLeaves =
                queryPlannerItem.match(currentLeaves, executionMonitor, runtimeExceptionHandler);
            // Now I check the constraints
            for (int i = 0; i < constraintsItems.size();) {
                ConstraintQueryPlannerItem c = constraintsItems.get(i);
                if (executionMonitor.isCancelled()) {
                    break;
                }
                if (canMatch(c, currentLeaves, runtimeExceptionHandler)) {
                    currentLeaves =
                        c.match(currentLeaves, executionMonitor, runtimeExceptionHandler);
                    constraintsItems.remove(i);
                } else {
                    i++;
                }
            }
            progress += increment;
            executionMonitor.progressIncrementChanged(progress);
        }
        if (executionMonitor.isCancelled()) {
            currentLeaves = null;
        }
        getConstraintSystem().setLeaves(currentLeaves);
    }

    private boolean canMatch(ConstraintQueryPlannerItem c, Set<BindingNode> currentLeaves,
        RuntimeExceptionHandler runtimeExceptionHandler) {
        boolean found = false;
        AbstractConstraint constraint = c.getConstraint();
        Iterator<BindingNode> iterator = currentLeaves.iterator();
        while (!found && iterator.hasNext()) {
            final BindingNode bindingNode = iterator.next();
            final SimpleValueComputationParameters parameters =
                new SimpleValueComputationParameters(getConstraintSystem(), bindingNode,
                    runtimeExceptionHandler);
            final OWLObjectInstantiator instantiator = new OWLObjectInstantiator(parameters);
            final VariableExtractor variableExtractor =
                new VariableExtractor(OPPLQueryImpl.this.getConstraintSystem(), false);
            found = constraint.accept(new ConstraintVisitorEx<Boolean>() {

                @Override
                public Boolean visit(InequalityConstraint ic) {
                    OWLObject instantiatedExpression = ic.getExpression().accept(instantiator);
                    return Boolean.valueOf(bindingNode.getAssignmentValue(ic.getVariable(),
                        parameters) == null
                        || !variableExtractor.extractVariables(instantiatedExpression).isEmpty());
                }

                @Override
                public Boolean visit(InCollectionConstraint<? extends OWLObject> icc) {
                    for (OWLObject owlObject : icc.getCollection()) {
                        OWLObject instantiated = owlObject.accept(instantiator);
                        if (!variableExtractor.extractVariables(instantiated).isEmpty()) {
                            return Boolean.TRUE;
                        }
                    }
                    return Boolean.valueOf(
                        bindingNode.getAssignmentValue(icc.getVariable(), parameters) == null);
                }

                @Override
                public Boolean visit(RegExpConstraint rc) {
                    OPPLFunction<Pattern> expression = rc.getExpression();
                    for (Variable<?> variable : variableExtractor.extractVariables(expression)) {
                        if (bindingNode.getAssignmentValue(variable, parameters) == null) {
                            return Boolean.TRUE;
                        }
                    }
                    return Boolean.valueOf(
                        bindingNode.getAssignmentValue(rc.getVariable(), parameters) == null);
                }

                @Override
                public Boolean visit(NAFConstraint nafConstraint) {
                    OWLAxiom instantiatedAxiom =
                        (OWLAxiom) nafConstraint.getAxiom().accept(instantiator);
                    Set<Variable<?>> extractedVariables =
                        variableExtractor.extractVariables(instantiatedAxiom);
                    return Boolean.valueOf(!extractedVariables.isEmpty());
                }
            }).booleanValue();
        }
        return !found;
    }

    /**
     * @return the dirty
     */
    public boolean isDirty() {
        return dirty;
    }

    /**
     * @param dirty the dirty to set
     */
    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}

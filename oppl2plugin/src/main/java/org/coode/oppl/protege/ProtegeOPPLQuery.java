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
package org.coode.oppl.protege;

import java.util.Collection;
import java.util.List;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ExecutionMonitor;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone */
public class ProtegeOPPLQuery implements OPPLQuery {
    private final OPPLQuery opplQuery;

    /** @param opplQuery */
    public ProtegeOPPLQuery(OPPLQuery opplQuery) {
        this.opplQuery = opplQuery;
    }

    @Override
    public void addAssertedAxiom(OWLAxiom axiom) {
        opplQuery.addAssertedAxiom(axiom);
    }

    @Override
    public void addAxiom(OWLAxiom axiom) {
        opplQuery.addAxiom(axiom);
    }

    @Override
    public void addConstraint(AbstractConstraint constraint) {
        opplQuery.addConstraint(constraint);
    }

    @Override
    public List<OWLAxiom> getAssertedAxioms() {
        return opplQuery.getAssertedAxioms();
    }

    @Override
    public List<OWLAxiom> getAxioms() {
        return opplQuery.getAxioms();
    }

    @Override
    public List<AbstractConstraint> getConstraints() {
        return opplQuery.getConstraints();
    }

    @Override
    public String toString() {
        return opplQuery.toString();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return opplQuery.render(shortFormProvider);
    }

    @Override
    public String render() {
        return opplQuery.render();
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return render();
    }

    @Override
    public ConstraintSystem getConstraintSystem() {
        return opplQuery.getConstraintSystem();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (opplQuery == null ? 0 : opplQuery.hashCode());
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
        ProtegeOPPLQuery other = (ProtegeOPPLQuery) obj;
        if (opplQuery == null) {
            if (other.opplQuery != null) {
                return false;
            }
        } else if (!opplQuery.equals(other.opplQuery)) {
            return false;
        }
        return true;
    }

    @Override
    public void execute(RuntimeExceptionHandler runtimeExceptionHandler,
            ExecutionMonitor executionMonitor) {
        opplQuery.execute(runtimeExceptionHandler, executionMonitor);
    }

    @Override
    public void execute(Collection<? extends BindingNode> leaves,
            RuntimeExceptionHandler runtimeExceptionHandler,
            ExecutionMonitor executionMonitor) {
        opplQuery.execute(leaves, runtimeExceptionHandler, executionMonitor);
    }
}

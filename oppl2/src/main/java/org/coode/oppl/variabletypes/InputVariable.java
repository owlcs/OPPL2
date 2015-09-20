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
package org.coode.oppl.variabletypes;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.*;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * @param <O>
 *        type
 */
public class InputVariable<O extends OWLObject> implements Variable<O> {

    private final String name;
    private final VariableType<O> type;
    private final IRI iri;
    private final VariableScope<?> variableScope;

    InputVariable(String name, VariableType<O> type) {
        this(name, type, null);
    }

    InputVariable(String name, VariableType<O> type, VariableScope<?> variableScope) {
        this.name = checkNotNull(name, "name");
        this.type = checkNotNull(type, "type");
        this.iri = IRI.create(ManchesterVariableSyntax.NAMESPACE, name);
        this.variableScope = variableScope;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IRI getIRI() {
        return this.iri;
    }

    @Override
    public VariableType<O> getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.getType();
    }

    /**
     * @return variable scope
     */
    public VariableScope<?> getVariableScope() {
        return this.variableScope;
    }

    @Override
    public <T> T accept(VariableVisitorEx<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public void accept(VariableVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        final int prime = 907;
        int result = 1;
        result = prime * result + (this.name == null ? 0 : this.name.hashCode());
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
        InputVariable<?> other = (InputVariable<?>) obj;
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        String scope = this.getVariableScope() == null ? "" : this.getVariableScope()
            .render(constraintSystem);
        return String.format("%s:%s%s", this.getName(), this.getType(), scope);
    }

    static <P extends OWLObject> InputVariable<P> getInputVariable(String name,
        VariableType<P> type, VariableScope<?> variableScope) {
        return new InputVariable<>(name, type, variableScope);
    }
}

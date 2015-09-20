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

import java.util.List;

import org.coode.oppl.*;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class ProtegeOPPLScript implements OPPLScript {

    private final OPPLScript opplScript;

    /**
     * @param opplScript
     *        opplScript
     */
    public ProtegeOPPLScript(OPPLScript opplScript) {
        this.opplScript = opplScript;
    }

    @Override
    public void accept(OPPLScriptVisitor visitor) {
        opplScript.accept(visitor);
    }

    @Override
    public <P> P accept(OPPLScriptVisitorEx<P> visitor) {
        return opplScript.accept(visitor);
    }

    @Override
    public List<OWLAxiomChange> getActions() {
        return opplScript.getActions();
    }

    @Override
    public ConstraintSystem getConstraintSystem() {
        return opplScript.getConstraintSystem();
    }

    @Override
    public List<InputVariable<?>> getInputVariables() {
        return opplScript.getInputVariables();
    }

    @Override
    public OPPLQuery getQuery() {
        return opplScript.getQuery();
    }

    @Override
    public List<Variable<?>> getVariables() {
        return opplScript.getVariables();
    }

    @Override
    public String toString() {
        return opplScript.toString();
    }

    @Override
    public String render(ShortFormProvider shortFormProvider) {
        return opplScript.render(shortFormProvider);
    }

    @Override
    public String render(ConstraintSystem constraintSystem) {
        return render();
    }

    @Override
    public String render() {
        return opplScript.render();
    }

    @Override
    public void addVariable(Variable<?> variable) {
        opplScript.addVariable(variable);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (opplScript == null ? 0 : opplScript.hashCode());
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
        ProtegeOPPLScript other = (ProtegeOPPLScript) obj;
        if (opplScript == null) {
            if (other.opplScript != null) {
                return false;
            }
        } else if (!opplScript.equals(other.opplScript)) {
            return false;
        }
        return true;
    }
}

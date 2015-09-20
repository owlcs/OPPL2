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
package org.coode.patterns.protege;

import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.patterns.InstantiatedPatternModel;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone Jun 12, 2008
 */
public class ProtegeInstantiatedPatternModel extends InstantiatedPatternModel {

    private final OWLModelManager modelManager;

    /**
     * @param patternModel
     *        patternModel
     * @param handler
     *        handler
     */
    public ProtegeInstantiatedPatternModel(ProtegePatternModel patternModel,
        RuntimeExceptionHandler handler) {
        super(patternModel, handler);
        modelManager = patternModel.getModelManager();
    }

    @Override
    protected String render(OWLObject owlObject) {
        return modelManager.getRendering(owlObject);
    }

    @Override
    public String render() {
        StringBuilder toReturn = new StringBuilder("$"
            + getInstantiatedPatternLocalName() + "(");
        boolean first = true;
        for (Variable<?> variable : getInputVariables()) {
            if (!first) {
                toReturn.append(", ");
            } else {
                first = false;
            }
            Set<OWLObject> instantiationsValues = getInstantiations(variable);
            if (instantiationsValues != null && !instantiationsValues.isEmpty()) {
                if (instantiationsValues.size() == 1) {
                    OWLObject instantiation = instantiationsValues.iterator().next();
                    toReturn.append(modelManager.getRendering(instantiation));
                } else {
                    boolean firstInstantiation = true;
                    toReturn.append("{");
                    for (OWLObject instantiation : instantiationsValues) {
                        String instantiationRendering = modelManager
                            .getRendering(instantiation);
                        toReturn.append(firstInstantiation ? instantiationRendering
                            : ", " + instantiationRendering);
                        firstInstantiation = firstInstantiation ? false
                            : firstInstantiation;
                    }
                    toReturn.append("}");
                }
            } else {
                toReturn.append(variable.getName());
            }
        }
        toReturn.append(")");
        return toReturn.toString();
    }
}

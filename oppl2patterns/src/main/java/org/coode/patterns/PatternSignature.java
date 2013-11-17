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

import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.patterns.utils.Utils;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** @author Luigi Iannone Jul 15, 2008 */
public class PatternSignature {
    private final String name;
    private final PatternModel pattern;

    /** @param name */
    public PatternSignature(String name, OWLOntologyManager ontologyManger,
            AbstractPatternModelFactory factory) throws PatternException {
        this.name = name;
        Set<String> existingPatternNames = Utils.getExistingPatternNames(ontologyManger);
        if (existingPatternNames.contains(name)) {
            pattern = Utils.find(name, ontologyManger, factory);
        } else {
            throw new PatternReferenceNotFoundException(name);
        }
    }

    public VariableType<?> getIthVariableType(int i) throws PatternException {
        try {
            return pattern.getInputVariables().get(i).getType();
        } catch (IndexOutOfBoundsException e) {
            throw new ArgumentIndexOutOfBoundsException(name, i);
        }
    }

    public Variable<?> getIthVariable(int i) throws PatternException {
        try {
            return pattern.getInputVariables().get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new ArgumentIndexOutOfBoundsException(name, i);
        }
    }

    public int size() {
        return pattern.getInputVariables().size();
    }

    /** @return the pattern */
    public PatternModel getPattern() {
        return pattern;
    }
}

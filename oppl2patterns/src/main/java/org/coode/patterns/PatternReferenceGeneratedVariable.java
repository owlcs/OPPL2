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

import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone Dec 10, 2008
 * @param <O> */
public class PatternReferenceGeneratedVariable<O extends OWLObject> extends
        GeneratedVariable<O> {
    /** @param referenceName
     * @param type
     * @param value */
    public PatternReferenceGeneratedVariable(String referenceName, VariableType<O> type,
            PatternReference<O> value) {
        super(referenceName, type, value);
    }

    /** @param referenceName
     * @param type
     * @param value
     * @return pattern reference generated variable */
    public static <T extends OWLObject> PatternReferenceGeneratedVariable<T>
            getPatternReferenceGeneratedVariable(String referenceName,
                    VariableType<T> type, PatternReference<T> value) {
        return new PatternReferenceGeneratedVariable<T>(referenceName, type, value);
    }
}

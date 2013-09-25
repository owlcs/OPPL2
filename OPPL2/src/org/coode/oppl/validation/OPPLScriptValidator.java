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
package org.coode.oppl.validation;

import org.coode.oppl.OPPLScript;

/** Abstract mechanism for validating OPPLScript flavours. Implementing this
 * interface adds custom checks to impose further constraints thank one of the
 * OPPL parser for valid scripts.
 * 
 * @author Luigi Iannone */
public interface OPPLScriptValidator {
    /** @param script
     *            The script to validate. Cannot be {@code null}.
     * @return true if the input script is valid according to this
     *         OPPLScriptValidator. */
    boolean accept(OPPLScript script);

    /** @return a natural language explanation of the validation rule(s) for this
     *         OPPLScriptValidator. */
    String getValidationRuleDescription();
}

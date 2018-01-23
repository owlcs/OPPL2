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
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.add;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.semanticweb.owlapi.model.OWLAxiomChange;

/**
 * Returns the changes that will occur if the visited OPPL construct is executed
 * 
 * @author Luigi Iannone
 */
public class ChangeExtractor {

    private final boolean considerImportClosure;
    private final RuntimeExceptionHandler runtimeExceptionHandler;
    private final ExecutionMonitor executionMonitor;

    /**
     * @param runtimeExceptionHandler runtimeExceptionHandler
     * @param considerImportClosure considerImportClosure
     */
    public ChangeExtractor(RuntimeExceptionHandler runtimeExceptionHandler,
        boolean considerImportClosure) {
        this(runtimeExceptionHandler, ExecutionMonitor.NON_CANCELLABLE, considerImportClosure);
    }

    /**
     * @param runtimeExceptionHandler runtimeExceptionHandler
     * @param executionMonitor executionMonitor
     * @param considerImportClosure considerImportClosure
     */
    public ChangeExtractor(RuntimeExceptionHandler runtimeExceptionHandler,
        ExecutionMonitor executionMonitor, boolean considerImportClosure) {
        this.executionMonitor = checkNotNull(executionMonitor, "executionMonitor");
        this.runtimeExceptionHandler =
            checkNotNull(runtimeExceptionHandler, "runtimeExceptionHandler");
        this.considerImportClosure = considerImportClosure;
    }

    /**
     * @param script script
     * @return changes
     */
    public List<OWLAxiomChange> visit(OPPLScript script) {
        OPPLQuery q = checkNotNull(script, "script").getQuery();
        if (q != null) {
            q.execute(getRuntimeExceptionHandler(), getExecutionMonitor());
        }
        List<OWLAxiomChange> toReturn = new ArrayList<>();
        List<OWLAxiomChange> changes = script.getActions();
        ConstraintSystem cs = script.getConstraintSystem();
        for (OWLAxiomChange change : changes) {
            boolean isAdd = change.isAddAxiom();
            ActionType action = isAdd ? ActionType.ADD : ActionType.REMOVE;
            if (considerImportClosure && !isAdd) {
                add(toReturn, ActionFactory.createChanges(action, change.getAxiom(), cs,
                    cs.getOntology().importsClosure(), getRuntimeExceptionHandler()));
            } else {
                add(toReturn, ActionFactory.createChanges(action, change.getAxiom(), cs,
                    cs.getOntology(), getRuntimeExceptionHandler()));
            }
        }
        return toReturn;
    }

    /**
     * @return the runtimeExceptionHandler
     */
    public RuntimeExceptionHandler getRuntimeExceptionHandler() {
        return runtimeExceptionHandler;
    }

    /**
     * @return the executionMonitor
     */
    public ExecutionMonitor getExecutionMonitor() {
        return executionMonitor;
    }
}

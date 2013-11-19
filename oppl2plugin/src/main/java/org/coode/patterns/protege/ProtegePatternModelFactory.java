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

import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.parsers.ErrorListener;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.EmptyActionListException;
import org.coode.patterns.EmptyVariableListException;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternConstraintSystem;
import org.coode.patterns.PatternExtractor;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternModelFactory;
import org.coode.patterns.UnsuitableOPPLScriptException;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiomChange;

/** @author Luigi Iannone Jun 16, 2008 */
public class ProtegePatternModelFactory implements AbstractPatternModelFactory {
    private final AbstractPatternModelFactory delegate;

    /** @param modelManager */
    public ProtegePatternModelFactory(OWLModelManager modelManager) {
        if (modelManager == null) {
            throw new NullPointerException("The model manager cannot be null");
        }
        delegate = new PatternModelFactory(modelManager.getActiveOntology(),
                modelManager.getOWLOntologyManager(), modelManager.getReasoner());
    }

    @Override
    public PatternModel createPatternModel(String name, List<Variable<?>> variables,
            List<OWLAxiomChange> actions, Variable<?> returnClause, String rendering,
            ConstraintSystem constraintSystem) throws EmptyVariableListException,
            EmptyActionListException, UnsuitableOPPLScriptException {
        return delegate.createPatternModel(name, variables, actions, returnClause,
                rendering, constraintSystem);
    }

    @Override
    public PatternModel createPatternModel(OPPLScript opplScript)
            throws UnsuitableOPPLScriptException {
        return delegate.createPatternModel(opplScript);
    }

    @Override
    public InstantiatedPatternModel createInstantiatedPatternModel(
            PatternModel patternModel, RuntimeExceptionHandler handler) {
        return delegate.createInstantiatedPatternModel(patternModel, handler);
    }

    @Override
    public PatternExtractor getPatternExtractor(ErrorListener errorListener) {
        return delegate.getPatternExtractor(errorListener);
    }

    @Override
    public PatternExtractor getPatternExtractor(Set<OWLAnnotation> visitedAnnotations,
            ErrorListener errorListener) {
        return delegate.getPatternExtractor(visitedAnnotations, errorListener);
    }

    @Override
    public PatternConstraintSystem createConstraintSystem() {
        return delegate.createConstraintSystem();
    }

    @Override
    public ManchesterSyntaxRenderer getRenderer(
            PatternConstraintSystem patternConstraintSystem) {
        return delegate.getRenderer(patternConstraintSystem);
    }

    @Override
    public OPPLAbstractFactory getOPPLFactory() {
        return delegate.getOPPLFactory();
    }
}

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

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.List;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLQueryImpl;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.OPPLScriptImpl;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.entity.OWLEntityFactory;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.rendering.VariableOWLEntityRenderer;
import org.coode.oppl.variablemansyntax.ProtegeScopeVariableChecker;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.ShortFormProvider;

/** @author Luigi Iannone */
public final class ProtegeOPPLFactory implements OPPLAbstractFactory {
    /** Adapter between {@code org.coode.oppl.entity.OWLEntityRenderer} and
     * {@code org.protege.editor.owl.ui.renderer.OWLEntityRenderer}
     * 
     * @author Luigi Iannone */
    private final class ProtegeOWLEntityRenderer implements OWLEntityRenderer {
        public ProtegeOWLEntityRenderer() {}

        @Override
        public String render(OWLEntity entity) {
            return getOWLEditorKit().getOWLModelManager().getRendering(entity);
        }
    }

    private final OWLEditorKit owlEditorKit;
    private ProtegeScopeVariableChecker variableScopeVariableChecker = null;

    /** @param owlEditorKit
     *            owlEditorKit */
    public ProtegeOPPLFactory(OWLEditorKit owlEditorKit) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
    }

    @Override
    public OWLEntityChecker getOWLEntityChecker() {
        return new ProtegeOWLEntityChecker(getOWLEditorKit());
    }

    @Override
    public VariableScopeChecker getVariableScopeChecker() throws OPPLException {
        if (variableScopeVariableChecker == null) {
            variableScopeVariableChecker = new ProtegeScopeVariableChecker(
                    getOWLEditorKit().getOWLModelManager());
        }
        return variableScopeVariableChecker;
    }

    @Override
    public OWLEntityRenderer getOWLEntityRenderer(ConstraintSystem cs) {
        return new VariableOWLEntityRenderer(checkNotNull(cs, "constraint system"),
                new ProtegeOWLEntityRenderer());
    }

    @Override
    public OWLEntityFactory getOWLEntityFactory() {
        return new ProtegeOWLEntityFactory(this);
    }

    @Override
    public OPPLScript
            buildOPPLScript(ConstraintSystem constraintSystem1,
                    List<Variable<?>> variables, OPPLQuery opplQuery,
                    List<OWLAxiomChange> actions) {
        if (variables == null || variables.contains(null)) {
            throw new IllegalArgumentException("Invalid variables");
        }
        if (actions == null || actions.contains(null)) {
            throw new IllegalArgumentException("Invalid actions");
        }
        ProtegeOPPLScript toReturn = new ProtegeOPPLScript(new OPPLScriptImpl(
                constraintSystem1, variables, opplQuery, actions, this));
        return toReturn;
    }

    @Override
    public OPPLQuery buildNewQuery(ConstraintSystem constraintSystem1) {
        OPPLQuery opplQuery = new OPPLQueryImpl(constraintSystem1, this);
        return new ProtegeOPPLQuery(opplQuery);
    }

    @Override
    public ConstraintSystem createConstraintSystem() {
        OWLReasoner reasoner = getOWLEditorKit().getOWLModelManager().getReasoner() instanceof NoOpReasoner ? null
                : getOWLEditorKit().getOWLModelManager().getReasoner();
        return new ConstraintSystem(getOWLEditorKit().getOWLModelManager()
                .getActiveOntology(), getOWLEditorKit().getOWLModelManager()
                .getOWLOntologyManager(), reasoner, this);
    }

    @Override
    public OWLOntology getOntology() {
        return getOWLEditorKit().getOWLModelManager().getActiveOntology();
    }

    /** @return the constraintSystem */
    public ConstraintSystem getConstraintSystem() {
        return createConstraintSystem();
    }

    @Override
    public OWLDataFactory getOWLDataFactory() {
        return getOWLEditorKit().getOWLModelManager().getOWLDataFactory();
    }

    @Override
    public ManchesterSyntaxRenderer
            getManchesterSyntaxRenderer(final ConstraintSystem cs) {
        checkNotNull(cs, "constraint system");
        return new ManchesterSyntaxRenderer(new ShortFormProvider() {
            @Override
            public String getShortForm(OWLEntity entity) {
                return ProtegeOPPLFactory.this.getOWLEntityRenderer(cs).render(entity);
            }

            @Override
            public void dispose() {}
        });
    }

    @Override
    public OWLOntologyManager getOntologyManager() {
        return getOWLEditorKit().getOWLModelManager().getOWLOntologyManager();
    }

    @Override
    public OPPLScript importOPPLScript(OPPLScript opplScript) {
        ConstraintSystem newConstraintSystem = createConstraintSystem();
        for (Variable<?> variable : opplScript.getConstraintSystem().getVariables()) {
            newConstraintSystem.importVariable(variable);
        }
        return new ProtegeOPPLScript(new OPPLScriptImpl(newConstraintSystem,
                opplScript.getVariables(), opplScript.getQuery(),
                opplScript.getActions(), this, true));
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    @Override
    public IRI getDefaultOntologyIRI() {
        return OPPLFactory.DEFAULT_ONTOLOGY_IRI;
    }
}

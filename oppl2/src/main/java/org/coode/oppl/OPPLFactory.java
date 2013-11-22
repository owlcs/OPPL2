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

import java.util.List;

import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.entity.OWLEntityRendererImpl;
import org.coode.oppl.exceptions.NullReasonerException;
import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.rendering.VariableOWLEntityRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.expression.ShortFormEntityChecker;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/** @author Luigi Iannone */
public class OPPLFactory implements OPPLAbstractFactory {
    private final OWLOntologyManager ontologyManager;
    private VariableScopeChecker variableScopeChecker = null;
    private final OWLReasoner reasoner;
    private final OWLOntology ontology;
    private OWLEntityChecker entityChecker = null;
    public static final IRI DEFAULT_ONTOLOGY_IRI = IRI
            .create("http://www.coode.org/oppl");

    /** @param ontologyManager
     * @param constraintSystem
     * @param dataFactory */
    public OPPLFactory(OWLOntologyManager ontologyManager, OWLOntology ontology,
            OWLReasoner reasoner) {
        this.ontologyManager = ontologyManager;
        this.ontology = ontology;
        this.reasoner = reasoner;
        entityChecker = defaultEntityChecker();
    }

    private OWLEntityChecker defaultEntityChecker() {
        BidirectionalShortFormProviderAdapter bshp = new BidirectionalShortFormProviderAdapter(
                ontologyManager.getOntologies(), new OPPLShortFormProvider(
                        new SimpleShortFormProvider()));
        // XXX fix for missing Thing
        bshp.add(ontologyManager.getOWLDataFactory().getOWLThing());
        bshp.add(ontologyManager.getOWLDataFactory().getOWLNothing());
        return new ShortFormEntityChecker(bshp);
    }

    @Override
    public OWLEntityChecker getOWLEntityChecker() {
        return entityChecker;
    }

    @Override
    public VariableScopeChecker getVariableScopeChecker() throws OPPLException {
        if (reasoner != null) {
            variableScopeChecker = variableScopeChecker != null ? variableScopeChecker
                    : new VariableScopeChecker(ontologyManager, reasoner);
        } else {
            throw new NullReasonerException();
        }
        return variableScopeChecker;
    }

    @Override
    public OWLEntityRenderer getOWLEntityRenderer(ConstraintSystem cs) {
        ArgCheck.checkNullArgument("The constraint system", cs);
        OWLEntityRendererImpl defaultRenderer = new OWLEntityRendererImpl();
        return new VariableOWLEntityRenderer(cs, defaultRenderer);
    }

    @Override
    public org.coode.oppl.entity.OWLEntityFactory getOWLEntityFactory() {
        return new EntityFactory(this);
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
        return new OPPLScriptImpl(constraintSystem1, variables, opplQuery, actions, this);
    }

    @Override
    public OPPLQuery buildNewQuery(ConstraintSystem constraintSystem1) {
        return new OPPLQueryImpl(constraintSystem1, this);
    }

    @Override
    public ConstraintSystem createConstraintSystem() {
        return reasoner == null ? new ConstraintSystem(ontology, ontologyManager, this)
                : new ConstraintSystem(ontology, ontologyManager, reasoner, this);
    }

    @Override
    public OWLDataFactory getOWLDataFactory() {
        return ontologyManager.getOWLDataFactory();
    }

    @Override
    public ManchesterSyntaxRenderer getManchesterSyntaxRenderer(ConstraintSystem cs) {
        ArgCheck.checkNullArgument("The constraint system", cs);
        return new ManchesterSyntaxRenderer(new OPPLShortFormProvider(
                new SimpleShortFormProvider()));
    }

    @Override
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    @Override
    public OPPLScript importOPPLScript(OPPLScript opplScript) {
        ConstraintSystem newConstraintSystem = createConstraintSystem();
        for (Variable<?> variable : opplScript.getConstraintSystem().getVariables()) {
            newConstraintSystem.importVariable(variable);
        }
        return new OPPLScriptImpl(newConstraintSystem, opplScript.getVariables(),
                opplScript.getQuery(), opplScript.getActions(), this, true);
    }

    @Override
    public OWLOntology getOntology() {
        return ontology;
    }

    @Override
    public IRI getDefaultOntologyIRI() {
        return DEFAULT_ONTOLOGY_IRI;
    }
}

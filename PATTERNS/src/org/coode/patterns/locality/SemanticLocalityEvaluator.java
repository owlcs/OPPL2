package org.coode.patterns.locality;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** <p/>
 * Title:
 * </p>
 * <p/>
 * Description:
 * </p>
 * <p/>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p/>
 * Company: Clark & Parsia, LLC. <http://www.clarkparsia.com>
 * </p>
 * 
 * @author Evren Sirin */
public final class SemanticLocalityEvaluator implements LocalityEvaluator {
    protected OWLDataFactory df;
    private final AxiomLocality axiomVisitor;
    private final BottomReplacer bottomReplacer;
    protected OWLReasoner reasoner;

    public SemanticLocalityEvaluator(OWLOntologyManager man, OWLReasoner reasoner) {
        df = man.getOWLDataFactory();
        this.reasoner = reasoner;
        axiomVisitor = new AxiomLocality(reasoner);
        bottomReplacer = new BottomReplacer(df);
    }

    /** True if the axiom is semantically local w.r.t. given signature */
    @Override
    public boolean isLocal(OWLAxiom axiom, Set<? extends OWLEntity> signature) {
        OWLAxiom newAxiom = bottomReplacer.replaceBottom(axiom, signature);
        boolean toReturn = newAxiom == null || axiomVisitor.isLocal(newAxiom);
        // if (axiom instanceof OWLClassAssertionAxiom) {
        // System.out
        // .println("SemanticLocalityEvaluator.isLocal() replaced axiom: "
        // + axiom
        // + "\nreplacing axiom: "
        // + newAxiom
        // + "\nlocal? " + toReturn);
        // }
        return toReturn;
        // if (newAxiom == null) {
        // return this.axiomVisitor.isLocal(axiom);
        // } else {
        // return this.axiomVisitor.isLocal(newAxiom);
        // }
    }
}

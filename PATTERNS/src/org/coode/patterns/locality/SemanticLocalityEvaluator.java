package org.coode.patterns.locality;

import java.util.Set;

import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObjectVisitor;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * <p/>
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
 * @author Evren Sirin
 */
public final class SemanticLocalityEvaluator implements LocalityEvaluator {
	protected OWLDataFactory df;
	private AxiomLocalityVisitor axiomVisitor;
	private BottomReplacer bottomReplacer;
	protected OWLReasoner reasoner;

	public SemanticLocalityEvaluator(OWLOntologyManager man,
			OWLReasoner reasoner) {
		this.df = man.getOWLDataFactory();
		this.reasoner = reasoner;
		axiomVisitor = new AxiomLocalityVisitor(reasoner, df);
		bottomReplacer = new BottomReplacer(df);
	}

	/**
	 * True if the axiom is semantically local w.r.t. given signature
	 */
	public boolean isLocal(OWLAxiom axiom, Set<? extends OWLEntity> signature) {
		OWLAxiom newAxiom = this.bottomReplacer.replaceBottom(axiom, signature);
		boolean toReturn = newAxiom == null
				|| this.axiomVisitor.isLocal(newAxiom);
//		if (axiom instanceof OWLClassAssertionAxiom) {
//			System.out
//					.println("SemanticLocalityEvaluator.isLocal() replaced axiom: "
//							+ axiom
//							+ "\nreplacing axiom: "
//							+ newAxiom
//							+ "\nlocal? " + toReturn);
//		}
		return toReturn;
		//		if (newAxiom == null) {
		//			return this.axiomVisitor.isLocal(axiom);
		//		} else {
		//			return this.axiomVisitor.isLocal(newAxiom);
		//		}
	}
}

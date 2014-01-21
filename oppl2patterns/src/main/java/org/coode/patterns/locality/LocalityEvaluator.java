package org.coode.patterns.locality;

import java.util.Set;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLEntity;

/** Copyright: Copyright (c) 2007 Company: Clark &amp; Parsia, LLC. <a
 * href="http://www.clarkparsia.com">clarkparsia</a>
 * 
 * @author Evren Sirin */
public interface LocalityEvaluator {
    /** @param axiom
     *            The axiom to test
     * @param signature
     *            The signature
     * @return <code>true</code> if the axiom is local w.r.t. given signature
     *         otherwise <code>false</code> */
    boolean isLocal(OWLAxiom axiom, Set<? extends OWLEntity> signature);
}

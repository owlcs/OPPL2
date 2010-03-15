package org.coode.oppl.test;

import java.util.Arrays;
import java.util.HashSet;

import org.coode.oppl.OPPLScript;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.inference.OWLReasonerFactory;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.reasonerfactory.factpp.FaCTPlusPlusReasonerFactory;

public class TambisTestCase extends AbstractTestCase {
	@Override
	protected OWLReasoner initReasoner(OWLOntology... ontologies)
			throws OWLReasonerException {
		OWLReasonerFactory reasonerFactory = new FaCTPlusPlusReasonerFactory();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontologyManager);
		reasoner.loadOntologies(new HashSet<OWLOntology>(Arrays
				.asList(ontologies)));
		reasoner.classify();
		return reasoner;
	}

	public void testTambis() {
		OPPLScript result = this.parse(
				"?x:CLASS, ?y:CLASS SELECT ASSERTED ?x equivalentTo ?y;",
				"tambis-full.owl");
		this.expectedCorrect(result);
		this.execute(result);
	}
}

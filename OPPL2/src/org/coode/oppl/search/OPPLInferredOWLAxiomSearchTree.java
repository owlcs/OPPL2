/**
 *
 */
package org.coode.oppl.search;

import org.coode.oppl.utils.DefaultOWLAxiomVisitorEx;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;

import com.clarkparsia.explanation.SatisfiabilityConverter;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLInferredOWLAxiomSearchTree extends AbstractOPPLAxiomSearchTree {
	private final DefaultOWLAxiomVisitorEx<Boolean> tautologyDetector = new DefaultOWLAxiomVisitorEx<Boolean>() {
		@Override
		protected Boolean doDefault(OWLAxiom axiom) {
			return false;
		};

		@Override
		public Boolean visit(OWLEquivalentDataPropertiesAxiom axiom) {
			return axiom.getProperties().size() == 1;
		};

		@Override
		public Boolean visit(OWLEquivalentObjectPropertiesAxiom axiom) {
			return axiom.getProperties().size() == 1;
		};

		@Override
		public Boolean visit(OWLEquivalentClassesAxiom axiom) {
			return axiom.getDescriptions().size() == 1;
		};
	};

	public OPPLInferredOWLAxiomSearchTree(ConstraintSystem constraintSystem) {
		super(constraintSystem);
	}

	/**
	 * @return {@code true} if the input {@link OPPLOWLAxiomSearchNode}
	 *         represents an OWLAxiom that can be inferred using the reasoner
	 *         exposed by the ConstraintSystem.
	 * @see org.coode.oppl.search.SearchTree#goalReached(java.lang.Object)
	 */
	@Override
	protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
		boolean toReturn = start.getBinding().isLeaf();
		if (toReturn) {
			toReturn = start.getAxiom().accept(this.tautologyDetector);
			if (!toReturn) {
				SatisfiabilityConverter converter = new SatisfiabilityConverter(
						this.getConstraintSystem().getOntologyManager()
								.getOWLDataFactory());
				OWLDescription conversion = converter.convert(start.getAxiom());
				try {
					toReturn = !this.getConstraintSystem().getReasoner()
							.isSatisfiable(conversion);
				} catch (OWLReasonerException e) {
					e.printStackTrace();
					toReturn = false;
				}
			}
		}
		return toReturn;
	}
}

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
package org.coode.patterns;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.SystemErrorEcho;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLAxiomVisitor;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLOntologyChange;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.OWLOntologyChangeListener;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.RemoveAxiom;
import org.semanticweb.owl.model.SWRLRule;

/**
 * @author Luigi Iannone
 * 
 *         Jul 3, 2008
 */
public class PatternManager implements OWLOntologyChangeListener {
	static abstract class AbstractEmptyManager {
		public void visit(OWLSubClassAxiom axiom) {
		}

		public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		}

		public void visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		}

		public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
		}

		public void visit(OWLDisjointClassesAxiom axiom) {
		}

		public void visit(OWLDataPropertyDomainAxiom axiom) {
		}

		public void visit(OWLImportsDeclaration axiom) {
		}

		public void visit(OWLAxiomAnnotationAxiom axiom) {
		}

		public void visit(OWLObjectPropertyDomainAxiom axiom) {
		}

		public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
		}

		public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		}

		public void visit(OWLDifferentIndividualsAxiom axiom) {
		}

		public void visit(OWLDisjointDataPropertiesAxiom axiom) {
		}

		public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
		}

		public void visit(OWLObjectPropertyRangeAxiom axiom) {
		}

		public void visit(OWLObjectPropertyAssertionAxiom axiom) {
		}

		public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
		}

		public void visit(OWLObjectSubPropertyAxiom axiom) {
		}

		public void visit(OWLDisjointUnionAxiom axiom) {
		}

		public void visit(OWLDeclarationAxiom axiom) {
		}

		public void visit(OWLOntologyAnnotationAxiom axiom) {
		}

		public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
		}

		public void visit(OWLDataPropertyRangeAxiom axiom) {
		}

		public void visit(OWLFunctionalDataPropertyAxiom axiom) {
		}

		public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
		}

		public void visit(OWLClassAssertionAxiom axiom) {
		}

		public void visit(OWLEquivalentClassesAxiom axiom) {
		}

		public void visit(OWLDataPropertyAssertionAxiom axiom) {
		}

		public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
		}

		public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		}

		public void visit(OWLDataSubPropertyAxiom axiom) {
		}

		public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		}

		public void visit(OWLSameIndividualsAxiom axiom) {
		}

		public void visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		}

		public void visit(OWLInverseObjectPropertiesAxiom axiom) {
		}

		public void visit(SWRLRule rule) {
		}
	}

	static class AdditionManager extends AbstractEmptyManager implements OWLAxiomVisitor {
		private OWLOntologyManager ontologyManager;
		private OWLOntology ontology;
		private final AbstractPatternModelFactory factory;

		public AdditionManager(OWLOntology ontology, OWLOntologyManager ontologyManager,
				AbstractPatternModelFactory f) {
			this.ontologyManager = ontologyManager;
			this.ontology = ontology;
			this.factory = f;
		}

		public void visit(OWLEntityAnnotationAxiom axiom) {
			PatternExtractor patternExtractor = this.factory.getPatternExtractor(getDefaultErrorListener());
			OWLAnnotation<? extends OWLObject> annotation = axiom.getAnnotation();
			OPPLScript patternModel = annotation.accept(patternExtractor);
			OWLEntity subject = axiom.getSubject();
			if (patternModel != null && subject instanceof OWLClass
					&& patternModel instanceof InstantiatedPatternModel) {
				PatternOPPLScript opplStatement = ((InstantiatedPatternModel) patternModel).getInstantiatedPattern();
				ClassPatternExecutor patternExecutor = new ClassPatternExecutor((OWLClass) subject,
						(InstantiatedPatternModel) patternModel, this.ontology,
						this.ontologyManager, annotation.getAnnotationURI());
				List<OWLAxiomChange> changes = opplStatement.accept(patternExecutor);
				try {
					this.ontologyManager.applyChanges(changes);
				} catch (OWLOntologyChangeException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	static class DeletionManager extends AbstractEmptyManager implements OWLAxiomVisitor {
		private final OWLOntologyManager ontologyManager;
		private final AbstractPatternModelFactory factory;

		/**
		 * @param ontologyManager
		 */
		public DeletionManager(OWLOntologyManager ontologyManager, AbstractPatternModelFactory f) {
			this.ontologyManager = ontologyManager;
			this.factory = f;
		}

		public void visit(OWLEntityAnnotationAxiom axiom) {
			PatternExtractor patternExtractor = this.factory.getPatternExtractor(getDefaultErrorListener());
			// System.out.println("Parsing " + axiom);
			OWLAnnotation<? extends OWLObject> annotation = axiom.getAnnotation();
			PatternOPPLScript patternModel = annotation.accept(patternExtractor);
			OWLEntity subject = axiom.getSubject();
			List<OWLAxiomChange> changes = new ArrayList<OWLAxiomChange>();
			if (patternModel != null && subject instanceof OWLClass
					&& patternModel instanceof InstantiatedPatternModel) {
				Set<OWLOntology> ontologies = this.ontologyManager.getOntologies();
				for (OWLOntology ontology : ontologies) {
					Set<OWLAxiom> axioms = ontology.getAxioms();
					for (OWLAxiom anOntologyAxiom : axioms) {
						Set<OWLAxiomAnnotationAxiom> annotationAxioms = anOntologyAxiom.getAnnotationAxioms(ontology);
						for (OWLAxiomAnnotationAxiom axiomAnnotationAxiom : annotationAxioms) {
							String value = axiomAnnotationAxiom.getAnnotation().getAnnotationValueAsConstant().getLiteral();
							URI annotationURI = axiomAnnotationAxiom.getAnnotation().getAnnotationURI();
							if (value.equals(patternModel.getUri().toString())
									&& annotationURI.equals(URI.create(PatternModel.NAMESPACE
											+ PatternActionFactory.CREATED_BY))) {
								changes.add(new RemoveAxiom(ontology, anOntologyAxiom));
							}
						}
					}
				}
				try {
					this.ontologyManager.applyChanges(changes);
				} catch (OWLOntologyChangeException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	private static Map<OWLOntologyManager, PatternManager> instances = new HashMap<OWLOntologyManager, PatternManager>();
	private final OWLOntologyManager ontologyManager;
	private final AbstractPatternModelFactory factory;

	PatternManager(OWLOntologyManager ontologyManager, AbstractPatternModelFactory f) {
		this.ontologyManager = ontologyManager;
		this.factory = f;
	}

	public AbstractPatternModelFactory getFactory() {
		return this.factory;
	}

	/**
	 * 
	 * @see org.semanticweb.owl.model.OWLOntologyChangeListener#ontologiesChanged(java.util.List)
	 */
	public void ontologiesChanged(List<? extends OWLOntologyChange> changes) throws OWLException {
		for (OWLOntologyChange ontologyChange : changes) {
			if (ontologyChange.isAxiomChange()) {
				OWLOntology ontology = ontologyChange.getOntology();
				OWLAxiomChange axiomChange = (OWLAxiomChange) ontologyChange;
				OWLAxiom axiom = axiomChange.getAxiom();
				OWLAxiomVisitor visitor;
				if (axiomChange instanceof AddAxiom) {
					visitor = new AdditionManager(ontology, this.ontologyManager, this.factory);
					axiom.accept(visitor);
				} else if (axiomChange instanceof RemoveAxiom) {
					visitor = new DeletionManager(this.ontologyManager, this.factory);
					axiom.accept(visitor);
				}
			}
		}
	}

	/**
	 * @return the instance
	 */
	public static synchronized PatternManager getInstance(OWLOntologyManager ontologyManager,
			AbstractPatternModelFactory f) {
		PatternManager patternManager = instances.get(ontologyManager);
		if (patternManager == null) {
			patternManager = new PatternManager(ontologyManager, f);
			instances.put(ontologyManager, patternManager);
		}
		return patternManager;
	}

	public static ErrorListener getDefaultErrorListener() {
		return new SystemErrorEcho();
	}
}

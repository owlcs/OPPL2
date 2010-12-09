package org.coode.patterns.locality;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.patterns.InstantiatedPatternModel;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyIRIMapper;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.OWLEntityCollector;

public class LocalityChecker {
	private class SigmaBuilder implements VariableTypeVisitorEx<OWLEntity> {
		private final OWLOntologyManager manager;
		private final OWLDataFactory factory;

		private SigmaBuilder(OWLOntologyManager manager) {
			this.manager = manager;
			this.factory = manager.getOWLDataFactory();
		}

		IRI create() {
			return IRI.create("urn:sigmaplus:a" + UUID.randomUUID().toString());
		}

		public OWLAnnotationProperty visitANNOTATIONPROPERTYVariableType(
				ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
			OWLAnnotationProperty property = this.factory.getOWLAnnotationProperty(this.create());
			try {
				this.manager.addAxiom(
						LocalityChecker.this.scratchpad,
						this.factory.getOWLDeclarationAxiom(property));
			} catch (OWLOntologyChangeException e) {
				// should never happen
				throw new RuntimeException("Unexpected condition", e);
			}
			return property;
		}

		public OWLEntity visitINDIVIDUALVariableType(INDIVIDUALVariableType v) {
			OWLNamedIndividual owlIndividual = this.factory.getOWLNamedIndividual(this.create());
			try {
				this.manager.addAxiom(
						LocalityChecker.this.scratchpad,
						this.factory.getOWLDeclarationAxiom(owlIndividual));
			} catch (OWLOntologyChangeException e) {
				// should never happen
				throw new RuntimeException("Unexpected condition", e);
			}
			return owlIndividual;
		}

		public OWLEntity visitDATAPROPERTYVariableType(DATAPROPERTYVariableType v) {
			OWLDataProperty owlDataProperty = this.factory.getOWLDataProperty(this.create());
			try {
				this.manager.addAxiom(
						LocalityChecker.this.scratchpad,
						this.factory.getOWLDeclarationAxiom(owlDataProperty));
			} catch (OWLOntologyChangeException e) {
				// should never happen
				throw new RuntimeException("Unexpected condition", e);
			}
			return owlDataProperty;
		}

		public OWLEntity visitOBJECTPROPERTYVariableType(OBJECTPROPERTYVariableType v) {
			OWLObjectProperty owlObjectProperty = this.factory.getOWLObjectProperty(this.create());
			try {
				this.manager.addAxiom(
						LocalityChecker.this.scratchpad,
						this.factory.getOWLDeclarationAxiom(owlObjectProperty));
			} catch (OWLOntologyChangeException e) {
				// should never happen
				throw new RuntimeException("Unexpected condition", e);
			}
			return owlObjectProperty;
		}

		public OWLEntity visitCONSTANTVariableType(CONSTANTVariableType v) {
			// it's not an owlentity in this case
			return null;
		}

		public OWLEntity visitCLASSVariableType(CLASSVariableType v) {
			OWLClass owlClass = this.factory.getOWLClass(this.create());
			try {
				this.manager.addAxiom(
						LocalityChecker.this.scratchpad,
						this.factory.getOWLDeclarationAxiom(owlClass));
			} catch (OWLOntologyChangeException e) {
				// should never happen
				throw new RuntimeException("Unexpected condition", e);
			}
			return owlClass;
		}
	}

	private InstantiatedPatternModel instantiatedPatternModel;
	private final Set<OWLEntity> entities = new HashSet<OWLEntity>();
	private LocalityEvaluator evaluator;
	private final OWLOntologyManager myManager;
	private final OWLOntology scratchpad;
	private LocalityCheckerLeafBrusher leafBrusher;
	private final VariableTypeVisitorEx<OWLEntity> plusBuilder;
	private final VariableTypeVisitorEx<OWLEntity> minusBuilder;
	private Map<Variable<?>, SigmaPlusSigmaMinus> sigmaValues;
	private OWLReasoner reasoner;
	private OWLOntologyManager externalManager;
	private final RuntimeExceptionHandler handler;

	public LocalityChecker(final OWLOntologyManager manager, OWLReasoner r,
			Collection<? extends OWLEntity> entities, RuntimeExceptionHandler handler) {
		this.externalManager = manager;
		this.handler = handler;
		this.myManager = OWLManager.createOWLOntologyManager();
		this.myManager.addIRIMapper(new OWLOntologyIRIMapper() {
			public IRI getDocumentIRI(IRI ontologyIRI) {
				return ontologyIRI;
			}
		});
		try {
			this.scratchpad = this.myManager.createOntology(Collections.<OWLAxiom> emptySet());
			// neither exceptions should ever be thrown
		} catch (OWLOntologyCreationException e) {
			throw new RuntimeException("Unexpected exception type", e);
		} catch (OWLOntologyChangeException e) {
			throw new RuntimeException("Unexpected exception type", e);
		}
		this.reasoner = r;
		this.evaluator = new SemanticLocalityEvaluator(this.externalManager, r);
		this.entities.addAll(entities);
		this.plusBuilder = new SigmaBuilder(this.myManager);
		this.minusBuilder = new SigmaBuilder(this.myManager) {
			@Override
			IRI create() {
				return IRI.create("urn:sigmaminus:a" + UUID.randomUUID().toString());
			}
		};
	}

	private void ensureOntologiesUnloaded(OWLReasoner r) {
		// removing the ontologies does not seem to work properly
		// try {
		// r.clearOntologies();
		// } catch (OWLReasonerException e) {
		// e.printStackTrace();
		// }
	}

	public void setSignature(Collection<? extends OWLEntity> owlentities) {
		this.entities.clear();
		this.entities.addAll(owlentities);
	}

	public void setInstantiatedPatternModel(InstantiatedPatternModel m) {
		this.instantiatedPatternModel = m;
	}

	public boolean isLocal() {
		this.sigmaValues = this.buildMinimalBindingNodes();
		BindingNode rootBindingNode = new BindingNode(Collections.<Assignment> emptySet(),
				this.sigmaValues.keySet());
		this.leafBrusher = new LocalityCheckerLeafBrusher(this.getEvaluator(),
				this.getInstantiatedPatternModel().getConstraintSystem(),
				this.getInstantiatedPatternModel().getInstantiatedPattern(), this.sigmaValues,
				this.getEntities(), this.getHandler());
		rootBindingNode.accept(this.leafBrusher);
		boolean local = this.leafBrusher.isLocal();
		this.ensureOntologiesUnloaded(this.reasoner);
		return local;
	}

	public Map<Variable<?>, Collection<OWLObject>> extractAllPossibleBindingNodes(OWLOntology o,
			Set<OWLEntity> signature) {
		Map<Variable<?>, Collection<OWLObject>> toReturn = new HashMap<Variable<?>, Collection<OWLObject>>();
		List<InputVariable<?>> inputVariables = this.instantiatedPatternModel.getInputVariables();
		for (InputVariable<?> v : inputVariables) {
			Set<OWLObject> values = new HashSet<OWLObject>();
			toReturn.put(v, values);
			if (this.instantiatedPatternModel.getInstantiations(v).size() == 0) {
				// no instantiations
				Set<? extends OWLObject> referencedValues = v.getType().getReferencedOWLObjects(
						Arrays.asList(o));
				for (OWLObject bind : referencedValues) {
					if (signature.contains(bind)) {
						values.add(bind);
					}
				}
				toReturn.put(v, values);
			}
		}
		return toReturn;
	}

	public Map<Variable<?>, SigmaPlusSigmaMinus> buildMinimalBindingNodes() {
		Map<Variable<?>, SigmaPlusSigmaMinus> toReturn = new HashMap<Variable<?>, SigmaPlusSigmaMinus>();
		List<InputVariable<?>> inputVariables = this.instantiatedPatternModel.getInputVariables();
		for (Variable<?> v : inputVariables) {
			if (this.instantiatedPatternModel.getInstantiations(v).size() == 0) {
				SigmaPlusSigmaMinus values = new SigmaPlusSigmaMinus(v.getType().accept(
						this.plusBuilder), v.getType().accept(this.minusBuilder));
				if (values.getPlus() != null && values.getMinus() != null) {
					toReturn.put(v, values);
				}
			}
		}
		return toReturn;
	}

	public List<OWLAxiom> getNonLocalAxioms() {
		return this.leafBrusher.getNonLocalAxioms();
	}

	public List<BindingNode> getExploredNodes() {
		return this.leafBrusher.getExploredBindings();
	}

	public List<Boolean> getExploredNodesLocality() {
		return this.leafBrusher.getExploredBindingsLocality();
	}

	public static Set<OWLEntity> collectEntities(Set<OWLOntology> ontologies) {
		// OWLEntityCollector is invoked differently in the most recent (past 3.1) OWL API
		// the new implementation here is compatible with both versions
		//OWLEntityCollector collector = new OWLEntityCollector();
		Set<OWLEntity> toReturn=new HashSet<OWLEntity>();
		for (OWLOntology o : ontologies) {
			//o.accept(collector);
			toReturn.addAll(o.getSignature());
		}
		return toReturn;//collector.getObjects();
	}

	/**
	 * @return the instantiatedPatternModel
	 */
	public InstantiatedPatternModel getInstantiatedPatternModel() {
		return this.instantiatedPatternModel;
	}

	/**
	 * @return the evaluator
	 */
	public LocalityEvaluator getEvaluator() {
		return this.evaluator;
	}

	/**
	 * @param evaluator
	 *            the evaluator to set
	 */
	public void setEvaluator(LocalityEvaluator evaluator) {
		this.evaluator = evaluator;
	}

	/**
	 * @return the entities
	 */
	public Set<OWLEntity> getEntities() {
		return new HashSet<OWLEntity>(this.entities);
	}

	public Map<Variable<?>, SigmaPlusSigmaMinus> getSigmaValues() {
		return Collections.unmodifiableMap(this.sigmaValues);
	}

	public Set<OWLEntity> getSigmaMinus() {
		Set<OWLEntity> externalSigmaValues = new HashSet<OWLEntity>();
		for (SigmaPlusSigmaMinus s : this.sigmaValues.values()) {
			externalSigmaValues.add(s.getMinus());
		}
		return externalSigmaValues;
	}

	public Set<OWLEntity> getSigmaPlus() {
		Set<OWLEntity> externalSigmaValues = new HashSet<OWLEntity>();
		for (SigmaPlusSigmaMinus s : this.sigmaValues.values()) {
			externalSigmaValues.add(s.getPlus());
		}
		return externalSigmaValues;
	}

	/**
	 * @return the handler
	 */
	public RuntimeExceptionHandler getHandler() {
		return this.handler;
	}
}
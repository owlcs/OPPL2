package org.coode.patterns.locality;

import java.net.URI;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.oppl.variabletypes.CLASSVariable;
import org.coode.oppl.variabletypes.CONSTANTVariable;
import org.coode.oppl.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariable;
import org.coode.patterns.InstantiatedPatternModel;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLOntologyURIMapper;
import org.semanticweb.owl.util.OWLEntityCollector;

public class LocalityChecker {
	private class SigmaBuilder implements VariableTypeVisitorEx<OWLEntity> {
		private final OWLOntologyManager manager;
		private final OWLClass thing;
		private final OWLDataFactory factory;

		private SigmaBuilder(OWLOntologyManager manager) {
			this.manager = manager;
			this.factory = manager.getOWLDataFactory();
			this.thing = this.factory.getOWLThing();
		}

		URI create() {
			return URI.create("urn:sigmaplus:a" + UUID.randomUUID().toString());
		}

		public OWLEntity visit(SingleValueGeneratedVariable<?> v) {
			// generated variables should not be used for this
			return null;
		}

		public OWLEntity visit(INDIVIDUALVariable v) {
			OWLIndividual owlIndividual = this.factory
					.getOWLIndividual(create());
			try {
				this.manager.addAxiom(scratchpad, this.factory
						.getOWLClassAssertionAxiom(owlIndividual, thing));
			} catch (OWLOntologyChangeException e) {
				//should never happen 
				throw new RuntimeException("Unexpected condition", e);
			}
			return owlIndividual;
		}

		public OWLEntity visit(DATAPROPERTYVariable v) {
			OWLDataProperty owlDataProperty = this.factory
					.getOWLDataProperty(create());
			try {
				this.manager.addAxiom(scratchpad,
						this.factory.getOWLDeclarationAxiom(owlDataProperty));
			} catch (OWLOntologyChangeException e) {
				//should never happen 
				throw new RuntimeException("Unexpected condition", e);
			}
			return owlDataProperty;
		}

		public OWLEntity visit(OBJECTPROPERTYVariable v) {
			OWLObjectProperty owlObjectProperty = this.factory
					.getOWLObjectProperty(create());
			try {
				this.manager.addAxiom(scratchpad,
						this.factory.getOWLDeclarationAxiom(owlObjectProperty));
			} catch (OWLOntologyChangeException e) {
				//should never happen 
				throw new RuntimeException("Unexpected condition", e);
			}
			return owlObjectProperty;
		}

		public OWLEntity visit(CONSTANTVariable v) {
			// it's not an owlentity in this case
			return null;
		}

		public OWLEntity visit(CLASSVariable v) {
			OWLClass owlClass = this.factory.getOWLClass(create());
			try {
				this.manager.addAxiom(scratchpad,
						this.factory.getOWLDeclarationAxiom(owlClass));
			} catch (OWLOntologyChangeException e) {
				//should never happen 
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
	private Map<Variable, SigmaPlusSigmaMinus> sigmaValues;
	private OWLReasoner reasoner;
	private OWLOntologyManager externalManager;

	public LocalityChecker(final OWLOntologyManager manager, OWLReasoner r,
			Collection<? extends OWLEntity> entities) {
		this.externalManager = manager;
		this.myManager = OWLManager.createOWLOntologyManager();
		myManager.addURIMapper(new OWLOntologyURIMapper() {
			public URI getPhysicalURI(URI ontologyURI) {
				return ontologyURI;
			}
		});
		try {
			this.scratchpad = myManager.createOntology(Collections
					.<OWLAxiom> emptySet());
			// neither exceptions should ever be thrown
		} catch (OWLOntologyCreationException e) {
			throw new RuntimeException("Unexpected exception type", e);
		} catch (OWLOntologyChangeException e) {
			throw new RuntimeException("Unexpected exception type", e);
		}
		this.reasoner = r;
		ensureClassified(r);
		this.evaluator = new SemanticLocalityEvaluator(externalManager, r);
		this.entities.addAll(entities);
		plusBuilder = new SigmaBuilder(myManager);
		minusBuilder = new SigmaBuilder(myManager) {
			URI create() {
				return URI.create("urn:sigmaminus:a"
						+ UUID.randomUUID().toString());
			}
		};
	}

	private void ensureOntologiesUnloaded(OWLReasoner r) {
		// removing the ontologies does not seem to work properly
//		try {
//			r.clearOntologies();
//		} catch (OWLReasonerException e) {
//			e.printStackTrace();
//		}
	}

	private void ensureClassified(OWLReasoner r) {
		try {
			r.loadOntologies(externalManager.getOntologies());
			r.loadOntologies(myManager.getOntologies());
			if (!r.isClassified()) {
				r.classify();
			}
		} catch (OWLReasonerException e) {
			e.printStackTrace();
		}
	}

	public void setSignature(Collection<? extends OWLEntity> owlentities) {
		this.entities.clear();
		this.entities.addAll(owlentities);
	}

	public void setInstantiatedPatternModel(InstantiatedPatternModel m) {
		this.instantiatedPatternModel = m;
	}

	public boolean isLocal() {
		sigmaValues = buildMinimalBindingNodes();
		ensureClassified( reasoner);
		BindingNode rootBindingNode = new BindingNode(
				Collections.<Assignment> emptySet(), sigmaValues.keySet());
		this.leafBrusher = new LocalityCheckerLeafBrusher(this.getEvaluator(),
				this.getInstantiatedPatternModel().getConstraintSystem(),
				this.getInstantiatedPatternModel().getInstantiatedPattern(),
				sigmaValues, this.getEntities());
		rootBindingNode.accept(this.leafBrusher);
		boolean local = this.leafBrusher.isLocal();
		ensureOntologiesUnloaded(reasoner);
		return local;
	}

	public Map<Variable, Collection<OWLObject>> extractAllPossibleBindingNodes(
			OWLOntology o, Set<OWLEntity> signature) {
		Map<Variable, Collection<OWLObject>> toReturn = new HashMap<Variable, Collection<OWLObject>>();
		List<Variable> inputVariables = instantiatedPatternModel
				.getInputVariables();
		for (Variable v : inputVariables) {
			HashSet<OWLObject> values = new HashSet<OWLObject>();
			//			values.add(instantiatedPatternModel.getPatternModel()
			//					.getConstraintSystem().getOntologyManager()
			//					.getOWLDataFactory().getOWLNothing());
			toReturn.put(v, values);
			if (instantiatedPatternModel.getInstantiations(v).size() == 0) {
				// no instantiations
				Set<? extends OWLObject> referencedValues = v.getType()
						.getReferencedOWLObjects(Arrays.asList(o));
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

	public Map<Variable, SigmaPlusSigmaMinus> buildMinimalBindingNodes() {
		Map<Variable, SigmaPlusSigmaMinus> toReturn = new HashMap<Variable, SigmaPlusSigmaMinus>();
		List<Variable> inputVariables = instantiatedPatternModel
				.getInputVariables();
		for (Variable v : inputVariables) {
			SigmaPlusSigmaMinus values = new SigmaPlusSigmaMinus(
					v.accept(plusBuilder), v.accept(minusBuilder));
			if (values.getPlus() != null && values.getMinus() != null) {
				toReturn.put(v, values);
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
		OWLEntityCollector collector = new OWLEntityCollector();
		for (OWLOntology o : ontologies) {
			o.accept(collector);
		}
		return collector.getObjects();
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

	public Map<Variable, SigmaPlusSigmaMinus> getSigmaValues() {
		return Collections.unmodifiableMap(sigmaValues);
	}

	public Set<OWLEntity> getSigmaMinus() {
		Set<OWLEntity> externalSigmaValues = new HashSet<OWLEntity>();
		for (SigmaPlusSigmaMinus s : sigmaValues.values()) {
			externalSigmaValues.add(s.getMinus());
		}
		return externalSigmaValues;
	}
}
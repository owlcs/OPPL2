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
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.util.OWLEntityCollector;

public class LocalityChecker {
	private InstantiatedPatternModel instantiatedPatternModel;
	private final Set<OWLEntity> entities = new HashSet<OWLEntity>();
	private LocalityEvaluator evaluator;
	private final OWLOntologyManager manager;
	private LocalityCheckerLeafBrusher leafBrusher;
	VariableTypeVisitorEx<OWLEntity> plusBuilder = new VariableTypeVisitorEx<OWLEntity>() {
		URI create() {
			return URI.create("urn:sigmaplus:a" + UUID.randomUUID().toString());
		}

		public OWLEntity visit(SingleValueGeneratedVariable<?> v) {
			return null;
		}

		public OWLEntity visit(INDIVIDUALVariable v) {
			return manager.getOWLDataFactory().getOWLIndividual(create());
		}

		public OWLEntity visit(DATAPROPERTYVariable v) {
			return manager.getOWLDataFactory().getOWLDataProperty(create());
		}

		public OWLEntity visit(OBJECTPROPERTYVariable v) {
			return manager.getOWLDataFactory().getOWLObjectProperty(create());
		}

		public OWLEntity visit(CONSTANTVariable v) {
			return null;
		}

		public OWLEntity visit(CLASSVariable v) {
			return manager.getOWLDataFactory().getOWLClass(create());
		}
	};
	VariableTypeVisitorEx<OWLEntity> minusBuilder = new VariableTypeVisitorEx<OWLEntity>() {
		URI create() {
			return URI
					.create("urn:sigmaminus:a" + UUID.randomUUID().toString());
		}

		public OWLEntity visit(SingleValueGeneratedVariable<?> v) {
			return null;
		}

		public OWLEntity visit(INDIVIDUALVariable v) {
			return manager.getOWLDataFactory().getOWLIndividual(create());
		}

		public OWLEntity visit(DATAPROPERTYVariable v) {
			return manager.getOWLDataFactory().getOWLDataProperty(create());
		}

		public OWLEntity visit(OBJECTPROPERTYVariable v) {
			return manager.getOWLDataFactory().getOWLObjectProperty(create());
		}

		public OWLEntity visit(CONSTANTVariable v) {
			return null;
		}

		public OWLEntity visit(CLASSVariable v) {
			return manager.getOWLDataFactory().getOWLClass(create());
		}
	};
	private Map<Variable, SigmaPlusSigmaMinus> sigmaValues;

	public LocalityChecker(OWLOntologyManager manager, OWLReasoner r,
			Collection<? extends OWLEntity> entities) {
		try {
			r.loadOntologies(manager.getOntologies());
			if (!r.isClassified()) {
				r.classify();
			}
		} catch (OWLReasonerException e) {
			e.printStackTrace();
		}
		this.manager = manager;
		this.evaluator = new SemanticLocalityEvaluator(manager, r);
		this.entities.addAll(entities);
	}

	public void setSignature(Collection<? extends OWLEntity> owlentities) {
		this.entities.clear();
		this.entities.addAll(owlentities);
	}

	public void setInstantiatedPatternModel(InstantiatedPatternModel m) {
		this.instantiatedPatternModel = m;
	}

	public boolean isLocal(OWLOntology o) {
		sigmaValues = buildMinimalBindingNodes(this.entities);
		BindingNode rootBindingNode = new BindingNode(
				Collections.<Assignment> emptySet(), sigmaValues.keySet());
		this.leafBrusher = new LocalityCheckerLeafBrusher(this.getEvaluator(),
				this.getInstantiatedPatternModel().getConstraintSystem(),
				this.getInstantiatedPatternModel().getInstantiatedPattern(),
				sigmaValues, this.getEntities());
		rootBindingNode.accept(this.leafBrusher);
		return this.leafBrusher.isLocal();
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

	public Map<Variable, SigmaPlusSigmaMinus> buildMinimalBindingNodes(
			Collection<OWLEntity> sig) {
		Map<Variable, SigmaPlusSigmaMinus> toReturn = new HashMap<Variable, SigmaPlusSigmaMinus>();
		List<Variable> inputVariables = instantiatedPatternModel
				.getInputVariables();
		for (Variable v : inputVariables) {
			// XXX this uses the first element coming out of the signature, but it's potentially wrong
			// however, the right approach, i.e., generating a new symbol, also requires modification to the ontology, i.e., the new class, property, must be declared in the ontology
			SigmaPlusSigmaMinus values = new SigmaPlusSigmaMinus(sig.iterator()
					.next(), v.accept(minusBuilder));
			toReturn.put(v, values);
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
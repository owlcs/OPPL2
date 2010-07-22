package org.coode.patterns.locality;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
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
	private LocalityCheckerLeafBrusher leafBrusher;

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
		Map<Variable, Set<OWLObject>> toAssign = new HashMap<Variable, Set<OWLObject>>();
		toAssign.clear();
		toAssign.putAll(this.instantiatedPatternModel.extractAllPossibleBindingNodes(
				o,
				this.entities));
		BindingNode rootBindingNode = new BindingNode(Collections.<Assignment> emptySet(),
				toAssign.keySet());
		this.leafBrusher = new LocalityCheckerLeafBrusher(this.getEvaluator(),
				this.getInstantiatedPatternModel().getConstraintSystem(),
				this.getInstantiatedPatternModel().getInstantiatedPattern(), toAssign,
				this.getEntities());
		rootBindingNode.accept(this.leafBrusher);
		return this.leafBrusher.isLocal();
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
}
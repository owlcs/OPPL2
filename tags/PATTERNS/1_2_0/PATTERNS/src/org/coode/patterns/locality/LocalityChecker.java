package org.coode.patterns.locality;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.Assignment;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.patterns.InstantiatedPatternModel;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.util.OWLEntityCollector;

public class LocalityChecker {
	protected InstantiatedPatternModel ipm;
	private Set<OWLEntity> entities;
	private LocalityEvaluator evaluator;
	private LocalityCheckerLeafBrusher leafBrusher;
	private Set<Variable> toAssign;

	public LocalityChecker(OWLOntologyManager manager, OWLReasoner r,
			Set<OWLEntity> entities) {
		try {
			r.loadOntologies(manager.getOntologies());
			if (!r.isClassified()) {
				r.classify();
			}
		} catch (OWLReasonerException e) {
			e.printStackTrace();
		}
		this.evaluator = new SemanticLocalityEvaluator(manager, r);
		this.entities = entities;
	}

	public void setSignature(Set<OWLEntity> owlentities) {
		this.entities = owlentities;
	}

	public void setInstantiatedPatternModel(InstantiatedPatternModel m) {
		this.ipm = m;
	}

	public boolean isLocal(OWLOntology o) {
		this.toAssign = this.ipm.extractAllPossibleBindingNodes(o,
				this.entities);
		BindingNode rootBindingNode = new BindingNode(
				new HashSet<Assignment>(), this.toAssign);
		this.leafBrusher = new LocalityCheckerLeafBrusher(this.evaluator,
				this.ipm.getConstraintSystem(), this.ipm
						.getInstantiatedPattern(), this.entities);
		rootBindingNode.accept(this.leafBrusher);
		return this.leafBrusher.isLocal();
	}

	public Set<Variable> getToAssign() {
		return this.toAssign;
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
}
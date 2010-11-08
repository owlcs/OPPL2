/**
 *
 */
package org.coode.oppl.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.CLASSVariable;
import org.coode.oppl.variabletypes.CONSTANTVariable;
import org.coode.oppl.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariable;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 */
public class OWLAxiomSearchTree extends SearchTree<OWLAxiom> {
	private final ValueComputationParameters parameters;

	/**
	 * @param manager
	 * @param constraintSystem
	 */
	public OWLAxiomSearchTree(ValueComputationParameters parameters) {
		if (parameters == null) {
			throw new NullPointerException(
					"The value computation parameters cannot be null");
		}
		this.parameters = parameters;
	}

	/**
	 * @return the parameters
	 */
	public ValueComputationParameters getParameters() {
		return this.parameters;
	}

	@Override
	protected List<OWLAxiom> getChildren(OWLAxiom node) {
		Set<BindingNode> leaves = this.getParameters().getConstraintSystem()
				.getLeaves();
		List<OWLAxiom> toReturn = new ArrayList<OWLAxiom>();
		VariableExtractor variableExtractor = new VariableExtractor(this
				.getParameters().getConstraintSystem(), false);
		Set<Variable> variables = variableExtractor.extractVariables(node);
		for (Variable variable : variables) {
			Collection<OWLObject> values = new HashSet<OWLObject>();
			if (leaves == null) {
				values.addAll(this.getAssignableValues(variable));
			} else {
				for (BindingNode bindingNode : leaves) {
					SimpleValueComputationParameters parameters = new SimpleValueComputationParameters(
							this.getParameters().getConstraintSystem(),
							bindingNode, this.getParameters()
									.getRuntimeExceptionHandler());
					if (bindingNode.getAssignedVariables().contains(variable)) {
						values.add(this.getParameters().getBindingNode()
								.getAssignmentValue(variable, parameters));
					} else {
						values.addAll(this.getAssignableValues(variable));
					}
				}
			}
			for (OWLObject value : values) {
				Assignment assignment = new Assignment(variable, value);
				BindingNode bindingNode = new BindingNode(Collections
						.singleton(assignment), variables);
				SimpleValueComputationParameters parameters = new SimpleValueComputationParameters(
						this.getParameters().getConstraintSystem(),
						bindingNode, this.getParameters()
								.getRuntimeExceptionHandler());
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						parameters);
				toReturn.add((OWLAxiom) node.accept(instantiator));
			}
		}
		return toReturn;
	}

	@Override
	protected boolean goalReached(OWLAxiom start) {
		boolean found = false;
		Iterator<OWLOntology> iterator = this.getParameters()
				.getConstraintSystem().getOntologyManager().getOntologies()
				.iterator();
		while (!found && iterator.hasNext()) {
			OWLOntology ontology = iterator.next();
			found = ontology.containsAxiom(start);
		}
		return found;
	}

	private Set<OWLClass> getAllClasses() {
		Set<OWLClass> toReturn = new HashSet<OWLClass>();
		Set<OWLOntology> ontologies = this.getParameters()
				.getConstraintSystem().getOntologyManager().getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getClassesInSignature());
		}
		return toReturn;
	}

	private Set<OWLLiteral> getAllConstants() {
		Set<OWLLiteral> toReturn = new HashSet<OWLLiteral>();
		for (OWLOntology ontology : this.getParameters().getConstraintSystem()
				.getOntologyManager().getOntologies()) {
			for (OWLAxiom axiom : ontology.getAxioms()) {
				toReturn.addAll(OWLObjectExtractor.getAllOWLLiterals(axiom));
			}
		}
		return toReturn;
	}

	private Set<OWLDataProperty> getAllDataProperties() {
		Set<OWLDataProperty> toReturn = new HashSet<OWLDataProperty>();
		Set<OWLOntology> ontologies = this.getParameters()
				.getConstraintSystem().getOntologyManager().getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getDataPropertiesInSignature());
		}
		return toReturn;
	}

	private Set<OWLNamedIndividual> getAllIndividuals() {
		Set<OWLNamedIndividual> toReturn = new HashSet<OWLNamedIndividual>();
		Set<OWLOntology> ontologies = this.getParameters()
				.getConstraintSystem().getOntologyManager().getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getIndividualsInSignature());
		}
		return toReturn;
	}

	private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Set<? extends OWLObject>>() {
		public Set<? extends OWLObject> visit(INDIVIDUALVariable v) {
			return OWLAxiomSearchTree.this.getAllIndividuals();
		}

		public Set<? extends OWLObject> visit(DATAPROPERTYVariable v) {
			return OWLAxiomSearchTree.this.getAllDataProperties();
		}

		public Set<? extends OWLObject> visit(OBJECTPROPERTYVariable v) {
			return OWLAxiomSearchTree.this.getObjectProperties();
		}

		public Set<? extends OWLObject> visit(CONSTANTVariable v) {
			return OWLAxiomSearchTree.this.getAllConstants();
		}

		public Set<? extends OWLObject> visit(CLASSVariable v) {
			return OWLAxiomSearchTree.this.getAllClasses();
		}
	};

	private Collection<? extends OWLObject> getAssignableValues(
			Variable variable) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(variable
				.accept(new VariableVisitor<Set<? extends OWLObject>>() {
					public Set<? extends OWLObject> visit(Variable v) {
						return v
								.accept(OWLAxiomSearchTree.this.assignableValuesVisitor);
					}

					public Set<? extends OWLObject> visit(
							RegexpGeneratedVariable<?> v) {
						Set<? extends OWLObject> toReturn = v
								.accept(OWLAxiomSearchTree.this.assignableValuesVisitor);
						Iterator<? extends OWLObject> iterator = toReturn
								.iterator();
						while (iterator.hasNext()) {
							OWLObject owlObject = iterator.next();
							ManchesterSyntaxRenderer renderer = OWLAxiomSearchTree.this
									.getParameters().getConstraintSystem()
									.getOPPLFactory()
									.getManchesterSyntaxRenderer(
											OWLAxiomSearchTree.this
													.getParameters()
													.getConstraintSystem());
							owlObject.accept(renderer);
							if (!v.getPatternGeneratingOPPLFunction().compute(
									OWLAxiomSearchTree.this.getParameters())
									.matcher(renderer.toString()).matches()) {
								iterator.remove();
							}
						}
						return toReturn;
					}

					public Set<? extends OWLObject> visit(GeneratedVariable<?> v) {
						return Collections.emptySet();
					}
				}));
		return toReturn;
	}

	private Set<OWLObjectProperty> getObjectProperties() {
		Set<OWLObjectProperty> toReturn = new HashSet<OWLObjectProperty>();
		Set<OWLOntology> ontologies = this.getParameters()
				.getConstraintSystem().getOntologyManager().getOntologies();
		for (OWLOntology owlOntology : ontologies) {
			toReturn.addAll(owlOntology.getObjectPropertiesInSignature());
		}
		return toReturn;
	}

	/**
	 * @return the assignableValuesVisitor
	 */
	public VariableTypeVisitorEx<Set<? extends OWLObject>> getAssignableValuesVisitor() {
		return this.assignableValuesVisitor;
	}
}

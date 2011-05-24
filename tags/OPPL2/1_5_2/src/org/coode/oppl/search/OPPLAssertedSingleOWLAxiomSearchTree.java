/**
 *
 */
package org.coode.oppl.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.PartialOWLObjectInstantiator;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.bindingtree.Assignment;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.SimpleValueComputationParameters;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.utils.AbstractVariableVisitorExAdapter;
import org.coode.oppl.utils.DefaultOWLAxiomVisitorAdapter;
import org.coode.oppl.utils.OWLObjectExtractor;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnnotationSubjectVisitor;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEntityVisitor;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRuntimeException;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLAssertedSingleOWLAxiomSearchTree extends SearchTree<OPPLOWLAxiomSearchNode> {
	private final ConstraintSystem constraintSystem;
	private final RuntimeExceptionHandler runtimeExceptionHandler;
	private final OWLAxiom targetAxiom;
	private final Set<OWLClass> allClasses = new HashSet<OWLClass>();
	private final Set<OWLObjectProperty> allObjectProperties = new HashSet<OWLObjectProperty>();
	private final Set<OWLDataProperty> allDataProperties = new HashSet<OWLDataProperty>();
	private final Set<OWLIndividual> allIndividuals = new HashSet<OWLIndividual>();
	private final Set<OWLLiteral> allConstants = new HashSet<OWLLiteral>();
	private final Set<OWLAnnotationProperty> allAnnotationProperties = new HashSet<OWLAnnotationProperty>();

	public OPPLAssertedSingleOWLAxiomSearchTree(OWLAxiom targetAxiom,
			ConstraintSystem constraintSystem, RuntimeExceptionHandler runtimeExceptionHandler) {
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		if (runtimeExceptionHandler == null) {
			throw new NullPointerException("The runtime exception handler cannot be null");
		}
		this.targetAxiom = targetAxiom;
		this.constraintSystem = constraintSystem;
		this.runtimeExceptionHandler = runtimeExceptionHandler;
		this.initAssignableValues();
	}

	/**
	 * @see org.coode.oppl.search.SearchTree#getChildren(java.lang.Object)
	 */
	@Override
	protected List<OPPLOWLAxiomSearchNode> getChildren(OPPLOWLAxiomSearchNode node) {
		List<OPPLOWLAxiomSearchNode> toReturn = new ArrayList<OPPLOWLAxiomSearchNode>();
		VariableExtractor variableExtractor = new VariableExtractor(this.getConstraintSystem(),
				false);
		Set<Variable<?>> variables = variableExtractor.extractVariables(node.getAxiom());
		BindingNode binding = node.getBinding();
		for (Variable<?> variable : variables) {
			Collection<OWLObject> values = new HashSet<OWLObject>(
					this.getAssignableValues(variable));
			for (OWLObject value : values) {
				Assignment assignment = new Assignment(variable, value);
				BindingNode childBinding = new BindingNode(binding.getAssignments(),
						binding.getUnassignedVariables());
				childBinding.addAssignment(assignment);
				ValueComputationParameters parameters = new SimpleValueComputationParameters(
						this.getConstraintSystem(), childBinding, this.getRuntimeExceptionHandler());
				PartialOWLObjectInstantiator instantiator = new PartialOWLObjectInstantiator(
						parameters);
				OWLAxiom instantiatedAxiom = (OWLAxiom) node.getAxiom().accept(instantiator);
				OPPLOWLAxiomSearchNode child = new OPPLOWLAxiomSearchNode(instantiatedAxiom,
						childBinding);
				toReturn.add(child);
			}
		}
		return toReturn;
	}

	/**
	 * @return {@code true} if the input {@link OPPLOWLAxiomSearchNode}
	 *         represents an OWLAxiom that is equal to the target axiom.
	 * @see org.coode.oppl.search.SearchTree#goalReached(java.lang.Object)
	 */
	@Override
	protected boolean goalReached(OPPLOWLAxiomSearchNode start) {
		return this.targetAxiom.getAxiomWithoutAnnotations().equals(start.getAxiom());
	}

	private final VariableTypeVisitorEx<Set<? extends OWLObject>> assignableValuesVisitor = new VariableTypeVisitorEx<Set<? extends OWLObject>>() {
		public Set<? extends OWLObject> visitCLASSVariableType(CLASSVariableType classVariableType) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allClasses;
		}

		public Set<? extends OWLObject> visitOBJECTPROPERTYVariableType(
				OBJECTPROPERTYVariableType objectpropertyVariableType) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allObjectProperties;
		}

		public Set<? extends OWLObject> visitDATAPROPERTYVariableType(
				DATAPROPERTYVariableType datapropertyVariableType) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allDataProperties;
		}

		public Set<? extends OWLObject> visitINDIVIDUALVariableType(
				INDIVIDUALVariableType individualVariableType) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allIndividuals;
		}

		public Set<? extends OWLObject> visitCONSTANTVariableType(
				CONSTANTVariableType constantVariableType) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allConstants;
		}

		public Set<? extends OWLObject> visitANNOTATIONPROPERTYVariableType(
				ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
			return OPPLAssertedSingleOWLAxiomSearchTree.this.allAnnotationProperties;
		}
	};

	private Collection<? extends OWLObject> getAssignableValues(Variable<?> variable) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		toReturn.addAll(variable.getType().accept(this.assignableValuesVisitor));
		Iterator<OWLObject> iterator = toReturn.iterator();
		while (iterator.hasNext()) {
			final OWLObject owlObject = iterator.next();
			boolean inScope = variable.accept(new AbstractVariableVisitorExAdapter<Boolean>(true) {
				@Override
				public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
					VariableScope<?> variableScope = v.getVariableScope();
					try {
						return variableScope == null || variableScope.check(owlObject);
					} catch (OWLRuntimeException e) {
						OPPLAssertedSingleOWLAxiomSearchTree.this.getRuntimeExceptionHandler().handleOWLRuntimeException(
								e);
						return false;
					}
				}
			});
			if (!inScope) {
				iterator.remove();
			}
		}
		return toReturn;
	}

	private void initAssignableValues() {
		this.extractFromLogicAxiom();
		this.getTargetAxiom().accept(new DefaultOWLAxiomVisitorAdapter() {
			@Override
			protected void doDefault(OWLAxiom axiom) {
				OPPLAssertedSingleOWLAxiomSearchTree.this.extractFromLogicAxiom();
			}

			@Override
			public void visit(OWLAnnotationAssertionAxiom axiom) {
				OPPLAssertedSingleOWLAxiomSearchTree.this.extractFromLogicAxiom();
				OWLAnnotationSubject subject = axiom.getSubject();
				subject.accept(new OWLAnnotationSubjectVisitor() {
					public void visit(OWLAnonymousIndividual individual) {
					}

					public void visit(IRI iri) {
						Set<OWLOntology> ontologies = OPPLAssertedSingleOWLAxiomSearchTree.this.getConstraintSystem().getOntologyManager().getOntologies();
						for (OWLOntology ontology : ontologies) {
							Set<OWLEntity> entitiesInSignature = ontology.getEntitiesInSignature(iri);
							for (OWLEntity entity : entitiesInSignature) {
								entity.accept(new OWLEntityVisitor() {
									public void visit(OWLAnnotationProperty property) {
										// TODO Auto-generated method stub
									}

									public void visit(OWLDatatype datatype) {
									}

									public void visit(OWLNamedIndividual individual) {
										OPPLAssertedSingleOWLAxiomSearchTree.this.allIndividuals.add(individual);
									}

									public void visit(OWLDataProperty property) {
										OPPLAssertedSingleOWLAxiomSearchTree.this.allDataProperties.add(property);
									}

									public void visit(OWLObjectProperty property) {
										OPPLAssertedSingleOWLAxiomSearchTree.this.allObjectProperties.add(property);
									}

									public void visit(OWLClass cls) {
										OPPLAssertedSingleOWLAxiomSearchTree.this.allClasses.add(cls);
									}
								});
							}
						}
					}
				});
			}
		});
	}

	/**
	 * 
	 */
	private void extractFromLogicAxiom() {
		this.allClasses.addAll(OWLObjectExtractor.getAllClasses(this.getTargetAxiom()));
		this.allDataProperties.addAll(OWLObjectExtractor.getAllOWLDataProperties(this.getTargetAxiom()));
		this.allObjectProperties.addAll(OWLObjectExtractor.getAllOWLObjectProperties(this.getTargetAxiom()));
		this.allIndividuals.addAll(OWLObjectExtractor.getAllOWLIndividuals(this.getTargetAxiom()));
		this.allConstants.addAll(OWLObjectExtractor.getAllOWLLiterals(this.getTargetAxiom()));
		this.allAnnotationProperties.addAll(OWLObjectExtractor.getAllAnnotationProperties(this.getTargetAxiom()));
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}

	/**
	 * @see org.coode.oppl.search.SearchTree#exhaustiveSearchTree(java.lang.Object,
	 *      java.util.List)
	 */
	@Override
	public boolean exhaustiveSearchTree(OPPLOWLAxiomSearchNode start,
			List<List<OPPLOWLAxiomSearchNode>> solutions) {
		if (start == null) {
			throw new NullPointerException("The starting node cannot be null");
		}
		if (solutions == null) {
			throw new NullPointerException(
					"The list on which solutions will be stored cannot be null");
		}
		boolean found = false;
		if (this.getTargetAxiom().getAxiomType().equals(start.getAxiom().getAxiomType())) {
			found = super.exhaustiveSearchTree(start, solutions);
		}
		return found;
	}

	/**
	 * @return the targetAxiom
	 */
	public OWLAxiom getTargetAxiom() {
		return this.targetAxiom;
	}

	/**
	 * @return the runtimeExceptionHandler
	 */
	public RuntimeExceptionHandler getRuntimeExceptionHandler() {
		return this.runtimeExceptionHandler;
	}
}

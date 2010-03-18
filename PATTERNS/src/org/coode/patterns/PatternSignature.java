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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.exceptions.OPPLException;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.VariableScopeChecker;
import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.coode.oppl.variablemansyntax.variabletypes.CLASSVariable;
import org.coode.oppl.variablemansyntax.variabletypes.CONSTANTVariable;
import org.coode.oppl.variablemansyntax.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variablemansyntax.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variablemansyntax.variabletypes.OBJECTPROPERTYVariable;
import org.coode.patterns.utils.Utils;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 *         Jul 15, 2008
 */
public class PatternSignature {
	private String name;
	private OWLOntologyManager ontologyManager;
	private final PatternModel pattern;
	private final AbstractPatternModelFactory factory;

	/**
	 * @param name
	 */
	public PatternSignature(String name, OWLOntologyManager ontologyManger,
			AbstractPatternModelFactory factory) throws PatternException {
		this.name = name;
		this.factory = factory;
		this.ontologyManager = ontologyManger;
		Set<String> existingPatternNames = Utils
				.getExistingPatternNames(ontologyManger);
		if (existingPatternNames.contains(name)) {
			this.pattern = Utils.find(name, ontologyManger, factory);
		} else {
			throw new PatternReferenceNotFoundException(name);
		}
	}

	public VariableType getIthVariableType(int i) throws PatternException {
		try {
			return this.pattern.getInputVariables().get(i).getType();
		} catch (IndexOutOfBoundsException e) {
			throw new ArgumentIndexOutOfBoundsException(this.name, i);
		}
	}

	public Variable getIthVariable(int i) throws PatternException {
		try {
			return this.pattern.getInputVariables().get(i);
		} catch (IndexOutOfBoundsException e) {
			throw new ArgumentIndexOutOfBoundsException(this.name, i);
		}
	}

	public List<OWLObject> getPossibleValues(int i) throws PatternException,
			OPPLException, OWLReasonerException {
		List<OWLObject> listToReturn = new ArrayList<OWLObject>();
		Variable variable = this.pattern.getInputVariables().get(i);
		// VariableType variableType = this.getIthVariableType(i);
		final VariableScopeChecker variableScopeChecker = this.factory
				.getOPPLParser().getOPPLFactory().getVariableScopeChecker();
		final Set<OWLOntology> ontologies = this.ontologyManager
				.getOntologies();
		VariableTypeVisitorEx<Set<OWLObject>> visitor = new VariableTypeVisitorEx<Set<OWLObject>>() {
			public Set<OWLObject> visit(SingleValueGeneratedVariable<?> v) {
				return v.getPossibleBindings();
			}

			public Set<OWLObject> visit(INDIVIDUALVariable v) {
				Set<OWLObject> toReturn = new HashSet<OWLObject>();
				for (OWLOntology ontology : ontologies) {
					Set<OWLIndividual> referencedIndividuals = ontology
							.getReferencedIndividuals();
					for (OWLIndividual individual : referencedIndividuals) {
						try {
							if (v.getVariableScope() == null
									|| v.getVariableScope().check(individual,
											variableScopeChecker)) {
								toReturn.add(individual);
							}
						} catch (OWLReasonerException e) {
							throw new RuntimeException(e.getMessage(), e);
						}
					}
				}
				return toReturn;
			}

			public Set<OWLObject> visit(DATAPROPERTYVariable v) {
				Set<OWLObject> toReturn = new HashSet<OWLObject>();
				for (OWLOntology ontology : ontologies) {
					Set<OWLDataProperty> referencedDataProperties = ontology
							.getReferencedDataProperties();
					for (OWLDataProperty dataProperty : referencedDataProperties) {
						try {
							if (v.getVariableScope() == null
									|| v.getVariableScope().check(dataProperty,
											variableScopeChecker)) {
								toReturn.add(dataProperty);
							}
						} catch (OWLReasonerException e) {
							throw new RuntimeException(e.getMessage(), e);
						}
					}
				}
				return toReturn;
			}

			public Set<OWLObject> visit(OBJECTPROPERTYVariable v) {
				Set<OWLObject> toReturn = new HashSet<OWLObject>();
				for (OWLOntology ontology : ontologies) {
					Set<OWLObjectProperty> referencedObjectProperties = ontology
							.getReferencedObjectProperties();
					for (OWLObjectProperty objectProperty : referencedObjectProperties) {
						try {
							if (v.getVariableScope() == null
									|| v.getVariableScope().check(
											objectProperty,
											variableScopeChecker)) {
								toReturn.add(objectProperty);
							}
						} catch (OWLReasonerException e) {
							throw new RuntimeException(e.getMessage(), e);
						}
					}
				}
				return toReturn;
			}

			public Set<OWLObject> visit(CONSTANTVariable v) {
				return Collections.emptySet();
			}

			public Set<OWLObject> visit(CLASSVariable v) {
				Set<OWLObject> toReturn = new HashSet<OWLObject>();
				for (OWLOntology ontology : ontologies) {
					Set<OWLClass> referencedClasses = ontology
							.getReferencedClasses();
					for (OWLClass owlClass : referencedClasses) {
						try {
							if (v.getVariableScope() == null
									|| v.getVariableScope().check(owlClass,
											variableScopeChecker)) {
								toReturn.add(owlClass);
							}
						} catch (OWLReasonerException e) {
							throw new RuntimeException(e.getMessage(), e);
						}
					}
				}
				return toReturn;
			}
		};
		listToReturn.addAll(variable.accept(visitor));
		// switch (variableType) {
		// case CLASS:
		// for (OWLOntology ontology : ontologies) {
		// Set<OWLClass> referencedClasses = ontology
		// .getReferencedClasses();
		// for (OWLClass owlClass : referencedClasses) {
		// if (variable.getVariableScope() == null
		// || variable.getVariableScope().check(owlClass,
		// variableScopeChecker)) {
		// toReturn.add(owlClass);
		// }
		// }
		// }
		// break;
		// case DATAPROPERTY:
		// for (OWLOntology ontology : ontologies) {
		// Set<OWLDataProperty> referencedDataProperties = ontology
		// .getReferencedDataProperties();
		// for (OWLDataProperty dataProperty : referencedDataProperties) {
		// if (variable.getVariableScope() == null
		// || variable.getVariableScope().check(
		// dataProperty, variableScopeChecker)) {
		// toReturn.add(dataProperty);
		// }
		// }
		// }
		// break;
		// case OBJECTPROPERTY:
		// for (OWLOntology ontology : ontologies) {
		// Set<OWLObjectProperty> referencedObjectProperties = ontology
		// .getReferencedObjectProperties();
		// for (OWLObjectProperty objectProperty : referencedObjectProperties) {
		// if (variable.getVariableScope() == null
		// || variable.getVariableScope().check(
		// objectProperty, variableScopeChecker)) {
		// toReturn.add(objectProperty);
		// }
		// }
		// }
		// break;
		// case INDIVIDUAL:
		// for (OWLOntology ontology : ontologies) {
		// Set<OWLIndividual> referencedIndividuals = ontology
		// .getReferencedIndividuals();
		// for (OWLIndividual individual : referencedIndividuals) {
		// if (variable.getVariableScope() == null
		// || variable.getVariableScope().check(
		// individual, variableScopeChecker)) {
		// toReturn.add(individual);
		// }
		// }
		// }
		// break;
		// case CONSTANT:
		// default:
		// break;
		// }
		return listToReturn;
	}

	public int size() {
		return this.pattern.getInputVariables().size();
	}

	public List<OWLObject> getPossibleValues(int i, String prefix)
			throws PatternException, OWLReasonerException, OPPLException {
		List<OWLObject> toReturn = this.getPossibleValues(i);
		Iterator<OWLObject> it = toReturn.iterator();
		while (it.hasNext()) {
			if (!it.next().toString().startsWith(prefix)) {
				it.remove();
			}
		}
		return toReturn;
	}

	/**
	 * @return the pattern
	 */
	public PatternModel getPattern() {
		return this.pattern;
	}
}

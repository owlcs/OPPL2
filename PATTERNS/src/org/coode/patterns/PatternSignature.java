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

import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.patterns.utils.Utils;
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
		Set<String> existingPatternNames = Utils.getExistingPatternNames(ontologyManger);
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

	// public List<OWLObject> getPossibleValues(int i) throws PatternException,
	// OPPLException,
	// OWLReasonerException {
	// List<OWLObject> listToReturn = new ArrayList<OWLObject>();
	// Variable variable = this.pattern.getInputVariables().get(i);
	// // VariableType variableType = this.getIthVariableType(i);
	// final VariableScopeChecker variableScopeChecker =
	// this.factory.getOPPLFactory().getVariableScopeChecker();
	// final Set<OWLOntology> ontologies = this.ontologyManager.getOntologies();
	// VariableTypeVisitorEx<Set<OWLObject>> visitor = new
	// VariableTypeVisitorEx<Set<OWLObject>>() {
	// public Set<OWLObject> visit(SingleValueGeneratedVariable<?> v) {
	// return v.getValue().getGeneratedValue(null)
	// BindingNode.getEmptyBindingNode();
	// }
	//
	// public Set<OWLObject> visit(INDIVIDUALVariable v) {
	// Set<OWLObject> toReturn = new HashSet<OWLObject>();
	// for (OWLOntology ontology : ontologies) {
	// Set<OWLIndividual> referencedIndividuals =
	// ontology.getReferencedIndividuals();
	// for (OWLIndividual individual : referencedIndividuals) {
	// try {
	// if (v.getVariableScope() == null
	// || v.getVariableScope().check(individual, variableScopeChecker)) {
	// toReturn.add(individual);
	// }
	// } catch (OWLReasonerException e) {
	// throw new RuntimeException(e.getMessage(), e);
	// }
	// }
	// }
	// return toReturn;
	// }
	//
	// public Set<OWLObject> visit(DATAPROPERTYVariable v) {
	// Set<OWLObject> toReturn = new HashSet<OWLObject>();
	// for (OWLOntology ontology : ontologies) {
	// Set<OWLDataProperty> referencedDataProperties =
	// ontology.getReferencedDataProperties();
	// for (OWLDataProperty dataProperty : referencedDataProperties) {
	// try {
	// if (v.getVariableScope() == null
	// || v.getVariableScope().check(
	// dataProperty,
	// variableScopeChecker)) {
	// toReturn.add(dataProperty);
	// }
	// } catch (OWLReasonerException e) {
	// throw new RuntimeException(e.getMessage(), e);
	// }
	// }
	// }
	// return toReturn;
	// }
	//
	// public Set<OWLObject> visit(OBJECTPROPERTYVariable v) {
	// Set<OWLObject> toReturn = new HashSet<OWLObject>();
	// for (OWLOntology ontology : ontologies) {
	// Set<OWLObjectProperty> referencedObjectProperties =
	// ontology.getReferencedObjectProperties();
	// for (OWLObjectProperty objectProperty : referencedObjectProperties) {
	// try {
	// if (v.getVariableScope() == null
	// || v.getVariableScope().check(
	// objectProperty,
	// variableScopeChecker)) {
	// toReturn.add(objectProperty);
	// }
	// } catch (OWLReasonerException e) {
	// throw new RuntimeException(e.getMessage(), e);
	// }
	// }
	// }
	// return toReturn;
	// }
	//
	// public Set<OWLObject> visit(CONSTANTVariable v) {
	// return Collections.emptySet();
	// }
	//
	// public Set<OWLObject> visit(CLASSVariable v) {
	// Set<OWLObject> toReturn = new HashSet<OWLObject>();
	// for (OWLOntology ontology : ontologies) {
	// Set<OWLClass> referencedClasses = ontology.getReferencedClasses();
	// for (OWLClass owlClass : referencedClasses) {
	// try {
	// if (v.getVariableScope() == null
	// || v.getVariableScope().check(owlClass, variableScopeChecker)) {
	// toReturn.add(owlClass);
	// }
	// } catch (OWLReasonerException e) {
	// throw new RuntimeException(e.getMessage(), e);
	// }
	// }
	// }
	// return toReturn;
	// }
	// };
	// listToReturn.addAll(variable.accept(visitor));
	//
	// return listToReturn;
	// }
	public int size() {
		return this.pattern.getInputVariables().size();
	}

	// public List<OWLObject> getPossibleValues(int i, String prefix) throws
	// PatternException,
	// OWLReasonerException, OPPLException {
	// List<OWLObject> toReturn = this.getPossibleValues(i);
	// Iterator<OWLObject> it = toReturn.iterator();
	// while (it.hasNext()) {
	// if (!it.next().toString().startsWith(prefix)) {
	// it.remove();
	// }
	// }
	// return toReturn;
	// }
	/**
	 * @return the pattern
	 */
	public PatternModel getPattern() {
		return this.pattern;
	}
}

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
import java.util.StringTokenizer;

import org.coode.oppl.ChangeExtractor;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.OPPLScriptVisitor;
import org.coode.oppl.OPPLScriptVisitorEx;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.utils.ArgCheck;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.coode.parsers.ErrorListener;
import org.coode.patterns.utils.Utils;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLAxiomVisitorEx;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.NamespaceUtil;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 *         Jun 10, 2008
 */
public class PatternModel implements OPPLScript, PatternOPPLScript {
	private final static class PatternOPPLScriptValidator implements OPPLScriptValidator {
		public PatternOPPLScriptValidator() {
		}

		public boolean accept(OPPLScript script) {
			boolean toReturn = script.getQuery() == null;
			if (toReturn) {
				List<OWLAxiomChange> actions = script.getActions();
				Iterator<OWLAxiomChange> it = actions.iterator();
				while (toReturn && it.hasNext()) {
					OWLAxiomChange action = it.next();
					toReturn = action instanceof AddAxiom;
				}
			}
			return toReturn;
		}

		public String getValidationRuleDescription() {
			return "The Script can only have ADD as its actions and cannot have any query";
		}
	}

	class ClassPatternDetector extends OWLObjectVisitorExAdapter<Boolean> implements
			OWLAxiomVisitorEx<Boolean>, OPPLScriptVisitorEx<Boolean> {
		private OWLClass thisClass = PatternModel.this.ontologyManager.getOWLDataFactory().getOWLClass(
				PatternModel.this.getConstraintSystem().getThisClassVariable().getIRI());

		@Override
		protected Boolean getDefaultReturnValue(OWLObject object) {
			return false;
		}

		@Override
		public Boolean visit(OWLSubClassOfAxiom axiom) {
			return axiom.getSubClass().equals(this.thisClass);
		}

		@Override
		public Boolean visit(OWLDisjointClassesAxiom axiom) {
			return axiom.getClassExpressions().contains(this.thisClass);
		}

		@Override
		public Boolean visit(OWLEquivalentClassesAxiom axiom) {
			return axiom.getClassExpressions().contains(this.thisClass);
		}

		public Boolean visit(OPPLQuery q) {
			return false;
		}

		public Boolean visit(Variable<?> v) {
			return false;
		}

		public Boolean visitActions(List<OWLAxiomChange> changes) {
			boolean found = false;
			Iterator<OWLAxiomChange> it = changes.iterator();
			while (!found && it.hasNext()) {
				found = it.next().getAxiom().accept(this);
			}
			return found;
		}

		public Boolean visit(OPPLQuery q, Boolean p) {
			return false;
		}

		public Boolean visit(Variable<?> v, Boolean p) {
			return false;
		}

		public Boolean visitActions(List<OWLAxiomChange> changes, Boolean p) {
			boolean found = false;
			Iterator<OWLAxiomChange> it = changes.iterator();
			while (!found && it.hasNext()) {
				found = it.next().getAxiom().accept(this);
			}
			return found;
		}
	}

	/**
	 * Extracts the definition
	 * 
	 * @author Luigi Iannone
	 * 
	 *         Jun 26, 2008
	 */
	static class DefinitorialExtractor extends OWLObjectVisitorExAdapter<OWLObject> implements
			OWLAxiomVisitorEx<OWLObject>, OPPLScriptVisitorEx<OWLClassExpression> {
		protected OWLClassExpression extractedDescription = null;
		protected OWLPropertyExpression<?, ?> extractedProperty = null;
		protected OWLObject owlObject;
		protected OWLDataFactory dataFactory;
		private VariableType<?> variableType;

		public OWLObject getExtractedObject() {
			OWLObject toReturn = null;
			toReturn = this.variableType.accept(new VariableTypeVisitorEx<OWLObject>() {
				public OWLObject visitCLASSVariableType(CLASSVariableType classVariableType) {
					return DefinitorialExtractor.this.extractedDescription;
				}

				public OWLObject visitOBJECTPROPERTYVariableType(
						OBJECTPROPERTYVariableType objectpropertyVariableType) {
					return DefinitorialExtractor.this.extractedProperty;
				}

				public OWLObject visitDATAPROPERTYVariableType(
						DATAPROPERTYVariableType datapropertyVariableType) {
					return DefinitorialExtractor.this.extractedProperty;
				}

				public OWLObject visitINDIVIDUALVariableType(
						INDIVIDUALVariableType individualVariableType) {
					throw new RuntimeException("Unsupported variable type: "
							+ individualVariableType + " for pattern used in functional mode");
				}

				public OWLObject visitCONSTANTVariableType(CONSTANTVariableType constantVariableType) {
					throw new RuntimeException("Unsupported variable type: " + constantVariableType
							+ " for pattern used in functional mode");
				}

				public OWLObject visitANNOTATIONPROPERTYVariableType(
						ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
					throw new RuntimeException("Unsupported variable type: "
							+ annotationpropertyVariableType
							+ " for pattern used in functional mode");
				}
			});
			return toReturn;
		}

		/**
		 * @param owlObject
		 * @param referenceReplacement
		 * @param replacemnts
		 */
		public DefinitorialExtractor(OWLObject owlObject, VariableType<?> variableType,
				OWLDataFactory dataFactory) {
			this.owlObject = owlObject;
			this.dataFactory = dataFactory;
			this.variableType = variableType;
		}

		/**
		 * @return the extractedDescription
		 */
		public OWLClassExpression getExtractedDescription() {
			return this.extractedDescription;
		}

		@Override
		public OWLClassExpression visit(OWLEquivalentClassesAxiom axiom) {
			OWLClassExpression toReturn = null;
			if (this.variableType == VariableTypeFactory.getCLASSVariableType()) {
				Set<OWLClassExpression> descriptions = new HashSet<OWLClassExpression>(
						axiom.getClassExpressions());
				descriptions.remove(this.owlObject);
				toReturn = !descriptions.isEmpty() ? descriptions.iterator().next() : null;
			}
			return toReturn;
		}

		@Override
		public OWLObjectPropertyExpression visit(OWLEquivalentObjectPropertiesAxiom axiom) {
			OWLObjectPropertyExpression toReturn = null;
			if (this.variableType == VariableTypeFactory.getOBJECTPROPERTYTypeVariableType()) {
				Set<OWLObjectPropertyExpression> properties = new HashSet<OWLObjectPropertyExpression>(
						axiom.getProperties());
				properties.remove(this.owlObject);
				toReturn = !properties.isEmpty() ? properties.iterator().next() : null;
				this.extractedProperty = toReturn;
			}
			return toReturn;
		}

		@Override
		public OWLDataPropertyExpression visit(OWLEquivalentDataPropertiesAxiom axiom) {
			OWLDataPropertyExpression toReturn = null;
			if (this.variableType == VariableTypeFactory.getDATAPROPERTYVariableType()) {
				Set<OWLDataPropertyExpression> properties = new HashSet<OWLDataPropertyExpression>(
						axiom.getProperties());
				properties.remove(this.owlObject);
				toReturn = !properties.isEmpty() ? properties.iterator().next() : null;
				this.extractedProperty = toReturn;
			}
			return toReturn;
		}

		public OWLClassExpression visitActions(List<OWLAxiomChange> changes) {
			OWLClassExpression toReturn = null;
			for (OWLAxiomChange axiomChange : changes) {
				OWLAxiom axiom = axiomChange.getAxiom();
				OWLObject description = axiom.accept(this);
				toReturn = toReturn == null ? (OWLClassExpression) description
						: this.dataFactory.getOWLObjectIntersectionOf(
								toReturn,
								(OWLClassExpression) description);
			}
			return toReturn;
		}

		public OWLClassExpression visit(OPPLQuery q, OWLClassExpression p) {
			return null;
		}

		public OWLClassExpression visit(Variable<?> v, OWLClassExpression p) {
			return null;
		}

		public OWLClassExpression visitActions(List<OWLAxiomChange> changes, OWLClassExpression p) {
			return this.visitActions(changes);
		}
	}

	static class ReplacementExtractor {
		public static List<List<Object>> permutations(List<List<Object>> elements) {
			return permutations(new ArrayList<Object>(), elements);
		}

		private static List<List<Object>> permutations(List<Object> path,
				List<List<Object>> elements) {
			List<List<Object>> toReturn = new ArrayList<List<Object>>();
			if (!elements.isEmpty()) {
				List<Object> elem = elements.iterator().next();
				elements.remove(elem);
				for (Object string : elem) {
					List<Object> newPath = new ArrayList<Object>(path);
					newPath.add(string);
					toReturn.addAll(permutations(newPath, elements));
				}
			} else {
				return new ArrayList<List<Object>>(
						Collections.singleton(new ArrayList<Object>(path)));
			}
			return toReturn;
		}
	}

	private List<PatternOPPLScript> dependencies = new ArrayList<PatternOPPLScript>();
	private String rendering = null;
	private IRI iri = null;
	private final OPPLScript opplStatement;
	private final OWLOntologyManager ontologyManager;
	private boolean valid = true;
	private final Set<PatternModelChangeListener> listeners = new HashSet<PatternModelChangeListener>();
	private Variable<?> returnVariable = null;
	public final static String NAMESPACE = "http://www.co-ode.org/patterns#";
	private final AbstractPatternModelFactory factory;

	public AbstractPatternModelFactory getPatternModelFactory() {
		return this.factory;
	}

	public OWLOntologyManager getOWLOntologyManager() {
		return this.ontologyManager;
	}

	public PatternModel(OPPLScript opplScript, OWLOntologyManager ontologyManager,
			AbstractPatternModelFactory f) throws UnsuitableOPPLScriptException {
		ArgCheck.checkNullArgument("The OPPL script", opplScript);
		ArgCheck.checkNullArgument("The ontology manager cannot be null", ontologyManager);
		if (!getScriptValidator().accept(opplScript)) {
			throw new UnsuitableOPPLScriptException(opplScript,
					getScriptValidator().getValidationRuleDescription());
		}
		this.opplStatement = opplScript;
		this.ontologyManager = ontologyManager;
		this.factory = f;
	}

	private final static OPPLScriptValidator SCRIPT_VALIDATOR = new PatternOPPLScriptValidator();

	public List<Variable<?>> getVariables() {
		List<Variable<?>> toReturn = new ArrayList<Variable<?>>();
		if (this.opplStatement != null) {
			toReturn = this.opplStatement.getVariables();
		}
		return toReturn;
	}

	@Override
	public String toString() {
		String rendering = this.rendering == null ? "" : this.rendering;
		return String.format("%s %s", this.opplStatement, rendering).trim();
	}

	/**
	 * @return the string rendering of this PatternModel. Override/use this
	 *         method in tools like Protege that have different strategies to
	 *         render OWL objects
	 */
	public String render() {
		StringBuffer buffer = new StringBuffer(this.getOpplStatement().render());
		buffer.append('\n');
		if (this.getRendering() != null) {
			buffer.append(this.getRendering());
		}
		Variable<?> v = this.getReturnVariable();
		if (v != null) {
			buffer.append(";\n RETURN ");
			buffer.append(this.getConstraintSystem().render(v));
		}
		return buffer.toString();
	}

	/**
	 * @return the rendering
	 */
	public String getRendering() {
		return this.rendering;
	}

	/**
	 * @param rendering
	 *            the rendering to set
	 */
	public void setRendering(String rendering) {
		this.rendering = rendering;
		StringTokenizer tokenizer = new StringTokenizer(rendering, " \n\t\r\f");
		boolean foundUndefinedVariable = false;
		while (!foundUndefinedVariable && tokenizer.hasMoreTokens()) {
			String nextToken = tokenizer.nextToken();
			if (nextToken.startsWith("?")) {
				boolean found = false;
				Iterator<Variable<?>> it = this.getVariables().iterator();
				while (!found && it.hasNext()) {
					Variable<?> variable = it.next();
					found = variable.getName().equals(nextToken.trim());
				}
				foundUndefinedVariable = !found;
			}
		}
		this.valid = !foundUndefinedVariable;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return this.valid;
	}

	public void addChangeListener(PatternModelChangeListener l) {
		this.listeners.add(l);
	}

	public void removeChangeListener(PatternModelChangeListener l) {
		this.listeners.remove(l);
	}

	/**
	 * @return the iri
	 */
	public IRI getIRI() {
		return this.iri;
	}

	/**
	 * @param iri
	 *            the iri to set
	 */
	public void setIRI(IRI iri) {
		this.iri = iri;
	}

	/**
	 * @return the opplStatement
	 */
	public OPPLScript getOpplStatement() {
		return this.opplStatement;
	}

	public String getPatternLocalName() {
		String toReturn = null;
		if (this.iri != null) {
			NamespaceUtil nsUtil = new NamespaceUtil();
			String[] split = nsUtil.split(this.iri.toString(), null);
			if (split.length == 2) {
				toReturn = split[1];
			}
		}
		return toReturn;
	}

	public PatternConstraintSystem getConstraintSystem() {
		return this.opplStatement == null ? this.factory.createConstraintSystem()
				: (PatternConstraintSystem) this.opplStatement.getConstraintSystem();
	}

	/**
	 * @param replacementTuples
	 * @param replacedObjects
	 * @throws PatternException
	 */
	public OWLObject getDefinitorialPortion(BindingNode bindingNode,
			RuntimeExceptionHandler runtimeExceptionHandler) throws PatternException {
		DefinitorialExtractor extractor = this.createDefinitorialExtractor(this.getReturnVariable());
		ChangeExtractor changeExtractor = new ChangeExtractor(runtimeExceptionHandler, false);
		List<OWLAxiomChange> changes = changeExtractor.visit(this);
		for (OWLAxiomChange owlAxiomChange : changes) {
			owlAxiomChange.getAxiom().accept(extractor);
		}
		return extractor.getExtractedObject();
	}

	private DefinitorialExtractor createDefinitorialExtractor(final Variable<?> variable) {
		final OWLDataFactory dataFactory = this.ontologyManager.getOWLDataFactory();
		OWLObject owlObject = null;
		VariableTypeVisitorEx<OWLObject> visitor = new VariableTypeVisitorEx<OWLObject>() {
			public OWLObject visitINDIVIDUALVariableType(INDIVIDUALVariableType t) {
				throw new RuntimeException("Unsupported variable type: " + variable.getType()
						+ " for pattern used in functional mode");
			}

			public OWLObject visitDATAPROPERTYVariableType(DATAPROPERTYVariableType t) {
				return dataFactory.getOWLDataProperty(variable.getIRI());
			}

			public OWLObject visitOBJECTPROPERTYVariableType(OBJECTPROPERTYVariableType t) {
				return dataFactory.getOWLObjectProperty(variable.getIRI());
			}

			public OWLObject visitANNOTATIONPROPERTYVariableType(
					ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
				return dataFactory.getOWLAnnotationProperty(variable.getIRI());
			}

			public OWLObject visitCONSTANTVariableType(CONSTANTVariableType t) {
				throw new RuntimeException("Unsupported variable type: " + variable.getType()
						+ " for pattern used in functional mode");
			}

			public OWLObject visitCLASSVariableType(CLASSVariableType v) {
				return dataFactory.getOWLClass(variable.getIRI());
			}
		};
		owlObject = variable.getType().accept(visitor);
		return new DefinitorialExtractor(owlObject, variable.getType(), dataFactory);
	}

	/**
	 * @param patternModel
	 * @return true if this PatternModel instance depends on the input one,
	 *         false otherwise
	 */
	public boolean dependsOn(PatternOPPLScript patternModel) {
		boolean toReturn = this.isDependent();
		if (toReturn) {
			toReturn = false;
			Iterator<PatternOPPLScript> it = this.dependencies.iterator();
			while (!toReturn && it.hasNext()) {
				PatternOPPLScript aPatternModel = it.next();
				toReturn = aPatternModel.getName().equals(patternModel.getName())
						|| aPatternModel.dependsOn(patternModel);
			}
		}
		return toReturn;
	}

	public boolean isDependent() {
		return !this.dependencies.isEmpty();
	}

	/**
	 * @param ontologies
	 * @return the set of PatternModel instances that depend on this. Please
	 *         notice that InstantiatedPatternModel instances will be returned
	 *         as well
	 */
	public Set<PatternOPPLScript> getDependingPatterns(Set<OWLOntology> ontologies,
			ErrorListener errorListener) {
		Set<PatternOPPLScript> toReturn = new HashSet<PatternOPPLScript>();
		for (OWLOntology ontology : ontologies) {
			Set<PatternModel> existingPatterns = Utils.getExistingPatterns(ontology, this.factory);
			for (PatternModel patternModel : existingPatterns) {
				if (patternModel.dependsOn(this)) {
					toReturn.add(patternModel);
					toReturn.addAll(patternModel.getInstantiations(errorListener));
				}
			}
		}
		toReturn.addAll(this.getInstantiations(errorListener));
		return toReturn;
	}

	public Set<InstantiatedPatternModel> getInstantiations(ErrorListener errorListener) {
		Set<InstantiatedPatternModel> toReturn = new HashSet<InstantiatedPatternModel>();
		Set<OWLOntology> ontologies = this.ontologyManager.getOntologies();
		PatternExtractor patternExtractor = this.factory.getPatternExtractor(errorListener);
		for (OWLOntology ontology : ontologies) {
			Set<OWLClass> referencedClasses = ontology.getClassesInSignature();
			for (OWLClass owlClass : referencedClasses) {
				Set<OWLAnnotationAssertionAxiom> annotationAxioms = owlClass.getAnnotationAssertionAxioms(ontology);
				for (OWLAnnotationAssertionAxiom annotationAxiom : annotationAxioms) {
					OPPLScript extractedPatternModel = annotationAxiom.getAnnotation().accept(
							patternExtractor);
					if (extractedPatternModel != null
							&& extractedPatternModel instanceof InstantiatedPatternModel
							&& ((InstantiatedPatternModel) extractedPatternModel).getInstantiatedPatternLocalName().equals(
									this.getPatternLocalName())) {
						toReturn.add((InstantiatedPatternModel) extractedPatternModel);
					}
				}
			}
		}
		return toReturn;
	}

	public Set<OWLObject> getOWLObjects(OWLOntology ontology, ErrorListener errorListener) {
		Set<OWLObject> toReturn = new HashSet<OWLObject>();
		boolean found = false;
		OWLAnnotation ontologyAnnotation = null;
		Iterator<OWLAnnotation> annotationIterator = ontology.getAnnotations().iterator();
		while (!found && annotationIterator.hasNext()) {
			ontologyAnnotation = annotationIterator.next();
			found = this.iri.equals(ontologyAnnotation.getProperty().getIRI());
		}
		if (found) {
			toReturn.add(ontologyAnnotation);
		}
		return toReturn;
	}

	public OWLOntology getOriginatingOntology() {
		OWLOntology toReturn = null;
		Set<OWLOntology> ontologies = this.ontologyManager.getOntologies();
		boolean found = false;
		Iterator<OWLOntology> it = ontologies.iterator();
		OWLOntology ontology = null;
		OWLAnnotation ontologyAnnotation = null;
		while (!found && it.hasNext()) {
			ontology = it.next();
			Iterator<OWLAnnotation> annotationIterator = ontology.getAnnotations().iterator();
			while (!found && annotationIterator.hasNext()) {
				ontologyAnnotation = annotationIterator.next();
				found = this.iri.equals(ontologyAnnotation.getProperty().getIRI());
			}
		}
		if (found) {
			toReturn = ontology;
		}
		return toReturn;
	}

	/**
	 * Sets the return variable
	 * 
	 * @param returnVariable
	 */
	public void setReturnVariable(Variable<?> returnVariable) {
		this.returnVariable = returnVariable;
	}

	/**
	 * @return the returnVariable
	 */
	public Variable<?> getReturnVariable() {
		return this.returnVariable;
	}

	/**
	 * @return true if the patterns returns a value, false otherwise
	 */
	public boolean isFunctional() {
		return this.returnVariable != null;
	}

	/**
	 * @return true if the pattern is applicable to OWL classes (must edit the
	 *         semantics of the class it applies to), false otherwise
	 */
	public boolean isClassPattern() {
		ClassPatternDetector classPatternDetector = new ClassPatternDetector();
		return this.accept(classPatternDetector);
	}

	/**
	 * 
	 * @return the pattern local name
	 * @see org.coode.oppl.OPPLScript#getName()
	 */
	public String getName() {
		return this.getPatternLocalName();
	}

	public void addDependency(PatternOPPLScript dependency) {
		this.dependencies.add(dependency);
	}

	public List<InputVariable<?>> getInputVariables() {
		return this.getOpplStatement().getInputVariables();
	}

	public boolean hasScopedVariables() {
		List<Variable<?>> variables = this.getVariables();
		Iterator<Variable<?>> it = variables.iterator();
		boolean found = false;
		while (!found && it.hasNext()) {
			Variable<?> v = it.next();
			found = v.accept(new VariableVisitorEx<Boolean>() {
				public <P extends OWLObject> Boolean visit(GeneratedVariable<P> v) {
					return false;
				}

				public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
					return v.getVariableScope() != null;
				}

				public <P extends OWLObject> Boolean visit(
						RegexpGeneratedVariable<P> regExpGenerated) {
					return false;
				}
			});
		}
		return found;
	}

	public void accept(OPPLScriptVisitor visitor) {
		this.getOpplStatement().accept(visitor);
	}

	public <P> P accept(OPPLScriptVisitorEx<P> visitor) {
		return this.getOpplStatement().accept(visitor);
	}

	public List<OWLAxiomChange> getActions() {
		return this.getOpplStatement().getActions();
	}

	public OPPLQuery getQuery() {
		return this.getOpplStatement().getQuery();
	}

	@Deprecated
	public void addVariable(Variable<?> variable) {
		if (this.opplStatement != null) {
			this.opplStatement.addVariable(variable);
		}
	}

	/**
	 * @return the scriptValidator
	 */
	public static final OPPLScriptValidator getScriptValidator() {
		return SCRIPT_VALIDATOR;
	}
}

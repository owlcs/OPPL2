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
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.OPPLFunctionVisitor;
import org.coode.oppl.function.OPPLFunctionVisitorEx;
import org.coode.oppl.function.ValueComputationParameters;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.util.NamespaceUtil;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 *         Jun 25, 2008
 */
public class PatternReference<O extends OWLObject> implements OPPLFunction<O> {
	private String patternName;
	private final PatternConstraintSystem patternConstraintSystem;
	private boolean resolvable;
	private final Set<String> visited = new HashSet<String>();
	private List<OWLObject>[] arguments;
	private PatternModel extractedPattern;
	private final ErrorListener errorListener;
	private final OWLObjectVisitorExAdapter<Variable<?>> variableExtractor = new OWLObjectVisitorExAdapter<Variable<?>>() {
		@Override
		public Variable<?> visit(OWLClass desc) {
			return PatternReference.this.getConstraintSystem().getVariable(desc.getIRI());
		}

		@Override
		public Variable<?> visit(OWLAnnotationProperty property) {
			return PatternReference.this.getConstraintSystem().getVariable(property.getIRI());
		}

		@Override
		public Variable<?> visit(OWLDataProperty property) {
			return PatternReference.this.getConstraintSystem().getVariable(property.getIRI());
		}

		@Override
		public Variable<?> visit(OWLObjectProperty property) {
			return PatternReference.this.getConstraintSystem().getVariable(property.getIRI());
		}

		@Override
		public Variable<?> visit(OWLNamedIndividual individual) {
			return PatternReference.this.getConstraintSystem().getVariable(individual.getIRI());
		}

		@Override
		public Variable<?> visit(OWLLiteral literal) {
			return PatternReference.this.getConstraintSystem().getVariable(literal.getLiteral());
		}
	};

	public PatternReference(String patternName, PatternConstraintSystem constraintSystem,
			ErrorListener errorListener, List<OWLObject>... args) throws PatternException {
		this(patternName, constraintSystem, Collections.<String> emptySet(), errorListener, args);
	}

	public PatternReference(String patternName, PatternConstraintSystem constraintSystem,
			Collection<? extends String> visitedPatterns, ErrorListener errorListener,
			List<OWLObject>... args) throws PatternException {
		if (patternName == null) {
			throw new NullPointerException("The pattern name cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		if (visitedPatterns == null) {
			throw new NullPointerException("The colleciton of visited patterns cannot be null");
		}
		if (errorListener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		this.patternName = patternName;
		this.patternConstraintSystem = constraintSystem;
		this.visited.addAll(visitedPatterns);
		this.errorListener = errorListener;
		this.init(args);
	}

	protected void init(List<OWLObject>... args) throws PatternException {
		Set<OWLOntology> ontologies = this.getConstraintSystem().getOntologyManager().getOntologies();
		Iterator<OWLOntology> ontologyIterator = ontologies.iterator();
		boolean found = false;
		OWLOntology anOntology;
		this.extractedPattern = null;
		// first check whether a pattern with that name is present
		while (!found && ontologyIterator.hasNext()) {
			anOntology = ontologyIterator.next();
			Set<OWLAnnotation> ontologyAnnotationAxioms = anOntology.getAnnotations();
			Iterator<OWLAnnotation> it = ontologyAnnotationAxioms.iterator();
			while (!found && it.hasNext()) {
				OWLAnnotation annotation = it.next();
				if (!this.hasBeenVisited(annotation.getProperty().getIRI())) {
					NamespaceUtil nsUtil = new NamespaceUtil();
					String[] split = nsUtil.split(
							annotation.getProperty().getIRI().toString(),
							null);
					if (split[1].compareTo(this.patternName) == 0) {
						PatternExtractor patternExtractor = this.patternConstraintSystem.getPatternModelFactory().getPatternExtractor(
								this.getVisitedAnnotations(),
								this.getErrorListener());
						this.extractedPattern = (PatternModel) annotation.accept(patternExtractor);
						found = this.extractedPattern != null;
					}
				}
			}
		}
		if (!found) {
			throw new PatternReferenceNotFoundException(this.patternName);
		}
		// Now check its variable compatibility
		this.checkCompatibility(args);
		this.resolvable = this.isResolvable(args);
		this.arguments = args;
	}

	/**
	 * @param extractedPattern
	 * @param args
	 * @return
	 */
	protected List<List<Object>> computeReplacements(List<OWLObject>... args) {
		List<List<Object>> replacements = new ArrayList<List<Object>>();
		for (List<OWLObject> iThAssignments : args) {
			List<Object> iThReplacement = new ArrayList<Object>();
			for (OWLObject iThAssignment : iThAssignments) {
				Variable<?> v = iThAssignment.accept(this.variableExtractor);
				if (v != null) {
					iThReplacement.add(v);
				} else {
					iThReplacement.add(iThAssignment);
				}
			}
			replacements.add(iThReplacement);
		}
		return replacements;
	}

	/**
	 * @param args
	 */
	protected boolean isResolvable(List<OWLObject>... args) {
		boolean isResolvable = true;
		for (int i = 0; i < args.length && isResolvable; i++) {
			List<OWLObject> iThArgumentAssignments = args[i];
			Iterator<OWLObject> it = iThArgumentAssignments.iterator();
			OWLObject anIthAssignment;
			while (it.hasNext() && isResolvable) {
				anIthAssignment = it.next();
				Variable<?> variable = anIthAssignment.accept(this.variableExtractor);
				if (variable != null) {
					isResolvable = false;
				}
			}
		}
		return isResolvable;
	}

	/**
	 * @param extractedPattern
	 * @param args
	 * @throws PatternException
	 * @throws IncompatibleArgumentException
	 * @throws InvalidNumebrOfArgumentException
	 */
	protected void checkCompatibility(List<OWLObject>... args) throws PatternException,
			IncompatibleArgumentException, InvalidNumebrOfArgumentException {
		boolean compatible = true;
		List<InputVariable<?>> variables = this.extractedPattern.getInputVariables();
		if (variables.size() == args.length) {
			for (int i = 0; i < args.length; i++) {
				List<OWLObject> iThArgAssignements = args[i];
				for (OWLObject anIthAssignment : iThArgAssignements) {
					Variable<?> variable = variables.get(i);
					Variable<?> argVariable = anIthAssignment.accept(this.variableExtractor);
					if (argVariable != null) {
						compatible = argVariable.getType().equals(variable.getType());
					} else {
						compatible = variable.getType().isCompatibleWith(anIthAssignment);
					}
					if (!compatible) {
						throw new IncompatibleArgumentException(anIthAssignment, variable);
					}
				}
			}
		} else {
			throw new InvalidNumebrOfArgumentException(this.patternName, args.length,
					variables.size());
		}
	}

	/**
	 * @return the resolvable
	 */
	public boolean isResolvable() {
		return this.resolvable;
	}

	/**
	 * @return the resolution
	 * @throws PatternException
	 */
	public List<OWLObject> getResolution() throws PatternException {
		List<List<Object>> replacements = this.computeReplacements(this.arguments);
		return this.extractedPattern.getDefinitorialPortions(replacements);
	}

	protected boolean hasBeenVisited(IRI annotationIRI) {
		boolean found = false;
		NamespaceUtil nsUtil = new NamespaceUtil();
		String[] split = nsUtil.split(annotationIRI.toString(), null);
		if (split != null && split.length == 2 && split[0].equals(PatternModel.NAMESPACE)) {
			found = this.visited.contains(split[1]);
		}
		return found;
	}

	protected Set<OWLAnnotation> getVisitedAnnotations() {
		Set<OWLAnnotation> toReturn = new HashSet<OWLAnnotation>();
		for (String visitedPatternName : this.visited) {
			Iterator<OWLOntology> it = this.getConstraintSystem().getOntologyManager().getOntologies().iterator();
			boolean found = false;
			OWLOntology ontology;
			while (!found && it.hasNext()) {
				ontology = it.next();
				Iterator<OWLAnnotation> annotationIterator = ontology.getAnnotations().iterator();
				OWLAnnotation anOntologyAnnotation = null;
				while (!found && annotationIterator.hasNext()) {
					anOntologyAnnotation = annotationIterator.next();
					found = anOntologyAnnotation.getProperty().getIRI().equals(
							IRI.create(PatternModel.NAMESPACE + visitedPatternName));
					if (found) {
						toReturn.add(anOntologyAnnotation);
					}
				}
			}
		}
		return toReturn;
	}

	public InstantiatedPatternModel getInstantiation(RuntimeExceptionHandler handler)
			throws PatternException {
		if (this.isResolvable()) {
			InstantiatedPatternModel toReturn = null;
			toReturn = this.getExtractedPattern().getPatternModelFactory().createInstantiatedPatternModel(
					this.getExtractedPattern(),
					handler);
			List<List<Object>> replacements = this.computeReplacements(this.arguments);
			int i = 0;
			for (Variable<?> variable : toReturn.getInputVariables()) {
				List<Object> variableReplacements = replacements.get(i);
				for (Object object : variableReplacements) {
					if (object instanceof OWLObject) {
						toReturn.instantiate(variable, (OWLObject) object);
					}
				}
				i++;
			}
			return toReturn;
		} else {
			throw new NonResovableArgumentsException(this.patternName, this.arguments);
		}
	}

	/**
	 * @return the extractedPattern
	 */
	public PatternModel getExtractedPattern() {
		return this.extractedPattern;
	}

	@Override
	public String toString() {
		return this.render(this.getConstraintSystem());
	}

	public String getPatternName() {
		return this.patternName;
	}

	/**
	 * @return the arguments
	 */
	public List<OWLObject>[] getArguments() {
		return this.arguments;
	}

	/**
	 * @return the patternConstraintSystem
	 */
	public PatternConstraintSystem getConstraintSystem() {
		return this.patternConstraintSystem;
	}

	/**
	 * @return the patternConstraintSystem
	 */
	public PatternConstraintSystem getPatternConstraintSystem() {
		return this.patternConstraintSystem;
	}

	/**
	 * @return the errorListener
	 */
	public ErrorListener getErrorListener() {
		return this.errorListener;
	}

	public String render(ConstraintSystem constraintSystem) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("$%s(", this.getPatternName()));
		for (List<OWLObject> args : this.getArguments()) {
			String openingBrace = args.size() > 1 ? "{" : "";
			String closingBrace = args.size() > 1 ? "}" : "";
			builder.append(openingBrace);
			Iterator<OWLObject> iterator = args.iterator();
			while (iterator.hasNext()) {
				OWLObject owlObject = iterator.next();
				ManchesterSyntaxRenderer renderer = this.getConstraintSystem().getOPPLFactory().getManchesterSyntaxRenderer(
						this.getConstraintSystem());
				owlObject.accept(renderer);
				builder.append(renderer.toString());
				if (iterator.hasNext()) {
					builder.append(", ");
				}
			}
			builder.append(closingBrace);
		}
		builder.append(")");
		return builder.toString();
	}

	public O compute(ValueComputationParameters params) {
		try {
			return (O) this.extractedPattern.getDefinitorialPortions(
					this.computeReplacements(this.getArguments())).get(0);
		} catch (PatternException e) {
			params.getRuntimeExceptionHandler().handleException(e);
		}
		return null;
	}

	public void accept(OPPLFunctionVisitor visitor) {
		visitor.visitGenericOPPLFunction(this);
	}

	public <P> P accept(OPPLFunctionVisitorEx<P> visitor) {
		return visitor.visitGenericOPPLFunction(this);
	}
}

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

import org.coode.oppl.Variable;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.NamespaceUtil;

/**
 * @author Luigi Iannone
 * 
 *         Jun 25, 2008
 */
public class PatternReference {
	private OWLOntologyManager ontologyManger;
	private String patternName;
	private final PatternConstraintSystem patternConstraintSystem;
	private boolean resolvable;
	private final Set<String> visited = new HashSet<String>();
	private List<String>[] arguments;
	private PatternOPPLScript extractedPattern;
	private final ErrorListener errorListener;

	public PatternReference(String patternName, PatternConstraintSystem constraintSystem,
			OWLOntologyManager ontologyManager, ErrorListener errorListener, List<String>... args)
			throws PatternException {
		this(patternName, constraintSystem, ontologyManager, Collections.<String> emptySet(),
				errorListener, args);
	}

	public PatternReference(String patternName, PatternConstraintSystem constraintSystem,
			OWLOntologyManager ontologyManager, Collection<? extends String> visitedPatterns,
			ErrorListener errorListener, List<String>... args) throws PatternException {
		if (patternName == null) {
			throw new NullPointerException("The pattern name cannot be null");
		}
		if (constraintSystem == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		if (ontologyManager == null) {
			throw new NullPointerException("The ontology manager cannot be null");
		}
		if (visitedPatterns == null) {
			throw new NullPointerException("The colleciton of visited patterns cannot be null");
		}
		if (errorListener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		this.patternName = patternName;
		this.patternConstraintSystem = constraintSystem;
		this.ontologyManger = ontologyManager;
		this.visited.addAll(visitedPatterns);
		this.errorListener = errorListener;
		this.init(args);
	}

	protected void init(List<String>... args) throws PatternException {
		Set<OWLOntology> ontologies = this.ontologyManger.getOntologies();
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
						this.extractedPattern = annotation.accept(patternExtractor);
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
	protected List<List<Object>> computeReplacements(List<String>... args) {
		List<List<Object>> replacements = new ArrayList<List<Object>>();
		for (List<String> iThAssignments : args) {
			List<Object> iThReplacement = new ArrayList<Object>();
			for (String iThAssignment : iThAssignments) {
				Variable v = this.patternConstraintSystem.getVariable(iThAssignment);
				if (v != null) {
					iThReplacement.add(v);
				} else {
					iThReplacement.add(this.parse(iThAssignment));
				}
			}
			replacements.add(iThReplacement);
		}
		return replacements;
	}

	private OWLObject parse(String string) {
		OWLEntityChecker entityChecker = this.getPatternConstraintSystem().getPatternModelFactory().getOPPLFactory().getOWLEntityChecker();
		OWLObject toReturn = entityChecker.getOWLClass(string);
		if (toReturn == null) {
			toReturn = entityChecker.getOWLDataProperty(string);
		}
		if (toReturn == null) {
			toReturn = entityChecker.getOWLDatatype(string);
		}
		if (toReturn == null) {
			toReturn = entityChecker.getOWLIndividual(string);
		}
		if (toReturn == null) {
			toReturn = entityChecker.getOWLObjectProperty(string);
		}
		return toReturn;
	}

	/**
	 * @param args
	 */
	protected boolean isResolvable(List<String>... args) {
		boolean isResolvable = true;
		for (int i = 0; i < args.length && isResolvable; i++) {
			List<String> iThArgumentAssignments = args[i];
			Iterator<String> it = iThArgumentAssignments.iterator();
			String anIthAssignment;
			while (it.hasNext() && isResolvable) {
				anIthAssignment = it.next();
				Variable variable = this.patternConstraintSystem.getVariable(anIthAssignment);
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
	protected void checkCompatibility(List<String>... args) throws PatternException,
			IncompatibleArgumentException, InvalidNumebrOfArgumentException {
		boolean compatible = true;
		List<Variable> variables = this.extractedPattern.getInputVariables();
		if (variables.size() == args.length) {
			for (int i = 0; i < args.length; i++) {
				List<String> iThArgAssignements = args[i];
				for (String anIthAssignment : iThArgAssignements) {
					Variable variable = variables.get(i);
					if (this.patternConstraintSystem.getVariable(anIthAssignment) != null) {
						Variable argVariable = this.patternConstraintSystem.getVariable(anIthAssignment);
						compatible = argVariable.getType().equals(variable.getType());
					} else {
						OWLObject arg = this.parse(anIthAssignment);
						if (arg != null) {
							compatible = variable.getType().isCompatibleWith(arg);
							// if (arg instanceof OWLEntity) {
							// compatible = variable.getType()
							// .isCompatibleWith(arg);
							// } else {
							// compatible = variable.getType()
							// .isCompatibleWith(arg);
							// }
						} else {
							compatible = false;
							throw new PatternException("Illegal argument " + iThArgAssignements);
						}
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
	public String getResolutionString() throws PatternException {
		List<List<Object>> replacements = this.computeReplacements(this.arguments);
		return this.extractedPattern.getDefinitorialPortionStrings(replacements);
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
		// TODO performance wise: have visited contain the complete uris or
		// check that the uri starts with the namespace before creating the
		// namespaceutil object
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
			Iterator<OWLOntology> it = this.ontologyManger.getOntologies().iterator();
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

	public InstantiatedPatternModel getInstantiation() throws PatternException {
		if (this.isResolvable()) {
			InstantiatedPatternModel toReturn = null;
			if (this.extractedPattern instanceof InstantiatedPatternModel) {
				toReturn = (InstantiatedPatternModel) this.extractedPattern;
			} else {
				PatternModel p = (PatternModel) this.extractedPattern;
				toReturn = p.getPatternModelFactory().createInstantiatedPatternModel(p);
			}
			List<List<Object>> replacements = this.computeReplacements(this.arguments);
			int i = 0;
			for (Variable variable : toReturn.getInputVariables()) {
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
	public PatternOPPLScript getExtractedPattern() {
		return this.extractedPattern;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("$");
		buffer.append(this.patternName);
		buffer.append('(');
		boolean firstArgument = true;
		for (List<String> ithArgList : this.arguments) {
			String comma = firstArgument ? "" : ", ";
			buffer.append(comma);
			firstArgument = false;
			if (ithArgList.size() > 1) {
				buffer.append('{');
				boolean firstSubArg = true;
				for (String string : ithArgList) {
					comma = firstSubArg ? "" : ", ";
					firstSubArg = false;
					buffer.append(comma);
					buffer.append(string);
				}
				buffer.append('}');
			} else if (ithArgList.size() == 1) {
				buffer.append(ithArgList.get(0));
			}
		}
		buffer.append(')');
		return buffer.toString().trim();
	}

	public String getPatternName() {
		return this.patternName;
	}

	/**
	 * @return the arguments
	 */
	public List<String>[] getArguments() {
		return this.arguments;
	}

	/**
	 * @return the patternConstraintSystem
	 */
	public PatternConstraintSystem getConstraintSystem() {
		return this.patternConstraintSystem;
	}

	/**
	 * @return the ontologyManger
	 */
	public OWLOntologyManager getOntologyManger() {
		return this.ontologyManger;
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
}

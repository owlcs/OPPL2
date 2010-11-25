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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.parsers.ErrorListener;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.patterns.OPPLPatternParser.PatternReferenceResolver;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.NamespaceUtil;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 * 
 */
public class PatternExtractor extends OWLObjectVisitorExAdapter<PatternOPPLScript> implements
		OWLAnnotationObjectVisitorEx<PatternOPPLScript> {
	private final OWLOntologyManager ontologyManager;
	private final OWLOntology ontology;
	private final ErrorListener errorListener;
	private final Set<OWLAnnotation> visited = new HashSet<OWLAnnotation>();

	/**
	 * @param owlOntologyManager
	 * @param visited
	 */
	public PatternExtractor(OWLOntology ontology, OWLOntologyManager owlOntologyManager,
			ErrorListener errorListener, Set<OWLAnnotation> visited) {
		super();
		if (ontology == null) {
			throw new NullPointerException("The ontology  cannot be null");
		}
		if (owlOntologyManager == null) {
			throw new NullPointerException("The ontology manager cannot be null");
		}
		if (errorListener == null) {
			throw new NullPointerException("The error listener cannot be null");
		}
		this.ontologyManager = owlOntologyManager;
		this.ontology = ontology;
		this.visited.addAll(visited);
		this.errorListener = errorListener;
	}

	/**
	 * @param owlOntologyManager
	 */
	public PatternExtractor(OWLOntology ontology, OWLOntologyManager owlOntologyManager,
			ErrorListener listener) {
		this(ontology, owlOntologyManager, listener, Collections.<OWLAnnotation> emptySet());
	}

	@Override
	public PatternOPPLScript visit(OWLAnnotation annotation) {
		PatternOPPLScript toReturn = null;
		if (this.visited.isEmpty() || !this.visited.contains(annotation)) {
			NamespaceUtil nsUtil = new NamespaceUtil();
			String[] split = nsUtil.split(annotation.getProperty().getIRI().toString(), null);
			if (split != null && split.length == 2 && split[0].equals(PatternModel.NAMESPACE)) {
				String value = annotation.getValue().accept(
						new OWLObjectVisitorExAdapter<String>() {
							@Override
							public String visit(OWLLiteral literal) {
								return literal.getLiteral();
							}
						});
				if (value != null) {
					String patternName = split[1];
					ParserFactory parserFactory = new ParserFactory(this.getOntology(),
							this.getOntologyManager());
					OPPLPatternParser parser = parserFactory.build(this.getErrorListener());
					Set<String> visitedPatternNames = this.getVisitedPatternNames();
					visitedPatternNames.add(patternName);
					this.getPatternReferenceResolver(visitedPatternNames);
					ParserFactory factory = new ParserFactory(this.ontology, this.ontologyManager);
					factory.build(visitedPatternNames, this.errorListener);
					toReturn = parser.parse(value);
					if (toReturn != null) {
						toReturn.setIRI(annotation.getProperty().getIRI());
					}
				}
			}
		} else {
			this.getErrorListener().reportThrowable(
					new RuntimeException("Cyclic reference detected "),
					0,
					0,
					0);
		}
		return toReturn;
	}

	protected Set<String> getVisitedPatternNames() {
		Set<String> toReturn = new HashSet<String>();
		NamespaceUtil nsUtil = new NamespaceUtil();
		String[] split = new String[2];
		for (OWLAnnotation patternAnnotation : this.visited) {
			if (split == null) {
				split = new String[2];
			}
			String iri = patternAnnotation.getProperty().getIRI().toString();
			if (iri != null) {
				split = nsUtil.split(iri, split);
				if (split != null && split[0].equals(PatternModel.NAMESPACE)) {
					toReturn.add(split[1]);
				}
			}
		}
		return toReturn;
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	/**
	 * @return the ontology
	 */
	public OWLOntology getOntology() {
		return this.ontology;
	}

	/**
	 * @return the errorListener
	 */
	public ErrorListener getErrorListener() {
		return this.errorListener;
	}

	private PatternReferenceResolver getPatternReferenceResolver(
			final Collection<? extends String> visited) {
		return new PatternReferenceResolver() {
			public void resolvePattern(OPPLSyntaxTree reference, String patternName,
					PatternConstraintSystem constraintSystem, OPPLPatternsSymbolTable symbolTable,
					List<Object>... args) {
				symbolTable.resolvePattern(
						reference,
						patternName,
						constraintSystem,
						new HashSet<String>(visited),
						args);
			}
		};
	}
}

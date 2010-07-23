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

import java.util.HashSet;
import java.util.Set;

import org.coode.patterns.syntax.ParseException;
import org.coode.patterns.syntax.PatternParser;
import org.coode.patterns.utils.ParserFactory;
import org.semanticweb.owl.model.OWLAnnotationVisitorEx;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLObjectAnnotation;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.util.NamespaceUtil;

/**
 * @author Luigi Iannone
 * 
 */
public class PatternExtractor implements
		OWLAnnotationVisitorEx<PatternOPPLScript> {
	private OWLOntologyManager owlOntologyManager;
	private final OWLOntology ontology;
	protected Set<OWLConstantAnnotation> visited = new HashSet<OWLConstantAnnotation>();

	/**
	 * @param owlOntologyManager
	 * @param visited
	 */
	public PatternExtractor(OWLOntology ontology,
			OWLOntologyManager owlOntologyManager,
			Set<OWLConstantAnnotation> visited) {
		this.owlOntologyManager = owlOntologyManager;
		this.ontology = ontology;
		this.visited = visited;
	}

	/**
	 * @param owlOntologyManager
	 */
	public PatternExtractor(OWLOntology ontology,
			OWLOntologyManager owlOntologyManager) {
		this.owlOntologyManager = owlOntologyManager;
		this.ontology = ontology;
	}

	public PatternOPPLScript visit(OWLObjectAnnotation annotation) {
		return null;
	}

	public PatternOPPLScript visit(OWLConstantAnnotation annotation) {
		PatternOPPLScript toReturn = null;
		if (this.visited.isEmpty() || !this.visited.contains(annotation)) {
			NamespaceUtil nsUtil = new NamespaceUtil();
			String[] split = nsUtil.split(annotation.getAnnotationURI()
					.toString(), null);
			if (split != null && split.length == 2
					&& split[0].equals(PatternModel.NAMESPACE)) {
				String value = annotation.getAnnotationValue().getLiteral();
				String patternName = split[1];
				PatternParser parser = this.initParser(value);
				try {
					parser.addVisited(patternName);
					toReturn = parser.Start();
					toReturn.setUri(annotation.getAnnotationURI());
				} catch (ParseException e) {
					System.out.println(value);
					e.printStackTrace(System.out);
				}
			}
		}
		return toReturn;
	}

	/**
	 * @param value
	 */
	protected PatternParser initParser(String value) {
		PatternParser parser = ParserFactory.initParser(value, this.ontology,
				this.owlOntologyManager);
		parser.setVisited(this.getVisitedPatternNames());
		return parser;
	}

	protected Set<String> getVisitedPatternNames() {
		Set<String> toReturn = new HashSet<String>();
		NamespaceUtil nsUtil = new NamespaceUtil();
		String[] split = new String[2];
		for (OWLConstantAnnotation patternAnnotation : this.visited) {
			if (split == null) {
				split = new String[2];
			}
			String uri = patternAnnotation.getAnnotationURI().toString();
			if (uri != null) {
				split = nsUtil.split(uri, split);
				if (split != null && split[0].equals(PatternModel.NAMESPACE)) {
					toReturn.add(split[1]);
				}
			}
		}
		return toReturn;
	}
}

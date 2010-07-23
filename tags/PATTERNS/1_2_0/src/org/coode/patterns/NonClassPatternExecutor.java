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

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.coode.oppl.ActionType;
import org.coode.oppl.ChangeExtractor;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 *         Jul 3, 2008
 */
public class NonClassPatternExecutor extends ChangeExtractor {
	private InstantiatedPatternModel instantiatedPatternModel;
	private URI annotationURI;
	private OWLOntology ontology;
	private OWLOntologyManager ontologyManager;

	public NonClassPatternExecutor(
			InstantiatedPatternModel instantiatedPatternModel,
			OWLOntology ontology, OWLOntologyManager ontologyManager,
			URI annotationURI) {
		super(instantiatedPatternModel.getConstraintSystem(), true);
		this.instantiatedPatternModel = instantiatedPatternModel;
		this.annotationURI = annotationURI;
		this.ontology = ontology;
		this.ontologyManager = ontologyManager;
	}

	@Override
	public List<OWLAxiomChange> visitActions(List<OWLAxiomChange> changes,
			List<OWLAxiomChange> p1) {
		Set<OWLAxiomChange> p = new HashSet<OWLAxiomChange>(changes.size());
		for (OWLAxiomChange axiomChange : changes) {
			ActionType actionType = axiomChange instanceof AddAxiom ? ActionType.ADD
					: ActionType.REMOVE;
			OWLAxiom axiom = axiomChange.getAxiom();
			Collection<? extends OWLAxiomChange> createdChanges = PatternActionFactory
					.createChange(actionType, axiom,
							this.instantiatedPatternModel, this.ontologyManager
									.getOWLDataFactory(), this.annotationURI,
							this.ontology);
			p.addAll(createdChanges);
		}
		return new ArrayList<OWLAxiomChange>(p);
	}
}

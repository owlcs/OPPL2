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
import java.util.List;
import java.util.Set;

import org.coode.oppl.ActionType;
import org.coode.oppl.variablemansyntax.PartialOWLObjectInstantiator;
import org.coode.oppl.variablemansyntax.VariableType;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLAnnotationAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.RemoveAxiom;

/**
 * @author Luigi Iannone
 * 
 *         Jul 3, 2008
 */
public class PatternActionFactory {
	public static final String CREATED_BY = "createdBy";

	public static Collection<? extends OWLAxiomChange> createChange(
			OWLClass thisClass, ActionType actionType, OWLAxiom axiom,
			InstantiatedPatternModel instantiatedPatternModel,
			OWLDataFactory owlDataFactory, URI annotationURI,
			OWLOntology ontology) {
		instantiatedPatternModel.getConstraintSystem().instantiateThisClass(
				new PatternConstant<OWLClass>(
						PatternConstraintSystem.THIS_CLASS_VARIABLE_NAME,
						VariableType.CLASS, PatternConstant
								.createConstantGeneratedValue(thisClass)));
		return createChange(actionType, axiom, instantiatedPatternModel,
				owlDataFactory, annotationURI, ontology);
	}

	/**
	 * @param instantiatedAxiom
	 * @param actionType
	 * @param changes
	 * @param instantiatedPatternModel
	 * @param owlDataFactory
	 * @param ontology
	 * @param annotationURI
	 */
	private static void addChange(OWLAxiom instantiatedAxiom,
			ActionType actionType, List<OWLAxiomChange> changes,
			InstantiatedPatternModel instantiatedPatternModel,
			OWLDataFactory owlDataFactory, OWLOntology ontology,
			URI annotationURI) {
		OWLAxiomChange axiomChange = null;
		if (instantiatedPatternModel.getConstraintSystem().getAxiomVariables(
				instantiatedAxiom).isEmpty()) {
			switch (actionType) {
				case ADD:
					OWLAnnotation<? extends OWLObject> annotation = owlDataFactory
							.getOWLConstantAnnotation(URI
									.create(PatternModel.NAMESPACE
											+ PatternActionFactory.CREATED_BY),
									owlDataFactory
											.getOWLTypedConstant(annotationURI
													.toString()));
					OWLAnnotationAxiom<OWLAxiom> annotationAxiom = owlDataFactory
							.getOWLAxiomAnnotationAxiom(instantiatedAxiom,
									annotation);
					axiomChange = new AddAxiom(ontology, instantiatedAxiom);
					changes.add(axiomChange);
					changes.add(new AddAxiom(ontology, annotationAxiom));
					break;
				case REMOVE:
					axiomChange = new RemoveAxiom(ontology, instantiatedAxiom);
					changes.add(axiomChange);
					break;
				default:
					break;
			}
		}
	}

	public static Collection<? extends OWLAxiomChange> createChange(
			ActionType actionType, OWLAxiom axiom,
			InstantiatedPatternModel instantiatedPatternModel,
			OWLDataFactory owlDataFactory, URI annotationURI,
			OWLOntology ontology) {
		List<OWLAxiomChange> toReturn = new ArrayList<OWLAxiomChange>();
		Set<BindingNode> bindingNodes = instantiatedPatternModel
				.extractBindingNodes();
		if (bindingNodes != null && !bindingNodes.isEmpty()) {
			instantiatedPatternModel.getConstraintSystem().setLeaves(
					bindingNodes);
			for (BindingNode bindingNode : bindingNodes) {
				PartialOWLObjectInstantiator instatiator = new PartialOWLObjectInstantiator(
						bindingNode, instantiatedPatternModel
								.getConstraintSystem());
				OWLAxiom instantiatedAxiom = (OWLAxiom) axiom
						.accept(instatiator);
				addChange(instantiatedAxiom, actionType, toReturn,
						instantiatedPatternModel, owlDataFactory, ontology,
						annotationURI);
			}
		}
		return toReturn;
	}
}

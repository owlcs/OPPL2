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
package org.coode.oppl.rendering;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.utils.ArgCheck;
import org.semanticweb.owl.model.OWLAntiSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstantAnnotation;
import org.semanticweb.owl.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLImportsDeclaration;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectAnnotation;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLUntypedConstant;
import org.semanticweb.owl.util.SimpleURIShortFormProvider;
import org.semanticweb.owl.util.URIShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class ManchesterSyntaxRenderer extends AbstractRenderer {
	private final OWLOntologyManager ontologyManager;
	private final ConstraintSystem constraintSystem;

	/**
	 * Builds a renderer in Manchester OWL Syntax <b>non frame based</b>
	 * 
	 * @param ontologyManager
	 *            Cannot be {@code null}.
	 * @param entityRenderer
	 *            the renderer according to which the named entities will be
	 *            rendered. Cannot be {@code null}.
	 * @param constraintSystem
	 *            the ConstraintSystem . Cannot be {@code null}.
	 * @throws NullPointerException
	 *             if any of the inputs is {@code null}.
	 */
	public ManchesterSyntaxRenderer(OWLOntologyManager ontologyManager,
			OWLEntityRenderer entityRenderer, ConstraintSystem constraintSystem) {
		ArgCheck.checkNullArgument("The ontology manager", ontologyManager);
		ArgCheck.checkNullArgument("The entity renderer", entityRenderer);
		ArgCheck.checkNullArgument("The constraint system", constraintSystem);
		this.ontologyManager = ontologyManager;
		this.entityRenderer = entityRenderer;
		this.constraintSystem = constraintSystem;
		this.init();
	}

	@Override
	public String toString() {
		return this.buffer.toString();
	}

	public void visit(OWLAntiSymmetricObjectPropertyAxiom axiom) {
		this.write("AntiSymmetric: ");
		axiom.getProperty().accept(this);
	}

	public void visit(OWLAxiomAnnotationAxiom axiom) {
		axiom.getSubject().accept(this);
		this.write(" ");
		axiom.getAnnotation().accept(this);
	}

	public void visit(OWLClass node) {
		this.write(this.getRendering(node));
	}

	public void visit(OWLClassAssertionAxiom axiom) {
		axiom.getIndividual().accept(this);
		this.write(" types ");
		axiom.getDescription().accept(this);
	}

	public void visit(OWLConstantAnnotation annotation) {
		URIShortFormProvider uriShortFormProvider = new SimpleURIShortFormProvider();
		this.write(uriShortFormProvider.getShortForm(annotation
				.getAnnotationURI()));
		this.write(" ");
		this.write(annotation.getAnnotationValue().toString());
	}

	public void visit(OWLDataPropertyDomainAxiom axiom) {
		axiom.getProperty().accept(this);
		this.write(" domain ");
		axiom.getDomain().accept(this);
	}

	public void visit(OWLDataPropertyRangeAxiom axiom) {
		axiom.getProperty().accept(this);
		this.write(" range ");
		axiom.getRange().accept(this);
	}

	public void visit(OWLEquivalentClassesAxiom node) {
		List<OWLDescription> orderedDescs = new ArrayList<OWLDescription>(node
				.getDescriptions());
		for (Iterator<OWLDescription> it = orderedDescs.iterator(); it
				.hasNext();) {
			OWLDescription desc = it.next();
			if (orderedDescs.get(0).isOWLNothing()) {
				it.remove();
				orderedDescs.add(desc);
				break;
			}
		}
		for (Iterator<OWLDescription> it = orderedDescs.iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" equivalentTo ");
			}
		}
	}

	public void visit(OWLImportsDeclaration axiom) {
		this.writeOntologyURI(axiom.getImportedOntologyURI());
		if (this.ontologyManager.getImportedOntology(axiom) == null) {
			this.write("      (Not Loaded)");
		}
	}

	public void visit(OWLIndividual node) {
		if (node.isAnonymous()) {
			this.write("Anonymous : [");
			for (OWLOntology ont : this.ontologyManager.getOntologies()) {
				for (OWLDescription desc : node.getTypes(ont)) {
					this.write(" ");
					desc.accept(this);
				}
			}
			this.write(" ]");
		} else {
			this.write(this.getRendering(node));
		}
	}

	public void visit(OWLObjectAnnotation owlObjectAnnotation) {
		URIShortFormProvider uriShortFormProvider = new SimpleURIShortFormProvider();
		this.write(uriShortFormProvider.getShortForm(owlObjectAnnotation
				.getAnnotationURI()));
		this.write(" ");
		owlObjectAnnotation.getAnnotationValue().accept(this);
	}

	public void visit(OWLObjectIntersectionOf node) {
		int indent = this.getIndent();
		List<OWLDescription> ops = new ArrayList<OWLDescription>(node
				.getOperands());
		for (int i = 0; i < ops.size(); i++) {
			OWLDescription curOp = ops.get(i);
			curOp.accept(this);
			if (i < ops.size() - 1) {
				this.write("\n");
				this.insertIndent(indent);
				this.writeAndKeyword();
			}
		}
	}

	public void visit(OWLObjectPropertyDomainAxiom axiom) {
		axiom.getProperty().accept(this);
		this.write(" some ");
		this.ontologyManager.getOWLDataFactory().getOWLThing().accept(this);
		this.write(" subClassOf ");
		axiom.getDomain().accept(this);
	}

	public void visit(OWLObjectPropertyRangeAxiom axiom) {
		axiom.getProperty().accept(this);
		this.write(" range ");
		axiom.getRange().accept(this);
	}

	public void visit(OWLObjectUnionOf node) {
		int indent = this.getIndent();
		for (Iterator<OWLDescription> it = node.getOperands().iterator(); it
				.hasNext();) {
			OWLDescription curOp = it.next();
			this.writeOpenBracket(curOp);
			curOp.accept(this);
			this.writeCloseBracket(curOp);
			if (it.hasNext()) {
				this.write("\n");
				this.insertIndent(indent);
				this.writeOrKeyword();
			}
		}
	}

	public void visit(OWLUntypedConstant node) {
		if (this.constraintSystem.isVariable(node)) {
			Variable v = this.constraintSystem.getVariable(node.getLiteral());
			this.write(this.constraintSystem.render(v));
		} else {
			this.write("\"");
			this.write(node.getLiteral());
			this.write("\"");
			if (node.hasLang()) {
				this.write("@");
				this.write(node.getLang());
			}
		}
	}
}

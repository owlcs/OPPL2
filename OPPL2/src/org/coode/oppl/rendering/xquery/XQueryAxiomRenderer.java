package org.coode.oppl.rendering.xquery;

import static org.semanticweb.owl.vocab.OWLXMLVocabulary.CLASS;

import java.net.URI;

import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.owlapi.owlxml.renderer.OWLXMLObjectRenderer;
import org.coode.owlapi.owlxml.renderer.OWLXMLWriter;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;
import org.semanticweb.owl.vocab.Namespaces;
import org.semanticweb.owl.vocab.OWLXMLVocabulary;

public class XQueryAxiomRenderer extends OWLXMLObjectRenderer {
	private final ConstraintSystem constraintSystem;
	private final OWLXMLWriter writer;

	public XQueryAxiomRenderer(OWLXMLWriter writer,
			ConstraintSystem constraintSystem) {
		super(writer);
		this.writer = writer;
		this.constraintSystem = constraintSystem;
	}

	/**
	 * @param desc
	 * @see org.coode.owlapi.owlxml.renderer.OWLXMLObjectRenderer#visit(org.semanticweb.owl.model.OWLClass)
	 */
	@Override
	public void visit(OWLClass desc) {
		if (this.constraintSystem.isVariable(desc)) {
			Variable variable = this.constraintSystem.getVariable(desc
					.getURI());
			this.writer.writeStartElement(CLASS.getURI());
			this.writer.writeNameAttribute(URI.create("("
					+ getVariableReference(variable) + ")"));
			this.writer.writeEndElement();
		} else {
			super.visit(desc);
		}
	}

	private String getVariableReference(Variable variable) {
		return variable.getName().replace('?', '$');
	}

	/**
	 * @param property
	 * @see org.coode.owlapi.owlxml.renderer.OWLXMLObjectRenderer#visit(org.semanticweb.owl.model.OWLDataProperty)
	 */
	@Override
	public void visit(OWLDataProperty property) {
		if (this.constraintSystem.isVariable(property)) {
			Variable variable = this.constraintSystem.getVariable(property
					.getURI());
			this.writer.writeStartElement(OWLXMLVocabulary.DATA_PROPERTY
					.getURI());
			this.writer.writeNameAttribute(URI.create("("
					+ getVariableReference(variable) + ")"));
			this.writer.writeEndElement();
		} else {
			super.visit(property);
		}
	}

	/**
	 * @param individual
	 * @see org.coode.owlapi.owlxml.renderer.OWLXMLObjectRenderer#visit(org.semanticweb.owl.model.OWLIndividual)
	 */
	@Override
	public void visit(OWLIndividual individual) {
		if (this.constraintSystem.isVariable(individual)) {
			Variable variable = this.constraintSystem
					.getVariable(individual.getURI());
			this.writer.writeStartElement(OWLXMLVocabulary.INDIVIDUAL.getURI());
			this.writer.writeNameAttribute(URI.create("("
					+ getVariableReference(variable) + ")"));
			this.writer.writeEndElement();
		} else {
			super.visit(individual);
		}
	}

	/**
	 * @param property
	 * @see org.coode.owlapi.owlxml.renderer.OWLXMLObjectRenderer#visit(org.semanticweb.owl.model.OWLObjectProperty)
	 */
	@Override
	public void visit(OWLObjectProperty property) {
		if (this.constraintSystem.isVariable(property)) {
			Variable variable = this.constraintSystem.getVariable(property
					.getURI());
			this.writer.writeStartElement(OWLXMLVocabulary.OBJECT_PROPERTY
					.getURI());
			this.writer.writeNameAttribute(URI.create("("
					+ getVariableReference(variable) + ")"));
			this.writer.writeEndElement();
		} else {
			super.visit(property);
		}
	}

	/**
	 * @param node
	 * @see org.coode.owlapi.owlxml.renderer.OWLXMLObjectRenderer#visit(org.semanticweb.owl.model.OWLTypedConstant)
	 */
	@Override
	public void visit(OWLTypedConstant node) {
		if (this.constraintSystem.isVariable(node)) {
			Variable variable = this.constraintSystem.getVariable(node
					.getLiteral());
			this.writer.writeStartElement(URI.create(Namespaces.OWL2XML
					+ "Literal"));
			this.writer.writeTextContent("(" + getVariableReference(variable)
					+ ")");
			this.writer.writeEndElement();
		} else {
			super.visit(node);
		}
	}

	/**
	 * @param node
	 * @see org.coode.owlapi.owlxml.renderer.OWLXMLObjectRenderer#visit(org.semanticweb.owl.model.OWLUntypedConstant)
	 */
	@Override
	public void visit(OWLUntypedConstant node) {
		if (this.constraintSystem.isVariable(node)) {
			Variable variable = this.constraintSystem.getVariable(node
					.getLiteral());
			this.writer.writeStartElement(URI.create(Namespaces.OWL2XML
					+ "Literal"));
			this.writer.writeTextContent("(" + getVariableReference(variable)
					+ ")");
			this.writer.writeEndElement();
		} else {
			super.visit(node);
		}
	}
}

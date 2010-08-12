package org.coode.oppl.protege.ui;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.coode.oppl.rendering.AbstractRenderer;
import org.protege.editor.owl.model.OWLModelManager;
import org.protege.editor.owl.ui.OWLDescriptionComparator;
import org.protege.editor.owl.ui.renderer.OWLEntityRenderer;
import org.protege.editor.owl.ui.renderer.OWLObjectRenderer;
import org.protege.editor.owl.ui.renderer.OWLRendererPreferences;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLConstantAnnotation;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAnnotation;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLRestriction;
import org.semanticweb.owlapi.model.OWLUntypedConstant;

/**
 * Author: Luigi Iannone<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: Oct 15, 2008<br>
 * <br>
 * <br>
 * <p/>
 * A renderer that renders objects possibly containing variables using the
 * Manchester OWL Syntax. Axiom level OWLObjects are rendered in Manchester
 * "style"
 */
public class VariableOWLObjectRenderer extends AbstractRenderer implements
		OWLObjectVisitor, OWLObjectRenderer {
	// private Map<OWLRestrictedDataRangeFacetVocabulary, String> facetMap;
	// private Map<URI, Boolean> simpleRenderDatatypes;
	private OWLObject focusedObject;
	private final OWLModelManager owlModelManager;
	// private int lastNewLineIndex = 0;
	// private int currentIndex = 0;
	private final OWLDescriptionComparator comparator;

	// private OWLEntityRenderer entityRenderer;
	public VariableOWLObjectRenderer(OWLModelManager owlModelManager) {
		this.owlModelManager = owlModelManager;
		this.comparator = new OWLDescriptionComparator(this.owlModelManager);
		// this.entityRenderer = owlModelManager.getOWLEntityRenderer();
		this.init();
	}

	public void dispose() {
	}

	public OWLObject getFocusedObject() {
		return this.focusedObject;
	}

	public String getText() {
		return this.buffer.toString();
	}

	public void initialise() {
	}

	public String render(OWLObject object,
			final OWLEntityRenderer entityRenderer) {
		this.entityRenderer = new org.coode.oppl.entity.OWLEntityRenderer() {
			public String render(OWLEntity entity) {
				return entityRenderer.render(entity);
			}
		};
		this.reset();
		try {
			object.accept(this);
			return this.buffer.toString();
		} catch (Exception e) {
			return "<Error! " + e.getMessage() + ">";
		}
	}

	private void reset() {
		this.lastNewLineIndex = 0;
		this.currentIndex = 0;
		this.buffer = new StringBuilder();
	}

	public void setFocusedObject(OWLObject focusedObject) {
		this.focusedObject = focusedObject;
		if (focusedObject instanceof OWLDescription) {
			this.comparator
					.setFocusedDescription((OWLClassExpression) focusedObject);
		}
	}

	public void setup(OWLModelManager owlModelManager) {
	}

	private List<OWLClassExpression> sort(Set<OWLClassExpression> descriptions) {
		List<OWLClassExpression> sortedDescs = new ArrayList<OWLClassExpression>(
				descriptions);
		Collections.sort(sortedDescs, this.comparator);
		return sortedDescs;
	}

	public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
		this.write("AntiSymmetric: ");
		axiom.getProperty().accept(this);
	}

	public void visit(OWLAxiomAnnotationAxiom axiom) {
		axiom.getSubject().accept(this);
		this.write(" ");
		axiom.getAnnotation().accept(this);
	}

	public void visit(OWLClass node) {
		String rendering = this.getRendering(node);
		this.write(rendering);
	}

	public void visit(OWLClassAssertionAxiom axiom) {
		axiom.getIndividual().accept(this);
		this.write(" instanceOf ");
		axiom.getDescription().accept(this);
	}

	public void visit(OWLLiteralAnnotation annotation) {
		this.write(this.owlModelManager.getURIRendering(annotation
				.getAnnotationURI()));
		this.write(" ");
		this.write(annotation.getAnnotationValue().toString());
	}

	public void visit(OWLDataPropertyDomainAxiom axiom) {
		axiom.getProperty().accept(this);
		this.write(" hasDomain ");
		axiom.getDomain().accept(this);
	}

	public void visit(OWLDataPropertyRangeAxiom axiom) {
		axiom.getProperty().accept(this);
		this.write(" hasRange ");
		axiom.getRange().accept(this);
	}

	public void visit(OWLEquivalentClassesAxiom node) {
		List<OWLClassExpression> orderedDescs = this.sort(node.getDescriptions());
		for (Iterator<OWLClassExpression> it = orderedDescs.iterator(); it
				.hasNext();) {
			OWLClassExpression  desc = it.next();
			if (orderedDescs.get(0).isOWLNothing()) {
				it.remove();
				orderedDescs.add(desc);
				break;
			}
		}
		for (Iterator<OWLClassExpression> it = orderedDescs.iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" equivalentTo ");
			}
		}
	}

	public void visit(OWLImportsDeclaration axiom) {
		this.writeOntologyIRI(axiom.getImportedOntologyURI());
		if (this.owlModelManager.getOWLOntologyManager().getImportedOntology(
				axiom) == null) {
			this.write("      (Not Loaded)");
		}
	}

	public void visit(OWLIndividual node) {
		if (node.isAnonymous()) {
			this.write("Anonymous : [");
			for (OWLOntology ont : this.owlModelManager.getActiveOntologies()) {
				for (OWLClassExpression desc : node.getTypes(ont)) {
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
		this.write(this.owlModelManager.getURIRendering(owlObjectAnnotation
				.getAnnotationURI()));
		this.write(" ");
		owlObjectAnnotation.getAnnotationValue().accept(this);
	}

	public void visit(OWLObjectIntersectionOf node) {
		int indent = this.getIndent();
		List<OWLClassExpression> ops = this.sort(node.getOperands());
		for (int i = 0; i < ops.size(); i++) {
			OWLClassExpression  curOp = ops.get(i);
			curOp.accept(this);
			if (i < ops.size() - 1) {
				this.write("\n");
				this.insertIndent(indent);
				if (curOp instanceof OWLClass
						&& ops.get(i + 1) instanceof OWLRestriction<?>
						&& OWLRendererPreferences.getInstance()
								.isUseThatKeyword()) {
					this.write("that ");
				} else {
					this.writeAndKeyword();
				}
			}
		}
	}

	public void visit(OWLObjectPropertyDomainAxiom axiom) {
		if (!OWLRendererPreferences.getInstance().isRenderDomainAxiomsAsGCIs()) {
			axiom.getDomain().accept(this);
			this.write(" domainOf ");
			axiom.getProperty().accept(this);
		} else {
			axiom.getProperty().accept(this);
			this.write(" some ");
			this.owlModelManager.getOWLDataFactory().getOWLThing().accept(this);
			this.write(" subClassOf ");
			axiom.getDomain().accept(this);
		}
	}

	public void visit(OWLObjectPropertyRangeAxiom axiom) {
		axiom.getRange().accept(this);
		this.write(" rangeOf ");
		axiom.getProperty().accept(this);
	}

	public void visit(OWLObjectUnionOf node) {
		int indent = this.getIndent();
		for (Iterator<OWLClassExpression> it = this.sort(node.getOperands())
				.iterator(); it.hasNext();) {
			OWLClassExpression  curOp = it.next();
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
		this.write("\"");
		this.write(node.getLiteral());
		this.write("\"");
		if (node.hasLang()) {
			this.write("@");
			this.write(node.getLang());
		}
	}

	@Override
	protected void writeOntologyURI(URI uri) {
		String shortName = this.owlModelManager.getURIRendering(uri);
		if (shortName != null) {
			this.write(shortName);
			this.write(" (");
			this.write(uri.toString());
			this.write(")");
		} else {
			this.write(uri.toString());
		}
	}
}

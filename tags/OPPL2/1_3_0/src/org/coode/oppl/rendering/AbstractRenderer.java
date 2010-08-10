package org.coode.oppl.rendering;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.coode.oppl.entity.OWLEntityRenderer;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataComplementOf;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataOneOf;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDataPropertyExpression;
import org.semanticweb.owl.model.OWLDataRange;
import org.semanticweb.owl.model.OWLDataRangeFacetRestriction;
import org.semanticweb.owl.model.OWLDataRangeRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataSubPropertyAxiom;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLDisjointClassesAxiom;
import org.semanticweb.owl.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLDisjointUnionAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEntityAnnotationAxiom;
import org.semanticweb.owl.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owl.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owl.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owl.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyChainSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyExpression;
import org.semanticweb.owl.model.OWLObjectPropertyInverse;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectSubPropertyAxiom;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLObjectVisitor;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyAnnotationAxiom;
import org.semanticweb.owl.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLSameIndividualsAxiom;
import org.semanticweb.owl.model.OWLSubClassAxiom;
import org.semanticweb.owl.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.SWRLAtom;
import org.semanticweb.owl.model.SWRLAtomConstantObject;
import org.semanticweb.owl.model.SWRLAtomDObject;
import org.semanticweb.owl.model.SWRLAtomDVariable;
import org.semanticweb.owl.model.SWRLAtomIVariable;
import org.semanticweb.owl.model.SWRLAtomIndividualObject;
import org.semanticweb.owl.model.SWRLBuiltInAtom;
import org.semanticweb.owl.model.SWRLClassAtom;
import org.semanticweb.owl.model.SWRLDataRangeAtom;
import org.semanticweb.owl.model.SWRLDataValuedPropertyAtom;
import org.semanticweb.owl.model.SWRLDifferentFromAtom;
import org.semanticweb.owl.model.SWRLObjectPropertyAtom;
import org.semanticweb.owl.model.SWRLRule;
import org.semanticweb.owl.model.SWRLSameAsAtom;
import org.semanticweb.owl.util.SimpleURIShortFormProvider;
import org.semanticweb.owl.util.URIShortFormProvider;
import org.semanticweb.owl.vocab.OWLRestrictedDataRangeFacetVocabulary;
import org.semanticweb.owl.vocab.XSDVocabulary;

public abstract class AbstractRenderer implements OWLObjectVisitor {
	protected Map<OWLRestrictedDataRangeFacetVocabulary, String> facetMap;
	protected BracketWriter bracketWriter;
	protected int currentIndex = 0;
	protected StringBuilder buffer;
	protected int lastNewLineIndex = 0;
	protected OWLEntityRenderer entityRenderer;
	protected Map<URI, Boolean> simpleRenderDatatypes;

	protected void init() {
		this.buffer = new StringBuilder();
		this.bracketWriter = new BracketWriter();
		this.facetMap = new HashMap<OWLRestrictedDataRangeFacetVocabulary, String>();
		this.facetMap.put(OWLRestrictedDataRangeFacetVocabulary.MIN_EXCLUSIVE,
				">");
		this.facetMap.put(OWLRestrictedDataRangeFacetVocabulary.MAX_EXCLUSIVE,
				"<");
		this.facetMap.put(OWLRestrictedDataRangeFacetVocabulary.MIN_INCLUSIVE,
				">=");
		this.facetMap.put(OWLRestrictedDataRangeFacetVocabulary.MAX_INCLUSIVE,
				"<=");
		this.simpleRenderDatatypes = new HashMap<URI, Boolean>();
		this.simpleRenderDatatypes.put(XSDVocabulary.INT.getURI(), false);
		this.simpleRenderDatatypes.put(XSDVocabulary.FLOAT.getURI(), false);
		this.simpleRenderDatatypes.put(XSDVocabulary.DOUBLE.getURI(), false);
		this.simpleRenderDatatypes.put(XSDVocabulary.STRING.getURI(), true);
		this.simpleRenderDatatypes.put(XSDVocabulary.BOOLEAN.getURI(), false);
	}

	public final void visit(SWRLAtomConstantObject swrlAtomConstantObject) {
		swrlAtomConstantObject.getConstant().accept(this);
	}

	public final void visit(SWRLAtomDVariable swrlAtomDVariable) {
		this.write("?");
		this.write(swrlAtomDVariable.getURI().getFragment());
	}

	public final void visit(SWRLAtomIndividualObject swrlAtomIndividualObject) {
		swrlAtomIndividualObject.getIndividual().accept(this);
	}

	public final void visit(SWRLAtomIVariable swrlAtomIVariable) {
		this.write("?");
		this.write(swrlAtomIVariable.getURI().getFragment());
	}

	public final void visit(SWRLBuiltInAtom swrlBuiltInAtom) {
		this.write(swrlBuiltInAtom.getPredicate().getShortName());
		this.write("(");
		Iterator<SWRLAtomDObject> it = swrlBuiltInAtom.getArguments()
				.iterator();
		while (it.hasNext()) {
			SWRLAtomDObject argument = it.next();
			argument.accept(this);
			if (it.hasNext()) {
				this.write(", ");
			}
		}
		this.write(")");
	}

	public final void visit(SWRLClassAtom swrlClassAtom) {
		OWLDescription desc = swrlClassAtom.getPredicate();
		if (desc.isAnonymous()) {
			this.write("(");
		}
		desc.accept(this);
		if (desc.isAnonymous()) {
			this.write(")");
		}
		this.write("(");
		swrlClassAtom.getArgument().accept(this);
		this.write(")");
	}

	public final void visit(SWRLDataRangeAtom swrlDataRangeAtom) {
		swrlDataRangeAtom.getPredicate().accept(this);
		this.write("(");
		swrlDataRangeAtom.getArgument().accept(this);
		this.write(")");
	}

	public final void visit(
			SWRLDataValuedPropertyAtom swrlDataValuedPropertyAtom) {
		swrlDataValuedPropertyAtom.getPredicate().accept(this);
		this.write("(");
		swrlDataValuedPropertyAtom.getFirstArgument().accept(this);
		this.write(", ");
		swrlDataValuedPropertyAtom.getSecondArgument().accept(this);
		this.write(")");
	}

	public final void visit(SWRLDifferentFromAtom swrlDifferentFromAtom) {
		swrlDifferentFromAtom.getPredicate().accept(this);
		this.write("(");
		swrlDifferentFromAtom.getFirstArgument().accept(this);
		this.write(", ");
		swrlDifferentFromAtom.getSecondArgument().accept(this);
		this.write(")");
	}

	public final void visit(SWRLObjectPropertyAtom swrlObjectPropertyAtom) {
		swrlObjectPropertyAtom.getPredicate().accept(this);
		this.write("(");
		swrlObjectPropertyAtom.getFirstArgument().accept(this);
		this.write(", ");
		swrlObjectPropertyAtom.getSecondArgument().accept(this);
		this.write(")");
	}

	@SuppressWarnings("unchecked")
	public final void visit(SWRLRule swrlRule) {
		for (Iterator<SWRLAtom> it = swrlRule.getBody().iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" , ");
			}
		}
		this.write(" -> ");
		for (Iterator<SWRLAtom> it = swrlRule.getHead().iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" \u2227 ");
			}
		}
	}

	public final void visit(SWRLSameAsAtom swrlSameAsAtom) {
		swrlSameAsAtom.getPredicate().accept(this);
		this.write("(");
		swrlSameAsAtom.getFirstArgument().accept(this);
		this.write(", ");
		swrlSameAsAtom.getSecondArgument().accept(this);
		this.write(")");
	}

	protected final void write(String s) {
		int index = s.indexOf('\n');
		if (index != -1) {
			this.lastNewLineIndex = this.currentIndex + index;
		}
		this.currentIndex = this.currentIndex + s.length();
		this.buffer.append(s);
	}

	protected final void writeAndKeyword() {
		this.write(this.getAndKeyWord());
		this.write(" ");
	}

	private final void writeCardinality(OWLDataCardinalityRestriction desc,
			String keyword) {
		desc.getProperty().accept(this);
		this.write(" ");
		this.write(keyword);
		this.write(" ");
		this.write(Integer.toString(desc.getCardinality()));
		this.write(" ");
		this.writeOpenBracket(desc.getFiller());
		desc.getFiller().accept(this);
		this.writeCloseBracket(desc.getFiller());
	}

	private final void writeCardinality(OWLObjectCardinalityRestriction desc,
			String keyword) {
		desc.getProperty().accept(this);
		this.write(" ");
		this.write(keyword);
		this.write(" ");
		this.write(Integer.toString(desc.getCardinality()));
		this.write(" ");
		this.writeOpenBracket(desc.getFiller());
		desc.getFiller().accept(this);
		this.writeCloseBracket(desc.getFiller());
	}

	private final void writeCloseBracket(OWLDataRange dataRange) {
		dataRange.accept(this.bracketWriter);
		if (this.bracketWriter.writeBrackets()) {
			this.write(")");
		}
	}

	protected final void writeCloseBracket(OWLDescription description) {
		description.accept(this.bracketWriter);
		if (this.bracketWriter.writeBrackets()) {
			this.write(")");
		}
	}

	private final void writeNotKeyword() {
		this.write(this.getNotKeyWord());
	}

	private final void writeOpenBracket(OWLDataRange dataRange) {
		dataRange.accept(this.bracketWriter);
		if (this.bracketWriter.writeBrackets()) {
			this.write("(");
		}
	}

	protected final void writeOpenBracket(OWLDescription description) {
		description.accept(this.bracketWriter);
		if (this.bracketWriter.writeBrackets()) {
			this.write("(");
		}
	}

	public final void visit(OWLDataSomeRestriction node) {
		node.getProperty().accept(this);
		this.write(" ");
		this.write(this.getSomeKeyWord());
		this.write(" ");
		node.getFiller().accept(this);
	}

	public final void visit(OWLDataSubPropertyAxiom axiom) {
		axiom.getSubProperty().accept(this);
		this.write(" subPropertyOf ");
		axiom.getSuperProperty().accept(this);
	}

	public final void visit(OWLDataType node) {
		this.write(node.getURI().getFragment());
	}

	public final void visit(OWLDataValueRestriction node) {
		node.getProperty().accept(this);
		this.write(" ");
		this.write(this.getValueKeyWord());
		this.write(" ");
		node.getValue().accept(this);
	}

	public final void visit(OWLDeclarationAxiom axiom) {
		OWLEntity entity = axiom.getEntity();
		if (entity.isOWLClass()) {
			this.write("Class(");
		} else if (entity.isOWLObjectProperty()) {
			this.write("Object property(");
		} else if (entity.isOWLDataProperty()) {
			this.write("Data property(");
		} else if (entity.isOWLIndividual()) {
			this.write("Individual(");
		} else {
			this.write("(");
		}
		entity.accept(this);
		this.write(")");
	}

	public final void visit(OWLDifferentIndividualsAxiom axiom) {
		this.write("DifferentIndividuals: [");
		for (Iterator<OWLIndividual> it = axiom.getIndividuals().iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(", ");
			}
		}
		this.write("]");
	}

	public final void visit(OWLDisjointClassesAxiom node) {
		for (Iterator<OWLDescription> it = node.getDescriptions().iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" disjointWith ");
			}
		}
	}

	public final void visit(OWLDisjointDataPropertiesAxiom axiom) {
		for (Iterator<OWLDataPropertyExpression> it = axiom.getProperties()
				.iterator(); it.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" disjointWith ");
			}
		}
	}

	private final String getAllKeyWord() {
		return "only";
	}

	private final String getAndKeyWord() {
		return "and";
	}

	private final String getExactlyKeyWord() {
		return "exactly";
	}

	protected final int getIndent() {
		return this.currentIndex - this.lastNewLineIndex;
	}

	private final String getMaxKeyWord() {
		return "max";
	}

	private final String getMinKeyWord() {
		return "min";
	}

	private final String getNotKeyWord() {
		return "not";
	}

	private final String getOrKeyWord() {
		return "or";
	}

	protected final String getRendering(OWLEntity entity) {
		return this.entityRenderer.render(entity);
	}

	private final String getSomeKeyWord() {
		return "some";
	}

	private final String getValueKeyWord() {
		return "value";
	}

	protected final void insertIndent(int indent) {
		for (int i = 0; i < indent; i++) {
			this.write(" ");
		}
	}

	public final void visit(OWLObjectValueRestriction node) {
		node.getProperty().accept(this);
		this.write(" ");
		this.write(this.getValueKeyWord());
		this.write(" ");
		node.getValue().accept(this);
	}

	public final void visit(OWLOntology ontology) {
		this.writeOntologyURI(ontology.getURI());
	}

	public final void visit(OWLOntologyAnnotationAxiom axiom) {
		axiom.getSubject().accept(this);
		this.write(" ");
		axiom.getAnnotation().accept(this);
	}

	public final void visit(OWLReflexiveObjectPropertyAxiom axiom) {
		this.write("Reflexive: ");
		axiom.getProperty().accept(this);
	}

	public final void visit(OWLSameIndividualsAxiom axiom) {
		this.write("SameIndividuals: [");
		for (Iterator<OWLIndividual> it = axiom.getIndividuals().iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(", ");
			}
		}
		this.write("]");
	}

	public final void visit(OWLSubClassAxiom node) {
		node.getSubClass().accept(this);
		this.write(" subClassOf ");
		node.getSuperClass().accept(this);
	}

	public final void visit(OWLSymmetricObjectPropertyAxiom axiom) {
		this.write("Symmetric: ");
		axiom.getProperty().accept(this);
	}

	public final void visit(OWLTransitiveObjectPropertyAxiom axiom) {
		this.write("Transitive: ");
		axiom.getProperty().accept(this);
	}

	public final void visit(OWLTypedConstant node) {
		if (this.simpleRenderDatatypes.containsKey(node.getDataType().getURI())) {
			boolean renderQuotes = this.simpleRenderDatatypes.get(node
					.getDataType().getURI());
			if (renderQuotes) {
				this.write("\"");
			}
			this.write(node.getLiteral());
			if (renderQuotes) {
				this.write("\"");
			}
		} else {
			this.write("\"");
			this.write(node.getLiteral());
			this.write("\"^^");
			node.getDataType().accept(this);
		}
	}

	protected void writeOntologyURI(URI uri) {
		URIShortFormProvider uriShortFormProvider = new SimpleURIShortFormProvider();
		String shortName = uriShortFormProvider.getShortForm(uri);
		if (shortName != null) {
			this.write(shortName);
			this.write(" (");
			this.write(uri.toString());
			this.write(")");
		} else {
			this.write(uri.toString());
		}
	}

	public final void visit(OWLDataAllRestriction node) {
		node.getProperty().accept(this);
		this.write(" ");
		this.write(this.getAllKeyWord());
		this.write(" ");
		node.getFiller().accept(this);
	}

	public final void visit(OWLDataComplementOf owlDataComplementOf) {
		this.write("not(");
		owlDataComplementOf.getDataRange().accept(this);
		this.write(")");
	}

	public final void visit(OWLDataExactCardinalityRestriction desc) {
		this.writeCardinality(desc, this.getExactlyKeyWord());
	}

	public final void visit(OWLDataMaxCardinalityRestriction desc) {
		this.writeCardinality(desc, this.getMaxKeyWord());
	}

	public final void visit(OWLDataMinCardinalityRestriction desc) {
		this.writeCardinality(desc, this.getMinKeyWord());
	}

	public final void visit(OWLDataOneOf node) {
		this.write("{");
		for (Iterator<OWLConstant> it = node.getValues().iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(", ");
			}
		}
		this.write("}");
	}

	public final void visit(OWLDataProperty node) {
		this.write(this.getRendering(node));
	}

	public final void visit(OWLDataPropertyAssertionAxiom axiom) {
		axiom.getSubject().accept(this);
		this.write(" ");
		axiom.getProperty().accept(this);
		this.write(" ");
		axiom.getObject().accept(this);
	}

	public void visit(OWLDataRangeFacetRestriction node) {
		String rendering = this.facetMap.get(node.getFacet());
		if (rendering == null) {
			rendering = node.getFacet().getShortName();
		}
		this.write(rendering);
		this.write(" ");
		node.getFacetValue().accept(this);
	}

	public void visit(OWLDataRangeRestriction node) {
		// writeOpenBracket(node);
		node.getDataRange().accept(this);
		this.write("[");
		for (Iterator<OWLDataRangeFacetRestriction> it = node
				.getFacetRestrictions().iterator(); it.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(", ");
			}
		}
		this.write("]");
		// writeCloseBracket(node);
	}

	public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
		for (Iterator<OWLObjectPropertyExpression> it = axiom.getProperties()
				.iterator(); it.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" disjointWith ");
			}
		}
	}

	public void visit(OWLDisjointUnionAxiom axiom) {
		axiom.getOWLClass().accept(this);
		this.write(" disjointUnionOf ");
		this.write("[");
		int indent = this.getIndent();
		for (Iterator<OWLDescription> it = axiom.getDescriptions().iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write("\n");
				this.insertIndent(indent);
			}
		}
		this.write("]");
	}

	public void visit(OWLEntityAnnotationAxiom owlEntityAnnotationAxiom) {
		owlEntityAnnotationAxiom.getSubject().accept(this);
		this.write(" ");
		owlEntityAnnotationAxiom.getAnnotation().accept(this);
	}

	public void visit(OWLEquivalentDataPropertiesAxiom node) {
		for (Iterator<OWLDataPropertyExpression> it = node.getProperties()
				.iterator(); it.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" equivalentTo ");
			}
		}
	}

	public void visit(OWLEquivalentObjectPropertiesAxiom node) {
		for (Iterator<OWLObjectPropertyExpression> it = node.getProperties()
				.iterator(); it.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" equivalentTo ");
			}
		}
	}

	public void visit(OWLFunctionalDataPropertyAxiom axiom) {
		this.write("Functional: ");
		axiom.getProperty().accept(this);
	}

	public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
		this.write("Functional: ");
		axiom.getProperty().accept(this);
	}

	public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
		this.write("InverseFunctional: ");
		axiom.getProperty().accept(this);
	}

	public void visit(OWLInverseObjectPropertiesAxiom axiom) {
		axiom.getFirstProperty().accept(this);
		this.write(" inverseOf ");
		axiom.getSecondProperty().accept(this);
	}

	public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
		this.write("Irreflexive: ");
		axiom.getProperty().accept(this);
	}

	public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
		this.write("not(");
		axiom.getSubject().accept(this);
		this.write(" ");
		axiom.getProperty().accept(this);
		this.write(" ");
		axiom.getObject().accept(this);
		this.write(")");
	}

	public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
		this.write("not(");
		axiom.getSubject().accept(this);
		this.write(" ");
		axiom.getProperty().accept(this);
		this.write(" ");
		axiom.getObject().accept(this);
		this.write(")");
	}

	public void visit(OWLObjectAllRestriction node) {
		node.getProperty().accept(this);
		this.write(" ");
		this.write(this.getAllKeyWord());
		this.write(" ");
		this.writeOpenBracket(node.getFiller());
		node.getFiller().accept(this);
		this.writeCloseBracket(node.getFiller());
	}

	public void visit(OWLObjectComplementOf node) {
		this.writeNotKeyword();
		this.write(" ");
		this.writeOpenBracket(node.getOperand());
		node.getOperand().accept(this);
		this.writeCloseBracket(node.getOperand());
	}

	public void visit(OWLObjectExactCardinalityRestriction desc) {
		this.writeCardinality(desc, this.getExactlyKeyWord());
	}

	public void visit(OWLObjectMaxCardinalityRestriction desc) {
		this.writeCardinality(desc, this.getMaxKeyWord());
	}

	public void visit(OWLObjectMinCardinalityRestriction desc) {
		this.writeCardinality(desc, this.getMinKeyWord());
	}

	public void visit(OWLObjectOneOf node) {
		this.write("{");
		for (Iterator<OWLIndividual> it = node.getIndividuals().iterator(); it
				.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(", ");
			}
		}
		this.write("}");
	}

	public void visit(OWLObjectProperty node) {
		this.write(this.getRendering(node));
	}

	public void visit(OWLObjectPropertyAssertionAxiom axiom) {
		axiom.getSubject().accept(this);
		this.write(" ");
		axiom.getProperty().accept(this);
		this.write(" ");
		axiom.getObject().accept(this);
	}

	public void visit(OWLObjectPropertyChainSubPropertyAxiom axiom) {
		for (Iterator<OWLObjectPropertyExpression> it = axiom
				.getPropertyChain().iterator(); it.hasNext();) {
			it.next().accept(this);
			if (it.hasNext()) {
				this.write(" o ");
			}
		}
		this.write(" \u279E ");
		axiom.getSuperProperty().accept(this);
	}

	public void visit(OWLObjectPropertyInverse property) {
		this.write("inv(");
		property.getInverse().accept(this);
		this.write(")");
	}

	public void visit(OWLObjectSelfRestriction desc) {
		desc.getProperty().accept(this);
		this.write(" ");
		this.write(this.getSomeKeyWord());
		this.write(" Self");
	}

	public void visit(OWLObjectSomeRestriction node) {
		node.getProperty().accept(this);
		this.write(" ");
		this.write(this.getSomeKeyWord());
		this.write(" ");
		this.writeOpenBracket(node.getFiller());
		node.getFiller().accept(this);
		this.writeCloseBracket(node.getFiller());
	}

	public void visit(OWLObjectSubPropertyAxiom axiom) {
		axiom.getSubProperty().accept(this);
		this.write(" subPropertyOf ");
		axiom.getSuperProperty().accept(this);
	}

	protected void writeOrKeyword() {
		this.write(this.getOrKeyWord());
		this.write(" ");
	}
}
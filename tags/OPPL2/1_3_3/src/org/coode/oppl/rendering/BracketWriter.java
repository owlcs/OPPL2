package org.coode.oppl.rendering;

import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataAllRestriction;
import org.semanticweb.owl.model.OWLDataComplementOf;
import org.semanticweb.owl.model.OWLDataExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLDataOneOf;
import org.semanticweb.owl.model.OWLDataRangeFacetRestriction;
import org.semanticweb.owl.model.OWLDataRangeRestriction;
import org.semanticweb.owl.model.OWLDataSomeRestriction;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLDataValueRestriction;
import org.semanticweb.owl.model.OWLDataVisitor;
import org.semanticweb.owl.model.OWLObjectAllRestriction;
import org.semanticweb.owl.model.OWLObjectComplementOf;
import org.semanticweb.owl.model.OWLObjectExactCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectIntersectionOf;
import org.semanticweb.owl.model.OWLObjectMaxCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectMinCardinalityRestriction;
import org.semanticweb.owl.model.OWLObjectOneOf;
import org.semanticweb.owl.model.OWLObjectSelfRestriction;
import org.semanticweb.owl.model.OWLObjectSomeRestriction;
import org.semanticweb.owl.model.OWLObjectUnionOf;
import org.semanticweb.owl.model.OWLObjectValueRestriction;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;
import org.semanticweb.owl.util.OWLDescriptionVisitorAdapter;

@SuppressWarnings("unused")
public class BracketWriter extends OWLDescriptionVisitorAdapter implements
		OWLDataVisitor {
	public BracketWriter() {
	}

	private boolean nested = false;

	public boolean writeBrackets() {
		return this.nested;
	}

	@Override
	public void visit(OWLObjectIntersectionOf owlAnd) {
		this.nested = true;
	}

	@Override
	public void visit(OWLDataAllRestriction owlDataAllRestriction) {
		this.nested = true;
	}

	@Override
	public void visit(OWLDataSomeRestriction owlDataSomeRestriction) {
		this.nested = true;
	}

	@Override
	public void visit(OWLDataValueRestriction owlDataValueRestriction) {
		this.nested = true;
	}

	@Override
	public void visit(OWLObjectAllRestriction owlObjectAllRestriction) {
		this.nested = true;
	}

	@Override
	public void visit(OWLObjectSomeRestriction owlObjectSomeRestriction) {
		this.nested = true;
	}

	@Override
	public void visit(OWLObjectValueRestriction owlObjectValueRestriction) {
		this.nested = true;
	}

	@Override
	public void visit(OWLObjectComplementOf owlNot) {
		this.nested = true;
	}

	@Override
	public void visit(OWLObjectUnionOf owlOr) {
		this.nested = true;
	}

	@Override
	public void visit(OWLClass owlClass) {
		this.nested = false;
	}

	@Override
	public void visit(OWLObjectOneOf owlObjectOneOf) {
		this.nested = false;
	}

	@Override
	public void visit(OWLObjectMinCardinalityRestriction desc) {
		this.nested = true;
	}

	@Override
	public void visit(OWLObjectExactCardinalityRestriction desc) {
		this.nested = true;
	}

	@Override
	public void visit(OWLObjectMaxCardinalityRestriction desc) {
		this.nested = true;
	}

	@Override
	public void visit(OWLObjectSelfRestriction desc) {
		this.nested = true;
	}

	@Override
	public void visit(OWLDataMinCardinalityRestriction desc) {
		this.nested = true;
	}

	@Override
	public void visit(OWLDataExactCardinalityRestriction desc) {
		this.nested = true;
	}

	@Override
	public void visit(OWLDataMaxCardinalityRestriction desc) {
		this.nested = true;
	}

	public void visit(OWLDataType node) {
		this.nested = false;
	}

	public void visit(OWLDataComplementOf node) {
		this.nested = false;
	}

	public void visit(OWLDataOneOf node) {
		this.nested = false;
	}

	public void visit(OWLDataRangeRestriction node) {
		this.nested = true;
	}

	public void visit(OWLTypedConstant node) {
		this.nested = false;
	}

	public void visit(OWLUntypedConstant node) {
		this.nested = false;
	}

	public void visit(OWLDataRangeFacetRestriction node) {
		this.nested = false;
	}
}

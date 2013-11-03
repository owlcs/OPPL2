package org.coode.oppl.function;

import org.coode.oppl.function.inline.InlineSet;
import org.semanticweb.owlapi.model.OWLObject;

public interface OPPLFunctionVisitor extends StringManipulationOPPLFunctionVisitor {
	public <O, I> void visitAggregation(Aggregation<O, I> aggregation);

	public <O extends OWLObject> void visitInlineSet(InlineSet<O> inlineSet);

	public <O> void visitConstant(Constant<O> constant);

	public <O extends OWLObject> void visitValuesVariableAtttribute(
			ValuesVariableAtttribute<O> valuesVariableAtttribute);

	public void visitRenderingVariableAttribute(
			RenderingVariableAttribute renderingVariableAttribute);

	public <O extends OWLObject> void visitGroupVariableAttribute(
			GroupVariableAttribute<O> groupVariableAttribute);

	public <O extends OWLObject> void visitExpression(Expression<O> expression);

	public <O, I extends OPPLFunction<?>> void visitCreate(Create<I, O> create);

	public void visitIRIVariableAttribute(IRIVariableAttribute iriVariableAttribute);

	public <O extends OWLObject> void visitGenericOPPLFunction(OPPLFunction<O> opplFunction);
}

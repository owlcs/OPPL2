package org.coode.oppl.generated;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.PlainVariableVisitorEx;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.coode.oppl.function.OPPLFunction;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;

public abstract class GeneratedVariable<O extends OWLObject> implements Variable {
	private final Variable delegate;
	private final OPPLFunction<? extends O> opplFunction;

	public GeneratedVariable(String name, OPPLFunction<? extends O> opplFunction) {
		if (name == null) {
			throw new NullPointerException("The name cannot be null");
		}
		if (opplFunction == null) {
			throw new NullPointerException("The OPPL Function cannot be null");
		}
		this.opplFunction = opplFunction;
		this.delegate = this.initDelegate(name);
	}

	protected abstract Variable initDelegate(String name);

	/**
	 * @return
	 * @see org.coode.oppl.Variable#getName()
	 */
	public String getName() {
		return this.delegate.getName();
	}

	/**
	 * @return
	 * @see org.coode.oppl.Variable#getIRI()
	 */
	public IRI getIRI() {
		return this.delegate.getIRI();
	}

	/**
	 * @return
	 * @see org.coode.oppl.Variable#getType()
	 */
	public VariableType getType() {
		return this.delegate.getType();
	}

	/**
	 * @param variableScope
	 * @param variableScopeChecker
	 * @see org.coode.oppl.Variable#setVariableScope(org.coode.oppl.VariableScope,
	 *      org.coode.oppl.VariableScopeChecker)
	 */
	public void setVariableScope(VariableScope<?> variableScope,
			VariableScopeChecker variableScopeChecker) {
		this.delegate.setVariableScope(variableScope, variableScopeChecker);
	}

	/**
	 * @return
	 * @see org.coode.oppl.Variable#getVariableScope()
	 */
	public VariableScope<?> getVariableScope() {
		return this.delegate.getVariableScope();
	}

	/**
	 * @param <P>
	 * @param visitor
	 * @return
	 * @see org.coode.oppl.Variable#accept(org.coode.oppl.VariableVisitor)
	 */
	public <P> P accept(VariableVisitor<P> visitor) {
		return this.delegate.accept(visitor);
	}

	/**
	 * @param <P>
	 * @param visitor
	 * @return
	 * @see org.coode.oppl.Variable#accept(org.coode.oppl.VariableTypeVisitorEx)
	 */
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return this.delegate.accept(visitor);
	}

	/**
	 * @param visitor
	 * @see org.coode.oppl.Variable#accept(org.coode.oppl.PlainVariableVisitor)
	 */
	public void accept(PlainVariableVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(PlainVariableVisitorEx<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @return the opplFunction
	 */
	public OPPLFunction<? extends O> getOPPLFunction() {
		return this.opplFunction;
	}

	@Override
	public boolean equals(Object obj) {
		return this.delegate.equals(obj);
	}

	@Override
	public int hashCode() {
		return this.delegate.hashCode();
	}
}

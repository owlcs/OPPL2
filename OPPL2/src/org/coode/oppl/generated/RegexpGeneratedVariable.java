package org.coode.oppl.generated;

import java.util.regex.Pattern;

import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.PlainVariableVisitorEx;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.VariableVisitor;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;

public abstract class RegexpGeneratedVariable<O extends OWLObject> implements Variable {
	private final Pattern pattern;
	private final Variable delegate;

	public RegexpGeneratedVariable(String name, Pattern pattern) {
		if (name == null) {
			throw new NullPointerException("The name cannot be null");
		}
		if (pattern == null) {
			throw new NullPointerException("The pattern cannot be null");
		}
		this.pattern = pattern;
		this.delegate = this.initDelegate(name);
	}

	protected abstract Variable initDelegate(String name);

	/**
	 * @return the pattern
	 */
	public Pattern getPattern() {
		return this.pattern;
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
	 * @param <P>
	 * @param visitor
	 * @return
	 * @see org.coode.oppl.Variable#accept(org.coode.oppl.VariableTypeVisitorEx)
	 */
	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return this.delegate.accept(visitor);
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
	 * @return
	 * @see org.coode.oppl.Variable#getIRI()
	 */
	public IRI getIRI() {
		return this.delegate.getIRI();
	}

	/**
	 * @return
	 * @see org.coode.oppl.Variable#getName()
	 */
	public String getName() {
		return this.delegate.getName();
	}

	/**
	 * @return
	 * @see org.coode.oppl.Variable#getType()
	 */
	public VariableType getType() {
		return this.delegate.getType();
	}

	/**
	 * @return
	 * @see org.coode.oppl.Variable#getVariableScope()
	 */
	public VariableScope<?> getVariableScope() {
		return this.delegate.getVariableScope();
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

	@Override
	public boolean equals(Object obj) {
		return this.delegate.equals(obj);
	}

	@Override
	public int hashCode() {
		return this.delegate.hashCode();
	}
}

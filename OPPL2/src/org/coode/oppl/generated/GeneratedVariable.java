package org.coode.oppl.generated;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ManchesterVariableSyntax;
import org.coode.oppl.PlainVariableVisitor;
import org.coode.oppl.PlainVariableVisitorEx;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopeChecker;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.variabletypes.VariableType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;

public class GeneratedVariable<O extends OWLObject> implements Variable<O> {
	private final OPPLFunction<? extends O> opplFunction;
	private final String name;
	private final IRI iri;
	private final VariableType<O> type;

	public GeneratedVariable(String name, VariableType<O> type,
			OPPLFunction<? extends O> opplFunction) {
		if (name == null) {
			throw new NullPointerException("The name cannot be null");
		}
		if (type == null) {
			throw new NullPointerException("The variable type cannot be null");
		}
		if (opplFunction == null) {
			throw new NullPointerException("The OPPL Function cannot be null");
		}
		this.opplFunction = opplFunction;
		this.name = name;
		this.type = type;
		this.iri = IRI.create(ManchesterVariableSyntax.NAMESPACE + this.getName());
	}

	public String render(ConstraintSystem constraintSystem) {
		return String.format(
				"%s:%s = %s",
				this.getName(),
				this.getType(),
				this.getOPPLFunction().render(constraintSystem));
	}

	/**
	 * @return the opplFunction
	 */
	public OPPLFunction<? extends O> getOPPLFunction() {
		return this.opplFunction;
	}

	public String getName() {
		return this.name;
	}

	public IRI getIRI() {
		return this.iri;
	}

	public VariableType<O> getType() {
		return this.type;
	}

	public void setVariableScope(VariableScope<?> variableScope,
			VariableScopeChecker variableScopeChecker) {
	}

	public VariableScope<?> getVariableScope() {
		return null;
	}

	public void accept(PlainVariableVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(PlainVariableVisitorEx<T> visitor) {
		return visitor.visit(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		result = prime * result + (this.type == null ? 0 : this.type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		GeneratedVariable<?> other = (GeneratedVariable<?>) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}
}

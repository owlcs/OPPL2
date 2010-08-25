package org.coode.parsers.oppl.variableattribute;

import org.coode.parsers.Type;
import org.coode.parsers.TypeVisitor;
import org.coode.parsers.TypeVisitorEx;

public enum VariableAttributeType implements Type {
	STRING, COLLECTION;
	public void accept(TypeVisitor visitor) {
		visitor.visitNonOWLType(this);
	}

	public <O> O accept(TypeVisitorEx<O> visitor) {
		return visitor.visitNonOWLType(this);
	}
}

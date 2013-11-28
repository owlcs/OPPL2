package org.coode.parsers.oppl.variableattribute;

import org.coode.parsers.Type;
import org.coode.parsers.TypeVisitor;
import org.coode.parsers.TypeVisitorEx;

/** @author Luigi Iannone */
public enum VariableAttributeType implements Type {
    /** String */
    STRING,
    /** collection */
    COLLECTION;
    @Override
    public void accept(TypeVisitor visitor) {
        visitor.visitNonOWLType(this);
    }

    @Override
    public <O> O accept(TypeVisitorEx<O> visitor) {
        return visitor.visitNonOWLType(this);
    }
}

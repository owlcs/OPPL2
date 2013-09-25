package org.coode.parsers.oppl;

import org.coode.parsers.Type;
import org.coode.parsers.TypeVisitor;
import org.coode.parsers.TypeVisitorEx;

/** Represents the type of identifiers that should be created on demand during
 * the execution of an OPPL Script. They all have an exclamation mark as their
 * prefix.
 * 
 * @author Luigi Iannone */
public class CreateOnDemand implements Type {
    private final static CreateOnDemand instance = new CreateOnDemand();

    private CreateOnDemand() {}

    @Override
    public void accept(TypeVisitor visitor) {
        visitor.visitNonOWLType(this);
    }

    @Override
    public <O> O accept(TypeVisitorEx<O> visitor) {
        return visitor.visitNonOWLType(this);
    }

    /** @return the instance */
    public static CreateOnDemand get() {
        return instance;
    }

    @Override
    public String toString() {
        return "CREATE_ON_DEMAD";
    }
}

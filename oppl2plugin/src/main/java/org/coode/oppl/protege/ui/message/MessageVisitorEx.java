package org.coode.oppl.protege.ui.message;

/** Visitor pattern for the Message hierarchy with a parametric return type
 * 
 * @param <O>
 *            the return type of this visitor.
 * @author Luigi Iannone */
public interface MessageVisitorEx<O> {
    /** @param error
     * @return visitor value */
    O visitError(Error error);

    /** @param warning
     * @return visitor value */
    O visitWarning(Warning warning);
}

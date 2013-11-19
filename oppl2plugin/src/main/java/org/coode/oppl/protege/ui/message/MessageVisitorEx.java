
package org.coode.oppl.protege.ui.message;

/** Visitor pattern for the Message hierarchy with a parametric return type
 * 
 * @param <O>
 *            the return type of this visitor.
 * @author Luigi Iannone */
public interface MessageVisitorEx<O> {
    O visitError(Error error);

    O visitWarning(Warning warning);
}

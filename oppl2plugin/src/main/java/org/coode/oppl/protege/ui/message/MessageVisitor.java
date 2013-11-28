package org.coode.oppl.protege.ui.message;

/** Simple visitor pattern for the Message hierarchy.
 * 
 * @author Luigi Iannone */
public interface MessageVisitor {
    /** @param error */
    void visitError(Error error);

    /** @param warning */
    void visitWarning(Warning warning);
}

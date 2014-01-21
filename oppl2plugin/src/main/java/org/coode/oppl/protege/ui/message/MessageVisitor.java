package org.coode.oppl.protege.ui.message;

/** Simple visitor pattern for the Message hierarchy.
 * 
 * @author Luigi Iannone */
public interface MessageVisitor {
    /** @param error
     *            error */
    void visitError(Error error);

    /** @param warning
     *            warning */
    void visitWarning(Warning warning);
}

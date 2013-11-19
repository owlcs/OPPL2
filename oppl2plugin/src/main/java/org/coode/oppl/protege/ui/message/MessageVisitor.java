
package org.coode.oppl.protege.ui.message;

/** Simple visitor pattern for the Message hierarchy.
 * 
 * @author Luigi Iannone */
public interface MessageVisitor {
    void visitError(Error error);

    void visitWarning(Warning warning);
}

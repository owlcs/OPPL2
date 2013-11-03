/**
 * 
 */
package org.coode.oppl.protege.ui.message;

/**
 * Generic Message
 * 
 * @author Luigi Iannone
 * 
 */
public interface Message {
	/**
	 * @return the String containing the message text.
	 */
	String getMessageText();

	/**
	 * Simple visitor pattern
	 * 
	 * @param visitor
	 */
	void accept(MessageVisitor visitor);

	/**
	 * Visitor pattern with parametric return value
	 * 
	 * @param <O>
	 *            the return type.
	 * @param visitor
	 *            the visiting entity. Cannot be {@code null}.
	 * @return the result of the visit.
	 */
	<O> O accept(MessageVisitorEx<O> visitor);
}

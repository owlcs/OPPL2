/**
 * 
 */
package org.coode.parsers.oppl.testcase.assertions;

import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;

/**
 * An assertion is a test on the results of a query contained in an OPPLTestCase
 * 
 * @author Luigi Iannone
 * 
 */
public interface Assertion {
	void accept(AssertionVisitor visitor);

	<O> O accept(AssertionVisitorEx<O> visitor);

	/**
	 * Determines whether this Assertion is valid for the input bindings.
	 * 
	 * @param bindings
	 *            The bindings against which this Assertion will be checked.
	 *            Cannot be <code>null</code>.
	 * @return <code>true</code> if this Assertion holds.
	 * @throws NullPointerException
	 *             if the input binding set is <code>null</code>.
	 */
	public boolean holds(Set<? extends BindingNode> bindings);
}

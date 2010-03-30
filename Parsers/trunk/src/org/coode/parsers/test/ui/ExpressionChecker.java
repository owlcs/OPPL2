package org.coode.parsers.test.ui;


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 11-Oct-2006<br>
 * <br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 */
public interface ExpressionChecker<O> {
	public void check(String text);

	O createObject(String text);

	ErrorReport getErrorReport();
}

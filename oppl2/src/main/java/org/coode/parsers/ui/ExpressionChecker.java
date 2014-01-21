package org.coode.parsers.ui;

/** Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 11-Oct-2006<br>
 * <br>
 * <br>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 * 
 * @param <O>
 *            type */
public interface ExpressionChecker<O> {
    /** @param text
     *            text */
    void check(String text);

    /** @param text
     *            text
     * @return create object */
    O createObject(String text);

    /** @return error report */
    ErrorReport getErrorReport();
}

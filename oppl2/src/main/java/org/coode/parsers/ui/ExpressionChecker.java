package org.coode.parsers.ui;

/** Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 11-Oct-2006<br>
 * <br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 * 
 * @param <O> */
public interface ExpressionChecker<O> {
    /** @param text */
    void check(String text);

    /** @param text
     * @return create object */
    O createObject(String text);

    /** @return error report */
    ErrorReport getErrorReport();
}

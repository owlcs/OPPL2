package org.coode.oppl.entity;

import org.semanticweb.owlapi.model.OWLException;

/** Author: drummond<br>
 * http://www.cs.man.ac.uk/~drummond/<br>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Sep 18, 2008 */
public class OWLEntityCreationException extends OWLException {
    private static final long serialVersionUID = 20100L;

    /** @param s
     *            s */
    public OWLEntityCreationException(String s) {
        super(s);
    }

    /** @param s
     *            s
     * @param throwable
     *            throwable */
    public OWLEntityCreationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    /** @param throwable
     *            throwable */
    public OWLEntityCreationException(Throwable throwable) {
        super(throwable);
    }
}

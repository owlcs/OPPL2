package org.coode.parsers.oppl.testcase.protege;

/** Raiswd when there is two OPPLTestCase instances with the same name stored as
 * annotations in an ontology or its import closure.
 * 
 * @author Luigi Iannone */
public class DuplicateOPPLTestCaseNameException extends RuntimeException {
    private static final long serialVersionUID = 20100L;

    /**
     * 
     */
    public DuplicateOPPLTestCaseNameException() {
        super();
    }

    /** @param message
     * @param cause */
    public DuplicateOPPLTestCaseNameException(String message, Throwable cause) {
        super(message, cause);
    }

    /** @param message */
    public DuplicateOPPLTestCaseNameException(String message) {
        super(message);
    }

    /** @param cause */
    public DuplicateOPPLTestCaseNameException(Throwable cause) {
        super(cause);
    }
}

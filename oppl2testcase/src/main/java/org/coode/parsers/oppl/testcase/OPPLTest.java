package org.coode.parsers.oppl.testcase;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.parsers.oppl.testcase.assertions.Assertion;

/** A Test contains an Assertion and an optional message that should be displayed
 * if the Assertion fails.
 * 
 * @author Luigi Iannone */
public class OPPLTest {
    /**
     * 
     */
    public static final String NO_MESSAGE = "";
    private final String message;
    private final Assertion assertion;

    /** @param assertion */
    public OPPLTest(Assertion assertion) {
        this(NO_MESSAGE, assertion);
    }

    /** @param message
     * @param assertion */
    public OPPLTest(String message, Assertion assertion) {
        this.message = checkNotNull(message, "message");
        this.assertion = checkNotNull(assertion, "assertion");
    }

    /** @return the message */
    public String getMessage() {
        return message;
    }

    /** @return the assertion */
    public Assertion getAssertion() {
        return assertion;
    }

    @Override
    public String toString() {
        // Grammar rule
        // ASSERT assertion (SEMICOLON message)?
        return String.format("ASSERT %s %s", getAssertion(),
                getMessage().equals(NO_MESSAGE) ? NO_MESSAGE : "; " + getMessage());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (assertion == null ? 0 : assertion.hashCode());
        result = prime * result + (message == null ? 0 : message.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        OPPLTest other = (OPPLTest) obj;
        if (assertion == null) {
            if (other.assertion != null) {
                return false;
            }
        } else if (!assertion.equals(other.assertion)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        return true;
    }
}

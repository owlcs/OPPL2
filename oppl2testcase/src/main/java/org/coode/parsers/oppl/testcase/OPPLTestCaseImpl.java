
package org.coode.parsers.oppl.testcase;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.OPPLScript;

/** @author Luigi Iannone */
public class OPPLTestCaseImpl implements OPPLTestCase {
    private final String name;
    private final OPPLScript opplScript;
    private final boolean requiresInference;
    private final List<OPPLTest> tests = new ArrayList<OPPLTest>();

    /** @param name
     * @param opplScript
     * @param requiresInference */
    public OPPLTestCaseImpl(String name, OPPLScript opplScript,
            List<? extends OPPLTest> tests, boolean requiresInference) {
        if (name == null) {
            throw new NullPointerException("The name cannot be null");
        }
        if (opplScript == null) {
            throw new NullPointerException("The OPPL Script cannot be null");
        }
        if (tests == null) {
            throw new NullPointerException("The test collection cannot be null");
        }
        if (!opplScript.getActions().isEmpty()) {
            throw new IllegalArgumentException(
                    "No actions allowed in OPPL Test case scripts");
        }
        if (tests.isEmpty()) {
            throw new IllegalArgumentException("There should be at least one test");
        }
        this.name = name;
        this.opplScript = opplScript;
        this.requiresInference = requiresInference;
        this.tests.addAll(tests);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean requiresInference() {
        return requiresInference;
    }

    @Override
    public OPPLScript getOPPLScript() {
        return opplScript;
    }

    @Override
    public List<OPPLTest> getTests() {
        return new ArrayList<OPPLTest>(tests);
    }

    @Override
    public String toString() {
        // Grammar rule
        // name SEMICOLON INFERENCE? statement test+
        StringBuilder b = new StringBuilder();
        b.append(String.format("%s; %s%s ", getName(),
                requiresInference() ? "INFERENCE; " : "", getOPPLScript()));
        for (OPPLTest t : getTests()) {
            b.append(String.format("%s ", t));
        }
        return b.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (opplScript == null ? 0 : opplScript.hashCode());
        result = prime * result + (requiresInference ? 1231 : 1237);
        result = prime * result + (tests == null ? 0 : tests.hashCode());
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
        OPPLTestCaseImpl other = (OPPLTestCaseImpl) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (opplScript == null) {
            if (other.opplScript != null) {
                return false;
            }
        } else if (!opplScript.equals(other.opplScript)) {
            return false;
        }
        if (requiresInference != other.requiresInference) {
            return false;
        }
        if (tests == null) {
            if (other.tests != null) {
                return false;
            }
        } else if (!tests.equals(other.tests)) {
            return false;
        }
        return true;
    }
}

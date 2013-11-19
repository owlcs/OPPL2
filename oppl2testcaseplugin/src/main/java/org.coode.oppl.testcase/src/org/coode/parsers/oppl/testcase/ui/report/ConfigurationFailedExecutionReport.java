/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

import org.coode.parsers.oppl.testcase.OPPLTestCase;

/** Represents an execution of an OPPLTestCase that terminated unsuccessfully
 * because its configuration failed.
 * 
 * @author Luigi Iannone */
public class ConfigurationFailedExecutionReport extends UnsuccessfulExecutionReport {
    private final String message;

    /** @param opplTestCase
     * @param message */
    public ConfigurationFailedExecutionReport(OPPLTestCase opplTestCase, String message) {
        super(opplTestCase);
        if (message == null) {
            throw new NullPointerException("The message cannot be null");
        }
        this.message = message;
    }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visitConfigurationFailedExecutionReport(this);
    }

    @Override
    public <O> O accept(ReportVisitorEx<O> visitor) {
        return visitor.visitConfigurationFailedExecutionReport(this);
    }

    /** @return the message */
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("FAILED CONFIGURATION %s", getMessage());
    }
}
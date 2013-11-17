/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

/** Visitor pattern with return value for {@link Report}
 * 
 * @author Luigi Iannone
 * @param <O>
 *            the type of the values returned by this visitor. */
public interface ReportVisitorEx<O> {
    /** @param report
     * @return visitor result */
    O visitSuccessfulExecutionReport(SuccessfulExecutionReport report);

    /** @param report
     * @return visitor result */
    O visitConfigurationFailedExecutionReport(ConfigurationFailedExecutionReport report);

    /** @param report
     * @return visitor result */
    O visitRuntimeErrorEncounteredExecutionReport(
            RuntimeErrorEncounteredExecutionReport report);

    /** @param report
     * @return visitor result */
    O visitAssertionFailedExecutionReport(AssertionFailedExecutionReport report);

    /** @param report
     * @return visitor result */
    O visitUnexecutedTestReport(UnexecutedTestReport report);
}

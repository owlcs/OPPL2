/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

/** Visitor pattern for {@link Report}
 * 
 * @author Luigi Iannone */
public interface ReportVisitor {
    /** @param report */
    void visitSuccessfulExecutionReport(SuccessfulExecutionReport report);

    /** @param report */
    void
            visitConfigurationFailedExecutionReport(
                    ConfigurationFailedExecutionReport report);

    /** @param report */
    void visitRuntimeErrorEncounteredExecutionReport(
            RuntimeErrorEncounteredExecutionReport report);

    /** @param report */
    void visitAssertionFailedExecutionReport(AssertionFailedExecutionReport report);

    /** @param report */
    void visitUnexecutedTestReport(UnexecutedTestReport report);
}

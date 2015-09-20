package org.coode.parsers.oppl.testcase.ui.report;

/**
 * Visitor pattern for {@link Report}
 * 
 * @author Luigi Iannone
 */
public interface ReportVisitor {

    /**
     * @param report
     *        report
     */
    void visitSuccessfulExecutionReport(SuccessfulExecutionReport report);

    /**
     * @param report
     *        report
     */
    void visitConfigurationFailedExecutionReport(
        ConfigurationFailedExecutionReport report);

    /**
     * @param report
     *        report
     */
    void visitRuntimeErrorEncounteredExecutionReport(
        RuntimeErrorEncounteredExecutionReport report);

    /**
     * @param report
     *        report
     */
    void visitAssertionFailedExecutionReport(AssertionFailedExecutionReport report);

    /**
     * @param report
     *        report
     */
    void visitUnexecutedTestReport(UnexecutedTestReport report);
}

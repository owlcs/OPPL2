/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

/** Visitor pattern for {@link Report}
 * 
 * @author Luigi Iannone */
public interface ReportVisitor {
    void visitSuccessfulExecutionReport(
            SuccessfulExecutionReport successfulExecutionReport);

    void visitConfigurationFailedExecutionReport(
            ConfigurationFailedExecutionReport configurationFailedExecutionReport);

            void
            visitRuntimeErrorEncounteredExecutionReport(
                    RuntimeErrorEncounteredExecutionReport runtimeErrorEncounteredExecutionReport);

    void visitAssertionFailedExecutionReport(
            AssertionFailedExecutionReport assertionFailedExecutionReport);

    void visitUnexecutedTestReport(UnexecutedTestReport unexecutedTestReport);
}

/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

/**
 * Visitor pattern with return value for {@link Report}
 * 
 * @author Luigi Iannone
 * 
 * @param <O>
 *            the type of the values returned by this visitor.
 */
public interface ReportVisitorEx<O> {
	O visitSuccessfulExecutionReport(SuccessfulExecutionReport successfulExecutionReport);

	O visitConfigurationFailedExecutionReport(
			ConfigurationFailedExecutionReport configurationFailedExecutionReport);

	O visitRuntimeErrorEncounteredExecutionReport(
			RuntimeErrorEncounteredExecutionReport runtimeErrorEncounteredExecutionReport);

	O visitAssertionFailedExecutionReport(
			AssertionFailedExecutionReport assertionFailedExecutionReport);

	O visitUnexecutedTestReport(UnexecutedTestReport unexecutedTestReport);
}

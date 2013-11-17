/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui.report;

/** @author Luigi Iannone */
public abstract class DefaultReportVisitorExAdapter<O> implements ReportVisitorEx<O> {
    private final O defaultValue;

    /** default returned value is null */
    public DefaultReportVisitorExAdapter() {
        this(null);
    }

    /** @param defaultValue */
    public DefaultReportVisitorExAdapter(O defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public O visitSuccessfulExecutionReport(
            SuccessfulExecutionReport successfulExecutionReport) {
        return this.getDefaultValue(successfulExecutionReport);
    }

    @Override
    public O visitConfigurationFailedExecutionReport(
            ConfigurationFailedExecutionReport configurationFailedExecutionReport) {
        return this.getDefaultValue(configurationFailedExecutionReport);
    }

    @Override
    public
            O
            visitRuntimeErrorEncounteredExecutionReport(
                    RuntimeErrorEncounteredExecutionReport runtimeErrorEncounteredExecutionReport) {
        return this.getDefaultValue(runtimeErrorEncounteredExecutionReport);
    }

    @Override
    public O visitAssertionFailedExecutionReport(
            AssertionFailedExecutionReport assertionFailedExecutionReport) {
        return this.getDefaultValue(assertionFailedExecutionReport);
    }

    @Override
    public O visitUnexecutedTestReport(UnexecutedTestReport unexecutedTestReport) {
        return this.getDefaultValue(unexecutedTestReport);
    }

    /** @return the defaultValue */
    protected O getDefaultValue(@SuppressWarnings("unused") Report report) {
        return this.defaultValue;
    }
}

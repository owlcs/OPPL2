package org.coode.oppl;

public interface ExecutionMonitor {
    static final ExecutionMonitor NON_CANCELLABLE = new ExecutionMonitor() {
        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public void progressIncrementChanged(int newValue) {
            // Do Nothing
        }
    };

    boolean isCancelled();

    void progressIncrementChanged(int newValue);
}

package org.coode.oppl;

/** @author Luigi Iannone */
public interface ExecutionMonitor {
    /**
     * 
     */
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

    /** @return true if cancelled */
    boolean isCancelled();

    /** @param newValue */
    void progressIncrementChanged(int newValue);
}

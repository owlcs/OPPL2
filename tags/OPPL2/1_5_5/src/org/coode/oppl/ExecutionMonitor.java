package org.coode.oppl;

public interface ExecutionMonitor {
	public static final ExecutionMonitor NON_CANCELLABLE = new ExecutionMonitor() {
		public boolean isCancelled() {
			return false;
		}

		public void progressIncrementChanged(int newValue) {
			// Do Nothing
		}
	};

	public boolean isCancelled();

	public void progressIncrementChanged(int newValue);
}

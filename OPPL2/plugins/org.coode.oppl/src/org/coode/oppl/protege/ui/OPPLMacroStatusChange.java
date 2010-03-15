package org.coode.oppl.protege.ui;

public interface OPPLMacroStatusChange {
	public abstract void addOPPLMacroListener(OPPLMacroListener listener);

	public abstract void removeOPPLMacroListener(OPPLMacroListener listener);
}
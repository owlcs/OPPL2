package org.coode.oppl.protege.ui;

/** @author Luigi Iannone */
public interface OPPLMacroStatusChange {
    /** @param listener */
    void addOPPLMacroListener(OPPLMacroListener listener);

    /** @param listener */
    void removeOPPLMacroListener(OPPLMacroListener listener);
}

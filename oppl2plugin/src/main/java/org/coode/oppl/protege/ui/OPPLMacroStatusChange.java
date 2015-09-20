package org.coode.oppl.protege.ui;

/**
 * @author Luigi Iannone
 */
public interface OPPLMacroStatusChange {

    /**
     * @param listener
     *        listener
     */
    void addOPPLMacroListener(OPPLMacroListener listener);

    /**
     * @param listener
     *        listener
     */
    void removeOPPLMacroListener(OPPLMacroListener listener);
}

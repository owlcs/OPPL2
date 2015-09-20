package org.coode.parsers.oppl;

import org.antlr.runtime.Token;
import org.coode.parsers.ManchesterOWLSyntaxTree;

/**
 * @author Luigi Iannone
 */
public class OPPLSyntaxTree extends ManchesterOWLSyntaxTree {

    private Object opplContent;

    /**
     * @param token
     *        token
     */
    public OPPLSyntaxTree(Token token) {
        super(token);
    }

    /**
     * @return the opplContent
     */
    public Object getOPPLContent() {
        return opplContent;
    }

    /**
     * @param opplContent
     *        the opplContent to set
     */
    public void setOPPLContent(Object opplContent) {
        this.opplContent = opplContent;
    }

    @Override
    public String toString() {
        return getText();
    }
}

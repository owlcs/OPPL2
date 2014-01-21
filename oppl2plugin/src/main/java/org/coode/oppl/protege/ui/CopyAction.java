package org.coode.oppl.protege.ui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/** @author Luigi Iannone */
public class CopyAction extends AbstractAction implements ClipboardOwner {
    private static final long serialVersionUID = 20100L;
    private String result;

    /** @param toolTipText
     *            toolTipText */
    public CopyAction(String toolTipText) {
        super("Copy Results", new ImageIcon(CopyAction.class.getClassLoader()
                .getResource("copy2Cipboard.jpg")));
        putValue(SHORT_DESCRIPTION, toolTipText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(getResult());
        c.setContents(selection, this);
    }

    /** @return the result */
    public String getResult() {
        return result;
    }

    /** @param result
     *            the result to set */
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // Do nothing
    }
}

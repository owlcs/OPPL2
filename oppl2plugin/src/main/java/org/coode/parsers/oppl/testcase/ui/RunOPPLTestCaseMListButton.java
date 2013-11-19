
package org.coode.parsers.oppl.testcase.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import org.protege.editor.core.ui.list.MListButton;

/** @author Luigi Iannone */
public class RunOPPLTestCaseMListButton extends MListButton {
    /** @param actionListener */
    public RunOPPLTestCaseMListButton(ActionListener actionListener) {
        super("Run OPPL TestCase ", Color.GREEN, actionListener);
    }

    @Override
    public void paintButtonContent(Graphics2D g) {
        int inset = 5;
        Rectangle bounds = getBounds();
        Polygon triangle = new Polygon(new int[] { (int) bounds.getMinX() + inset,
                (int) bounds.getMinX() + inset, (int) bounds.getMaxX() - inset },
                new int[] { (int) bounds.getMinY() + inset,
                        (int) bounds.getMaxY() - inset, (int) bounds.getCenterY() }, 3);
        g.draw(triangle);
        g.fill(triangle);
    }
}

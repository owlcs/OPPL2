/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.patterns.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import org.protege.editor.core.ui.list.MListButton;

/** @author Luigi Iannone Sep 17, 2008 */
public class InstantiatePatternButton extends MListButton {
    public InstantiatePatternButton(ActionListener actionListener) {
        super("Instantiate pattern", new Color(100, 40, 140), actionListener);
    }

    @Override
    public void paintButtonContent(Graphics2D g) {
        int stringWidth = g.getFontMetrics().getStringBounds("?", g).getBounds().width;
        int w = getBounds().width;
        int h = getBounds().height;
        g.drawString("i", getBounds().x + w / 2 - stringWidth / 2, getBounds().y
                + g.getFontMetrics().getAscent() / 2 + h / 2);
    }

    @Override
    public int hashCode() {
        return getActionListener().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean toReturn = obj == this;
        if (!toReturn && obj instanceof InstantiatePatternButton) {
            toReturn = ((InstantiatePatternButton) obj).getActionListener().equals(
                    getActionListener());
        }
        return toReturn;
    }
}

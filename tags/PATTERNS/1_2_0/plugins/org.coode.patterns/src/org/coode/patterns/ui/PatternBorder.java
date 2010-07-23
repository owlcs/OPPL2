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
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

import org.coode.patterns.PatternModel;

/**
 * @author Luigi Iannone
 * 
 */
public class PatternBorder implements Border {
	private final PatternModel patternModel;

	/**
	 * @param patternModel
	 */
	public PatternBorder(PatternModel patternModel) {
		this.patternModel = patternModel;
	}

	/**
	 * @see javax.swing.border.Border#getBorderInsets(java.awt.Component)
	 */
	public Insets getBorderInsets(Component c) {
		return new Insets(0,
				c.getFontMetrics(c.getFont()).getStringBounds(
						this.patternModel.getName(), c.getGraphics())
						.getBounds().width + 8, 0, 0);
	}

	/**
	 * @see javax.swing.border.Border#isBorderOpaque()
	 */
	public boolean isBorderOpaque() {
		return false;
	}

	/**
	 * @see javax.swing.border.Border#paintBorder(java.awt.Component,
	 *      java.awt.Graphics, int, int, int, int)
	 */
	@SuppressWarnings("unused")
	public void paintBorder(Component component, Graphics g, int x, int y,
			int width, int height) {
		Color oldColor = g.getColor();
		g.setColor(Color.BLUE);
		g.drawString(this.patternModel.getName(), x + 4, y + 2
				+ g.getFontMetrics().getAscent()
				+ g.getFontMetrics().getLeading());
		g.setColor(oldColor);
	}
}

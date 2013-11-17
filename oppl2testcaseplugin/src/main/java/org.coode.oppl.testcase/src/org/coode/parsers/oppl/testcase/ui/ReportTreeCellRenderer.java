/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.ui.report.Report;

/** @author Luigi Iannone */
public class ReportTreeCellRenderer implements TreeCellRenderer {
    private static final Stroke ICON_STROKE = new BasicStroke(2.0f,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        TreeModel model = tree.getModel();
        Component toReturn = null;
        DefaultTreeCellRenderer defaultTreeCellRenderer = new DefaultTreeCellRenderer();
        if (model instanceof ReportTreeModel) {
            ReportTreeModel reportTreeModel = (ReportTreeModel) model;
            if (reportTreeModel.getRoot() == value) {
                Icon icon = reportTreeModel.isSuccessful() ? ReportTreeCellRenderer
                        .getSuccessIcon(16, 16) : getErrorIcon(16, 16);
                defaultTreeCellRenderer.setOpenIcon(icon);
                defaultTreeCellRenderer.setClosedIcon(icon);
                defaultTreeCellRenderer.setLeafIcon(icon);
                toReturn = defaultTreeCellRenderer.getTreeCellRendererComponent(tree,
                        value, selected, expanded, leaf, row, hasFocus);
            } else if (value instanceof OPPLTestCase) {
                OPPLTestCase opplTestCase = (OPPLTestCase) value;
                Icon icon = reportTreeModel.isSuccessful(opplTestCase) ? getSuccessIcon(
                        16, 16) : getErrorIcon(16, 16);
                defaultTreeCellRenderer.setOpenIcon(icon);
                defaultTreeCellRenderer.setClosedIcon(icon);
                defaultTreeCellRenderer.setLeafIcon(icon);
                toReturn = defaultTreeCellRenderer.getTreeCellRendererComponent(tree,
                        opplTestCase.getName(), selected, expanded, leaf, row, hasFocus);
            } else if (value instanceof Report) {
                Icon icon = !reportTreeModel.isUnsuccessful((Report) value) ? getSuccessIcon(
                        16, 16) : getErrorIcon(16, 16);
                defaultTreeCellRenderer.setOpenIcon(icon);
                defaultTreeCellRenderer.setClosedIcon(icon);
                defaultTreeCellRenderer.setLeafIcon(icon);
                toReturn = defaultTreeCellRenderer.getTreeCellRendererComponent(tree,
                        value, selected, expanded, leaf, row, hasFocus);
            }
        } else {
            toReturn = defaultTreeCellRenderer.getTreeCellRendererComponent(tree, value,
                    selected, expanded, leaf, row, hasFocus);
        }
        return toReturn;
    }

    final static Icon getErrorIcon(final int width, final int height) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Color oldColour = g.getColor();
                Color oldBackground = ((Graphics2D) g).getBackground();
                Stroke oldStroke = ((Graphics2D) g).getStroke();
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                ((Graphics2D) g).setStroke(ICON_STROKE);
                g.setColor(Color.RED);
                int inset = 4;
                g.drawLine(x + inset, y + inset, x + width - inset, y + height - inset);
                g.drawLine(x + inset, y + height - inset, x + width - inset, y + inset);
                g.setColor(oldColour);
                ((Graphics2D) g).setStroke(oldStroke);
                ((Graphics2D) g).setBackground(oldBackground);
            }

            @Override
            public int getIconWidth() {
                return width;
            }

            @Override
            public int getIconHeight() {
                return height;
            }
        };
    }

    final static Icon getSuccessIcon(final int width, final int height) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Color oldColour = g.getColor();
                Color oldBackground = ((Graphics2D) g).getBackground();
                Stroke oldStroke = ((Graphics2D) g).getStroke();
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                ((Graphics2D) g).setStroke(ICON_STROKE);
                g.setColor(Color.GREEN);
                int inset = 4;
                g.drawLine(x + inset, y + height / 2, x + width / 2, y + height - inset);
                g.drawLine(x + width / 2, y + height - inset, x + width - inset, y
                        + inset);
                g.setColor(oldColour);
                ((Graphics2D) g).setStroke(oldStroke);
                ((Graphics2D) g).setBackground(oldBackground);
            }

            @Override
            public int getIconWidth() {
                return width;
            }

            @Override
            public int getIconHeight() {
                return height;
            }
        };
    }
}

package org.coode.patterns.protege.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.table.TableModel;

import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.patterns.locality.LocalityChecker;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.model.OWLEntity;

/** locality checker */
public class LocalityCheckerActionListener extends LocalityChecker implements
        ActionListener {
    private static final String SAFETY_ANALYSIS_BREAKDOWN = "Safety analysis breakdown";
    public final static int DIMENSION = 18;
    private final JButton resultButton;

    /** @param kit
     * @param signature
     * @param resultButton
     * @param handler */
    public LocalityCheckerActionListener(final OWLEditorKit kit,
            Set<OWLEntity> signature, JButton resultButton,
            RuntimeExceptionHandler handler) {
        super(kit.getOWLModelManager().getOWLOntologyManager(), kit.getOWLModelManager()
                .getReasoner(), signature, handler);
        this.resultButton = resultButton;
        this.resultButton.setIcon(generateIcon(Color.gray));
        this.resultButton.setToolTipText("Check not executed yet");
        this.resultButton.setEnabled(false);
    }

    /** @param color
     * @return icon */
    public Icon generateIcon(final Color color) {
        return new Icon() {
            /** Draw the icon at the specified location. Icon implementations may
             * use the Component argument to get properties useful for painting,
             * e.g. the foreground or background color. */
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Color oldColor = g.getColor();
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(color);
                g2.fillOval(x + 2, y + 2, DIMENSION - 4, DIMENSION - 4);
                g2.setColor(Color.LIGHT_GRAY);
                g2.drawOval(x + 2, y + 2, DIMENSION - 4, DIMENSION - 4);
                g2.setColor(oldColor);
            }

            /** Returns the icon's width.
             * 
             * @return an int specifying the fixed width of the icon. */
            @Override
            public int getIconWidth() {
                return DIMENSION;
            }

            /** Returns the icon's height.
             * 
             * @return an int specifying the fixed height of the icon. */
            @Override
            public int getIconHeight() {
                return DIMENSION;
            }
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resultButton.setEnabled(true);
        resultButton.setToolTipText(SAFETY_ANALYSIS_BREAKDOWN);
        if (getInstantiatedPatternModel() != null) {
            if (!isLocal()) {
                resultButton.setIcon(generateIcon(Color.red));
            } else {
                resultButton.setIcon(generateIcon(Color.green));
            }
        }
    }

    /** @return table model */
    public TableModel print() {
        return new LocalityCheckResultTableModel(this);
    }
}

package org.coode.oppl.protege.ui.message;

import java.awt.Component;

import javax.swing.*;

/**
 * @author Luigi Iannone
 */
public class MessageListCellRenderer implements ListCellRenderer, MessageVisitorEx<Icon> {

    private final DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus) {
        Component toReturn = defaultListCellRenderer.getListCellRendererComponent(list,
            value, index, isSelected, cellHasFocus);
        if (toReturn instanceof JLabel
            && Message.class.isAssignableFrom(value.getClass())) {
            ((JLabel) toReturn).setIcon(((Message) value).accept(this));
        }
        return toReturn;
    }

    @Override
    public Icon visitError(Error error) {
        return new ImageIcon(this.getClass().getClassLoader().getResource("error.png"));
    }

    @Override
    public Icon visitWarning(Warning warning) {
        return new ImageIcon(this.getClass().getClassLoader().getResource("warning.png"));
    }
}

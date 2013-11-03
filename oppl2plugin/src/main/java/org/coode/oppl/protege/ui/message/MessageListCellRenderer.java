/**
 * 
 */
package org.coode.oppl.protege.ui.message;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * @author Luigi Iannone
 * 
 */
public class MessageListCellRenderer implements ListCellRenderer, MessageVisitorEx<Icon> {
	private final DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();

	public Component getListCellRendererComponent(JList list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		Component toReturn = this.defaultListCellRenderer.getListCellRendererComponent(
				list,
				value,
				index,
				isSelected,
				cellHasFocus);
		if (toReturn instanceof JLabel && Message.class.isAssignableFrom(value.getClass())) {
			((JLabel) toReturn).setIcon(((Message) value).accept(this));
		}
		return toReturn;
	}

	public Icon visitError(Error error) {
		return new ImageIcon(this.getClass().getClassLoader().getResource("error.png"));
	}

	public Icon visitWarning(Warning warning) {
		return new ImageIcon(this.getClass().getClassLoader().getResource("warning.png"));
	}
}

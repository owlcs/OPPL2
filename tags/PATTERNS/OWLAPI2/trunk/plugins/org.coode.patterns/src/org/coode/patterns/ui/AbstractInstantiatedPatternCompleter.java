package org.coode.patterns.ui;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import org.apache.log4j.Logger;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.model.OWLObject;

public abstract class AbstractInstantiatedPatternCompleter {
	public static final int DEFAULT_MAX_ENTRIES = 100;
	protected OWLEditorKit owlEditorKit;
	protected JTextComponent textComponent;
	protected KeyListener keyListener;
	protected Set<String> wordDelimeters;
	// private AutoCompleterMatcher matcher;
	protected JList popupList;
	protected JWindow popupWindow;
	protected static final int POPUP_WIDTH = 350;
	protected static final int POPUP_HEIGHT = 300;
	protected String lastTextUpdate = "*";
	protected int maxEntries = DEFAULT_MAX_ENTRIES;

	protected final static class SpecializedHierarchyListener implements
			HierarchyListener {
		private AbstractInstantiatedPatternCompleter main;

		public SpecializedHierarchyListener(
				AbstractInstantiatedPatternCompleter _this) {
			this.main = _this;
		}

		/**
		 * Called when the hierarchy has been changed. To discern the actual
		 * type of change, call <code>HierarchyEvent.getChangeFlags()</code> .
		 * 
		 * @see java.awt.event.HierarchyEvent#getChangeFlags()
		 */
		public void hierarchyChanged(HierarchyEvent e) {
			if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) != 0) {
				this.main.createPopupWindow();
			}
		}
	}

	protected final static class SpecializedKeyListener extends KeyAdapter {
		private AbstractInstantiatedPatternCompleter main;

		public SpecializedKeyListener(AbstractInstantiatedPatternCompleter _this) {
			this.main = _this;
		}

		@Override
		public void keyPressed(KeyEvent e) {
			this.main.processKeyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() != KeyEvent.VK_UP
					&& e.getKeyCode() != KeyEvent.VK_DOWN
					&& this.main.popupWindow.isVisible()
					&& !this.main.lastTextUpdate.equals(this.main.textComponent
							.getText())) {
				this.main.lastTextUpdate = this.main.textComponent.getText();
				this.main.updatePopup(this.main.getMatches());
			}
		}
	}

	protected static final class SpecializedMouseAdapter extends MouseAdapter {
		private AbstractInstantiatedPatternCompleter main;

		public SpecializedMouseAdapter(
				AbstractInstantiatedPatternCompleter _this) {
			this.main = _this;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				this.main.completeWithPopupSelection();
			}
		}
	}

	protected AbstractInstantiatedPatternCompleter(OWLEditorKit owlEditorKit,
			JTextComponent tc) {
		this.owlEditorKit = owlEditorKit;
		this.textComponent = tc;
		this.keyListener = new SpecializedKeyListener(this);
		this.textComponent.addKeyListener(this.keyListener);
		this.wordDelimeters = new HashSet<String>();
		this.wordDelimeters.add(" ");
		this.wordDelimeters.add("\n");
		this.wordDelimeters.add("[");
		this.wordDelimeters.add("]");
		this.wordDelimeters.add("{");
		this.wordDelimeters.add("}");
		this.wordDelimeters.add("(");
		this.wordDelimeters.add(")");
		this.wordDelimeters.add(",");
		this.wordDelimeters.add("^");
		// this.matcher = new AutoCompleterMatcherImpl(owlEditorKit
		// .getOWLModelManager());
		this.popupList = new JList();
		this.popupList.setAutoscrolls(true);
		this.popupList.setCellRenderer(owlEditorKit.getWorkspace()
				.createOWLCellRenderer());
		this.popupList.addMouseListener(new SpecializedMouseAdapter(this));
		this.popupList.setRequestFocusEnabled(false);
		this.createPopupWindow();
		this.textComponent
				.addHierarchyListener(new SpecializedHierarchyListener(this));
	}

	protected final void completeWithPopupSelection() {
		if (this.popupWindow.isVisible()) {
			Object selObject = this.popupList.getSelectedValue();
			if (selObject != null) {
				this.insertWord(this.getInsertText(selObject));
				this.hidePopup();
			}
		}
	}

	protected final void createPopupWindow() {
		JScrollPane sp = ComponentFactory.createScrollPane(this.popupList);
		this.popupWindow = new JWindow((Window) SwingUtilities
				.getAncestorOfClass(Window.class, this.textComponent));
		this.popupWindow.setAlwaysOnTop(true);
		this.popupWindow.getContentPane().setLayout(new BorderLayout());
		this.popupWindow.getContentPane().add(sp, BorderLayout.CENTER);
		this.popupWindow.setFocusableWindowState(false);
	}

	protected final void decrementSelection() {
		if (this.popupList.getModel().getSize() > 0) {
			int selIndex = this.popupList.getSelectedIndex();
			selIndex--;
			if (selIndex < 0) {
				selIndex = this.popupList.getModel().getSize() - 1;
			}
			this.popupList.setSelectedIndex(selIndex);
			this.popupList.scrollRectToVisible(this.popupList.getCellBounds(
					selIndex, selIndex));
		}
	}

	protected final String getInsertText(Object o) {
		if (o instanceof OWLObject) {
			OWLModelManager owlModelManager = this.owlEditorKit
					.getModelManager();
			return owlModelManager.getOWLObjectRenderer().render((OWLObject) o,
					owlModelManager.getOWLEntityRenderer());
		} else {
			return o.toString();
		}
	}

	protected final String getWordToComplete() {
		try {
			int index = this.getWordIndex();
			int caretIndex = this.textComponent.getCaretPosition();
			return this.textComponent.getDocument().getText(index,
					caretIndex - index);
		} catch (BadLocationException e) {
			return "";
		}
	}

	protected abstract int getWordIndex();

	protected final void hidePopup() {
		this.popupWindow.setVisible(false);
		this.popupList.setListData(new Object[0]);
	}

	protected final void incrementSelection() {
		if (this.popupList.getModel().getSize() > 0) {
			int selIndex = this.popupList.getSelectedIndex();
			selIndex++;
			if (selIndex > this.popupList.getModel().getSize() - 1) {
				selIndex = 0;
			}
			this.popupList.setSelectedIndex(selIndex);
			this.popupList.scrollRectToVisible(this.popupList.getCellBounds(
					selIndex, selIndex));
		}
	}

	protected final void insertWord(String word) {
		try {
			String wordToComplete = this.getWordToComplete();
			if (word.startsWith(wordToComplete)) {
				int index = this.getWordIndex();
				int caretIndex = this.textComponent.getCaretPosition();
				this.textComponent.getDocument().remove(index,
						caretIndex - index);
				this.textComponent.getDocument()
						.insertString(index, word, null);
			} else {
				this.textComponent.getDocument().insertString(
						this.textComponent.getText().length(), word, null);
			}
		} catch (BadLocationException e) {
			this.getLogger().error(e);
		}
	}

	protected abstract Logger getLogger();

	protected final void performAutoCompletion() {
		List<?> matches = this.getMatches();
		if (matches.size() == 1) {
			// Don't show popup
			this.insertWord(this.getInsertText(matches.iterator().next()));
		} else if (matches.size() > 1) {
			// Show popup
			this.lastTextUpdate = this.textComponent.getText();
			this.showPopup();
			this.updatePopup(matches);
		}
	}

	protected abstract List<? extends Object> getMatches();

	protected final void processKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && e.isControlDown()) {
			// Show popup
			this.performAutoCompletion();
		} else if (e.getKeyCode() == KeyEvent.VK_TAB) {
			e.consume();
			this.performAutoCompletion();
		} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (this.popupWindow.isVisible()) {
				// Hide popup
				e.consume();
				this.hidePopup();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (this.popupWindow.isVisible()) {
				// Complete
				e.consume();
				this.completeWithPopupSelection();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (this.popupWindow.isVisible()) {
				e.consume();
				this.incrementSelection();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (this.popupWindow.isVisible()) {
				e.consume();
				this.decrementSelection();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.hidePopup();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.hidePopup();
		}
	}

	protected final void showPopup() {
		if (this.popupWindow == null) {
			this.createPopupWindow();
		}
		if (!this.popupWindow.isVisible()) {
			this.popupWindow.setSize(POPUP_WIDTH, POPUP_HEIGHT);
			try {
				int wordIndex = this.getWordIndex();
				if (wordIndex < 0) {
					return;
				}
				Point p = this.textComponent.modelToView(this.getWordIndex())
						.getLocation();
				SwingUtilities.convertPointToScreen(p, this.textComponent);
				p.y = p.y
						+ this.textComponent.getFontMetrics(
								this.textComponent.getFont()).getHeight();
				this.popupWindow.setLocation(p);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			this.popupWindow.setVisible(true);
		}
	}

	protected final void uninstall() {
		this.textComponent.removeKeyListener(this.keyListener);
	}

	protected final void updatePopup(List<?> matches) {
		int count = matches.size();
		if (count > this.maxEntries) {
			count = this.maxEntries;
		}
		if (!matches.isEmpty()) {
			this.popupList.setListData(matches.subList(0, count).toArray());
		} else {
			this.popupList.setListData(matches.toArray());
		}
		this.popupList.setSelectedIndex(0);
		this.popupWindow.setSize(POPUP_WIDTH, POPUP_HEIGHT);
	}
}

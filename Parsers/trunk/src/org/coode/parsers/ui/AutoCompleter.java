package org.coode.parsers.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.antlr.runtime.tree.TreeAdaptor;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.MOWLLexer;
import org.coode.parsers.ManchesterOWLSyntaxAutoComplete;
import org.coode.parsers.ManchesterOWLSyntaxAutoCompleteCombinedParser;
import org.coode.parsers.ManchesterOWLSyntaxSimplify;
import org.coode.parsers.ManchesterOWLSyntaxTree;
import org.coode.parsers.ManchesterOWLSyntaxTypes;
import org.coode.parsers.SymbolTable;
import org.coode.parsers.Type;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: May 4, 2006<br>
 * <br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 */
public abstract class AutoCompleter {
	public static final int DEFAULT_MAX_ENTRIES = 100;
	private final TreeAdaptor adaptor;
	private JTextComponent textComponent;
	private Set<String> wordDelimeters;
	private JList popupList;
	private JWindow popupWindow;
	public static final int POPUP_WIDTH = 350;
	public static final int POPUP_HEIGHT = 300;
	private String lastTextUpdate = "*";
	private int maxEntries = DEFAULT_MAX_ENTRIES;
	private KeyListener keyListener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			AutoCompleter.this.processKeyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN) {
				if (AutoCompleter.this.popupWindow.isVisible()
						&& !AutoCompleter.this.lastTextUpdate.equals(AutoCompleter.this.textComponent.getText())) {
					AutoCompleter.this.lastTextUpdate = AutoCompleter.this.textComponent.getText();
					AutoCompleter.this.updatePopup(AutoCompleter.this.getMatches());
				}
			}
		}
	};
	private ComponentAdapter componentListener = new ComponentAdapter() {
		@Override
		public void componentHidden(ComponentEvent event) {
			AutoCompleter.this.hidePopup();
		}

		@Override
		public void componentResized(ComponentEvent event) {
			AutoCompleter.this.hidePopup();
		}

		@Override
		public void componentMoved(ComponentEvent event) {
			AutoCompleter.this.hidePopup();
		}
	};
	private HierarchyListener hierarchyListener = new HierarchyListener() {
		/**
		 * Called when the hierarchy has been changed. To discern the actual
		 * type of change, call <code>HierarchyEvent.getChangeFlags()</code>.
		 * 
		 * @see java.awt.event.HierarchyEvent#getChangeFlags()
		 */
		public void hierarchyChanged(HierarchyEvent e) {
			if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) != 0) {
				AutoCompleter.this.createPopupWindow();
				Container frame = AutoCompleter.this.textComponent.getTopLevelAncestor();
				if (frame != null) {
					frame.addComponentListener(AutoCompleter.this.componentListener);
				}
			}
		}
	};
	private MouseListener mouseListener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				AutoCompleter.this.completeWithPopupSelection();
			}
		}
	};
	private FocusListener focusListener = new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent event) {
			AutoCompleter.this.hidePopup();
		}
	};
	private static ErrorListener silentErrorListener = new ErrorListener() {
		public void unrecognisedSymbol(CommonTree t) {
		}

		public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
		}

		public void recognitionException(RecognitionException e, String... tokenNames) {
		}

		public void recognitionException(RecognitionException e) {
		}

		public void incompatibleSymbols(CommonTree parentExpression, CommonTree... trees) {
		}

		public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
		}

		public void illegalToken(CommonTree t, String message) {
		}

		public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
		}
	};

	public AutoCompleter(JTextComponent tc, TreeAdaptor adaptor) {
		this.textComponent = tc;
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
		this.adaptor = adaptor;
		this.popupList = new JList();
		this.popupList.setAutoscrolls(true);
		this.popupList.addMouseListener(this.mouseListener);
		this.popupList.setRequestFocusEnabled(false);
		this.textComponent.addKeyListener(this.keyListener);
		this.textComponent.addHierarchyListener(this.hierarchyListener);
		// moving or resizing the text component or dialog closes the popup
		this.textComponent.addComponentListener(this.componentListener);
		// switching focus to another component closes the popup
		this.textComponent.addFocusListener(this.focusListener);
		this.createPopupWindow();
	}

	public void cancel() {
		this.hidePopup();
	}

	private void processKeyPressed(KeyEvent e) {
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

	private void completeWithPopupSelection() {
		if (this.popupWindow.isVisible()) {
			Object selObject = this.popupList.getSelectedValue();
			if (selObject != null) {
				this.insertWord(selObject.toString());
				this.hidePopup();
			}
		}
	}

	private List<String> getMatches() {
		List<String> toReturn = new ArrayList<String>();
		String text = this.textComponent.getText();
		ManchesterOWLSyntaxTree tree = this.getTree(text);
		boolean newWord = text.matches(".*\\s");
		if (tree != null) {
			System.out.println(tree.toStringTree());
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.reset();
			ManchesterOWLSyntaxAutoComplete autoComplete = new ManchesterOWLSyntaxAutoComplete(
					nodes, this.getSymbolTable());
			autoComplete.setNewWord(newWord);
			autoComplete.downup(tree);
			if (tree.getCompletions() != null) {
				toReturn.addAll(tree.getCompletions());
			}
		}
		return toReturn;
	}

	protected ManchesterOWLSyntaxTree getTree(String input) {
		MOWLLexer lexer = new MOWLLexer(new ANTLRStringStream(input));
		TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		ManchesterOWLSyntaxAutoCompleteCombinedParser parser = new ManchesterOWLSyntaxAutoCompleteCombinedParser(
				tokens);
		parser.setTreeAdaptor(this.adaptor);
		try {
			RuleReturnScope r = parser.main();
			CommonTree tree = (CommonTree) r.getTree();
			if (tree != null) {
				CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
				nodes.setTokenStream(tokens); // where to find tokens
				nodes.setTreeAdaptor(this.adaptor);
				ManchesterOWLSyntaxSimplify simplify = new ManchesterOWLSyntaxSimplify(nodes);
				simplify.setTreeAdaptor(this.adaptor);
				simplify.downup(tree);
				nodes.reset();
				ManchesterOWLSyntaxTypes types = new ManchesterOWLSyntaxTypes(nodes,
						this.getSymbolTable(), silentErrorListener);
				types.downup(tree);
			}
			return (ManchesterOWLSyntaxTree) tree;
		} catch (RecognitionException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected abstract SymbolTable getSymbolTable();

	private void createPopupWindow() {
		JScrollPane sp = new JScrollPane(this.popupList);
		this.popupWindow = new JWindow((Window) SwingUtilities.getAncestorOfClass(
				Window.class,
				this.textComponent));
		// popupWindow.setAlwaysOnTop(true); // this doesn't appear to work with
		// certain Windows/java combinations
		this.popupWindow.getContentPane().setLayout(new BorderLayout());
		this.popupWindow.getContentPane().add(sp, BorderLayout.CENTER);
		this.popupWindow.setFocusableWindowState(false);
	}

	private void performAutoCompletion() {
		List<String> matches = this.getMatches();
		if (matches.size() == 1) {
			// Don't show popup
			this.insertWord(matches.iterator().next());
		} else if (matches.size() > 1) {
			// Show popup
			this.lastTextUpdate = this.textComponent.getText();
			this.showPopup();
			this.updatePopup(matches);
		}
	}

	private void insertWord(String word) {
		try {
			// remove any currently selected text - this is the default
			// behaviour
			// of the editor when typing manually
			int selStart = this.textComponent.getSelectionStart();
			int selEnd = this.textComponent.getSelectionEnd();
			int selLen = selEnd - selStart;
			if (selLen > 0) {
				this.textComponent.getDocument().remove(selStart, selLen);
			}
			int index = this.getWordIndex();
			int caretIndex = this.textComponent.getCaretPosition();
			if (caretIndex > 0 && caretIndex > index) {
				this.textComponent.getDocument().remove(index, caretIndex - index);
			}
			this.textComponent.getDocument().insertString(index, word + " ", null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	private void showPopup() {
		if (this.popupWindow == null) {
			this.createPopupWindow();
		}
		if (!this.popupWindow.isVisible()) {
			this.popupWindow.setSize(POPUP_WIDTH, POPUP_HEIGHT);
			try {
				int wordIndex = this.getWordIndex();
				Point p = new Point(0, 0); // default for when the doc is empty
				if (wordIndex > 0) {
					p = this.textComponent.modelToView(wordIndex).getLocation();
				}
				SwingUtilities.convertPointToScreen(p, this.textComponent);
				p.y = p.y
						+ this.textComponent.getFontMetrics(this.textComponent.getFont()).getHeight();
				this.popupWindow.setLocation(p);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			this.popupWindow.setVisible(true);
		}
	}

	private void hidePopup() {
		this.popupWindow.setVisible(false);
		this.popupList.setListData(new Object[0]);
	}

	private void updatePopup(List<String> matches) {
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

	private void incrementSelection() {
		if (this.popupList.getModel().getSize() > 0) {
			int selIndex = this.popupList.getSelectedIndex();
			selIndex++;
			if (selIndex > this.popupList.getModel().getSize() - 1) {
				selIndex = 0;
			}
			this.popupList.setSelectedIndex(selIndex);
			this.popupList.scrollRectToVisible(this.popupList.getCellBounds(selIndex, selIndex));
		}
	}

	private void decrementSelection() {
		if (this.popupList.getModel().getSize() > 0) {
			int selIndex = this.popupList.getSelectedIndex();
			selIndex--;
			if (selIndex < 0) {
				selIndex = this.popupList.getModel().getSize() - 1;
			}
			this.popupList.setSelectedIndex(selIndex);
			this.popupList.scrollRectToVisible(this.popupList.getCellBounds(selIndex, selIndex));
		}
	}

	private int getWordIndex() {
		int index = this.getEscapedWordIndex();
		if (index == -1) {
			index = this.getUnbrokenWordIndex();
		}
		return Math.max(0, index);
	}

	// determines if we are currently inside an escaped name (if there are an
	// uneven number of escape characters)
	private int getEscapedWordIndex() {
		try {
			int caretPos = Math.max(0, this.getEffectiveCaretPosition() - 1);
			String expression = this.textComponent.getDocument().getText(0, caretPos);
			int escapeEnd = -1;
			do {
				int escapeStart = expression.indexOf("'", escapeEnd + 1);
				if (escapeStart != -1) {
					escapeEnd = expression.indexOf("'", escapeStart + 1);
					if (escapeEnd == -1) {
						return escapeStart;
					}
				} else {
					return -1;
				}
			} while (true);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private int getUnbrokenWordIndex() {
		try {
			int caretPos = Math.max(0, this.getEffectiveCaretPosition() - 1);
			if (caretPos > 0) {
				for (int index = caretPos; index > -1; index--) {
					if (this.wordDelimeters.contains(this.textComponent.getDocument().getText(
							index,
							1))) {
						return index + 1;
					}
					if (index == 0) {
						return 0;
					}
				}
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// private String getWordToComplete() {
	// try {
	// int index = this.getWordIndex();
	// int caretIndex = this.getEffectiveCaretPosition();
	// return this.textComponent.getDocument().getText(index,
	// caretIndex - index);
	// } catch (BadLocationException e) {
	// return "";
	// }
	// }
	// the caret pos should be read as the start of the selection if there is
	// one
	private int getEffectiveCaretPosition() {
		int startSel = this.textComponent.getSelectionStart();
		if (startSel >= 0) {
			return startSel;
		}
		return this.textComponent.getCaretPosition();
	}

	public void uninstall() {
		this.hidePopup();
		this.textComponent.removeKeyListener(this.keyListener);
		this.textComponent.removeComponentListener(this.componentListener);
		this.textComponent.removeFocusListener(this.focusListener);
		this.textComponent.removeHierarchyListener(this.hierarchyListener);
	}
}

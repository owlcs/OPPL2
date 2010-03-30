package org.coode.parsers.test.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLOntologyManager;

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
 * <p/>
 * An editor that can be used to edit text containing class expressions. The
 * editor is backed by a parser that checks that the text is well formed and
 * provides feedback if the text is not well formed.
 */
public class ExpressionEditor<O> extends JTextPane implements
		RefreshableComponent, VerifiedInputEditor {
	private static final int CHECK_DELAY = 500;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3136357683296782324L;
	private final KeywordColourMap keywordColourMap = new KeywordColourMap();
	private Border outerBorder;
	private Border defaultBorder;
	private Border stateBorder;
	private Border errorBorder;
	private Stroke errorStroke;
	private DocumentListener docListener;
	private int errorStartIndex;
	private int errorEndIndex;
	private Timer timer;
	private static final int DEFAULT_TOOL_TIP_INITIAL_DELAY = ToolTipManager
			.sharedInstance().getInitialDelay();
	public static final String DEFAULT_FONT_NAME = "Dialog";
	private static final int DEFAULT_TOOL_TIP_DISMISS_DELAY = ToolTipManager
			.sharedInstance().getDismissDelay();
	private static final int ERROR_TOOL_TIP_INITIAL_DELAY = 100;
	private static final int ERROR_TOOL_TIP_DISMISS_DELAY = 9000;
	private ExpressionChecker<O> expressionChecker;
	private final OWLOntologyManager ontologyMmanager;

	public ExpressionEditor(OWLOntologyManager manager,
			ExpressionChecker<O> checker) {
		if (manager == null) {
			throw new NullPointerException(
					"The ontology manager cannot be null");
		}
		if (checker == null) {
			throw new NullPointerException(
					"The expression checker cannot be null");
		}
		this.ontologyMmanager = manager;
		this.outerBorder = null;
		this.expressionChecker = checker;
		this.defaultBorder = BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.LIGHT_GRAY);
		this.setStateBorder(this.defaultBorder);
		this.errorBorder = BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.RED);
		this.errorStroke = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 3.0f, new float[] { 4.0f, 2.0f }, 0.0f);
		this.docListener = new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				ExpressionEditor.this.handleDocumentUpdated();
			}

			public void removeUpdate(DocumentEvent e) {
				ExpressionEditor.this.handleDocumentUpdated();
			}

			public void changedUpdate(DocumentEvent e) {
			}
		};
		this.getDocument().addDocumentListener(this.docListener);
		this.timer = new Timer(ExpressionEditor.CHECK_DELAY,
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ExpressionEditor.this.handleTimer();
					}
				});
		this.refreshComponent();
		this.createStyles();
	}

	public void refreshComponent() {
		this.setFont(new Font(DEFAULT_FONT_NAME, Font.PLAIN, 14));
	}

	public void setExpressionObject(O desc) {
		if (desc == null) {
			this.setText("");
		} else {
			this.setText(desc.toString());
		}
	}

	public ExpressionChecker<O> getExpressionChecker() {
		return this.expressionChecker;
	}

	public O createObject() throws OWLException {
		return this.expressionChecker.createObject(this.getText());
	}

	public void setStateBorder(Border border) {
		this.stateBorder = border;
		super.setBorder(BorderFactory.createCompoundBorder(this.outerBorder,
				this.stateBorder));
	}

	@Override
	public void setBorder(Border border) {
		this.outerBorder = border;
		// Override to set the outer border
		super.setBorder(BorderFactory.createCompoundBorder(this.outerBorder,
				this.stateBorder));
	}

	private void clearError() {
		this.setToolTipText(null);
		this.setStateBorder(this.defaultBorder);
		this.setErrorRange(0, 0);
		ToolTipManager.sharedInstance().setInitialDelay(
				DEFAULT_TOOL_TIP_INITIAL_DELAY);
		ToolTipManager.sharedInstance().setDismissDelay(
				DEFAULT_TOOL_TIP_DISMISS_DELAY);
	}

	protected void checkExpression() {
		// Parse the text in the editor. If no parse
		// exception is thrown, clear the error, otherwise
		// set the error
		this.expressionChecker.check(this.getText());
		this.setError(this.expressionChecker.getErrorReport());
	}

	private void handleTimer() {
		this.timer.stop();
		this.checkExpression();
	}

	private void handleDocumentUpdated() {
		this.timer.restart();
		this.clearError();
		this.performHighlighting();
		this.notifyValidationChanged(false); // updates always disable until
		// parsed
	}

	private void setError(ErrorReport e) {
		this.notifyValidationChanged(e == null); // if no error, then content is
		// valid
		if (e != null) {
			ToolTipManager.sharedInstance().setInitialDelay(
					ERROR_TOOL_TIP_INITIAL_DELAY);
			ToolTipManager.sharedInstance().setDismissDelay(
					ERROR_TOOL_TIP_DISMISS_DELAY);
			this.setToolTipText(getHTMLErrorMessage(e.getMessage()));
			this.setStateBorder(this.errorBorder);
			int start = e.getLinearisedPosition(this.getText());
			this.setErrorRange(start, e
					.getLength()
					+ start);
		} else {
			this.clearError();
		}
	}

	private void setErrorRange(int startIndex, int endIndex) {
		this.errorStartIndex = startIndex;
		this.errorEndIndex = endIndex;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color oldColor = g.getColor();
		try {
			// Paint in error range if there is one
			if (this.errorStartIndex != this.errorEndIndex
					&& this.errorStartIndex > -1
					&& this.errorStartIndex < this.getDocument().getLength()) {
				Rectangle start = this.modelToView(this.errorStartIndex);
				Rectangle end = this.modelToView(this.errorEndIndex);
				g.setColor(Color.RED);
				((Graphics2D) g).setStroke(this.errorStroke);
				int y = end.y + end.height;
				g.drawLine(start.x, y, end.x + end.width, y);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		g.setColor(oldColor);
	}

	private void performHighlighting() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					final int lineStartIndex = 0;
					final int lineEndIndex = ExpressionEditor.this
							.getDocument().getLength();
					if (lineEndIndex - lineStartIndex < 0) {
						return;
					}
					StringTokenizer tokenizer = new StringTokenizer(
							ExpressionEditor.this.getDocument().getText(
									lineStartIndex,
									lineEndIndex - lineStartIndex),
							" ()[]{},\n\t.'", true);
					int index = lineStartIndex;
					boolean inEscapedName = false;
					while (tokenizer.hasMoreTokens()) {
						String curToken = tokenizer.nextToken();
						if (curToken.equals("'")) {
							if (inEscapedName) {
								inEscapedName = false;
							} else {
								inEscapedName = true;
							}
						}
						if (!inEscapedName) {
							Color color = ExpressionEditor.this.keywordColourMap
									.get(curToken);
							if (color == null) {
								color = Color.BLACK;
							}
							ExpressionEditor.this
									.getStyledDocument()
									.setCharacterAttributes(
											index,
											curToken.length(),
											ExpressionEditor.this
													.getStyledDocument()
													.getStyle(color.toString()),
											true);
						}
						index += curToken.length();
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

	private static String getHTMLErrorMessage(String msg) {
		String html = "<html><body>";
		msg = msg.replace("\n", "<br>");
		msg = msg.replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		html += msg;
		html += "</body></html>";
		return html;
	}

	private void createStyles() {
		for (Color color : this.keywordColourMap.values()) {
			Style style = this.getStyledDocument().addStyle(color.toString(),
					null);
			StyleConstants.setForeground(style, color);
			StyleConstants.setBold(style, true);
		}
		StyleConstants.setForeground(this.getStyledDocument().addStyle(
				Color.BLACK.toString(), null), Color.BLACK);
	}

	// /////////////////////// content verification
	private Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private boolean previousValue = true;

	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.add(listener);
	}

	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	private void notifyValidationChanged(boolean valid) {
		if (valid != this.previousValue) { // only report changes
			this.previousValue = valid;
			for (InputVerificationStatusChangedListener l : this.listeners) {
				l.verifiedStatusChanged(valid);
			}
		}
	}

	/**
	 * @return the ontologyMmanager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyMmanager;
	}
}

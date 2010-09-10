/**
 * 
 */
package org.coode.oppl.lint.protege;

import java.util.Formatter;
import java.util.Locale;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.RewriteEmptyStreamException;
import org.coode.lint.protege.LintProtegePluginInstanceAdapter;
import org.coode.oppl.lint.OPPLLintParser;
import org.coode.oppl.lint.OPPLLintScript;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.Type;
import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.ExtensionInstantiator;
import org.protege.editor.core.plugin.JPFUtil;
import org.protege.editor.core.plugin.PluginUtilities;
import org.protege.editor.core.plugin.ProtegePlugin;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 */
public final class OPPLLintPlugin implements
		ProtegePlugin<LintProtegePluginInstanceAdapter<OWLObject>> {
	public static final String LINT_PLUGIN_TYPE_ID = "oppllint";
	private final IExtension extension;
	private final OWLEditorKit owlEditorKit;
	public static final ErrorListener ERROR_LISTENER = new ErrorListener() {
		public void unrecognisedSymbol(CommonTree t) {
			System.err.println("Unerecognised token " + t.getText() + " at line " + t.getLine()
					+ " position " + t.getCharPositionInLine());
		}

		public void incompatibleSymbolType(CommonTree t, Type type, CommonTree expression) {
			System.err.println("Incompatible type " + type + " for token " + t.getText()
					+ " in expression " + expression + " at line " + t.getLine() + " position "
					+ t.getCharPositionInLine());
		}

		public void rewriteEmptyStreamException(RewriteEmptyStreamException e) {
			System.err.println(e.getMessage().replaceAll("rule", "Incomplete "));
		}

		public void recognitionException(RecognitionException e) {
			String message = e.getMessage() != null ? e.getMessage() : "";
			StringBuilder out = new StringBuilder();
			Formatter formatter = new Formatter(out, Locale.getDefault());
			Token token = e.token;
			formatter.format(
					"Recognition exception when parsing  token: %s line %d position %d",
					token.getText(),
					token.getLine(),
					token.getCharPositionInLine());
			message = out.toString();
			System.err.println(message + " unexpected token code " + e.getUnexpectedType());
		}

		public void reportThrowable(Throwable t, int line, int charPosInLine, int length) {
			System.err.println(t.getMessage() + " at line " + line + " position " + length);
		}

		public void recognitionException(RecognitionException e, String... tokenNames) {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			boolean first = true;
			for (String string : tokenNames) {
				String comma = first ? "" : ", ";
				first = false;
				builder.append(comma);
				builder.append(string);
			}
			builder.append("]");
			System.err.println("Recognition exception " + e.getMessage() + " "
					+ e.getUnexpectedType() + " for token names " + builder.toString());
		}

		public void illegalToken(CommonTree t, String message) {
			System.err.println("Illegal token " + t.getText() + " at line " + t.getLine()
					+ " position " + t.getCharPositionInLine() + ": " + message);
		}

		public void incompatibleSymbols(CommonTree parentExpression, CommonTree... expressions) {
			StringBuilder message = new StringBuilder("Incompatible children in "
					+ parentExpression.getText());
			boolean first = true;
			for (CommonTree token : expressions) {
				String comma = first ? "" : ", ";
				message.append(comma);
				first = false;
				message.append(token.getText());
			}
			System.err.println(message);
		}
	};

	public OPPLLintPlugin(IExtension extension, OWLEditorKit owlEditorKit) {
		if (extension == null) {
			throw new NullPointerException("The extension cannot be null");
		}
		if (owlEditorKit == null) {
			throw new NullPointerException("The OWL editor kit cannot be null");
		}
		this.extension = extension;
		this.owlEditorKit = owlEditorKit;
	}

	/**
	 * @see org.protege.editor.core.plugin.ProtegePlugin#getId()
	 */
	public String getId() {
		return this.extension.getUniqueIdentifier();
	}

	/**
	 * @see org.protege.editor.core.plugin.ProtegePlugin#getDocumentation()
	 */
	public String getDocumentation() {
		return JPFUtil.getDocumentation(this.extension);
	}

	/**
	 * @see org.protege.editor.core.plugin.ProtegePlugin#newInstance()
	 */
	public LintProtegePluginInstanceAdapter<OWLObject> newInstance() throws ClassNotFoundException,
			IllegalAccessException, InstantiationException {
		ExtensionInstantiator<OPPLLintScript> instantiator = new ExtensionInstantiator<OPPLLintScript>(
				this.extension) {
			@Override
			public OPPLLintScript instantiate() throws ClassCastException, InstantiationException,
					IllegalAccessException, ClassNotFoundException {
				String script = PluginUtilities.getAttribute(
						OPPLLintPlugin.this.extension,
						"script");
				OPPLLintParser parser = ProtegeParserFactory.getInstance(
						OPPLLintPlugin.this.owlEditorKit).build(OPPLLintPlugin.ERROR_LISTENER);
				OPPLLintScript lint = parser.parse(script);
				return lint;
			}
		};
		OPPLLintScript instantiated = instantiator.instantiate();
		LintProtegePluginInstanceAdapter<OWLObject> toReturn = instantiated != null ? LintProtegePluginInstanceAdapter.buildLintProtegePluginInstanceAdapter(
				instantiated,
				this.extension) : null;
		return toReturn;
	}
}

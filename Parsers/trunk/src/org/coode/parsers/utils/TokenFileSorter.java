/**
 * 
 */
package org.coode.parsers.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;

/**
 * @author Luigi Iannone
 * 
 */
public class TokenFileSorter {
	private final String path;
	private final List<Token> tokens = new ArrayList<Token>();

	/**
	 * @param path
	 */
	public TokenFileSorter(String path) {
		if (path == null) {
			throw new NullPointerException("The token file cannot be null");
		}
		this.path = path;
		this.parse();
	}

	protected void write(String outPath) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(new File(outPath));
		for (Token token : this.getTokens()) {
			writer.println(token.toString());
		}
		writer.close();
	}

	public void save() throws FileNotFoundException {
		this.write(this.getPath());
	}

	public void save(String outputPath) throws FileNotFoundException {
		this.write(outputPath);
	}

	private void parse() {
		this.tokens.clear();
		try {
			File file = new File(this.getPath());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			try {
				while ((line = reader.readLine()) != null) {
					Pattern pattern = Pattern.compile("(\\w*)\\s*=\\s*(\\w*)",
							Pattern.DOTALL);
					Matcher matcher = pattern.matcher(line);
					boolean matches = matcher.matches();
					if (matches) {
						final String tokenName = matcher.group(1);
						final int type = Integer.parseInt(matcher.group(2)
								.trim());
						this.tokens.add(new Token() {
							public void setType(int arg0) {
							}

							public void setTokenIndex(int arg0) {
							}

							public void setText(String arg0) {
							}

							public void setLine(int arg0) {
							}

							public void setInputStream(CharStream arg0) {
							}

							public void setCharPositionInLine(int arg0) {
							}

							public void setChannel(int arg0) {
							}

							public int getType() {
								return type;
							}

							public int getTokenIndex() {
								return -1;
							}

							public String getText() {
								return tokenName;
							}

							public int getLine() {
								return -1;
							}

							public CharStream getInputStream() {
								return null;
							}

							public int getCharPositionInLine() {
								// TODO Auto-generated method stub
								return 0;
							}

							public int getChannel() {
								return 0;
							}

							@Override
							public String toString() {
								return this.getText() + "=" + this.getType();
							}
						});
					}
				}
				Collections.sort(this.tokens, new Comparator<Token>() {
					public int compare(Token aToken, Token anotherToken) {
						return aToken.getType() - anotherToken.getType();
					}
				});
				reader.close();
			} catch (IOException e) {
				Logger.getLogger(this.getClass().getName()).log(Level.WARNING,
						"Could not read line " + e.getMessage());
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
					"The File could not be open " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		if (args.length >= 1) {
			String tokenFileName = args[0];
			TokenFileSorter tokenFileSorter = new TokenFileSorter(tokenFileName);
			try {
				if (args.length > 1) {
					tokenFileSorter.save(args[1]);
				} else {
					tokenFileSorter.save();
				}
			} catch (FileNotFoundException e) {
				Logger.getLogger(TokenFileSorter.class.getName()).log(
						Level.SEVERE,
						"The output File could not be open " + e.getMessage());
			}
		}
	}

	/**
	 * @return the file
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * @return the tokens
	 */
	public List<Token> getTokens() {
		return new ArrayList<Token>(this.tokens);
	}
}

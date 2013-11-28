package org.coode.parsers.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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

/** @author Luigi Iannone */
public class TokenFileSorter {
    private final String path;
    private final List<Token> tokens = new ArrayList<Token>();

    /** @param path */
    public TokenFileSorter(String path) {
        this.path = checkNotNull(path, "path");
        parse();
    }

    protected void write(String outPath) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(outPath));
        for (Token token : getTokens()) {
            writer.println(token.toString());
        }
        writer.close();
    }

    /** @throws FileNotFoundException */
    public void save() throws FileNotFoundException {
        write(getPath());
    }

    /** @param outputPath
     * @throws FileNotFoundException */
    public void save(String outputPath) throws FileNotFoundException {
        write(outputPath);
    }

    private void parse() {
        tokens.clear();
        try {
            File file = new File(getPath());
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
                        final int type = Integer.parseInt(matcher.group(2).trim());
                        tokens.add(new Token() {
                            @Override
                            public void setType(int arg0) {}

                            @Override
                            public void setTokenIndex(int arg0) {}

                            @Override
                            public void setText(String arg0) {}

                            @Override
                            public void setLine(int arg0) {}

                            @Override
                            public void setInputStream(CharStream arg0) {}

                            @Override
                            public void setCharPositionInLine(int arg0) {}

                            @Override
                            public void setChannel(int arg0) {}

                            @Override
                            public int getType() {
                                return type;
                            }

                            @Override
                            public int getTokenIndex() {
                                return -1;
                            }

                            @Override
                            public String getText() {
                                return tokenName;
                            }

                            @Override
                            public int getLine() {
                                return -1;
                            }

                            @Override
                            public CharStream getInputStream() {
                                return null;
                            }

                            @Override
                            public int getCharPositionInLine() {
                                // TODO Auto-generated method stub
                                return 0;
                            }

                            @Override
                            public int getChannel() {
                                return 0;
                            }

                            @Override
                            public String toString() {
                                return getText() + "=" + getType();
                            }
                        });
                    }
                }
                Collections.sort(tokens, new Comparator<Token>() {
                    @Override
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

    /** @param args */
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
                Logger.getLogger(TokenFileSorter.class.getName()).log(Level.SEVERE,
                        "The output File could not be open " + e.getMessage());
            }
        }
    }

    /** @return the file */
    public String getPath() {
        return path;
    }

    /** @return the tokens */
    public List<Token> getTokens() {
        return new ArrayList<Token>(tokens);
    }
}

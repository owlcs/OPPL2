package org.coode.parsers.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author Luigi Iannone */
public class TokenSync {
    private class TokenMap {
        private final String path;
        private final Map<Integer, String> map = new HashMap<Integer, String>();
        private final Map<String, Integer> inverseMap = new HashMap<String, Integer>();
        private int max = 0;

        /** @param path */
        public TokenMap(String path) {
            this.path = checkNotNull(path, "path");
            parse();
        }

        /** @return the path */
        public String getPath() {
            return path;
        }

        private void parse() {
            try {
                File file = new File(getPath());
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = null;
                map.clear();
                inverseMap.clear();
                max = 0;
                try {
                    while ((line = reader.readLine()) != null) {
                        Pattern pattern = Pattern.compile("(.*)=(.*)", Pattern.DOTALL);
                        Matcher matcher = pattern.matcher(line);
                        boolean matches = matcher.matches();
                        if (matches) {
                            final String tokenName = matcher.group(1);
                            final int type = Integer.parseInt(matcher.group(2));
                            map.put(type, tokenName);
                            inverseMap.put(tokenName, type);
                            max = Math.max(max, type);
                        }
                    }
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

        public void save() throws FileNotFoundException {
            write(getPath());
        }

        protected void write(String outPath) throws FileNotFoundException {
            PrintWriter writer = new PrintWriter(new File(outPath));
            Set<Integer> keySet = new TreeSet<Integer>(map.keySet());
            for (Integer type : keySet) {
                writer.println(map.get(type) + "=" + type);
            }
            writer.close();
        }

        public Set<Integer> getKeys() {
            return new HashSet<Integer>(map.keySet());
        }

        public String getTokenText(int key) {
            return map.get(key);
        }

        public Integer getType(String string) {
            return inverseMap.get(string);
        }

        public boolean containsTokenText(String string) {
            return inverseMap.get(string) != null;
        }

        public void sync(TokenMap reference) {
            checkNotNull(reference, "reference");
            for (Integer key : reference.getKeys()) {
                String tokenText = reference.getTokenText(key);
                Integer myKey = getType(tokenText);
                if (containsTokenText(tokenText) && !key.equals(myKey)) {
                    changeKey(tokenText, myKey, key);
                } else if (!isEmptyKey(key)
                        && tokenText.compareTo(getTokenText(key)) != 0) {
                    // If the key is occupied in this token map by some other
                    // token
                    max++;
                    max = Math.max(reference.getMax(), max);
                    String tokenText2move = getTokenText(key);
                    map.remove(key);
                    map.put(max, tokenText2move);
                    inverseMap.put(tokenText2move, max);
                }
            }
            removeDuplicates(reference);
        }

        /** @param reference */
        private void removeDuplicates(TokenMap reference) {
            for (Integer key : reference.getKeys()) {
                String tokenText = reference.getTokenText(key);
                this.removeDuplicates(key, tokenText);
            }
        }

        /** @param referenceKey
         * @param tokenText */
        private void removeDuplicates(Integer referenceKey, String tokenText) {
            for (Object thisKey : map.keySet().toArray()) {
                if (tokenText.compareTo(map.get(thisKey)) == 0
                        && !thisKey.equals(referenceKey)) {
                    map.remove(thisKey);
                    inverseMap.put(tokenText, referenceKey);
                }
            }
        }

        /** @param key
         * @return */
        private boolean isEmptyKey(Integer key) {
            return getTokenText(key) == null;
        }

        private void changeKey(String tokenText, Integer fromKey, Integer toKey) {
            String preExisting = map.get(toKey);
            if (preExisting != null) {
                // Need to move what is already there and swap it with the key
                // we are going to relocate
                map.put(fromKey, preExisting);
                inverseMap.put(preExisting, fromKey);
            }
            map.put(toKey, tokenText);
            inverseMap.put(tokenText, toKey);
        }

        /** @return the max */
        public int getMax() {
            return max;
        }
    }

    private final TokenMap referenceTokenMap;
    private final List<TokenMap> toSync = new ArrayList<TokenMap>();
    private boolean synced = false;

    /** @param referencePath
     * @param toSync
     * @param others */
    public TokenSync(String referencePath, String toSync, String... others) {
        checkNotNull(referencePath, "referencePath");
        checkNotNull(toSync, "toSync");
        referenceTokenMap = new TokenMap(referencePath);
        this.toSync.add(new TokenMap(toSync));
        for (String string : others) {
            this.toSync.add(new TokenMap(string));
        }
    }

    /** sync */
    public void sync() {
        if (!synced) {
            for (TokenMap tokenMap : toSync) {
                tokenMap.sync(referenceTokenMap);
            }
            synced = true;
        }
    }

    /** @throws FileNotFoundException */
    public void save() throws FileNotFoundException {
        this.save(false);
    }

    /** @param forceSync
     * @throws FileNotFoundException */
    public void save(boolean forceSync) throws FileNotFoundException {
        if (forceSync) {
            sync();
        }
        referenceTokenMap.save();
        for (TokenMap toSyncTokenMap : toSync) {
            toSyncTokenMap.save();
        }
    }

    /** @param args */
    public static void main(String[] args) {
        if (args.length >= 2) {
            String referenceTokenFileName = args[0];
            String toSync = args[1];
            List<String> asList = new ArrayList<String>(Arrays.asList(args));
            asList.remove(referenceTokenFileName);
            asList.remove(toSync);
            TokenSync tokenSync = new TokenSync(referenceTokenFileName, toSync,
                    asList.toArray(new String[asList.size()]));
            tokenSync.sync();
            try {
                tokenSync.save();
            } catch (FileNotFoundException e) {
                Logger.getLogger(TokenFileSorter.class.getName()).log(Level.SEVERE,
                        "The output File could not be open " + e.getMessage());
            }
        }
    }
}

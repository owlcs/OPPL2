package org.coode.parsers.utils;

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

public class TokenSync {
	private class TokenMap {
		private final String path;
		private final Map<Integer, String> map = new HashMap<Integer, String>();
		private final Map<String, Integer> inverseMap = new HashMap<String, Integer>();
		private int max = 0;

		/**
		 * @param path
		 */
		public TokenMap(String path) {
			if (path == null) {
				throw new NullPointerException("The token file cannot be null");
			}
			this.path = path;
			this.parse();
		}

		/**
		 * @return the path
		 */
		public String getPath() {
			return this.path;
		}

		private void parse() {
			try {
				File file = new File(this.getPath());
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = null;
				this.map.clear();
				this.inverseMap.clear();
				this.max = 0;
				try {
					while ((line = reader.readLine()) != null) {
						Pattern pattern = Pattern.compile("(.*)=(.*)", Pattern.DOTALL);
						Matcher matcher = pattern.matcher(line);
						boolean matches = matcher.matches();
						if (matches) {
							final String tokenName = matcher.group(1);
							final int type = Integer.parseInt(matcher.group(2));
							this.map.put(type, tokenName);
							this.inverseMap.put(tokenName, type);
							this.max = Math.max(this.max, type);
						}
					}
					reader.close();
				} catch (IOException e) {
					Logger.getLogger(this.getClass().getName()).log(
							Level.WARNING,
							"Could not read line " + e.getMessage());
				}
			} catch (FileNotFoundException e) {
				Logger.getLogger(this.getClass().getName()).log(
						Level.SEVERE,
						"The File could not be open " + e.getMessage());
			}
		}

		public void save() throws FileNotFoundException {
			this.write(this.getPath());
		}

		protected void write(String outPath) throws FileNotFoundException {
			PrintWriter writer = new PrintWriter(new File(outPath));
			Set<Integer> keySet = new TreeSet<Integer>(this.map.keySet());
			for (Integer type : keySet) {
				writer.println(this.map.get(type) + "=" + type);
			}
			writer.close();
		}

		public Set<Integer> getKeys() {
			return new HashSet<Integer>(this.map.keySet());
		}

		public String getTokenText(int key) {
			return this.map.get(key);
		}

		public Integer getType(String string) {
			return this.inverseMap.get(string);
		}

		public boolean containsTokenText(String string) {
			return this.inverseMap.get(string) != null;
		}

		public void sync(TokenMap reference) {
			if (reference == null) {
				throw new NullPointerException("The reference cannot be null");
			}
			for (Integer key : reference.getKeys()) {
				String tokenText = reference.getTokenText(key);
				Integer myKey = this.getType(tokenText);
				if (this.containsTokenText(tokenText) && myKey != key) {
					this.changeKey(tokenText, myKey, key);
				} else if (!this.isEmptyKey(key)
						&& tokenText.compareTo(this.getTokenText(key)) != 0) {
					// If the key is occupied in this token map by some other
					// token
					this.max++;
					this.max = Math.max(reference.getMax(), this.max);
					String tokenText2move = this.getTokenText(key);
					this.map.remove(key);
					this.map.put(this.max, tokenText2move);
					this.inverseMap.put(tokenText2move, this.max);
				}
			}
			removeDuplicates(reference);
		}

		/**
		 * @param reference
		 */
		private void removeDuplicates(TokenMap reference) {
			for (Integer key : reference.getKeys()) {
				String tokenText = reference.getTokenText(key);
				this.removeDuplicates(key, tokenText);
			}
		}

		/**
		 * @param referenceKey
		 * @param tokenText
		 */
		private void removeDuplicates(Integer referenceKey, String tokenText) {
			for (Integer thisKey : new HashSet<Integer>(this.map.keySet())) {
				if (tokenText.compareTo(this.map.get(thisKey)) == 0 && thisKey != referenceKey) {
					this.map.remove(thisKey);
					this.inverseMap.put(tokenText, referenceKey);
				}
			}
		}

		/**
		 * @param key
		 * @return
		 */
		private boolean isEmptyKey(Integer key) {
			return this.getTokenText(key) == null;
		}

		private void changeKey(String tokenText, Integer fromKey, Integer toKey) {
			String preExisting = this.map.get(toKey);
			if (preExisting != null) {
				// Need to move what is already there and swap it with the key
				// we are going to relocate
				this.map.put(fromKey, preExisting);
				this.inverseMap.put(preExisting, fromKey);
			}
			this.map.put(toKey, tokenText);
			this.inverseMap.put(tokenText, toKey);
		}

		/**
		 * @return the max
		 */
		public int getMax() {
			return this.max;
		}
	}

	private final TokenMap referenceTokenMap;
	private final List<TokenMap> toSync = new ArrayList<TokenMap>();
	private boolean synced = false;

	public TokenSync(String referencePath, String toSync, String... others) {
		if (referencePath == null) {
			throw new NullPointerException("The reference path cannot be null");
		}
		if (toSync == null) {
			throw new NullPointerException("The toSync path cannot be null");
		}
		this.referenceTokenMap = new TokenMap(referencePath);
		this.toSync.add(new TokenMap(toSync));
		for (String string : others) {
			this.toSync.add(new TokenMap(string));
		}
	}

	public void sync() {
		if (!this.synced) {
			for (TokenMap tokenMap : this.toSync) {
				tokenMap.sync(this.referenceTokenMap);
			}
			this.synced = true;
		}
	}

	public void save() throws FileNotFoundException {
		this.save(false);
	}

	public void save(boolean forceSync) throws FileNotFoundException {
		if (forceSync) {
			this.sync();
		}
		this.referenceTokenMap.save();
		for (TokenMap toSyncTokenMap : this.toSync) {
			toSyncTokenMap.save();
		}
	}

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
				Logger.getLogger(TokenFileSorter.class.getName()).log(
						Level.SEVERE,
						"The output File could not be open " + e.getMessage());
			}
		}
	}
}

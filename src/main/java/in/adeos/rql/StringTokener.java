package in.adeos.rql;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * The StringTokener class provides a method to break a string into tokens
 * 
 * @author Ankit Raj
 * @since 1.0.0
 */
public class StringTokener {

	private static final String EXCLUDE = "exclude";

	private Reader reader;
	
	/**
	 * Constructs instance that uses RQL String
	 * 
	 * @param s RQL String
	 */
	public StringTokener(String s) {
		this.reader = new StringReader(s);
	}
	
	/**
	 * Method to deserialize RQL String
	 * 
	 * @return FilterToken object which is a root node of a Tree
	 * @throws Exception
	 */
	public FilterToken deserialize() throws Exception {
		FilterToken root = new FilterToken("root");
		nextFilter(root);
		return root;
	}

	private void nextFilter(FilterToken root) throws Exception {
		while (true) {
			char c = next();
			switch (c) {
			case '{':
				processFilterToken(root);
				return;
			case '[':
				setExclude(root);
			}
		}
	}

	private void processFilterToken(FilterToken filter) throws Exception {
		StringBuilder sb = new StringBuilder();
		while (true) {
			char c = next();
			switch (c) {
			case ',':
				filter.getProperties().add(sb.toString());
				sb.delete(0, sb.length());
				break;
			case ':':
				FilterToken child = new FilterToken(sb.toString());
				filter.getChildren().put(sb.toString(), child);
				nextFilter(child);
				break;
			case '}':
				filter.getProperties().add(sb.toString());
				return;
			default:
				sb.append(c);
			}
		}
	}

	private void setExclude(FilterToken filter) throws Exception {
		StringBuilder sb = new StringBuilder();
		while (true) {
			char c = next();
			switch (c) {
			case ']':
				filter.setExclude(isExcluded(sb.toString()));
				return;
			default:
				sb.append(c);
			}
		}
	}

	private boolean isExcluded(String str) {
		return EXCLUDE.equals(str);
	}

	private char next() throws Exception {
		int c;
		try {
			c = this.reader.read();
		} catch (IOException exc) {
			throw new Exception(exc);
		}

		if (c <= 0) { // End of stream
			return 0;
		}

		return (char) c;
	}
}

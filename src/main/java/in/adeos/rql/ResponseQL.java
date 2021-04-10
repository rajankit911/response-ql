package in.adeos.rql;

/**
 * Response Query Language class provides parsing method to deserialize RQL string into tree node
 * 
 * @author Ankit Raj
 * @since 1.0.0
 */

public class ResponseQL {
	
	/**
	 * Method to deserialize RQL String as tree expressed using set of {@link FilterNode} instances.
	 * 
	 * @param arg RQL String from client
	 * @return FilterToken object which is a root node of a Tree
	 * @throws Exception
	 */
	public static FilterToken parse(String arg) throws Exception {
		StringTokener stringTokener = new StringTokener(arg);
		return stringTokener.deserialize();
	}
}

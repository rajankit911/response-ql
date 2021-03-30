package in.adeos.rql;

public class ResponseQL {
	
	public static FilterToken parse(String arg) throws Exception {
		StringTokener jsonToken = new StringTokener(arg);
		return jsonToken.deserialize();
	}
}

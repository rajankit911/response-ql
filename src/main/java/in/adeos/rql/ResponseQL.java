package in.adeos.rql;

public class ResponseQL {
	
	public static FilterToken parse(String arg) throws Exception {
		StringTokener stringTokener = new StringTokener(arg);
		return stringTokener.deserialize();
	}
}

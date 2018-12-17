package com.dikshatech.tst.utilitieslib;

import java.util.HashMap;
import java.util.Map;

public class Parameter {

	public static Map<String, String> loginParam() {
		Map<String, String> login = new HashMap<>();
		login.put("callback", "callback");
		login.put("password", "Lynx");
		login.put("method", "login");
		login.put("cType", "LOGIN");
		login.put("device", "html");
		login.put("origin", "xmlp");
		return login;
	}

	public static Map<String, String> homeParam() {
		Map<String, String> login = new HashMap<>();
		login.put("callback", "callback");
		login.put("password", "");
		login.put("method", "login");
		login.put("cType", "LOGIN");
		login.put("device", "html");
		login.put("origin", "xmlp");
		return login;
	}

	public static Map<String, String> logoutParam() {
		Map<String, String> logout = new HashMap<>();
		logout.put("callback", "callback");
		logout.put("method", "logout");
		logout.put("origin", "xmlp");
		return logout;
	}

	public static Map<String, String> timesheetParam() {
		Map<String, String> login = new HashMap<>();
		login.put("callback", "callback");
		login.put("rType", "RECEIVEALLTIMESHEET");
		login.put("method", "receive");
		login.put("cType", "TIMESHEET");
		login.put("origin", "xmlp");
		return login;
	}

	public static Map<String, String> leavesParam() {
		Map<String, String> login = new HashMap<>();
		login.put("callback", "callback");
		login.put("password", "");
		login.put("method", "");
		login.put("cType", "LOGIN");
		login.put("device", "html");
		login.put("origin", "xmlp");
		return login;
	}
}

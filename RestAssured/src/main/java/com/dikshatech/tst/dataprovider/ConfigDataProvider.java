package com.dikshatech.tst.dataprovider;

import java.io.FileInputStream;
import java.util.Properties;

import com.dikshatech.tst.pagefatory.TestBase;

public class ConfigDataProvider extends TestBase{

	protected static  Properties prop;

	protected ConfigDataProvider() {}
	static {
		try {
			FileInputStream FIS = new FileInputStream("src/main/java/com/dikshatech/tst/configuration/config.properties");
			setProp(new Properties());
			getProp().load(FIS);
		} catch (Exception e) {
			logger.info("Exception is " + e.getMessage());
		}
	}

	public static String getUrl() {
		return getProp().getProperty("url");
	}

	public static String getlinuxChromePath() {
		return getProp().getProperty("linuxchromePath");
	}
	
	public static String getwindowChromePath() {
		return getProp().getProperty("windowchromePath");
	}

	public static String getFirefoxPath() {
		return getProp().getProperty("FirefoxPath");
	}

	public static String getIEPath() {
		return getProp().getProperty("IEPath");
	}

	public static String getBroswer() {
		return getProp().getProperty("browser");
	}

	public static String loginExcel() {
		return getProp().getProperty("logincredential");
	}

	public static String leavesExcel() {
		return getProp().getProperty("leavesheet");
	}

	public static String perdiemreportID() {
		return getProp().getProperty("perdiemreport_Id");
	}

	public static String getleaveUrl() {
		return getProp().getProperty("leaveurl");
	}

	public static String get(String key) {
		return getProp().getProperty(key);
	}

	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		ConfigDataProvider.prop = prop;
	}
}
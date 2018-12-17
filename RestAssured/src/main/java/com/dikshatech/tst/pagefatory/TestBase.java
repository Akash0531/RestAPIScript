package com.dikshatech.tst.pagefatory;

import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.json.XML;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import org.json.JSONObject;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.utilitieslib.GetterSetter;
import com.dikshatech.tst.utilitieslib.Parameter;
import com.dikshatech.tst.utilitieslib.Path;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public abstract class TestBase {

	public static final Logger logger = Logger.getLogger(TestBase.class);
	public static ExtentReports report;
	public static ExtentTest exlogger;
	public static JSONObject loginResp;
	public static GetterSetter pojo = new GetterSetter();
	public static JSONObject logoutResp;

	/**
	 * Method to validate the get response Status Code using Rest Assured
	 **/
	public static void setEndpointURL() {
		RestAssured.urlEncodingEnabled = false;
		RestAssured.baseURI = ConfigDataProvider.getProp().getProperty("baseURL");
		// RestAssured.basePath= ConfigDataProvider.getProp().getProperty("basePath");
	}

	public static void getloginStatus(String lynxUsername) {
		Response resp = given().params(Parameter.loginParam()).param("userName", lynxUsername).when()
				.get(Path.LOGIN_RESOURCE_PATH);
		int respStatus = resp.getStatusCode();
		softassert().assertEquals(respStatus, 200);
		loginResp = XML.toJSONObject(resp.asString());
		logger.info("Status code is : " + respStatus);
	}

	@BeforeTest(alwaysRun = true)
	public static void reportIntializer() {
		report = new ExtentReports(ConfigDataProvider.getProp().getProperty("loggerpath"), true);
		report.addSystemInfo("Host Name", "Lynx").addSystemInfo("Environment", "Automation_Testing")
				.addSystemInfo("User Name", System.getProperty("user.name"));
		exlogger = report.startTest("Validation Report");
		setEndpointURL();
	}

	@AfterMethod(alwaysRun = true, description = "Capturing the snapshot whenever any Testcase failed with some info")
	public void faliure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.info("Test Case Failed and name of the test case is: " + result.getName());
			exlogger.log(LogStatus.FAIL, result.getName() + " Verification is failed.");
		}
	}

	/**
	 * Method to convert other format response to accept it as JSON
	 **/
	public static Response jsonConverter(String endpoint) {
		RestAssured.defaultParser = Parser.JSON;

		return given().headers("Content-Type", "application/json", "Accept", "application/json").when().get(endpoint)
				.then().contentType("text/html").extract().response();
	}

	@AfterSuite(alwaysRun = true)
	public void extentreport() {
		report.endTest(exlogger);
		report.flush();
		report.close();
	}

	/**
	 * Method to validate the Logout response Status Code using Rest Assured
	 **/
	public static String getLogoutstatus() {
		Response resp = given().params(Parameter.logoutParam()).when().get(Path.LOGOUT_RESOURCE_PATH);
		int logoutStsCode = resp.getStatusCode();
		softassert().assertEquals(logoutStsCode, 200);
		logoutResp = XML.toJSONObject(resp.asString());
		String logoutSts = logoutResp.getString("actionForm");
		logger.info("Status code for logout is " + logoutStsCode + " and application is successfully " + logoutSts);
		return logoutSts;
	}

	public static void waitfor(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (Exception e) {

			logger.info(e.getMessage());
		}
	}

	public static float floatconversion(String s) {
		return Float.parseFloat(s);
	}

	public static ExcelReadData excelreaddata() {
		return new ExcelReadData(ConfigDataProvider.getProp().getProperty("excelname"));
	}

	public static SoftAssert softassert() {
		return new SoftAssert();
	}

	@DataProvider(name = "logindata")
	public static Object[][] testDataFeed() {
		int rowCount = excelreaddata().rowCount("Login_Credentials");
		Object[][] userName = new Object[rowCount - 1][1];
		for (int i = 0; i < rowCount - 1; i++) {
			userName[i][0] = excelreaddata().getData("Login_Credentials", i + 1, 5);
		}
		return userName;
	}

}

package com.diksha.tst.TestScripts;

import org.testng.annotations.Test;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.objectrepository.LoginObject;
import com.dikshatech.tst.pagefatory.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import org.json.JSONObject;
import org.json.XML;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * Rest API test cases for login response using Rest Assured.
 */
public class LoginAPI extends TestBase {

	public static String domainID = "@dikshatech.com";
	public static String passeduserName;

	/**
	 * Method to validate the valid and Invalid user
	 **/
	@Test(dataProvider = "logindata", priority = 0, enabled = true)
	public static void userValidation(String uName) {
		getloginStatus(uName + domainID);
		passeduserName = uName;
		String status = LoginObject.checkValiduser();
		if (status.equals("Valid")) {
			logger.info("Valid User invoked");
		} else {
			String errormsg = loginResp.getJSONObject("actionForm").getString("errors");
			JSONObject actionForm = loginResp.getJSONObject("actionForm");
			JSONObject result = actionForm.getJSONObject("result");
			String invaliduName = result.getString("userName");
			logger.error(errormsg + " :- " + invaliduName);
		}
	}

	@Test(priority = 1, enabled = true)
	public void logoutValidation() {
		String logoutstatus = getLogoutstatus();
		softassert().assertEquals(logoutstatus, "logout");
	}

	@Test(priority = 2, enabled = true)
	public static void loginStatus() {
		String status = LoginObject.checkValiduser();
		if (status.equals("Valid")) {
			logger.info("Valid User invoked");
		} else {
			String errormsg = loginResp.getJSONObject("actionForm").getString("errors");
			JSONObject actionForm = loginResp.getJSONObject("actionForm");
			JSONObject result = actionForm.getJSONObject("result");
			String invaliduName = result.getString("userName");
			logger.error(errormsg + " :- " + invaliduName);
			System.exit(0);
		}
	}

	/**
	 * Method to convert XML to JSON and validate the key components value.
	 **/
	@Test(priority = 3, enabled = true)
	public static void loginAPI() {
		RestAssured.urlEncodingEnabled = false;
		LoginObject.setLogindetails(16);
		String userName = loginResp.getJSONObject("actionForm").getString("userName");
		String mailId = loginResp.getJSONObject("actionForm").getString("officialEmaiID");
		String designation = loginResp.getJSONObject("actionForm").getString("designation");
		logger.info("Full Name of the logged in user is " + userName);
		logger.info("Username of the logged in user is " + pojo.getUserName());

		Assert.assertEquals(loginResp.getJSONObject("actionForm").get("login"), true);
		Assert.assertEquals(userName, pojo.getFullName());
		Assert.assertEquals(mailId, pojo.getOfficialMailID());
		Assert.assertEquals(designation, pojo.getDesignation());
		exlogger.log(LogStatus.PASS, "EX Workinmg");
	}

	/**
	 * Method to validate the CEO modules & fetaures access.
	 **/
	@Test(priority = 4, enabled = true)
	public static void moduleAccessValidation() {

		LoginObject.validateuserRoles();
	}

	/**
	 * Method to receive the JSON response and validate the key components value.
	 **/
	@Test(priority = 5, enabled = false)
	public static void weatherResponse() {
		RestAssured.urlEncodingEnabled = false;

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("Hyderabad");

		ResponseBody<?> respbody = response.body();
		logger.info(respbody.asString());
		Assert.assertEquals(respbody.asString().contains("Hyderabad"), true);

		JsonPath jsonPathEvaluator = response.jsonPath();

		String city = jsonPathEvaluator.get("City");

		logger.info("City name is " + city);
		Assert.assertEquals(city, "Hyderabad");
	}

	/**
	 * Method to convert XML to JSON with an proper Indentation
	 **/
	@Test(priority = 6, enabled = false)
	public static void jsonData() {
		RestAssured.urlEncodingEnabled = false;

		RequestSpecification request = RestAssured.given();
		Response response = request.get(ConfigDataProvider.getProp().getProperty("loginUrl"));
		ResponseBody<?> respbody = response.getBody();
		int indentFACTOR = 4;
		String stringResponse = respbody.asString();
		JSONObject xmlJSONObj = XML.toJSONObject(stringResponse);
		// logger.info(xmlJSONObj);
		String jsonString = xmlJSONObj.toString(indentFACTOR);
		// logger.info(jsonString);
	}

	@Test(priority = 4, enabled = false)
	public void getModule() {

	}
}

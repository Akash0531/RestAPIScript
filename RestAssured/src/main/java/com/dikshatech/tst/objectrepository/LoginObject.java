package com.dikshatech.tst.objectrepository;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

import com.diksha.tst.TestScripts.LoginAPI;
import com.dikshatech.tst.pagefatory.TestBase;
import com.dikshatech.tst.utilitieslib.Permission;

public class LoginObject extends TestBase {

	public static void setLogindetails(int row) {
		int cellCount = excelreaddata().cellCount("Login_Credentials", row);
		String[] details = new String[cellCount];
		for (int i = 0; i < cellCount; i++) {
			details[i] = excelreaddata().getData("Login_Credentials", row, i);
		}
		pojo.setFullName(details[0]);
		pojo.setUserName(details[1]);
		pojo.setOfficialMailID(details[3]);
		pojo.setDesignation(details[4]);
	}

	public static String checkValiduser() {
		int rowCount = excelreaddata().rowCount("Login_Credentials");
		String userName = "";
		String returntype = "";
		int count = 0;
		for (int i = 1; i < rowCount; i++) {
			userName = excelreaddata().getData("Login_Credentials", i, 1);
			if (userName.equals(LoginAPI.passeduserName)) {
				returntype = "Valid";
				count++;
				break;
			}
		}
		if (count == 0) {
			returntype = "Invalid";
		}
		return returntype;
	}

	public static int[] getModulespermission() {
		JSONObject actionForm = loginResp.getJSONObject("actionForm");
		JSONObject roles = actionForm.getJSONObject("roles");
		JSONArray modules = roles.getJSONArray("modules");
		int[] modID = null;
		if (modules != null && modules.length() > 0) {
			modID = new int[modules.length()];
			for (int i = 0; i < modules.length(); i++) {
				JSONObject jsonObj = modules.getJSONObject(i);
				modID[i] = jsonObj.getInt("moduleId");
				/*
				 * if(i>0) { modName[i]= jsonObj.getString("moduleName"); }
				 */
			}
		}
		return modID;
	}

	public static int[] getfeaturesPermission() {
		JSONObject actionForm = loginResp.getJSONObject("actionForm");
		JSONObject roles = actionForm.getJSONObject("roles");
		JSONArray modules = roles.getJSONArray("modules");
		int[] featuresID = new int[150];
		int count = 0;
		if (modules != null && modules.length() > 0) {
			for (int i = 0; i < modules.length(); i++) {
				JSONObject jsonObj = modules.getJSONObject(i);
				if (jsonObj.optJSONArray("features") != null) {
					JSONArray features = jsonObj.getJSONArray("features");
					if (features != null && features.length() > 0) {
						for (int j = 0; j < features.length(); j++) {
							JSONObject jsonObj1 = features.getJSONObject(j);
							featuresID[count] = jsonObj1.getInt("featureId");
							count++;
						}
					}
				} else {
					JSONObject jobj = jsonObj.getJSONObject("features");
					featuresID[count] = jobj.getInt("featureId");
					count++;
				}
			}
		}
		return featuresID;
	}

	public static void moduleAccessValidation(int[] expModulesID) {

		boolean compStatus = false;
		int[] actModulesID = LoginObject.getModulespermission();
		if (actModulesID != null && actModulesID.length > 0) {
			Arrays.sort(actModulesID);
			Arrays.sort(expModulesID);
			if (actModulesID.length == expModulesID.length) {
				for (int i = 0; i < actModulesID.length; i++) {
					if (actModulesID[i] == expModulesID[i]) {
						compStatus = true;
					}
				}
			}
			if (compStatus) {
				logger.info("The logged in user has required modules permission");
			} else {
				logger.error("The logged in user has unauthorized modules permission");

			}
		}
	}

	public static void validateuserRoles() {
		String designation = loginResp.getJSONObject("actionForm").getString("divisionName") + " "
				+ loginResp.getJSONObject("actionForm").getString("designation");
		if (!designation.isEmpty()) {
			switch (designation) {
			case "Corp CEO":
				int[] ceoModulesID = Permission.getceomoduleID();
				moduleAccessValidation(ceoModulesID);
				break;
			case "RMG Manager":
				int[] rmgManagerModulesID = Permission.getRMGManagermoduleID();
				moduleAccessValidation(rmgManagerModulesID);
				break;
			case "RMG Senior Specialist":
				int[] rmgSPOCModulesID = Permission.getRMGSPOCmoduleID();
				moduleAccessValidation(rmgSPOCModulesID);
				break;
			case "Finance and Operations Manager":
				int[] finManagerModulesID = Permission.getFinanceManagermoduleID();
				moduleAccessValidation(finManagerModulesID);
				break;
			case "Finance and Operations Senior Analyst":
				int[] finAnalystModulesID = Permission.getFinanceAnalystmoduleID();
				moduleAccessValidation(finAnalystModulesID);
				break;
			default:
				logger.error("No Such Roles/Designation defined");
				break;
			}
		}
		/*
		 * if (pojo.getDesignation().equals(designation)) { int[] ceoModulesID =
		 * Permission.getceomoduleID(); moduleAccessValidation(ceoModulesID); } else if
		 * (pojo.getDesignation().equals(designation)) { int[] rmgMangerModulesID =
		 * Permission.getRMGManagermoduleID();
		 * moduleAccessValidation(rmgMangerModulesID); }
		 */
	}

}

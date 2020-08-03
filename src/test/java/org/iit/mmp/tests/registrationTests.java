package org.iit.mmp.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.iit.mmp.helper.helperClass;
import org.iit.mmp.patientModulePages.registrationPage;
import org.iit.mmp.util.testBase;

public class registrationTests extends testBase {
	helperClass hObj;
	registrationPage rp;
	@Parameters("url")
	@Test(priority = 1,description="tc_001 Validation of Registration Functionality",groups={"US_001","regression","sanity"})
	public void validateRegistration(String url) throws InterruptedException {
		hObj = new helperClass(driver);
		rp = new registrationPage(driver);
		hObj.launchHomePage(url);
		hObj.clickOnRegisterLink();
		HashMap<String, String> hmap = rp.fillregisterPatientForm();
		for (Map.Entry<String, String> mapElement : hmap.entrySet()) {
			String key = (String) mapElement.getKey();
			String value = (String) mapElement.getValue();
			System.out.println(key + " : " + value);
		}
		String expected = "Thank you for registering with MMP.";
		String actual = rp.registrationCompleteAlertMessage();
		Assert.assertEquals(actual.trim(), expected, actual);
		System.out.println("The registration successful message is " + actual);
	}
	@Parameters("patientLoginUrl")
	@Test(priority = 2,description="tc_002 Validation of PatientLogin Functionality",groups={"US_002","regression","sanity"})
	public void validatePatientLoginAlertMessageBeforeApproval(String patientLoginUrl) throws InterruptedException {
		String expected = "Admin Approval is pending.";
		String actual = rp.patientLoginAlertMessageBeforeApproval(patientLoginUrl);
		Assert.assertEquals(actual.trim(), expected, actual);
		System.out.println("The alert message when patient logs in before admin approves is  " + actual);
	}
	@Parameters({ "url", "uName", "pWord" })
	@Test(priority = 3,description="tc_003 Validation of AdminLogin Functionality",groups={"US_003","regression","sanity"})
	public void validateAdminLoginAlertMessageAfterApproval(String url, String uName, String pWord) throws Exception {
		String expected = "USER has been updated.";
		String actual = rp.adminApprovalAlertMessage(url, uName, pWord);
		Assert.assertEquals(actual.trim(), expected, actual);
		System.out.println("The alert message when admin logs in to approves is  " + actual);
	}
	@Parameters({"patientLoginUrl","tc_Name"})
	@Test(priority = 4,description="tc_004 Validation of PatientLogin Functionality",groups={"US_002","regression","sanity"})
	public void validatePatientLoginAlertMessageAfterApproval(String patientLoginUrl, String tc_Name) throws InterruptedException, IOException {
		String actual = "Patient Portal";
		String expected = rp.validatePatientLoginAfterApproval(patientLoginUrl,tc_Name);
		Assert.assertEquals(actual, expected);
		System.out.println("The panel title when patient logs in after admin's approval is  " + expected);
	}
}
package org.iit.mmp.patientmodule.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientModulePages.PateintRegistrationPage;
import org.iit.mmp.util.TestBase;
public class PatientRegistrationTests extends TestBase {
	HelperClass hObj;
	PateintRegistrationPage rp;
	@Parameters("url")
	@Test(priority = 1,description="TC_001 Validation of Registration Functionality",groups=("PatientRegistrationTests"))
	public void validateRegistration(String url) throws InterruptedException {
		hObj = new HelperClass(driver);
		rp = new PateintRegistrationPage(driver);
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
	@Test(priority = 2,description="TC_002 Validation of PatientLogin Functionality",groups=("PatientRegistrationTests"))
	public void validatePatientLoginAlertMessageBeforeApproval(String patientLoginUrl) throws InterruptedException {
		String expected = "Admin Approval is pending.";
		String actual = rp.patientLoginAlertMessageBeforeApproval(patientLoginUrl);
		Assert.assertEquals(actual.trim(), expected, actual);
		System.out.println("The alert message when patient logs in before admin approves is  " + actual);
	}
	
	@Parameters({"patientLoginUrl","tc_Name"})
	@Test(priority = 3,dependsOnGroups = {"AdminTests"},description="TC_003 Validation of PatientLogin Functionality",groups=("PatientRegistration"))
	public void validatePatientLoginAlertMessageAfterApproval(String patientLoginUrl, String tc_Name) throws InterruptedException, IOException {
		String actual = "Patient Portal";
		String expected = rp.validatePatientLoginAfterApproval(patientLoginUrl,tc_Name);
		Assert.assertEquals(actual, expected);
		System.out.println("The panel title when patient logs in after admin's approval is  " + expected);
	}
}
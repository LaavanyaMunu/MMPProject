package org.iit.mmp.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import java.util.HashMap;
import java.util.Map;
import org.iit.mmp.helper.helperClass;
import org.iit.mmp.patientModulePages.registrationPage;
import org.iit.mmp.util.testBase;

public class registrationTests extends testBase{
	helperClass hObj ;
	registrationPage rp;
	@Parameters("url")
	@Test(priority = 1)
	public void validateRegistration(String url) throws InterruptedException {
		hObj = new helperClass(driver);
		 rp= new registrationPage(driver);
		hObj.launchHomePage(url);
		hObj.clickOnRegisterLink();
		HashMap<String,String> hmap = rp.fillregisterPatientForm();
		 for (Map.Entry<String,String> mapElement : hmap.entrySet()) { 
	            String key = (String)mapElement.getKey();
	            String value = (String)mapElement.getValue(); 
	  
	            System.out.println(key + " : " + value); 
		 }
		String expected = "Thank you for registering with MMP.";
		String actual = rp.registrationCompleteAlertMessage();
		Assert.assertEquals(actual.trim(),expected, actual);
		System.out.println("The registration successful message is "+ actual);	
		
		}
	
	@Parameters("patientLoginUrl")
	@Test(priority =2) 
	  public void validatePatientLoginAlertMessageBeforeApproval(String patientLoginUrl) throws InterruptedException {
	  String expected ="Admin Approval is pending.";
	  String actual =rp.patientLoginAlertMessageBeforeApproval(patientLoginUrl); 
	  Assert.assertEquals(actual.trim(),expected, actual);
	  System.out.println("The alert message when patient logs in before admin approves is  "+ actual );
	  }
	  @Parameters({"url", "uName","pWord"})
	  @Test(priority =3) 
	  public void validateAdminLoginAlertMessageAfterApproval(String url,String uName, String pWord) throws Exception {
	  String expected ="USER has been updated.";
	  String actual =rp.adminApprovalAlertMessage(url,uName,pWord);
	  Assert.assertEquals(actual.trim(),expected,actual);
	  System.out.println("The alert message when admin logs in to approves is  "+ actual ); 
	  }
	@Parameters("patientLoginUrl")
	@Test(priority =4) 
	  public void validatePatientLoginAlertMessageAfterApproval(String patientLoginUrl) throws InterruptedException {
	  String actual = "Patient Portal";
	  String expected = rp.validatePatientLoginAfterApproval(patientLoginUrl);
	  Assert.assertEquals(actual, expected);
	  System.out.println("The panel title when patient logs in after admin's approval is  "+ expected );
	  }	  
}

package org.iit.mmp.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import org.iit.mmp.helper.helperClass;
import org.iit.mmp.patientModulePages.registrationPage;
import org.iit.mmp.util.testBase;

public class registrationTests extends testBase{
	//WebDriver driver;
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
		String actual = "Thank you for registering with MMP.";
		String expected = rp.registrationCompleteAlertMessage();
		Assert.assertEquals(expected.trim(), actual);
		}
	@Test(priority =2) 
	  public void validatePatientLoginAlertMessageBeforeApproval() throws InterruptedException {
	  //rp.patientLoginAlertMessageBeforeApproval(); 
	  String actual ="Admin Approval is pending.";
	  String expected =rp.patientLoginAlertMessageBeforeApproval(); 
	  Assert.assertEquals(expected.trim(),actual);
	  System.out.println("The alert message when patient logs in before admin approves is  "+ expected );
	  }
	@Parameters("url")
	@Test(priority =3) 
	  public void validateAdminLoginAlertMessageAfterApproval(String url) throws Exception {
	  //rp.adminApprovalAlertMessage(url); 
	  String actual ="Patient is updated.";
	  String expected =rp.adminApprovalAlertMessage(url); 
	  Assert.assertEquals(expected.trim(),actual);
	  System.out.println("The alert message when admin logs in to approves is  "+ expected );
	  }
	@Test(priority =4) 
	  public void validatePatientLoginAlertMessageAfterApproval() throws InterruptedException {
	  //rp.patientLoginAlertMessageAfterApproval(); 
	  String actual ="Admin Approval is pending.";
	  String expected =rp.patientLoginAlertMessageAfterApproval(); 
	  Assert.assertEquals(expected.trim(),actual);
	  System.out.println("The alert message when patient logs in after admin's approval is  "+ expected );
	  }
	  
	 

	}
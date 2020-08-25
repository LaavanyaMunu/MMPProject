package org.iit.mmp.adminmodule.tests;
import org.iit.mmp.AdminModulePages.AdminModuleRegisteredPatientApprovalPage;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class RegisteredPatientApprovalTests extends TestBase{
	HelperClass helperObj;
	AdminModuleRegisteredPatientApprovalPage adminApproval;
	@Parameters({"url", "uName", "pWord"})
	@Test(priority=3, description="ATC_001 Validation of AdminLogin Functionality",groups=("AdminTests"))
	public void validateAdminLoginAlertMessageAfterApproval(String url , String uName, String pWord) throws Exception {
		helperObj = new HelperClass(driver);
		adminApproval= new AdminModuleRegisteredPatientApprovalPage(driver);
		helperObj.launchHomePage(url);
		helperObj.launchAdminLoginPage(uName, pWord);
		String actual = adminApproval.adminApprovalAlertMessage();
		String expected = "USER has been updated.";
		Assert.assertEquals(actual.trim(), expected, actual);
		System.out.println("The alert message when admin logs in to approves is  " + actual);
	}
}


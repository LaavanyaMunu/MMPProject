 package org.iit.mmp.patientModulePages;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.iit.mmp.helper.helperClass;
import org.iit.mmp.util.appLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class registrationPage {
	 
	WebDriver driver;
	helperClass helperObj ;
	int noOfChars = 4;
	
	By FirstName = By.xpath("//input[@id='firstname']");
	By LastName = By.id("lastname");
	By DOB = By.id("datepicker");
	By license = By.id("license");
	By ssn = By.id("ssn");
	By state = By.id("state");
	By city = By.id("city");
	By address = By.id("address");
	By zip = By.id("zipcode");
	By age = By.id("age");
	By height = By.id("height");
	By weight = By.id("weight");
	By pharmacy = By.id("pharmacy");
	By pharAddress = By.id("pharma_adress");
	By email = By.id("email");
	By pwd = By.id("password");
	By uname = By.id("username");
	By confirmpwd = By.id("confirmpassword");
	By security = By.id("security");
	By ans = By.id("answer");
	
	
	HashMap<String,String> registrationMap = new HashMap<String,String>();
	
	public registrationPage(WebDriver driver)
	{
		this.driver = driver;
		helperObj = new helperClass(driver);
		
	}
	
	public void enterFirstName() {
		String fnameValue = "ATFirstName"+appLibrary.getRandomChars(noOfChars);
		driver.findElement(FirstName).sendKeys(fnameValue);
		registrationMap.put("firstName", fnameValue);
	}
	public void enterLastName() {
		String lnameValue = "ATLastName"+appLibrary.getRandomChars(noOfChars);
		driver.findElement(LastName).sendKeys(lnameValue);
		registrationMap.put("lastName", lnameValue);
	}
	public void enterDOB() {
		String dobValue = appLibrary.getDate(-999);
		driver.findElement(DOB).sendKeys(dobValue);
		registrationMap.put("dateOfBirth", dobValue);
		
	}
	public void enterLicense() {
		//String licenseValue =appLibrary.getRandomDigits(8);
		//int validLicense = Integer.parseInt(licenseValue);
		int n = 10000000 + new Random().nextInt(30000000);
		driver.findElement(license).sendKeys(Integer.toString(n));
		registrationMap.put("license", Integer.toString(n));
		
	}
	public void enterSSN() {
		//String ssnValue = appLibrary.getRandomDigits(9);
		int n = 100000000 + new Random().nextInt(899999999);
		driver.findElement(ssn).sendKeys(Integer.toString(n));
		registrationMap.put("ssn", Integer.toString(n));
	}
	public void enterState() {
		String stateValue =appLibrary.getRandomChars(noOfChars);
		driver.findElement(state).sendKeys(stateValue);
		registrationMap.put("state", stateValue);
	}
	public void enterCity() {
		String cityValue = "ATCity"+appLibrary.getRandomChars(noOfChars);
		driver.findElement(city).sendKeys(cityValue);
		registrationMap.put("city", cityValue);
	}
	public void enterAddress() {
		String addressValue = "ATAddress"+appLibrary.getRandomChars(noOfChars);
		driver.findElement(address).sendKeys(addressValue);
		registrationMap.put("address", addressValue);
	}
	public void enterZip() {
		//String zipValue = appLibrary.getRandomDigits(5);
		int n = 10000+ new Random().nextInt(89999);
		driver.findElement(zip).sendKeys(Integer.toString(n));
		registrationMap.put("zip", Integer.toString(n));
	}
	public void enterage() {
		String ageValue =appLibrary.getRandomDigits(2);
		driver.findElement(age).sendKeys(ageValue);
		registrationMap.put("age", ageValue);
	}
	public void enterHeight() {
		String heightValue = appLibrary.getRandomDigits(2);
		driver.findElement(height).sendKeys(heightValue);
		registrationMap.put("height", heightValue);
	}
	public void enterWeight() {
		String weightValue = appLibrary.getRandomDigits(2);
		driver.findElement(weight).sendKeys(weightValue);
		registrationMap.put("weight", weightValue);
	}
	public void enterPharmacy() {
		String pharmacyValue = "ATPharmacy"+appLibrary.getRandomChars(10);
		driver.findElement(pharmacy).sendKeys(pharmacyValue);
		registrationMap.put("pharmacy", pharmacyValue);
	}
	public void enterPharAddress() {
		String pharAddressValue = "ATPharAddress"+appLibrary.getRandomChars(15);
		driver.findElement(pharAddress).sendKeys(pharAddressValue);
		registrationMap.put("pharAddress", pharAddressValue);
	}
	public void enterEmail() {
		String emailValue = "ATEmail"+appLibrary.getRandomChars(noOfChars) + "@gmail.com";
		driver.findElement(email).sendKeys(emailValue);
		registrationMap.put("email", emailValue);
	}
	public void enterPassword() {
		String pwdValue = appLibrary.getAlphaNumericString(8)+"2";
		driver.findElement(pwd).sendKeys(pwdValue);
		driver.findElement(confirmpwd).sendKeys(pwdValue);
		registrationMap.put("pwd", pwdValue);
		registrationMap.put("confirmpwd", pwdValue);
	}
	public void enterUserName() {
		String uNameValue = "ATUname"+appLibrary.getRandomChars(noOfChars);
		driver.findElement(uname).sendKeys(uNameValue);
		registrationMap.put("uname", uNameValue);
	}

	public void enterSecurityQues() {
		Select sel = new Select(driver.findElement(security));
		sel.selectByIndex(appLibrary.getRandomIndexInRange(3,1));
		registrationMap.put("securityQues", sel.getFirstSelectedOption().getText());
		//registrationMap.put("securityQues", "what is your age");
	}
	public void enterSecurityAns() {
		String answerValue = "ATAns"+ appLibrary.getRandomChars(noOfChars);
		driver.findElement(ans).sendKeys(answerValue);
		registrationMap.put("secuAns", answerValue);
	}
	public void clickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value = 'Save']")).click();
	}
	public HashMap<String, String> fillregisterPatientForm() throws InterruptedException {
		enterFirstName();
		enterLastName();
		enterDOB();
		enterLicense();
		enterSSN();
		enterState();
		enterCity();
		enterAddress();
		enterZip();
		enterage();
		enterHeight();
		enterWeight();
		enterPharmacy();
		enterPharAddress();
		enterEmail();
		enterPassword();
		enterUserName();
		//enterConfirmPwd();
		Thread.sleep(2000);
		enterSecurityQues();
		enterSecurityAns();
		clickOnSave();
		return registrationMap;
	}
	
	public String registrationCompleteAlertMessage() throws InterruptedException {
		Thread.sleep(5000);
		  String regCompleteAlert= helperObj.alertMessage();
		  return regCompleteAlert;
	}
	public String patientLoginAlertMessageBeforeApproval(String patientLoginUrl) throws InterruptedException {
		driver.get(patientLoginUrl);
		//helperObj.patientLogin(uName, pWord);
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(registrationMap.get("uname"));
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(registrationMap.get("pwd"));
		driver.findElement(By.xpath("//input[@value = 'Sign In']")).click();
		Thread.sleep(5000);
		String loginalertMessage = helperObj.alertMessage();
		return loginalertMessage;
	}
   public String adminApprovalAlertMessage(String url,String uName, String pWord) throws Exception {
	    helperObj.launchAdminLoginPage(url,uName,pWord);
	    driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();
		Thread.sleep(2000);
	    //number of rows in the dynamic table 
	    List<WebElement> rows = driver.findElements(By.xpath("//*[@id='show']/table/tbody/tr/td[1]"));
	    int i=rows.size();
	    driver.findElement(By.xpath("//*[@id='show']/table/tbody/tr["+i+"]/td[1]/a")).click();
	   	Select status = new Select(driver.findElement(By.name("approval")));
	   	Thread.sleep(2000);
	    status.selectByVisibleText("Accepted");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String patientStatusMsgAfterAdminAppr = helperObj.alertMessage();
		return patientStatusMsgAfterAdminAppr;
   }
   public String validatePatientLoginAfterApproval(String patientLoginUrl,String tc_Name) throws InterruptedException, IOException {
		driver.get(patientLoginUrl);
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(registrationMap.get("uname"));
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(registrationMap.get("pwd"));
		driver.findElement(By.xpath("//input[@value = 'Sign In']")).click();
		Thread.sleep(2000);
		helperObj.captureScreenshot(tc_Name);
		String title= driver.findElement(By.xpath("//div[@class='panel-heading']/h3[@class='panel-title']")).getText();
		return title;
	}
}

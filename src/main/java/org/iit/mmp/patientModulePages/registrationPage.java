 package org.iit.mmp.patientModulePages;

import java.util.HashMap;
import java.util.Random;

import org.iit.mmp.helper.helperClass;
import org.iit.mmp.util.appLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class registrationPage {
	 
	WebDriver driver;
	helperClass helperObj ;
	 	
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
		String fnameValue = "ATFirstName"+appLibrary.getRandomChars(4);
		driver.findElement(FirstName).sendKeys(fnameValue);
		registrationMap.put("firstName", fnameValue);
	}
	public void enterLastName() {
		String lnameValue = "ATLastName"+appLibrary.getRandomChars(4);
		driver.findElement(LastName).sendKeys(lnameValue);
		registrationMap.put("lastName", lnameValue);
	}
	public void enterDOB() {
		String dobValue = appLibrary.getDate(-999);
		driver.findElement(DOB).sendKeys(dobValue);
		registrationMap.put("dateOfBirth", dobValue);
		
	}
	public void enterLicense() {
		String licenseValue =appLibrary.getRandomDigits(7);
		//int validLicense = Integer.parseInt(licenseValue);
		driver.findElement(license).sendKeys(licenseValue);
		registrationMap.put("license", licenseValue);
		System.out.println(" lince value is "+ licenseValue);
	}
	public void enterSSN() {
		String ssnValue = appLibrary.getRandomDigits(8);
		driver.findElement(ssn).sendKeys(ssnValue);
		registrationMap.put("ssn", ssnValue);
	}
	public void enterState() {
		String stateValue =appLibrary.getRandomChars(2);
		driver.findElement(state).sendKeys(stateValue);
		registrationMap.put("state", stateValue);
	}
	public void enterCity() {
		String cityValue = "ATCity"+appLibrary.getRandomChars(10);
		driver.findElement(city).sendKeys(cityValue);
		registrationMap.put("city", cityValue);
	}
	public void enterAddress() {
		String addressValue = "ATAddress"+appLibrary.getRandomChars(15);
		driver.findElement(address).sendKeys(addressValue);
		registrationMap.put("address", addressValue);
	}
	public void enterZip() {
		String zipValue = appLibrary.getRandomDigits(4);
		driver.findElement(zip).sendKeys(zipValue);
		registrationMap.put("zip", zipValue);
	}
	public void enterage() {
		String ageValue =appLibrary.getRandomDigits(1);
		driver.findElement(age).sendKeys(ageValue);
		registrationMap.put("age", ageValue);
	}
	public void enterHeight() {
		String heightValue = appLibrary.getRandomDigits(1);
		driver.findElement(height).sendKeys(heightValue);
		registrationMap.put("height", heightValue);
	}
	public void enterWeight() {
		String weightValue = appLibrary.getRandomDigits(1);
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
		String emailValue = "ATEmail"+appLibrary.getRandomChars(10) + "@gmail.com";
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
		String uNameValue = "ATUname"+appLibrary.getRandomChars(4);
		driver.findElement(uname).sendKeys(uNameValue);
		registrationMap.put("uname", uNameValue);
	}

	/*
	 * public void enterConfirmPwd() { String confirmPwdValue =
	 * driver.findElement(pwd).getText();
	 * driver.findElement(confirmpwd).sendKeys(confirmPwdValue);
	 * registrationMap.put("confirmpwd", confirmPwdValue); }
	 */
	public void enterSecurityQues() {
		Select sel = new Select(driver.findElement(security));
		/*
		 * Random r = new Random(); sel.selectByIndex(r.nextInt(3));
		 */
		System.out.println("SECU QUES IS " + 1);
		sel.selectByIndex(appLibrary.getRandomIndexInRange(3,1));
		registrationMap.put("securityQues", "what is your age");
	}
	public void enterSecurityAns() {
		String answerValue = "ATAns"+ appLibrary.getRandomChars(4);
		driver.findElement(ans).sendKeys(answerValue);
		registrationMap.put("secuAns", answerValue);
	}
	public void clickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value = 'Save']")).click();
	}
	
	public String registrationCompleteAlertMessage() throws InterruptedException {
		Thread.sleep(5000);
		 Alert regAlert = driver.switchTo().alert(); 
		  String AlertMessage = regAlert.getText(); 
		  regAlert.accept(); 
		  return AlertMessage; 
	}
	

	public String patientLoginAlertMessageBeforeApproval() throws InterruptedException {
		//driver.findElement(By.xpath("//a[text()='Patient Login']")).click();
		//driver.findElement(By.xpath("//a[@href='portal/login.php']")).click();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(registrationMap.get("uname"));
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(registrationMap.get("pwd"));
		driver.findElement(By.xpath("//input[@value = 'Sign In']")).click();
		Thread.sleep(5000);
		Alert pa = driver.switchTo().alert();
		String loginalertMessage = pa.getText();
		pa.accept();
		return loginalertMessage;
	}
   public String adminApprovalAlertMessage(String url) throws Exception {
	    helperObj.launchAdminLoginPage(url);
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    //js.executeScript("window.scrollBy(0,5000)");
	    js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.name("approval")) );
	    String patientToApprove = driver.findElement(uname).getText() ;
	    System.out.println(patientToApprove);
	    driver.findElement(By.xpath("//a[contains(text(),'patientToApprove']")).click();
	   	Select status = new Select(driver.findElement(By.name("approval")));
	    Thread.sleep(2000);
		status.selectByVisibleText("Accepted");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(5000);
	    Alert statusPopup = driver.switchTo().alert();
		String patientStatusMsgAfterAdminAppr = statusPopup.getText();
		statusPopup.accept();
		return patientStatusMsgAfterAdminAppr;
   }
   public String patientLoginAlertMessageAfterApproval() throws InterruptedException {
		//driver.findElement(By.xpath("//a[@href='portal/login.php']")).click();
	    driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(registrationMap.get("uname"));
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(registrationMap.get("pwd"));
		driver.findElement(By.xpath("//input[@value = 'Sign In']")).click();
		Thread.sleep(5000);
		Alert pa = driver.switchTo().alert();
		pa.accept();
		return pa.getText();
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


}

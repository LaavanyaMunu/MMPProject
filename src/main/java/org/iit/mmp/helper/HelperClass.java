package org.iit.mmp.helper;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass{
	WebDriver driver;
	public HelperClass(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver switchToAFrameAvailable(String frame, int timeInSecs) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		return driver;
	}
	public void launchHomePage(String url) {
		driver.get(url);
	}
	public void launchAdminLoginPage(String uName, String pWord) throws InterruptedException {
		//driver.get(homePageUrl);
		driver.findElement(By.xpath("//div[@id='welcome']//following-sibling::a[contains(text(),'Login') ]")).click();
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(pWord);
		driver.findElement(By.xpath("//input[@value = 'Sign In']")).click();
	}
	public void navigateToAModule(String moduleName) {
		driver.findElement(By.xpath("//span[contains(text(),'" + moduleName + "')]")).click();
	}
	public void captureScreenshot(String tc_Name) throws IOException {
		System.out.println("Capturing the Screenshot for testcase" + tc_Name);
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcFile = tss.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "\\screenshots\\" + tc_Name
				+ Calendar.getInstance().getTimeInMillis() + ".jpg";
		System.out.println(destPath);
		File destFile = new File(destPath);
		FileUtils.copyFile(srcFile, destFile);
	}
	public void clickOnRegisterLink() {
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
	}
	public void patientLogin(String url,String uName, String pWord) {
		driver.get(url);
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(pWord);
		driver.findElement(By.xpath("//input[@value = 'Sign In']")).click();
	}
		public String alertMessage() {
		Alert alt = driver.switchTo().alert(); 
		  String AlertMessage = alt.getText(); 
		  alt.accept(); 
		  return AlertMessage;
	}
		
}

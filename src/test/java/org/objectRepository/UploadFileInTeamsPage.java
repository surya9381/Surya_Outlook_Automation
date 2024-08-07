package org.objectRepository;

import java.awt.AWTException;

import org.genericLibrary.Webdriver_Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFileInTeamsPage {

	public UploadFileInTeamsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[@aria-label='Teams']")
	private WebElement teams;
	
	@FindBy(xpath = "//span[text()='General']")
	private WebElement general;
	
	@FindBy(xpath = "//div[text()='Files']")
	private WebElement files;
	
	@FindBy(xpath = "//button[text()='Resumes_New']")
	private WebElement newResume;
	
	@FindBy(xpath = "//span[text()='Upload']")
	private WebElement upload;
	
	@FindBy(xpath = "//span[text()='Files']")
	private WebElement file2;
	
	@FindBy(xpath = "//button[@aria-label='Open office app launcher']")
	private WebElement ofcAppLauncher;
	
	@FindBy(xpath = "//span[text()='Outlook']")
	private WebElement outlook;

	public WebElement getTeams() {
		return teams;
	}

	public WebElement getGeneral()
	{
		return general;
	}
	
	public WebElement getFiles() {
		return files;
	}

	public WebElement getNewResume()
	{
		return newResume;
	}
	
	public WebElement getUpload() {
		return upload;
	}

	public WebElement getFile2() {
		return file2;
	}
	
	public WebElement getOfcAppLauncher()
	{
		return ofcAppLauncher;
	}
	
	public WebElement getOutlook()
	{
		return outlook;
	}
	
	public void uploadResume(WebDriver driver) throws InterruptedException, AWTException
	{
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.implicitWaitCondition(driver, 1000);
		
		wlib.switchToWindow(driver);
		
		wlib.explicitWaitCondition(driver, teams, 500);
		teams.click();
		
		wlib.explicitWaitCondition(driver, general, 200);
		general.click();
		
		wlib.explicitWaitCondition(driver, files, 200);
		files.click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("embedded-page-container");
		
//		WebElement frame = driver.findElement(By.xpath("//iframe"));
//		driver.switchTo().frame(frame);
		wlib.explicitWaitCondition(driver, newResume, 200);
		newResume.click();
		
		Thread.sleep(5000);
		
		wlib.explicitWaitCondition(driver, upload, 200);
		upload.click();
		
		wlib.explicitWaitCondition(driver, file2, 200);
		file2.click();
		
		Thread.sleep(3000);
		
		wlib.uploadFile();
		driver.switchTo().defaultContent();
		
	    wlib.explicitWaitCondition(driver, ofcAppLauncher, 100);
	    ofcAppLauncher.click();
	    
	    wlib.explicitWaitCondition(driver, outlook, 100);
	    outlook.click();
	    

	}

    
		
	}


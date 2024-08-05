package org.objectRepository;

import java.io.IOException;

import org.genericLibrary.File_Utility;
import org.genericLibrary.Webdriver_Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Outlook_LoginPage {

	public File_Utility flib;
	public Webdriver_Utility wlib;
	
	public Outlook_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailTB;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement nextBtn;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordTB;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement yesBtn;

	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}
	
	public void loginToOutlook(WebDriver driver) throws IOException
	{
		flib=new File_Utility();
		String email=flib.getPropertyKeyValue("email");
		String password=flib.getPropertyKeyValue("password");
		
	    wlib=new Webdriver_Utility();
		wlib.explicitWaitCondition(driver, emailTB, 100);
		
		emailTB.sendKeys(email);
		nextBtn.click();
		
		wlib.explicitWaitCondition(driver, passwordTB, 100);
		passwordTB.sendKeys(password);
		signInBtn.click();
		
		wlib.explicitWaitCondition(driver, checkbox, 100);
		checkbox.click();
		yesBtn.click();
		
	}
}

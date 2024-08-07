package org.objectRepository;

import org.genericLibrary.Webdriver_Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Outlook_Homepage {

	public Outlook_Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'GmWAd')])[1]")
	private WebElement resumeBox;
	
	@FindBy(xpath = "//span[text()='Download']")
	private WebElement download;
	
	@FindBy(xpath = "//button[@title='Close']")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//button[@title='App launcher']")
	private WebElement appLauncher;
	
	@FindBy(xpath = "//span[contains(@class,'TeamsLogo')]")
	private WebElement teamsLogo;

	public WebElement getResumeBox() {
		return resumeBox;
	}

	public WebElement getDownload() {
		return download;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public WebElement getAppLauncher() {
		return appLauncher;
	}

	public WebElement getTeamsLogo() {
		return teamsLogo;
	}
	
	public void downloadResume(WebDriver driver)
	{
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.explicitWaitCondition(driver, resumeBox, 200);
		resumeBox.click();
		
		wlib.explicitWaitCondition(driver, download, 200);
		download.click();
		
		wlib.explicitWaitCondition(driver, closeBtn, 200);
		closeBtn.click();
		
		wlib.explicitWaitCondition(driver, appLauncher, 200);
		appLauncher.click();
		
		wlib.explicitWaitCondition(driver, teamsLogo, 200);
		teamsLogo.click();
		
	}
}

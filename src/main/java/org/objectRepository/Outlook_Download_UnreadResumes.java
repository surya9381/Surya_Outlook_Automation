package org.objectRepository;

import org.genericLibrary.Webdriver_Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Outlook_Download_UnreadResumes {

	public Outlook_Download_UnreadResumes(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//button[@aria-label='Filter']")
	private WebElement filter;
	
	@FindBy(xpath = "//span[text()='Unread']")
	private WebElement unread;
	
	@FindBy(xpath = "(//div[contains(@class,'AVFDW')])[1]")
	private WebElement resumebox;
	
	@FindBy(xpath = "//span[text()='Download']")
	private WebElement download;
	
	@FindBy(xpath = "//button[@title='Close']")
	private WebElement closeBtn;
	
	@FindBy(xpath = "(//div[@role='checkbox'])[1]")
	private WebElement checkbox;
	
	@FindBy(xpath = "//span[text()='Mark as read']")
	private WebElement markAsRead;
	
	@FindBy(xpath = "//button[@title='App launcher']")
	private WebElement appLauncher;
	
	@FindBy(xpath = "//span[contains(@class,'TeamsLogo')]")
	private WebElement teamsLogo;
	
	public WebElement getFilter() {
		return filter;
	}

	public void setFilter(WebElement filter) {
		this.filter = filter;
	}

	public WebElement getUnread() {
		return unread;
	}

	public void setUnread(WebElement unread) {
		this.unread = unread;
	}

	public WebElement getResumebox() {
		return resumebox;
	}

	public void setResumebox(WebElement resumebox) {
		this.resumebox = resumebox;
	}

	public WebElement getDownload() {
		return download;
	}

	public void setDownload(WebElement download) {
		this.download = download;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public void setCloseBtn(WebElement closeBtn) {
		this.closeBtn = closeBtn;
	}
	
	public WebElement getCheckbox()
	{
		return checkbox;
	}
	
	public WebElement getMarkAsRead()
	{
		return markAsRead;
	}

	public WebElement getAppLauncher() {
		return appLauncher;
	}

	public void setAppLauncher(WebElement appLauncher) {
		this.appLauncher = appLauncher;
	}

	public WebElement getTeamsLogo() {
		return teamsLogo;
	}

	public void setTeamsLogo(WebElement teamsLogo) {
		this.teamsLogo = teamsLogo;
	}


	public void downloadResume(WebDriver driver) throws InterruptedException
	{	
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.implicitWaitCondition(driver, 100);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		wlib.explicitWaitCondition(driver, filter, 100);
		filter.click();
		
		wlib.explicitWaitCondition(driver, unread, 100);
		unread.click();
		
		Thread.sleep(5000);
		
		wlib.explicitWaitCondition(driver, resumebox, 200);
		resumebox.click();
		
		wlib.explicitWaitCondition(driver, download, 200);
		download.click();
		
		wlib.explicitWaitCondition(driver, closeBtn, 200);
		closeBtn.click();
		
		wlib.explicitWaitCondition(driver, checkbox, 100);
		checkbox.click();
		
		Thread.sleep(2000);
		
		wlib.rightClickAction(driver, checkbox);
		
		wlib.explicitWaitCondition(driver, markAsRead, 100);
		markAsRead.click();
		
		wlib.explicitWaitCondition(driver, appLauncher, 200);
		appLauncher.click();
		
		wlib.explicitWaitCondition(driver, teamsLogo, 200);
		teamsLogo.click();
		
	}
}

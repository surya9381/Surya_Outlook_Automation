package org.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.genericLibrary.BaseClass;
import org.genericLibrary.Webdriver_Utility;
import org.objectRepository.Outlook_Download_UnreadResumes;
import org.objectRepository.Outlook_LoginPage;
import org.objectRepository.UploadFileInTeamsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DownloadUnreadResumesAndUploadInTeams extends BaseClass
{
    @Test
    public void unreadResumes() throws IOException, InterruptedException, AWTException
    {
    	Outlook_LoginPage login=new Outlook_LoginPage(driver);
		login.loginToOutlook(driver);
		
		Thread.sleep(2000);
		
		for(int i=1;i<=10;i++)
			
		{
			wlib.implicitWaitCondition(driver, 200);
		
		Outlook_Download_UnreadResumes unread=new Outlook_Download_UnreadResumes(driver);
		unread.downloadResume(driver);
		
		Thread.sleep(20000);
		
		UploadFileInTeamsPage upload=new UploadFileInTeamsPage(driver);
		upload.uploadResume(driver);
		
		Thread.sleep(2000);
		
		wlib.implicitWaitCondition(driver, 200);
		wlib.switchToWindow(driver);
		
		Thread.sleep(2000);
		
		}
		
		
	
		
    }
	
}

package org.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.genericLibrary.BaseClass;
import org.genericLibrary.Webdriver_Utility;
import org.objectRepository.Outlook_Homepage;
import org.objectRepository.Outlook_LoginPage;
import org.objectRepository.UploadFileInTeamsPage;
import org.testng.annotations.Test;

public class Surya extends BaseClass {

	@Test
	public void test() throws IOException, InterruptedException, AWTException
	{
		Outlook_LoginPage login=new Outlook_LoginPage(driver);
		login.loginToOutlook(driver);
		
		Thread.sleep(2000);
		
		Outlook_Homepage download=new Outlook_Homepage(driver);
		download.downloadResume(driver);
		
		Thread.sleep(20000);
		
		UploadFileInTeamsPage upload=new UploadFileInTeamsPage(driver);
		upload.uploadResume(driver);
		
	}
}

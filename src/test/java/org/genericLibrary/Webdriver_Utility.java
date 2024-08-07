package org.genericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility {

	public void implicitWaitCondition(WebDriver driver, int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	public void explicitWaitCondition(WebDriver driver, WebElement element, int duration)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToWindow(WebDriver driver)
	{
		 Set<String> set = driver.getWindowHandles();
		Iterator<String> i=set.iterator();
		while(i.hasNext())
		{
			String id=i.next();
			driver.switchTo().window(id);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains("partialWindowTitle"))
			{
				break;
			}
		}
	}
	

     public static File getLatestFilefromDir(String dirPath)
     {
		File dir = new File(dirPath);
	    File[] files = dir.listFiles();
		        if (files == null || files.length == 0) {
		            return null;
		        }

		        // Get the latest file based on last modified time
		        return Arrays.stream(files)
		                .filter(File::isFile)
		                .max(Comparator.comparing(File::lastModified))
		                .orElse(null);
	 }
     
	 public void uploadFile() throws InterruptedException, AWTException
	 {
		
	    File latestFile = getLatestFilefromDir("C:\\Users\\SuryanarayanaA\\Downloads\\resumes");

		StringSelection path=new StringSelection(latestFile.getAbsolutePath());
		Thread.sleep(2000);
		Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(path, null);
		Thread.sleep(2000);
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(2000);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	 
	 public void rightClickAction(WebDriver driver, WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }

	
}

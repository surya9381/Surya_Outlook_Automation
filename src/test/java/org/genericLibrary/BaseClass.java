package org.genericLibrary;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public File_Utility flib;
	public WebDriver driver;
	public Webdriver_Utility wlib;
	
   @BeforeClass
   public void launchBrowser() throws IOException
   {
	   flib=new File_Utility();
	   String browser=flib.getPropertyKeyValue("browser");
	   
	   if(browser.equalsIgnoreCase("chrome"))
	   {
		   String downloadFilePath = "C:\\Users\\SuryanarayanaA\\Downloads\\resumes";
		   Map<String, Object> preferences = new HashMap<>();
		   preferences.put("download.default_directory", downloadFilePath);

		   ChromeOptions options = new ChromeOptions();
		   options.setExperimentalOption("prefs", preferences);
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver(options);
		   
		   
//		   WebDriverManager.chromedriver().setup();
//		   driver=new ChromeDriver();
	   }
	   else if(browser.equalsIgnoreCase("edge"))
	   {
		   WebDriverManager.edgedriver().setup();
		   driver=new EdgeDriver();
	   }
	   driver.manage().window().maximize();
	   wlib=new Webdriver_Utility();
	   wlib.implicitWaitCondition(driver, 30);   
   }
   
   @BeforeMethod
   public void loginToApp() throws IOException
   {
	   String url=flib.getPropertyKeyValue("url");
	   
	   driver.get(url);
   }
}

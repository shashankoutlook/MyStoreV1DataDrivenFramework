package com.mystore.Baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;
public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	protected String url=readconfig.getBaseUrl();
	//String browser = readconfig.getBrowser();

	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() 
	{
		String browser="chrome";
		switch(browser.toLowerCase())
		{
		case "chrome":
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins");
			driver=new ChromeDriver();
			break;
			
		case "msedge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
			default:
				driver=null;
				break;
				
		}
		//implicit wait===10sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//For logging initialization
		logger=LogManager.getLogger("MystoreV1");
		//open url
				driver.get(url);
				logger.info("url opened");
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
}

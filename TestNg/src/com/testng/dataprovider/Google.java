package com.testng.dataprovider;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Google {

	public static WebDriver  dr =null;
	public static Xls_Reader xls =null;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeClass
	public void launchBrowser()
	{
		log.debug("Launcing the browser");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sony\\Desktop\\Samarthview\\geckodriver.exe");
		log.debug("Initializing excel file");
		dr = new FirefoxDriver();
		xls = new Xls_Reader("C:\\Users\\Sony\\Desktop\\Testdata.xlsx");
		
	}
	
	@Test
	public void verifyTitle()
	{
		 
		
		String Expected_title = xls.getCellData("Testdata", 0, 2);
		System.out.println(Expected_title);
		log.debug("Opening Facebook website");
		dr.get("https://www.facebook.com/");
		String Actual_title = dr.getTitle();
		log.debug("Verifying actual and expected data");
		Assert.assertEquals(Actual_title, Expected_title);
		log.debug("Successfully Verified Flipkart Title");
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		log.debug("Closing the browser");
		dr.quit();
		//dr.close();
		
	}
	
}

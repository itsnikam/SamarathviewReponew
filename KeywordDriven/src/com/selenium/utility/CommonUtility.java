package com.selenium.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import static com.selenium.Executionengine.Driverscript.log;


import com.selenium.config.Constant;
import com.selenium.config.CustomException;

public class CommonUtility {

	
	public static WebDriver dr;
	public static WebElement element;
	CustomException c = new CustomException();
	
	public static WebElement getObject(String key,String value) throws CustomException
	{
		try{
		if(key.endsWith("xpath")){
			element = dr.findElement(By.xpath(value));
		}else if(key.endsWith("linktext"))
		{
			element = dr.findElement(By.partialLinkText(value));
		}else if(key.endsWith("id"))
		{
			element = dr.findElement(By.id(value));
		}else if(key.endsWith("classname"))
		{
			element = dr.findElement(By.className(value));
		}
		}catch(Exception e )
		{
			log.debug("Element not found"+key);
			log.debug("Unable to Locate Element with Xpath as "+value);
			dr.quit();
			Assert.fail("Test Case Failed As Element not present");
			//throw new CustomException().ElementNotFoundException("Element not found");;
			//Write down the code to take screen shot
			//takeScreenshot();
			
		}
		return element;
	}
	
	public static void launchBrowser(String value)
	{
		
		if(value.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver",Constant.firefox_path);
			dr = new FirefoxDriver();
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			dr.manage().window().maximize();
		}else if(value.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", Constant.chrome_path);
			dr = new ChromeDriver();
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			dr.manage().window().maximize();
		}
		
	}
	
	public static void launchApplication(String url){
		
		dr.get(url);
	}
	public static void closeBrowser()
	{
		
		dr.quit();
	}
	public static String getTitle()
	{
		
		return dr.getTitle();
	}
	
}

package com.selenium.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.config.Constant;

public class CommonUtility {

	public static WebDriver dr;
	public static WebElement element;
	public static WebElement getObject(String key,String value)
	{
		
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
	
}

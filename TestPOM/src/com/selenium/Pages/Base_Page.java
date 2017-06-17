package com.selenium.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class Base_Page  {

	public static WebDriver dr;

	public static void openBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sony\\Desktop\\Samarthview\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		
	}
	public static void click(String Path)
	{
		dr.findElement(By.xpath(Path)).click();
		
	}
	
	public static void closeBrowser()
	{
		
		dr.quit();
	}
	
	public static void navigate(String url)
	{
		dr.get(url);
		
	}
	public static void inputText(String path,String text)
	{
		
		dr.findElement(By.xpath(path)).sendKeys(text);
		
	}
	public static void clearText(String path)
	{
		dr.findElement(By.xpath(path)).clear();
		
	}
	
}

package com.selenium.tests;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Mytest {

	
	
	@Test
	public void testBrowser()
	{
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sony\\Desktop\\Samarthview\\geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://www.facebook.com");
		System.out.println(dr.getTitle());
	}
	
}

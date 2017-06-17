package com.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSalesforce {

	
	
	@Test
	public void Login()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sony\\Desktop\\Samarthview\\geckodriver.exe");
		WebDriver dr = new FirefoxDriver();
		dr.get("https://www.salesforce.com/in/?ir=1");
		dr.findElement(By.xpath("html/body/header/div[2]/div/div[1]/div/div/div[2]/nav/div[1]/div/div[2]/div[4]/div/div/a/span[2]")).click();
		
		
		
	}
}

package com.selenium.config;

import java.io.IOException;
import static com.selenium.Executionengine.Driverscript.log;
import org.apache.log4j.Logger;
import org.testng.Assert;
import com.selenium.Executionengine.Driverscript;
import com.selenium.utility.CommonUtility;

public class Keywords  {

	

	

	public static void openBrowser(String page_object,String data,String object)
	{
		log.debug("Opening the browser");
		CommonUtility.launchBrowser(Constant.browser);
		log.debug("Done with open browser operation");
	}
	
	public static void navigate(String page_object,String data,String object)
	{
		log.debug("Launching the application");
		CommonUtility.launchApplication(data);
		log.debug("application Launched Successfully !!!");
	}
	public static void input_Text(String page_object,String data,String object) throws CustomException
	{
		log.debug("Entering the text ");
		CommonUtility.getObject(page_object, object).sendKeys(data);
	}
	
	public static void click(String page_object,String data,String object) throws CustomException
	{
		log.debug("Clicking on object"+page_object);
		CommonUtility.getObject(page_object, object).click();
		
	}
	public static void waitfor(String page_object,String data,String object) throws InterruptedException
	{
		Thread.sleep(5000);
	}
	
	public static void closeapp(String page_object,String data,String object)
	{
		log.debug("Closing the Browser");
		CommonUtility.closeBrowser();
		log.debug("Browser closed successfully");
	}
	
	public static void verifyText(String page_object,String data,String object) throws CustomException
	{
		log.debug("Verifying text");
		Assert.assertEquals(data, CommonUtility.getObject(page_object, object).getText());
		log.debug("Text Verification is Successful");
	}
	public static void verifyTitle(String page_object,String data,String object)
	{
		log.debug("Verifying Title");
		Assert.assertEquals(data, CommonUtility.getTitle());
		log.debug("Title Verification is Successful");
	}

}

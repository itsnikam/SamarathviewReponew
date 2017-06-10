package com.selenium.config;

import com.selenium.utility.CommonUtility;

public class Keywords {

	
	public static void openBrowser(String page_object,String data,String object)
	{
		
		CommonUtility.launchBrowser(Constant.browser);
		
	}
	
	public static void navigate(String page_object,String data,String object)
	{
		
		CommonUtility.launchApplication(Constant.app_url);
	}
	public static void input_Text(String page_object,String data,String object)
	{
		
		CommonUtility.getObject(page_object, object).sendKeys(data);
	}
	
	public static void click(String page_object,String data,String object)
	{
		CommonUtility.getObject(page_object, object).click();
		
	}
	public static void waitfor(String page_object,String data,String object) throws InterruptedException
	{
		Thread.sleep(5000);
		
	}
	
	public static void closeapp(String page_object,String data,String object)
	{
		CommonUtility.closeBrowser();
	}
	

}

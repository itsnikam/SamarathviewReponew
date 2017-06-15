package com.selenium.config;

public class CustomException extends Exception{
	
	
	public static String ElementNotFoundException(String msg)
	{
		takeScreenshot();
		return msg;
		
		
	}
	
	public static void takeScreenshot()
	{
		/*1.Logic to generate screnshot path with current time stamp
		 *2.code to cpature screen shot 
		 */
		
	}
	

}

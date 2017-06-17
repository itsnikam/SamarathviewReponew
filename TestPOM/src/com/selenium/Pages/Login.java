package com.selenium.Pages;

public class Login extends Base_Page {

	
	public void openLoginpage()
	{
		
		Base_Page.openBrowser();
		Base_Page.navigate("https://login.salesforce.com/?locale=in");
	}
	
	public void setUSername(String username)
	{
		Base_Page.clearText("//input[@id='username']");
		Base_Page.inputText("//input[@id='username']", username);
	}
	
	public void setPwd(String pwd)
	{
	
		Base_Page.clearText("//*[@id='password']");
		Base_Page.inputText("//*[@id='password']", pwd);
	}
	public void closeApp()
	{
		
		Base_Page.closeBrowser();
	}
	
	public Dashboard submit()
	{
		
		Base_Page.click("//input[@id='Login']");
		return new Dashboard();
	}
}

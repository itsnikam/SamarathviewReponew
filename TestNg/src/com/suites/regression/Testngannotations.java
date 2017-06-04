package com.suites.regression;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



//Remain with parallel ,grouping the test cases  
public class Testngannotations {
/*
 * 1.Logintoapplication
 * 2.adduser
 * 3.List user
 * 4.logout
 */
	
	//this methid will gets executed before executing any of the test method insidet THIS class
	@BeforeClass
	public void Launchapplication()
	{
		
		System.out.println("Launching the application");
	}
	
	@BeforeMethod
	public void setup()
	{
		//this method will gets executed before execting every test method inside this class
		System.out.println("checking if browser is opened mode");
	}
	
	
	@AfterMethod
	public void cleanup()
	{
		//this method will gets executed before execting every test method inside this class
		System.out.println("Cleanup successful");
	}
	
	@Test(priority=1)
	public void Logintoapplication()
	{
		
		
		//use of assertions
		   Assert.assertTrue(10<5);  
		   System.out.println("Successfully Login to application");
			
		
	}
	
	@Test(priority=2,dependsOnMethods="Logintoapplication")
	public void adduser()
	{
		
		System.out.println("Creating the user");
	}
	
	
	@Test(priority=3,dependsOnMethods="Logintoapplication")
	public void listuser()
	{
		System.out.println("Listing the user");
	}
	
	@Test(priority=4,dependsOnMethods="Logintoapplication")
	public void logout()
	{
		System.out.println("Logout");
	}
	
	//this methid will gets executed after executing all of the test method inside THIS class
	@AfterClass
	public void closeapplication()
	{
		
		System.out.println("Closing the application");
	}
	
	
}

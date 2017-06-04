package com.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Createuser {

	
	//uname,pwd,age
	
	@Test(dataProvider="gettestData")
	public void createUser(String uname,String pwd,int age)
	{
		
		System.out.println("Creating the user with params"+uname+"--"+pwd+"--");
		
		
	}
	
	@DataProvider
	public Object[][] gettestData()
	{
		//rows - how many times you want to run your test casse
		// column - no of parameters
		Object[][] data =  new Object[3][3];  
		
		
		//row1
		data[0][0] = "user1";
		data[0][1] = "pwd1";
		data[0][2] = 30;
		
		//row2
		data[1][0] = "user2";
		data[1][1] = "pwd2";
		data[1][2] = 20;

		//row3
		data[2][0] = "user3";
		data[2][1] = "pwd3";
		data[2][2] = 30;

		
		return data;
	}
	
}

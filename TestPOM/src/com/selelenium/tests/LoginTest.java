package com.selelenium.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Pages.Dashboard;
import com.selenium.Pages.Login;

public class LoginTest {

	Login login = new Login();
	Dashboard dashboard;
	@Test(dataProvider="getData")
	public void doLogin(String uname,String pwd)
	{
		System.out.println("");
		login.openLoginpage();
		login.setUSername(uname);
		login.setPwd(pwd);
		dashboard = login.submit();
		login.closeApp();

	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		com.selelenium.tests.Xls_Reader xls = new com.selelenium.tests.Xls_Reader("C:\\Users\\Sony\\Desktop\\Testdata.xlsx");
		
		int row_count = xls.getRowCount("Testdata");
		int col_count = xls.getColumnCount("Testdata");
		
		Object[][] data =  new Object[row_count-1][col_count];
			
	
		
		for(int i=2;i<=row_count;i++)
		{
			
			for(int j=0;j<col_count;j++){
			
				//System.out.println(xls.getCellData("Testdata", j, i));
				data [i-2] [j]= xls.getCellData("Testdata", j, i);
			
		}
		
		}
		
		return data;
		
		
	}
	
}

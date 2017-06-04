package com.testng.dataprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Verifytitle {
	
	
	public static WebDriver dr = null;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sony\\Desktop\\Samarthview\\geckodriver.exe");
		dr = new FirefoxDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void verifyTitle(String url,String Expectedvalue)
	{
		//code to launch ff
		dr.get(url);
		String Actual_title = dr.getTitle();
		Assert.assertEquals(Actual_title, Expectedvalue);
		System.out.println("Verified Title of url"+url);
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Xls_Reader xls = new Xls_Reader("C:\\Users\\Sony\\Desktop\\Testdata.xlsx");
		
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
	
	@AfterTest
	public void closeBrowser()
	{
		
		dr.quit();
	}

}

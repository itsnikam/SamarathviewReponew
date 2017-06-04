package com.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testwork {

	@Test(dataProvider="getdata")
	public void test1(String url,String title,String link)
	{
		System.out.println("--url--"+url);
		System.out.println("--title--"+title);
		System.out.println("--Link--"+link);
		
	}
	
	@DataProvider
	public Object[][] getdata() {
		// TODO Auto-generated method stub

		Xls_Reader xls = new Xls_Reader("C:\\Users\\Sony\\Desktop\\Testdata.xlsx");
		int row_count = xls.getRowCount("Testdata");
		int col_count = xls.getColumnCount("Testdata");
		//System.out.println(row_count);
		//System.out.println(col_count);
		
		Object[][] data =  new Object[row_count-1][col_count];
			
		
		
		for(int i=2;i<row_count+1;i++)
		{
			
			for(int j=0;j<col_count;j++){
			if(xls.getCellData("Testdata", 0, i)=="")
			{
				
				System.out.println("No data");
			}
			else{
				System.out.println(xls.getCellData("Testdata", j, i));
				data [i-2] [j]= xls.getCellData("Testdata", j, i);
			}
		}
		
		}
		
		return data;
	}

}

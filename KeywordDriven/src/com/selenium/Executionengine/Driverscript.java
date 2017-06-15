package com.selenium.Executionengine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.config.Constant;
import com.selenium.config.CustomException;
import com.selenium.config.Keywords;
import com.testng.dataprovider.Xls_Reader;

public class Driverscript extends CustomException{

	public static Xls_Reader xls =null;
	public static Xls_Reader xls1 =null;
	public static String tc_name;
	public static String suite_name;
	public static String suite_runmode;
	public static String tc_runmode;
	public static int tc_start;
	public static int tc_end;
	public static String sactionkeyword;
	public static String page_object;
	public static String data;
	public static Method method[];
	public static Properties or ;
	public static FileInputStream fn ;
	public static Logger log;
	
	public Driverscript() throws IOException
	{
		//initialize keywords class
				Keywords keyword = new Keywords();
				//initialize both excel files 
				xls = new Xls_Reader(Constant.Testcases_path);
				xls1 = new Xls_Reader(Constant.keywords_path);

				//initialize object repo
				or = new Properties();
				File f = new File(Constant.OR_path);
				fn = new FileInputStream(f);
				or.load(fn);
				
				//initialize logger
				log=Logger.getLogger("devpinoyLogger");
				
				//Get all methods from keywords class
				method = keyword.getClass().getDeclaredMethods();

		
	}
	public static void main(String[] args) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
	
		Driverscript test = new Driverscript();
		
		for(int k=2;k<=xls.getRowCount("Test Suites");k++)
		{
			suite_name = xls.getCellData("Test Suites", "SuiteName", k);
			suite_runmode = xls.getCellData("Test Suites", "RunMode", k);
			System.out.println(suite_name+"--->"+suite_runmode);
			if(suite_runmode.equalsIgnoreCase("Yes")||suite_runmode.equalsIgnoreCase("Y")){
					for(int i=2;i<=xls.getRowCount(suite_name);i++)
					{
						tc_name = xls.getCellData(suite_name, "TC_Name", i);
						tc_runmode = xls.getCellData(suite_name, "RunMode", i);
						System.out.println(tc_name+"--->"+tc_runmode);
							if (tc_runmode.equalsIgnoreCase("Yes")||tc_runmode.equalsIgnoreCase("Y")){
								log.debug("***Starting the test Case***"+tc_name);
								tc_start = xls1.getCellRowNum("Test Steps", "TCID",tc_name);
								tc_end = gettc_endrow(xls1,tc_name,tc_start);
								System.out.println(tc_start+"---"+tc_end);
								for (int j=tc_start;j<=tc_end;j++)
								{
									sactionkeyword = xls1.getCellData("Test Steps", "Keyword", j);
									page_object = xls1.getCellData("Test Steps", "Object", j);
									data = xls1.getCellData("Test Steps", "Data", j);
									System.out.println(sactionkeyword+"--"+page_object+"--"+data);
									Executekeyword();
								}
								xls.setCellData(suite_name, "Status", i, "Pass");
				
					}
			
		}
		}
			
		}
	}

	private static int gettc_endrow(Xls_Reader xls,String tcname,int startrow) {
		int count =startrow;
		for(int i=startrow;i<=xls.getRowCount("Test Steps");i++)
		{
			
			if(xls.getCellData("Test Steps","TCID", i).equalsIgnoreCase(tcname))
			{
				
				count =count+1;
			}else{
				
				break;
			}
		}
		return count-1;
		
	}

	private static void Executekeyword() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		for(int i=0;i<method.length;i++)
		{
			
			if(sactionkeyword.equalsIgnoreCase(method[i].getName()))
			{
				method[i].invoke(sactionkeyword,page_object,data,or.getProperty(page_object));
				
			}
		}
	}


}

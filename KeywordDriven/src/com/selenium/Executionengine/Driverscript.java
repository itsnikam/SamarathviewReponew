package com.selenium.Executionengine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.config.Keywords;
import com.testng.dataprovider.Xls_Reader;

public class Driverscript {

	public static Xls_Reader xls =null;
	public static String sactionkeyword;
	public static String page_object;
	public static String data;
	public static Method method[];
	public static Properties or ;
	public static FileInputStream fn ;
	
	public static void main(String[] args) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Keywords keyword = new Keywords();

		or = new Properties();
		File f = new File(System.getProperty("user.dir")+"\\src\\com\\selenium\\config\\OR.properties");
		fn = new FileInputStream(f);
		or.load(fn);
		
		method = keyword.getClass().getDeclaredMethods();
		String path = System.getProperty("user.dir")+"\\src\\com\\selenium\\Dataengine\\Keywords.xlsx";
		xls = new Xls_Reader(path);
		
		//TO-DO
		//write the logic to fetch test case start and end row number
		for (int i=2;i<=10;i++)
		{
			sactionkeyword = xls.getCellData("Test Steps", "Keyword", i);
			page_object = xls.getCellData("Test Steps", "Object", i);
			data = xls.getCellData("Test Steps", "Data", i);
			
			Executekeyword();
		}
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

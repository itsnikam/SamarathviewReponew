package com.suites.parallel;

import org.testng.annotations.Test;

public class Parallel {

	@Test
	public void method1()
	{
		
		System.out.println("Inside Test1");
		//Printing Id of the thread on using which test method got executed
				System.out.println("Test Case One with Thread Id:- "
						+ Thread.currentThread().getId());
	}
	
	@Test
	public void method2()
	{
		
		System.out.println("Inside Test2");
		//Printing Id of the thread on using which test method got executed
				System.out.println("Test Case two with Thread Id:- "
						+ Thread.currentThread().getId());
	}
	
}

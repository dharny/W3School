package com.W3School.reRun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyReRunAnalyzer implements IRetryAnalyzer{
	int  j = 3, i = 0 ;
	public boolean retry(ITestResult result) {
		 
		if(i>j) {
		i++;
		System.out.println("retry no :" + i);
		
		return true;
	   }
		return false;}

}

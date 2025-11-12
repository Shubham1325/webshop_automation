package com.webshopautomation.listeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryListenersImplementation implements IRetryAnalyzer
{
	@Override
	public boolean retry(ITestResult result) 
	{
		int limit=2;
		int count=0;
		while(count<limit)
		{
			count++;
			return true;
		}
		return false;
	}

}

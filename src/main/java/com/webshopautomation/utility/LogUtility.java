package com.webshopautomation.utility;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.webshopautomation.base.BaseClass;
import com.webshopautomation.listeners.ListenersImplementation;
public class LogUtility extends ListenersImplementation
{
	public void checkUrl(String expectedUrl,String passMsg)
	{
		Assert.assertEquals(BaseClass.driver.getCurrentUrl().contains(expectedUrl),true);
		test.log(Status.PASS,passMsg);
	}
}

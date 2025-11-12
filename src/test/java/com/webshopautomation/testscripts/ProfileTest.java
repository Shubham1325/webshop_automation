package com.webshopautomation.testscripts;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webshopautomation.base.BaseClass;
import com.webshopautomation.objectrepo.HomePage;
import com.webshopautomation.utility.LogUtility;
@Listeners(com.webshopautomation.listeners.ListenersImplementation.class)
public class ProfileTest extends BaseClass
{
	@Test
	public void profileClickTest()
	{
		HomePage homePage=new HomePage(driver);
		homePage.profileSelect();
		LogUtility logUtility=new LogUtility();
		logUtility.checkUrl("info","expected url is verfied and step is passed");
	}
}

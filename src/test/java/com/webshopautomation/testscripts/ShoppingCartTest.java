package com.webshopautomation.testscripts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webshopautomation.base.BaseClass;
import com.webshopautomation.objectrepo.HomePage;
@Listeners(com.webshopautomation.listeners.ListenersImplementation.class)
public class ShoppingCartTest extends BaseClass
{
	@Test
	public void shoppingCartEnabledTest()
	{
		HomePage homePage=new HomePage(driver);
		homePage.shoppingCartEnabled();
	}
}

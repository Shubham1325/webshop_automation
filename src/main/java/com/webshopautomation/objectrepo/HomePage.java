package com.webshopautomation.objectrepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;
import com.webshopautomation.base.BaseClass;
public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}	
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
	private WebElement profile;
	
	@FindBy(xpath = "//a[@class='ico-cart']//span[@class='cart-label']")
	private WebElement shoppingCart;
	
	public void profileSelect()
	{
		profile.click();
		test.log(Status.INFO,"user profile in opened");
	}
	
	public void shoppingCartEnabled()
	{
		if(shoppingCart.isEnabled())
		{
			test.log(Status.INFO,"shopping cart is enabled");
		}
		else
		{
			test.log(Status.INFO,"shopping cart is disabled");
		}
	}
}











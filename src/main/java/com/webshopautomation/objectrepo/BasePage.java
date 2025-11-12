package com.webshopautomation.objectrepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.webshopautomation.listeners.ListenersImplementation;
public class BasePage extends ListenersImplementation
{
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
}

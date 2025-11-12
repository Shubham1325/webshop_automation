package com.webshopautomation.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.webshopautomation.constants.Constants;

public class BaseClass
{
	public Properties properties;
	public FileInputStream fis;
	public static WebDriver driver;
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		properties=new Properties();
		fis=new FileInputStream(Constants.configPath);
		properties.load(fis);
	}
	
	@BeforeClass
	public void beforeClass()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("url"));
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.name("Email")).sendKeys(properties.getProperty("username"));
		driver.findElement(By.id("Password")).sendKeys(properties.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}
	
	@AfterSuite
	public void afterSuite() throws IOException  
	{
		fis.close();
	}
}

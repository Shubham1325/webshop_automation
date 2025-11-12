package com.webshopautomation.constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Constants 
{
	public static String dirPath=System.getProperty("user.dir");
	public static String configPath=dirPath+"/src/main/resources/config.properties";
	public static String reportsPath=dirPath+"/TestReports";
	public static String screenshotPath=dirPath+"/Screenshots";
	
	
}









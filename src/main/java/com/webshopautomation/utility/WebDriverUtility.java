package com.webshopautomation.utility;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.webshopautomation.base.BaseClass;
import com.webshopautomation.constants.Constants;

public class WebDriverUtility 
{
	public static String takeScreenShot(String screenShotName)
	{
		TakesScreenshot ts=(TakesScreenshot)BaseClass.driver;
		File ssPath=new File(Constants.screenshotPath+"/"+screenShotName+".png");
		File ss = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(ss, ssPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ssPath.toString();
	}
}

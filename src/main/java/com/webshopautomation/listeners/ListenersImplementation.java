package com.webshopautomation.listeners;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.webshopautomation.constants.Constants;
import com.webshopautomation.utility.JavaUtility;
import com.webshopautomation.utility.WebDriverUtility;
public class ListenersImplementation implements ISuiteListener,ITestListener
{
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		spark=new ExtentSparkReporter(Constants.reportsPath+"/"+suite.getName()+JavaUtility.getSystemDate()+".html");
		report=new ExtentReports();
		System.out.println(suite.getName()+" has started!!");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		report.attachReporter(spark);
		test=report.createTest(result.getName());
		test.log(Status.INFO, result.getName()+" has started");
		System.out.println(result.getName()+" test script  has started");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility.takeScreenShot(result.getName());
		test.log(Status.SKIP, result.getName()+" has skipped");
		System.out.println(result.getName()+" test script  has skipped");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		test.addScreenCaptureFromPath("."+WebDriverUtility.takeScreenShot(result.getName()));
		test.log(Status.FAIL, result.getName()+" has failed and captured the screenshot");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getName()+" has successfully executed");
		System.out.println(result.getName()+" test script  has executed successfully");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		System.out.println(suite.getName()+" Suite has executed");
	}

	
}

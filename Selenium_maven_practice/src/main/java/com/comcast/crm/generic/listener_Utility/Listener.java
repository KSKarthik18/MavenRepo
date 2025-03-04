	package com.comcast.crm.generic.listener_Utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.baseclass.Baseclass;
import com.comcast.crm.generic.webdriverutility.Javautility;

public class Listener implements ITestListener, ISuiteListener{
	
	ExtentReports report;
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

//	@Override
//	public void onStart(ISuite suite) {
//		// TODO Auto-generated method stub
//		String dobj= new Date().toString().replace(" ","_").replace(":", "_");
//		ExtentSparkReporter spark= new ExtentSparkReporter("./Advancereport/report+"+dobj+"+.html");
//		spark.config().setDocumentTitle("Vtiger CRM Report");
//		spark.config().setReportName("Vtiger");
//		spark.config().setTheme(Theme.DARK);
//		
//		report=new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("Browser", "Chrome");
//
//		
//	}

	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		//UtilityClass.setTest(test);
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		extentTest.get().log(Status.PASS, methodname+"--> passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String method = result.getMethod().getMethodName();
		String dobj= new Date().toString().replace(" ","_").replace(":", "_");
		//TakesScreenshot ts= (TakesScreenshot) UtilityClass.getDriver();
		//String src = ts.getScreenshotAs(OutputType.BASE64);
		//UtilityClass.getTest().addScreenCaptureFromBase64String(src, method+"_"+dobj);
		//UtilityClass.getTest().log(Status.FAIL, "Failed");
		//UtilityClass.getTest().log(Status.FAIL, result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot) Baseclass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+method+new Javautility().getsystemdateYYYYDDMM()+".jpeg");
		try {
			FileUtils.copyFile(src, dst);
			String p = dst.getAbsolutePath();
			test.addScreenCaptureFromBase64String(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().log(Status.FAIL, method+"--> passed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String method = result.getMethod().getMethodName();
		extentTest.get().log(Status.FAIL, method+"--> passed");
		
	}

	

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		File file=new File("./extnt/report.html");
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(file);
		htmlreport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Selenium execution Report");
		
		report = new ExtentReports();
		
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base-url", " https://localhost:8888");
		report.setSystemInfo("Reporter Name", "Vijayalaxmi SB");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		report.flush();
		try {
			Desktop.getDesktop().browse(new File("report.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

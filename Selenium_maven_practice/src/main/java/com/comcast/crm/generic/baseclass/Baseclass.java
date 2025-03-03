package com.comcast.crm.generic.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.Database_utility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.UtilityClass;
import com.comcast.crm.generic.webdriverutility.Webdriverutitlity;
import com.comcast.crm.objecctrepositaryutilirity.Homepage;
import com.comcast.crm.objecctrepositaryutilirity.Loginpage;
//https://github.com/KSKarthik18/CRM_Comcast.git

public class Baseclass {
		public Webdriverutitlity wlib= new Webdriverutitlity();
	    public Javautility jlib= new Javautility();
	    public Excelutility elib= new Excelutility();
		public Database_utility dlib= new Database_utility();
		public Fileutility flib= new Fileutility();
		public WebDriver driver=null;
		public static WebDriver sdriver;
	
		@BeforeSuite(alwaysRun = true)
		public void configBS() {
			System.out.println("==========Connect to DB and Report Generation=============");
			dlib.getbdconnection();
		}
		
		@Parameters("BROWSER")
		@BeforeClass(alwaysRun = true)
		public void configBC(String Brwser) throws Exception {
			System.out.println("Execute Launch the browser");
			ChromeOptions op= new ChromeOptions();
			op.addArguments("--incognito");
			String br=System.getProperty("browser",Brwser);
			String Browser =br;
					//BROWSER;
					//flib.getDatafromPropertiesFile("browser");
			
			if(Browser.equals("chrome")) {
				driver= new ChromeDriver();
			}else if (Browser.equals("firefox")) {
				driver= new FirefoxDriver();
			}else if (Browser.equals("edge")) {
				driver= new EdgeDriver();
			}else {
				driver= new ChromeDriver();
			}
			wlib.maximize(driver);
			sdriver=driver;
			UtilityClass.setDriver(driver);
			
		}
		
		@BeforeMethod(alwaysRun = true)
		public void configBM() throws Exception {
			System.out.println("Execute Login to app");
			String Url = flib.getDatafromPropertiesFile("url");
			String Username = flib.getDatafromPropertiesFile("username");
			String Password = flib.getDatafromPropertiesFile("password");
		
			Loginpage lp= new Loginpage(driver);
			wlib.implicitwait(driver);
			driver.get(Url);
			lp.logintoApp(Username, Password);
			
		}
		
		@AfterMethod(alwaysRun = true)
		public void configAM() {
			System.out.println("Execute Logout of app");
			Homepage hp= new Homepage(driver);
			hp.getSignout().click();
			Actions act= new Actions(driver);
			act.moveToElement(hp.getOut()).click().perform();
		}
		
		@AfterClass(alwaysRun = true)
		public void configAC() {
			System.out.println("Execute Close the browser");
			driver.quit();
		}
		
		@AfterSuite(alwaysRun = true)
		public void configAS() throws Exception {
			System.out.println("===========Close DB, Report Backup========");
			dlib.closeconnection();
		}
}

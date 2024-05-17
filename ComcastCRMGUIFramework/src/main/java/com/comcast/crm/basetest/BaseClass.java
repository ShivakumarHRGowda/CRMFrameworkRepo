package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	
	// create object
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	
	
	@BeforeSuite // (groups = {"smoketest","regressiontest"})
	public void configBS() throws SQLException {
		System.out.println("==== DB connection and Report configuration");
		dLib.getDBConnection();
		
	}

	//@Parameters("BROWSER")
	@BeforeClass // (groups = {"smoketest","regressiontest"})
	//public void congigBC(String browser) throws Throwable {
	public void congigBC() throws Throwable {
		System.out.println("launch browser");
		 String BROWSER=fLib.getDataFromPropertiesFile("browser");
		//String BROWSER = browser;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
      // sdriver=driver;
       UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod //(groups = { "smoketest", "regressiontest" })
	public void congifBM() throws Throwable {
		System.out.println("login");
		LoginPage lp = new LoginPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod // (groups = {"smoketest","regressiontest"})
	public void configAM() {
		System.out.println("logout");
		HomePage hp = new HomePage(driver);
		hp.singOut();

	}

	@AfterClass // (groups = {"smoketest","regressiontest"})
	public void configAC() {
		System.out.println("close browser");
		driver.quit();
	}

	@AfterSuite // (groups = {"smoketest","regressiontest"})
	public void configAS() throws SQLException {
		System.out.println("==== close DB connection and Report backup");
		dLib.closeDBConnection();
		
	}
}

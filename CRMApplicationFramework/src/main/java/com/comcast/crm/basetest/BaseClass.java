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
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.PropertiesUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
public class BaseClass {
	public DatabaseUtility dbu = new DatabaseUtility();
	public PropertiesUtility pu = new PropertiesUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	

	@BeforeSuite(groups = { "SmokeTest", "regression" })
	public void configBS() throws SQLException {
		System.out.println("=====connect to DB , Report Config===");
		dbu.getDbconnection();
		
			}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeTest", "regression" })
	public void configBC(@Optional("chrome") String browser) throws Throwable {
		System.out.println("Launch the Browser");
		String BROWSER = browser;
		// pu.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "SmokeTest", "regression" })
	public void configBM() throws Throwable {
		System.out.println("====Login====");
		String URL = pu.getDataFromPropertiesFile("url");
		String Username = pu.getDataFromPropertiesFile("username");
		String Password = pu.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToapp(Username, Password, URL);
	}

	@AfterMethod(groups = { "SmokeTest", "regression" })
	public void configAM() {
		System.out.println("========Logout=======");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "SmokeTest", "regression" })
	public void configAC() {
		System.out.println("close the browser");
		driver.close();
	}

	@AfterSuite(groups = { "SmokeTest", "regression" })
	public void configAS() throws Throwable {
		System.out.println("=======Close the DB, report backup========");
		dbu.closeDbconnection();

	}
}

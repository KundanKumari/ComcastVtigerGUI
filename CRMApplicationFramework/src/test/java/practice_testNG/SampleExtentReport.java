package practice_testNG;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.listenerutility.Listener;

public class SampleExtentReport extends Listener{

	@Test
	public void createContactTest()throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://49.249.28.218:8888");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFCer".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		}
//		driver.quit();
	}
	/*@Test
	public void createContactwithOrgTest() {
		ExtentTest test = report.createTest("createContactwithOrgTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");

		}
	}
	@Test
	public void createContactwithPhoneNumberTest() throws Throwable {
		
		//extent report support BASE64 screenshot
		ExtentTest test = report.createTest("createContactwithPhoneNumberTest");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
*/
}
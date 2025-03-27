package com.comcast.crm.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.PropertiesUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrgWithThreeTestCase extends BaseClass {
@Test(groups = "SmokeTest")
	public void CreateOrgWithOrgName() throws Throwable {

		// genetate the random number
		// step 1: read the testscript data from ExcelFile
		String OrgName = eu.getDataFromExcel("Org", 7, 2) + ju.getRandomNumer();
		// String industry = EU.getDataFromExcel("Org", 3, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrglnk().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();
		

		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createorg(OrgName);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		if (actorgName.contains(OrgName)) {
			System.out.println(OrgName + " name is verified == PASS");
		} else {
			System.out.println(OrgName + " name is not verified == PASS");
		}
	}

	@Test(groups =  "regression")
	public void CreateOrgtestWithIndustry() throws Throwable {

		// genetate the random number
		// step 1: read the testscript data from ExcelFile
		String OrgName = eu.getDataFromExcel("Org", 7, 2) + ju.getRandomNumer();
		String Industry = eu.getDataFromExcel("Org", 4, 3);
		String Type = eu.getDataFromExcel("Org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrglnk().click();

		// step 2 navigate to organization module
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();

		// step 3 click on "create organization" Button
		// step 4 enter all the details & create new organization
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createorg(OrgName, Industry, Type);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		if (actorgName.contains(OrgName)) {
			System.out.println(OrgName + " name is verified == PASS");
		} else {
			System.out.println(OrgName + " name is not verified == PASS");
		}

		// verify hearder indrustries and type info
		String actindrustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actindrustries.equals(Industry)) {
			System.out.println(Industry + "is created==PASS");
		} else {
			System.out.println(Industry + "is create==FAIL");
		}

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(Type)) {
			System.out.println(Type + "is created==PASS");
		} else {
			System.out.println(Type + "is create==FAIL");
		}
	}

	@Test(groups = "regression")
	public void CreateOrgWithPhoneN() throws Throwable {

		// genetate the random number
		// step 1: read the testscript data from ExcelFile
		String OrgName = eu.getDataFromExcel("Org", 7, 2) + ju.getRandomNumer();
		String PhoneNo = eu.getDataFromExcel("contact", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrglnk().click();

		// step 2 navigate to organization module
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();

		CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		cp.createorg(OrgName, PhoneNo);

		// verify the phone number information expected result
		String actPhoneNo = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actPhoneNo.equals(PhoneNo)) {
			System.out.println(PhoneNo + "is created==PASS");
		} else {
			System.out.println(PhoneNo + "is create==FAIL");
		}
	}
}

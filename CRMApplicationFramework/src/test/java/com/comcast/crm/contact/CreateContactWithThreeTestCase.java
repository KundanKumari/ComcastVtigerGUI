package com.comcast.crm.contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.Listener;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPagewithOrgName;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
@Listeners(com.comcast.crm.generic.listenerutility.Listener.class)
public class CreateContactWithThreeTestCase extends BaseClass {
	@Test(groups = "SmokeTest")
	public void CreateContact() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
       //step 1 : read testscript data from excelfile
		String LastName = eu.getDataFromExcel("contact", 1, 2) + ju.getRandomNumer();

		//Step 2 : navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		//Step 3 : click on createcontact button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactBtn().click();

		//step 4 : enter all the details & create new contact
		UtilityClassObject.getTest().log(Status.INFO, "create a new contact page");
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		
		cncp.Contact(LastName);
		UtilityClassObject.getTest().log(Status.PASS, LastName+"==========>create a new contact page");

		// verify the phone number information expected result
		String actheader = cp.getHeadertext().getText();
		boolean status=actheader.contains(LastName);
		Assert.assertEquals(status, true);
		
		String actLastName= cp.getLastNameText().getText();
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(actLastName, LastName);
		}
	
	@Test(groups = "regression")
	public void  CreateContact_SupportDate()throws Throwable {
	String LastName =eu.getDataFromExcel("contact", 1,2 ) + ju.getRandomNumer();
	//Step 2 : navigate to contact module
	HomePage hp = new HomePage(driver);
	hp.getContactlnk().click();

	//Step 3 : click on createcontact button
	ContactsPage cp = new ContactsPage(driver);
	cp.getCreatecontactBtn().click();
	
   String StartDate=ju.getSystemDateYYYYMMDD();
	
   //support end date	
	String Enddate=ju.getRequiriedDateYYYYMMDD(30);
	
	CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
	cncp.Contact(LastName, StartDate, Enddate);
	String actStartdate =cncp.getStartDateText().getText();
	 if(actStartdate.equals(StartDate)) {
		 System.out.println(StartDate +"is created==PASS");
	 }else {
		 System.out.println(StartDate+ "is create==FAIL");
	 }
	 
	 String actEnddate=cncp.getEndDateText().getText();
	 if(actEnddate.equals(Enddate)) {
		 System.out.println(Enddate +"is created==PASS");
	 }else {
		 System.out.println(Enddate+ "is create==FAIL");
	 }
}
	
	@Test(groups = "regression")
		public void CreateContactwithOrg() throws Throwable {
			
			String OrgName = eu.getDataFromExcel("Org", 7, 2)+ ju.getRandomNumer();
			String contactLastName = eu.getDataFromExcel("contact", 7,3)+ ju.getRandomNumer();
				 
			 HomePage hp=new HomePage(driver);
			 hp.getOrglnk().click();
			 //step 2 navigate to organization module
			 //step 3 click on "create organization" Button
			 //step 4 enter all the details & create new organization
			 OrganizationPage op=new OrganizationPage(driver);
			 op.getCreateOrgBtn().click();
			 
			 CreatingNewOrganizationPage con=new CreatingNewOrganizationPage(driver);
			 con.createorg(OrgName);
			 
			 String headerInfo=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
			 if(headerInfo.contains(OrgName)) {
				 System.out.println(OrgName +"is created==PASS");
			 }else {
				 System.out.println(OrgName+ "is create==FAIL");
			 }
			
			//step 6 navigate to organization module
			 
			 hp.getContactlnk().click();
			 
		     ContactsPage cp=new ContactsPage(driver);
		     cp.getCreatecontactBtn().click();
			 
		     
			 CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
			 cncp.getLastnametextfield().sendKeys(contactLastName);
			 cncp.getSelectBtn().click();
			 
			 wu.switchToTabOnURL(driver, "module=Accounts");

			 CreatingNewContactPagewithOrgName c=new CreatingNewContactPagewithOrgName(driver);
			 c.getSearchT().sendKeys(OrgName);
			 c.getSearchBTN().click();
			 
			
			 driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			 	
			 wu.switchToTabOnURL(driver, "module=Contacts");
			 
			 cncp.getCreateContsavebtn().click();
			 //headerInfo=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
			 headerInfo=cp.getHeadertext().getText();
			 if(headerInfo.contains(contactLastName)) {
				 System.out.println(contactLastName +"is created=====PASS");
			 }else {
				 System.out.println(contactLastName+ "is create==FAIL");
			 }
			//verify hearder orgName informationbexpected result
			 String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			 
			 //trim is used to ignore the space before string and after string
			 if(actOrgName.trim().equals(OrgName)) {
				 System.out.println(OrgName +"is created=======PASS");
			 }else {
				 System.out.println(OrgName+ "is create==FAIL");
			
			 }
			 	 
		}}

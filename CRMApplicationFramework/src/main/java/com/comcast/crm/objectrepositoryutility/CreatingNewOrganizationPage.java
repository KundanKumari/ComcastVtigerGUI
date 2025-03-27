package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDB;
	
	@FindBy(name="accounttype")
	private WebElement TypeDD;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getPhone() {
		return phone;
	}

	public WebElement getIndustryDB() {
		return industryDB;
	}
	public WebElement getTypeDD() {
		return TypeDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
//implementation is same for both the method, mehtod name is same only argument is different this concept is called
//overloading mehtod. during development of the script in "pom" class we can provide overloaded method
//because one method is require for one testscript other method may require for other testscript.
//providing different- different name of the method do not looks good. instead of can overloaded method
    public void createorg(String orgName) {
	orgNameEdt.sendKeys(orgName);
	saveBtn.click();
}
    public void createorg(String orgName, String industry, String type) {
    	orgNameEdt.sendKeys(orgName);
    	Select sel=new Select(industryDB);
    	sel.selectByVisibleText(industry);
    	Select sel1=new Select(TypeDD);
    	sel1.selectByVisibleText(type);
    	saveBtn.click();    	
    }
    public void createorg(String orgName, String phoneNo) {
    	orgNameEdt.sendKeys(orgName);
    	phone.sendKeys(phoneNo);
    	saveBtn.click();
}}

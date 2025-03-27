package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;
	//contructor
	public ContactsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(linkText ="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreatecontactBtn;
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement headertext;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement LastNameText;


	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCreatecontactBtn() {
		return CreatecontactBtn;
	}
	public WebElement getHeadertext() {
		return headertext;
	}
	public WebElement getLastNameText() {
		return LastNameText;
	}
	
}

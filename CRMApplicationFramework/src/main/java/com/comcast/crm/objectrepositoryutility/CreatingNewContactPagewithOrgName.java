package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewContactPagewithOrgName {
	WebDriver driver;
	public CreatingNewContactPagewithOrgName(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement searchT;

	@FindBy(xpath="//input[@type='button']")
	private WebElement searchBTN;

	
	
	public WebElement getSearchT() {
		return searchT;
	}
 
	public WebElement getSearchBTN() {
		return searchBTN;
	}
	
	
}

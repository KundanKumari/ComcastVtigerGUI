package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnametextfield;

	@FindBy(name = "support_start_date")
	private WebElement support_start_date;

	@FindBy(name = "support_end_date")
	private WebElement support_end_date;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement StartDateText;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement EndDateText;

	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement selectBtn;

	@FindBy(xpath = "//input[@name='button']")
	private WebElement CreateContsavebtn;
	

	public WebElement getLastnametextfield() {
		return lastnametextfield;
	}
	public WebElement getSupport_start_date() {
		return support_start_date;
	}

	public WebElement getSupport_end_date() {
		return support_end_date;
	}

	public WebElement getStartDateText() {
		return StartDateText;
	}

	public WebElement getEndDateText() {
		return EndDateText;
	}
	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getCreateContsavebtn() {
		return CreateContsavebtn;
	}

	public void Contact(String contactLastName) {
		lastnametextfield.sendKeys(contactLastName);
		CreateContsavebtn.click();
	}
	public void Contact(String contactLastName, String StartDate, String EndDate) {
		lastnametextfield.sendKeys(contactLastName);
		support_start_date.clear();
		support_start_date.sendKeys(StartDate);
		
		support_end_date.clear();
		support_end_date.sendKeys(EndDate);
		CreateContsavebtn.click();

}}

package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
   public HomePage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
	@FindBy(linkText="Organizations")
	private WebElement orglnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlnk;
	
	@FindBy(linkText="More")
	private WebElement morelnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignslnk;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText ="Sign Out")
	private WebElement signoutLink;
	
	public WebElement getOrglnk() {
		return orglnk;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}

	public WebElement getMorelnk() {
		return morelnk;
	}

	public WebElement getCampaignslnk() {
		return campaignslnk;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignout() {
		return signoutLink;
	}
	
	
	public void navigateToCampaginPage() {
		Actions act=new Actions(driver);
		act.moveToElement(morelnk).perform();;
		campaignslnk.click();
	}
	public void logout() {
		Actions act= new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutLink.click();
	}
	
}

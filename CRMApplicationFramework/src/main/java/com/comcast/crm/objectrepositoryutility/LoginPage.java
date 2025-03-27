package com.comcast.crm.objectrepositoryutility;
/**
 * 
 * @author kunda
 * 
 * Cantains login page elements & business lp like login()
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
//Rule-1 create a seperate java class
public class LoginPage extends WebDriverUtility{  
	
	//create globle driver object
	WebDriver driver;
	//create a consructor inside consructor we do initialization. then pass the driver object. using driver object
	public LoginPage(WebDriver driver) {
		//local variable and globle veriable has same name in avoid the confusion we use this keyword.
		this.driver=driver;
		//secong argument this keyword mean current class object.
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	//Rule-2 Object Creation
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	
//Rule 3 : object Initialization 
//Rule 4 : object Encapsulation

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void LoginToapp(String username, String password) {
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}

//run 5 : provide Action
/**
 * login to application based username, password, url arguments
 * 	
 * @param username
 * @param password
 * @param URL
 */
	public void LoginToapp(String username, String password, String URL) {
		waitForPageToLoad(driver);
		driver.get(URL);
		driver.manage().window().maximize();
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}

}

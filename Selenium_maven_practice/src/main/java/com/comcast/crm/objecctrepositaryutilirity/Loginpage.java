package com.comcast.crm.objecctrepositaryutilirity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.Webdriverutitlity;

public class Loginpage extends Webdriverutitlity {
	
	public Loginpage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//rule1 create a seperate java classs
	//rule 2 object creation
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement Usernameedt;
	
	@FindBy(name="user_password")
	private WebElement Passwordedt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	//rule 4 object encapsulation
	public WebElement getUsernameedt() {
		return Usernameedt;
	}

	public WebElement getPasswordedt() {
		return Passwordedt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//rule 5[Business method]
	
	//we can provide action
	public void logintoApp(String Username, String Password) {
		//Webdriverutitlity wlib= new Webdriverutitlity();
		//wlib.implicitwait(driver);
		// not required to create an object when extends is used
//		implicitwait(driver);
//		maximize(driver);
//		driver.get(URL);
		Usernameedt.sendKeys(Username);
		Passwordedt.sendKeys(Password);
		loginbtn.click();
	}
	
	
	
	
	
	
	//rule 3: object initialization
	
}

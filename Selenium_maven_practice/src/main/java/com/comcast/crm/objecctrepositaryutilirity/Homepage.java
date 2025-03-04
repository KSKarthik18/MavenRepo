package com.comcast.crm.objecctrepositaryutilirity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	//rule 3
	public Homepage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//step 2 object creation
	@FindBy(linkText = "Organizations")
	private WebElement orglnk;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement cntlnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signout;
	
	@FindBy(linkText = "Sign Out")
	private WebElement out;

	//rule4 
	public WebElement getOut() {
		return out;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getOrglnk() {
		return orglnk;
	}

	public WebElement getCntlnk() {
		return cntlnk;
	}
	

	
	
	
}

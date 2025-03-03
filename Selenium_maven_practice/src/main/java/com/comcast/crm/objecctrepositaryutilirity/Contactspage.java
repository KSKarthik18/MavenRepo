package com.comcast.crm.objecctrepositaryutilirity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage {
	
	//step3 
	
	public Contactspage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}
	//step1 make seperate classes for elements
	//step2  find elements
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontact;
	
	//step4 object encapsualation
	
	public WebElement getCreatecontact() {
		return createcontact;
	}
}

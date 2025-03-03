package com.comcast.crm.objecctrepositaryutilirity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactsinfopage {
	
	public Contactsinfopage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement header;
	
	public WebElement getHeader() {
		return header;
	}
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startdate;
	
	@FindBy(xpath  = "//td[@id='mouseArea_Support End Date']")
	private WebElement endate;
	
	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEndate() {
		return endate;
	}
	
	
}

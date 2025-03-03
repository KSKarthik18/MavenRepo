package com.comcast.crm.objecctrepositaryutilirity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {
	//step3 
	
	public CreateNewContactsPage(WebDriver driver) {
	
		PageFactory.initElements(driver,this);
	}
	
	//step2
	@FindBy(name = "lastname")
	private WebElement name;
	
	@FindBy(name = "support_start_date")
	private WebElement startdate;
	
	@FindBy(name="support_end_date")
	private WebElement endate;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement addorganization;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	//step4
	public WebElement getName() {
		return name;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEndate() {
		return endate;
	}

	public WebElement getAddorganization() {
		return addorganization;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	//step5
	public void writedata(String contactname) {
	getName().sendKeys(contactname);
	savebtn.click();
	}
	
	public void writedata(String contactname,String srtdate, String ndate) {
		name.sendKeys(contactname);
		startdate.clear();
		startdate.sendKeys(srtdate);
		endate.clear();
		endate.sendKeys(ndate);
		savebtn.click();
	}
	
	public void newdata(String contactname,String srtdate, String ndate) {
		name.sendKeys(contactname);
		startdate.clear();
		startdate.sendKeys(srtdate);
		endate.clear();
		endate.sendKeys(ndate);
	}

}

package contacts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.baseclass.Baseclass;
import com.comcast.crm.objecctrepositaryutilirity.Contactsinfopage;
import com.comcast.crm.objecctrepositaryutilirity.Contactspage;
import com.comcast.crm.objecctrepositaryutilirity.CreateNewContactsPage;
import com.comcast.crm.objecctrepositaryutilirity.CreateNewOrganizationPage;
import com.comcast.crm.objecctrepositaryutilirity.Homepage;
import com.comcast.crm.objecctrepositaryutilirity.Organizationpage;
//@Listeners(com.comcast.crm.generic.listener_Utility.Listener.class)
public class Working_with_Cnt_TC_baseclassTest extends Baseclass {
	@Test(groups = "Smoke_Test")
	public void contacts_01() throws Exception {
		
		String contname = elib.getDataFromExcel("Sheet1", 10, 2) +jlib.getrandomnumber();
		
		Homepage hp= new Homepage(driver);
		hp.getCntlnk().click();
		
		Contactspage cp=new Contactspage(driver);
		cp.getCreatecontact().click();
		
		CreateNewContactsPage cnp= new CreateNewContactsPage(driver);
		cnp.writedata(contname);
		
		Contactsinfopage cip=new Contactsinfopage(driver);
		String actualheader = cip.getHeader().getText();
		boolean status =actualheader.contains(contname);
		//verify
		SoftAssert srt=new SoftAssert();
		srt.assertTrue(status);
		srt.assertAll();
//		if(actualheader.contains(contname)) {
//			System.out.println(contname+ " created");
//		}else {
//			System.out.println(contname+ " Not created");
//		}
		System.out.println("test case CNT1 completed");
	}
	
	@Test(groups = "Regression_test")
	public void contacs_02() throws Exception {

		String contname = elib.getDataFromExcel("Sheet1", 10, 2) + jlib.getrandomnumber();
		
		
//		//to get current date
		String actualdate = jlib.getsystemdateYYYYDDMM();
		
		//to get 30days date
		String datereq = jlib.getsystemdateYYYYDDMM(30);
		
		Homepage hp= new Homepage(driver);
		hp.getCntlnk().click();

		Contactspage cp= new Contactspage(driver);
		cp.getCreatecontact().click();
		
		CreateNewContactsPage cnp= new CreateNewContactsPage(driver);
		cnp.writedata(contname, actualdate, datereq);
		
	
		Contactsinfopage cip=new Contactsinfopage(driver);
		String srtdate = cip.getStartdate().getText();
		String ndate = cip.getEndate().getText();
		//verify
		Assert.assertEquals(actualdate,srtdate);
		Assert.assertEquals(datereq, ndate.trim());
	
		System.out.println("test case CNT2 completed");
	}
	
	@Test(groups = "Regression_test")
	public void Contacts_06() throws Exception {
		String contname = elib.getDataFromExcel("Sheet1", 10, 2);
		String orgname = elib.getDataFromExcel("Sheet1", 1, 2)+ jlib.getrandomnumber();
		
		//to get current date
		String actualdate = jlib.getsystemdateYYYYDDMM();
		//to get 30days date
		String datereq = jlib.getsystemdateYYYYDDMM(30);

		Homepage hp= new Homepage(driver);
		hp.getOrglnk().click();
		
		Organizationpage op= new Organizationpage(driver);
		op.getCreatbtn().click();
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.writedata(orgname);
		
		WebElement ele = hp.getCntlnk();
		System.out.println(ele);
		Thread.sleep(2000);
		ele.click();
       
		Contactspage cp= new Contactspage(driver);
		cp.getCreatecontact().click();
	
		CreateNewContactsPage cnp= new CreateNewContactsPage(driver);
		cnp.newdata(contname, actualdate, datereq);		
		cnp.getAddorganization().click();

		Set<String> allwh = driver.getWindowHandles();
		//System.out.println(allwh.size());
		String wh = driver.getWindowHandle();
		for (String we : allwh) {
			driver.switchTo().window(we);
		}
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.switchTo().window(wh);

		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	
		//organization name verify
		String Actualorgname = driver.findElement(By.xpath("(//a[text()='"+orgname+"'])[2]")).getText();
		if(Actualorgname.equals(orgname)) {
			System.out.println("Verified");
		}else {
			System.out.println("Organization not verified");
		}
			System.out.println("test case CNT3 completed");
	}
	
}

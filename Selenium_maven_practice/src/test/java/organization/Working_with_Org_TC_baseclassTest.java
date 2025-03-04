package organization;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseclass.Baseclass;
import com.comcast.crm.objecctrepositaryutilirity.CreateNewOrganizationPage;
import com.comcast.crm.objecctrepositaryutilirity.Homepage;
import com.comcast.crm.objecctrepositaryutilirity.Organizationpage;

//@Listeners(com.comcast.crm.generic.listener_Utility.Listener.class)

public class Working_with_Org_TC_baseclassTest extends Baseclass {

	@Test(groups="Smoke_Test")
	public void organization_01() throws Exception {

		int rannum = jlib.getrandomnumber();

		String orgname = elib.getDataFromExcel("Sheet1", 1, 2) + rannum;

		Homepage hp = new Homepage(driver);
		hp.getOrglnk().click();

		Organizationpage op = new Organizationpage(driver);
		op.getCreatbtn().click();

		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.writedata(orgname, "Banking");

		// verify
		String heading = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (heading.contains(orgname)) {
			System.out.println(orgname + "\t" + "created");
		} else {
			System.out.println(orgname + "Not created");
		}

		String actualname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actualname.trim().equals(orgname)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		System.out.println("test case  ORG1 Completed");
	}

	@Test(groups="Regression_test")
	public void organization_02() throws Exception {

		int rannum = jlib.getrandomnumber();

		String orgname = elib.getDataFromExcel("Sheet1", 4, 2) + rannum;
		String Industries = elib.getDataFromExcel("Sheet1", 4, 3);
		String Type = elib.getDataFromExcel("Sheet1", 4, 4);

		Homepage hp = new Homepage(driver);
		hp.getOrglnk().click();

		Organizationpage op = new Organizationpage(driver);
		op.getCreatbtn().click();

		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.writedata(orgname, Industries, Type);

		// verify
		String heading = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (heading.trim().contains(orgname)) {
			System.out.println(orgname + "created");
		} else {
			System.out.println(orgname + "Not created");
		}

		String actualname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actualname.trim().equals(orgname)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		System.out.println("test case ORG2 Completed");
	}
	
	@Test(groups="Regression_test")
	public void organization_03() throws Exception {
		int rannum=jlib.getrandomnumber();
	
		String orgname = elib.getDataFromExcel("Sheet1", 7, 2) +rannum;
		String Industries = elib.getDataFromExcel("Sheet1", 7, 3);
		String Type = elib.getDataFromExcel("Sheet1", 7, 4);
		String Phones = elib.getDataFromExcel("Sheet1", 7, 5);
				
		Homepage hp= new Homepage(driver);
		hp.getOrglnk().click();
		
		Organizationpage op= new Organizationpage(driver);
		op.getCreatbtn().click();
		
		CreateNewOrganizationPage cnp= new CreateNewOrganizationPage(driver);
		cnp.writedata(orgname, Industries, Type, Phones);
		
	
		//verify
		String heading = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(heading.contains(orgname)) {
			System.out.println(orgname+ " created");
		}else {
			System.out.println(orgname+ " Not created");
		}
		
		String actualname = driver.findElement(By.id("mouseArea_Organization Name")).getText();

		if(actualname.trim().equals(orgname)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		String actual_num = driver.findElement(By.id("mouseArea_Phone")).getText();
		if(actual_num.trim().equals(Phones)) {
			System.out.println("Number added sucessfulyy"+ Phones);
		}else {
			System.out.println("failed to add");
		}
		System.out.println("test case ORG3 Completed");
	}
}


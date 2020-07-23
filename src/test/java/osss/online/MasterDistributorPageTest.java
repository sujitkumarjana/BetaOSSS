package osss.online;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MasterDistributorPage;
import TestBase.BaseClass;

//Author: Shyam
public class MasterDistributorPageTest extends BaseClass 
{
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MasterDistributorPage masterDistributorPage;
	
	//Creating the constructor
	public MasterDistributorPageTest()
	{
	 super();
	}
	
	@BeforeMethod()
	public void setup()
	{
	 initialization();
	 homePage = new HomePage();
	 homePage.navigatetoLoginPage();
	 loginPage = new LoginPage();
	 loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
	 dashboardPage = new DashboardPage();
	 dashboardPage.navigatetoMasterDistributorPage();
	 masterDistributorPage = new MasterDistributorPage();
	}
	
	@Test(enabled=false)
	public void verifyPageLabel(){
		Assert.assertEquals(masterDistributorPage.verifyPage(), "Master Distributors");;
	}
	
	@Test(enabled=false)
	public void ClickOnAddNewTest()
	{
	 masterDistributorPage.ClickOnAddNew();
	}
	
	@Test(priority=1)
	public void AddMasterDistributorTest() throws InterruptedException
	{
	 masterDistributorPage.ClickOnAddNew();
	 Thread.sleep(2000);
	// masterDistributorPage.AddMDPersonalInformation("Shyam", "GHorai", "ss@mailinator.com", "9865320102", "ARTPH2265D", "896545214578");

	 masterDistributorPage.AddMDAddressInformation("India", "Himachal Pradesh");

	}
}

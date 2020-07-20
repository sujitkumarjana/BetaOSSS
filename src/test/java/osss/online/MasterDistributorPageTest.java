package osss.online;

<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
=======
import org.testng.annotations.BeforeMethod;
>>>>>>> 4137fd05b5b48d36a5493972bd9d8a7ed06f582d
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MasterDistributorPage;
import TestBase.BaseClass;

<<<<<<< HEAD
public class MasterDistributorPageTest extends BaseClass{
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MasterDistributorPage mdPage;
	
	
	public MasterDistributorPageTest(){
		super();
	}

	@BeforeClass
	public void setup(){
		initialization();
		homePage = new HomePage();
		homePage.navigatetoLoginPage();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		mdPage = new MasterDistributorPage();
	}
	
	@Test
	public void verifyPageLabel(){
		Assert.assertEquals(mdPage.verifyPage(), "Master Distributors");;
	}
	
	
	
=======
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
	 dashboardPage.NavigateToMasterDistributor();
	 masterDistributorPage = new MasterDistributorPage();
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
	 masterDistributorPage.AddMDAddressInformation("Iran");
	}
>>>>>>> 4137fd05b5b48d36a5493972bd9d8a7ed06f582d
}

package osss.online;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import TestBase.BaseClass;

public class DashboardPageTest extends BaseClass{
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	

	public DashboardPageTest(){
		super();
	}
	
	@BeforeClass
	public void setup(){
		initialization();
		homePage = new HomePage();
		homePage.navigatetoLoginPage();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		dashboardPage = new DashboardPage();
		dashboardPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		
	}
	
	@Test
	public void verifyPageTitle(){
		String dashboardPageTitle = dashboardPage.verifyPageTitle();
		Assert.assertEquals(dashboardPageTitle, "SSS - Easy & Complete Solution", 
				"Dashboard page title not matched.");
	}
	
	/*@Test(priority = 2)
	public void verifyPageURL(){
		String dashboardPageURL = dashboardPage.verifyPageURL();
		Assert.assertEquals(dashboardPageURL, "http://beta.osss.online/Home/Dashboard", 
				"Dashboard page URL not matched.");
	}*/
	
	@Test
	public void verifyMenuItems(){
		String userType = prop.getProperty("usertype");
		if(userType.equalsIgnoreCase("Admin")){
		Assert.assertTrue(dashboardPage.employeeMenu(), "Employees Menu is not displayed");
		Assert.assertTrue(dashboardPage.manageFundMenu(), "Manage Fund Menu is not displayed");
		Assert.assertTrue(dashboardPage.masterDistributorMenu(), "Master Distributor Menu is not displayed");
		Assert.assertTrue(dashboardPage.distributorMenu(), "Distributor Menu is not displayed");
		Assert.assertTrue(dashboardPage.retailersMenu(), "Retailers Menu is not displayed");
		Assert.assertTrue(dashboardPage.customersMenu(), "Customer Menu is not displayed");
		}
		else if(userType.equalsIgnoreCase("MD")){
			Assert.assertTrue(!dashboardPage.employeeMenu(), "Employees Menu is not displayed");
			Assert.assertTrue(!dashboardPage.manageFundMenu(), "Manage Fund Menu is not displayed");
			Assert.assertTrue(!dashboardPage.masterDistributorMenu(), "Master Distributor Menu is not displayed");
			Assert.assertTrue(dashboardPage.distributorMenu(), "Distributor Menu is not displayed");
			Assert.assertTrue(dashboardPage.retailersMenu(), "Retailers Menu is not displayed");
			Assert.assertTrue(!dashboardPage.customersMenu(), "Customer Menu is not displayed");
		}
		else if(userType.equalsIgnoreCase("Distributors")){
			Assert.assertTrue(!dashboardPage.employeeMenu(), "Employees Menu is not displayed");
			Assert.assertTrue(!dashboardPage.manageFundMenu(), "Manage Fund Menu is not displayed");
			Assert.assertTrue(!dashboardPage.masterDistributorMenu(), "Master Distributor Menu is not displayed");
			Assert.assertTrue(!dashboardPage.distributorMenu(), "Distributor Menu is not displayed");
			Assert.assertTrue(dashboardPage.retailersMenu(), "Retailers Menu is not displayed");
			Assert.assertTrue(!dashboardPage.customersMenu(), "Customer Menu is not displayed");
		}
	}
	
//<<<<<<< HEAD
	@Test
	public void verifyUserLavel(){
		Assert.assertEquals(dashboardPage.verifyUserType(), "Admin");;
	}
//=======
    //Author: Shyam
	// Navigating to Master Distributor Page
	
	@Test(priority = 4)
	public void NavigateToMDPageTest()
	{
	  dashboardPage.NavigateToMasterDistributor();
	}
	
//>>>>>>> 4137fd05b5b48d36a5493972bd9d8a7ed06f582d
	
	@AfterClass
	public void TearDown(){
		driver.quit();
	}
	
}

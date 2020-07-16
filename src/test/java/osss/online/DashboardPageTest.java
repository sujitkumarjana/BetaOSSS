package osss.online;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.BaseClass;

public class DashboardPageTest extends BaseClass{
	
	

	public DashboardPageTest(){
		super();
	}
	
	@BeforeClass
	public void setup(){
		initialization();
		homePageObject = new HomePage();
		homePageObject.navigatetoLoginPage();
		loginPageObject = new LoginPage();
		dashboardPageObject = loginPageObject.login(prop.getProperty("user"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyPageTitle(){
		String dashboardPageTitle = dashboardPageObject.verifyPageTitle();
		Assert.assertEquals(dashboardPageTitle, "SSS - Easy & Complete Solution", 
				"Dashboard page title not matched.");
	}
	
	@Test(priority = 2)
	public void verifyPageURL(){
		String dashboardPageURL = dashboardPageObject.verifyPageURL();
		System.out.println("Dashboard Page URl is: " + dashboardPageURL);
		Assert.assertEquals(dashboardPageURL, "http://beta.osss.online/Home/Dashboard", 
				"Dashboard page URL not matched.");
	}
	
	@Test(priority = 3)
	public void verifyMenuItems(){
		Assert.assertTrue(dashboardPageObject.employeeMenu(), "Employees Menu is not displayed");
		Assert.assertTrue(dashboardPageObject.manageFundMenu(), "Manage Fund Menu is not displayed");
		Assert.assertTrue(dashboardPageObject.masterDistributorMenu(), "Master Distributor Menu is not displayed");
		Assert.assertTrue(dashboardPageObject.distributorMenu(), "Distributor Menu is not displayed");
		Assert.assertTrue(dashboardPageObject.retailersMenu(), "Retailers Menu is not displayed");
		Assert.assertTrue(dashboardPageObject.customersMenu(), "Customer Menu is not displayed");
	}
	

	
	/*@AfterClass
	public void TearDown(){
		driver.quit();
	}*/
	
}

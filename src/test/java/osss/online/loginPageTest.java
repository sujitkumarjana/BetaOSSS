package osss.online;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.BaseClass;

public class loginPageTest extends BaseClass{

	HomePage homePage;
	LoginPage loginPage;
	
	public loginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setup (){
		initialization();
		homePage= new HomePage();
		homePage.navigatetoLoginPage();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void VerifyPageTitle(){
		String loginPageTitle = loginPage.verifyPageTitle();
		Assert.assertEquals(loginPageTitle, "SSS - Easy & Complete Solution");
	}
	
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}

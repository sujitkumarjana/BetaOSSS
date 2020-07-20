package osss.online;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MasterDistributorPage;
import TestBase.BaseClass;

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
	
	
	
}

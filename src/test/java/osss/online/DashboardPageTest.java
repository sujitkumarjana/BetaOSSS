package osss.online;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.DashboardPage;
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
	
	@Test()
	public void login(){
		dashboardPageObject.verifyPageTitle();
	}
	
	
	
	
}

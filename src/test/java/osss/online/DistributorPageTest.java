package osss.online;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.DistributorPage;
import Pages.HomePage;
import Pages.LoginPage;
import TestBase.BaseClass;

public class DistributorPageTest extends BaseClass{
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	DistributorPage distributorPage;
	
	public DistributorPageTest(){
		super();
	}

	@BeforeClass
	public void setup(){
		initialization();
		homePage = new HomePage();
		homePage.navigatetoLoginPage();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		dashboardPage.navigatetoDistributorPage();
		distributorPage = new DistributorPage();
	}
	
	@Test
	public void verifyDistributorPageLabelTest(){
		String title = distributorPage.verifyDistributorPageTitle();
		Assert.assertEquals(title, "Distributors", "Distribuitor page label not matched.");
	}
	
	@Test
	public void addNewDistributor(){
		distributorPage.addDistributor();
		distributorPage.adddistributorPersonalInformation("ABC", "XYZ", "ABC@ABC.com", "51654656356", 
				"ABCD1234", "ABCD1234", "C:/Users/DELL/Pictures/download.jpg");
		/*distributorPage.addDistributorAddressInformation("India", "Bihar", "Kolkata", "700054", "Test Test");*/
		distributorPage.ChooseServices("Recharge");
	}
		
}

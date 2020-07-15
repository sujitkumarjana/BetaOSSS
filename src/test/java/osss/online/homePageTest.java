package osss.online;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import TestBase.BaseClass;

public class homePageTest extends BaseClass{

	HomePage homePage;
	public homePageTest (){
		super();
	}
	
	@Test
	public void getTitleTest(){
		initialization();
		homePage = new HomePage();
		String homePageTitle = homePage.getTitle();
		Assert.assertEquals(homePageTitle, "OSSS");
	}
	
}

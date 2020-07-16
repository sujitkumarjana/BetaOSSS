package Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestBase.BaseClass;

public class DashboardPage extends BaseClass{
	
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	
	public String verifyPageURL(){
		return driver.getCurrentUrl();
	}

}

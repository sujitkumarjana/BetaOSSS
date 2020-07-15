package Pages;

import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class HomePage extends BaseClass{

	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
}

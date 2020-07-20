package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class MasterDistributorPage extends BaseClass{

	public MasterDistributorPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//i[@class = 'icon-people mr-2']//following::span[@class = 'font-weight-semibold']")
	WebElement pageLabel;
	
	public String verifyPage(){
		return pageLabel.getText();
	}
	
	
	
	
}

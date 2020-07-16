package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy (xpath = "//input[@id = 'UserName']")
	WebElement userName;
	@FindBy (xpath = "//input[@id = 'Password']")
	WebElement passWord;
	@FindBy (xpath = "//button[@id = 'btnLogin']")
	WebElement submit;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	
	public DashboardPage login(String username, String Password){
		userName.sendKeys(username);
		passWord.sendKeys(Password);
		submit.click();
		return new DashboardPage();
	}

}

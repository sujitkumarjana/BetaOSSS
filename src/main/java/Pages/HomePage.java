package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class HomePage extends BaseClass{

	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public LoginPage navigatetoLoginPage(){
		driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]")).click();
		return new LoginPage();
	}
	
}

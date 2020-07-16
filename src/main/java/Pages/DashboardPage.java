package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class DashboardPage extends BaseClass{
	
	@FindBy (xpath = "//span[contains(text(), 'Employees')]")
	WebElement employeeMenu;
	@FindBy (xpath = "//span[contains(text(), 'Manage Fund')]")
	WebElement manageFundMenu;
	@FindBy (xpath = "//span[contains(text(), 'Master Distributors')]")
	WebElement masterDistributorMenu;
	@FindBy (xpath = "//span[contains(text(), 'Master Distributors')]//following::span[contains(text(), 'Distributors')]")
	WebElement distributorMenu;
	@FindBy (xpath = "//span[contains(text(), 'Retailers')]")
	WebElement retailersMenu;
	@FindBy (xpath = "//span[contains(text(), 'Customers')]")
	WebElement costomersMenu;
	
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	
	public String verifyPageURL(){
		return driver.getCurrentUrl();
	}

	public boolean employeeMenu(){
		return employeeMenu.isDisplayed();
	}
	
	public boolean manageFundMenu(){
		return manageFundMenu.isDisplayed();
	}
	
	public boolean masterDistributorMenu(){
		return masterDistributorMenu.isDisplayed();
	}
	
	public boolean distributorMenu(){
		return distributorMenu.isDisplayed();
	}
	
	public boolean retailersMenu(){
		return retailersMenu.isDisplayed();
	}
	
	public boolean customersMenu(){
		return costomersMenu.isDisplayed();
	}
	
	
	
	
}

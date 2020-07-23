package Pages;

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
	@FindBy (xpath = "//div[@class = 'card-body text-center']//span")
	WebElement userLeble;
	
	//Initializing driver
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Verify dashboard page title
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	
	//Verify dashboard page URL
	public String verifyPageURL(){
		return driver.getCurrentUrl();
	}

	//Verify "Employee" menu present or not
	public boolean employeeMenu(){
		return employeeMenu.isDisplayed();
	}
	
	//Verify "Manage Fund" menu present or not
	public boolean manageFundMenu(){
		return manageFundMenu.isDisplayed();
	}
	
	//Verify "Master Distributor" menu present or not
	public boolean masterDistributorMenu(){
		return masterDistributorMenu.isDisplayed();
	}
	
	//Verify "Distributor" menu present or not
	public boolean distributorMenu(){
		return distributorMenu.isDisplayed();
	}
	
	//Verify "Retailer" menu present or not
	public boolean retailersMenu(){
		return retailersMenu.isDisplayed();
	}
	
	//Verify "Customer" menu present or not
	public boolean customersMenu(){
		return costomersMenu.isDisplayed();
	}
	
	//Verify user type (Admin, Master Distributor, Distributor...)
	public String verifyUserType(){
		return userLeble.getText();
	}
	
	//Navigate to "Master Distributor" page
	public MasterDistributorPage navigatetoMasterDistributorPage(){
		masterDistributorMenu.click();
		return new MasterDistributorPage();
	}

	//Navigate to "Distributor" page
	public DistributorPage navigatetoDistributorPage(){
		distributorMenu.click();
		return new DistributorPage();
	}
	
}

package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseClass;

public class DistributorPage extends BaseClass{
	
	@FindBy (xpath = "//i[@class = 'icon-people mr-2']//following::span[contains(text(), 'Distributors') and @class = 'font-weight-semibold']")
	WebElement distributorPageLabel;
	@FindBy (xpath = "//button[contains(text(),'Actions')]")
	WebElement actions;
	@FindBy (xpath = "//a[contains(text(), 'Add New')]")
	WebElement addNewDistributor;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public DistributorPage(){
		PageFactory.initElements(driver, this);
	}

	//Verifying Distributor page label
	public String verifyDistributorPageTitle(){
		return distributorPageLabel.getText();
	}
	
	public void addDistributor(){
		actions.click();
		addNewDistributor.click();
	}
	
	public void adddistributorPersonalInformation(String FirstName, String LastName, String Email, String Phone,
			String PAN, String Aadhar, String Picture){
		
		WebElement fName = driver.findElement(By.xpath("//input[@ng-model= 'BodyObj.first_name']"));
		fName.sendKeys(FirstName);
		
		WebElement lName = driver.findElement(By.xpath("//input[@ng-model= 'BodyObj.last_name']"));
		lName.sendKeys(LastName);
		
		WebElement email = driver.findElement(By.xpath("//input[@ng-model= 'BodyObj.email_address']"));
		email.sendKeys(Email);
		
		js.executeScript("document.getElementById('txtPhone').value='" + Phone + "'");
		/*WebElement phone = driver.findElement(By.xpath("//input[@ng-model= 'BodyObj.formatted_number']"));
		phone.sendKeys(Phone);*/
		
		WebElement pan = driver.findElement(By.xpath("//input[@ng-model= 'BodyObj.pan_card_number']"));
		pan.sendKeys(PAN);
		
		WebElement aadhar = driver.findElement(By.xpath("//input[@ng-model= 'BodyObj.aadhar_card_number']"));
		aadhar.sendKeys(Aadhar);
		
		WebElement picture = driver.findElement(By.xpath("//input[@id = 'postedFile']"));
		picture.sendKeys(Picture);
		
	}
	
	public void addDistributorAddressInformation(String Country, String State, String City, 
			String PIN, String Address){
		
		WebElement countryList = driver.findElement(By.xpath("//span[@id = 'select2-ddlCountry-container']"));
		countryList.click();
		driver.findElement(By.xpath("//select[@id='ddlCountry']//option[@label = '"+ Country +"']")).click();
		
		WebElement stateList = driver.findElement(By.xpath("//span[contains(text(), 'Select State')]"));
		stateList.click();
		driver.findElement(By.xpath("//select[@data-placeholder = 'Select State']/option[@label = '"+ State +"']")).click();
		
		WebElement city = driver.findElement(By.xpath("//input[@ng-model = 'BodyObj.city']"));
		city.sendKeys(City);
		
		WebElement pin = driver.findElement(By.xpath("//input[@ng-model = 'BodyObj.zip']"));
		pin.sendKeys(PIN);
		
		WebElement address = driver.findElement(By.xpath("//input[@ng-model = 'BodyObj.address1']"));
		address.sendKeys(Address);
	}
	
}

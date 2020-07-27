package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseClass;

public class DistributorPage extends BaseClass {

	@FindBy(xpath = "//i[@class = 'icon-people mr-2']//following::span[contains(text(), 'Distributors') and @class = 'font-weight-semibold']")
	WebElement distributorPageLabel;
	@FindBy(xpath = "//button[contains(text(),'Actions')]")
	WebElement actions;
	@FindBy(xpath = "//a[contains(text(), 'Add New')]")
	WebElement addNewDistributor;

	@FindBy(xpath = "//input[@ng-model= 'BodyObj.first_name']")
	WebElement fName;
	@FindBy(xpath = "//input[@ng-model= 'BodyObj.last_name']")
	WebElement lName;
	@FindBy(xpath = "//input[@ng-model= 'BodyObj.email_address']")
	WebElement email;
	@FindBy(xpath = "//input[@ng-model= 'BodyObj.pan_card_number']")
	WebElement pan;
	@FindBy(xpath = "//input[@ng-model= 'BodyObj.aadhar_card_number']")
	WebElement aadhar;
	@FindBy(xpath = "//input[@id = 'postedFile']")
	WebElement picture;

	@FindBy(xpath = "//span[@id = 'select2-ddlCountry-container']")
	WebElement countryList;
	@FindBy(xpath = "//span[contains(text(), 'Select State')]")
	WebElement stateList;
	@FindBy(xpath = "//input[@ng-model = 'BodyObj.city']")
	WebElement city;
	@FindBy(xpath = "//input[@ng-model = 'BodyObj.zip']")
	WebElement pin;
	@FindBy(xpath = "//input[@ng-model = 'BodyObj.address1']")
	WebElement address;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions action;

	public DistributorPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Distributor page label
	public String verifyDistributorPageTitle() {
		return distributorPageLabel.getText();
	}

	public void addDistributor() {
		actions.click();
		addNewDistributor.click();
	}

	public void adddistributorPersonalInformation(String FirstName, String LastName, String Email, String Phone,
			String PAN, String Aadhar, String Picture) {

		fName.sendKeys(FirstName);
		lName.sendKeys(LastName);
		email.sendKeys(Email);
		js.executeScript("document.getElementById('txtPhone').value='" + Phone + "'");
		pan.sendKeys(PAN);
		aadhar.sendKeys(Aadhar);
		picture.sendKeys(Picture);

	}

	public void addDistributorAddressInformation(String Country, String State, String City, String PIN,
			String Address) {

		countryList.click();
		WebElement country = driver
				.findElement(By.xpath("//select[@id='ddlCountry']/option[@label = '" + Country + "']"));
		js.executeScript("arguments[0].click()", country);
		//country.click();
		
		stateList.click();
		WebElement state = driver
				.findElement(By.xpath("//select[@data-placeholder = 'Select State']/option[@label = '" + State + "']"));
		js.executeScript("arguments[0].click()", state);
		//state.click();
		city.sendKeys(City);
		pin.sendKeys(PIN);
		address.sendKeys(Address);
	}
	
	public void ChooseServices(String ServiceName){
				
		if(ServiceName.equalsIgnoreCase("Money Transfer")){
		WebElement MoneyTransfer = driver.findElement(By.xpath("//input[@name = 'radio-unstyled-inline-left' and @value = '3984']"));
		MoneyTransfer.click();
		}
		else if(ServiceName.equalsIgnoreCase("AEPS")){
			WebElement aeps = driver.findElement(By.xpath("//input[@name = 'radio-unstyled-inline-left' and @value = '8']"));
			aeps.click();
		}
		else if(ServiceName.equalsIgnoreCase("PAN Card")){
			WebElement PANCard = driver.findElement(By.xpath("//input[@name = 'radio-unstyled-inline-left' and @value = '3983']"));
			PANCard.click();
		}
		else if(ServiceName.equalsIgnoreCase("Recharge")){
			WebElement recharge = driver.findElement(By.xpath("//input[@name = 'radio-unstyled-inline-left' and @value = '7']"));
			recharge.click();
		}
	}

}

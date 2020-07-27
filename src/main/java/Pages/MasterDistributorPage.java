 package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

//@Author: Shyam 

public class MasterDistributorPage extends BaseClass {
	
	// Using this because the Phone no field was not working with SendKeys()
	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Intializing the web elements

	@FindBy(xpath = "//button[contains(text(),'Actions')]")WebElement ActionBtn;
	@FindBy(xpath = "//a[contains(text(),'Add New')]")WebElement AddNewbtn;
	@FindBy(xpath = "//input[@placeholder='First Name']")WebElement FirstName;
	@FindBy(xpath = "//input[@placeholder='Last Name']")WebElement LastName;
	@FindBy(xpath = "//input[@placeholder='Enter a valid email address']")WebElement Email;
	@FindBy(xpath = "//input[@id='txtPhone']")WebElement Phone;
	@FindBy(xpath = "//input[@placeholder='PAN Number']")WebElement PAN;
	@FindBy(xpath = "//input[@placeholder='Aadhar Number']")WebElement Adhar;
	@FindBy(xpath = "//span[@id='select2-ddlCountry-container']")WebElement CountryDD;
	@FindBy(xpath = "//label[contains(text(), 'State')]")WebElement StateDD;
	@FindBy(xpath="//input[@placeholder='City']")WebElement City;
	@FindBy(xpath="//input[@placeholder='999999']")WebElement Pin;
	@FindBy(xpath="//textarea[@placeholder='Enter your address here']") WebElement Address;

	// Creating the constructor of MasterDistributorPage
	public MasterDistributorPage() {
		// Initilizing the Page Factory
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class = 'icon-people mr-2']//following::span[@class = 'font-weight-semibold']")
	WebElement pageLabel;

	public String verifyPage() {
		return pageLabel.getText();
	}

	// Actions or Methods
	
	public void ClickOnAddNew() {
		ActionBtn.click();
		AddNewbtn.click();
	}

	public void AddMDPersonalInformation(String FName, String LName, String email, String ph, String pan, String adhar)

	{
		FirstName.sendKeys(FName);
		LastName.sendKeys(LName);
		Email.sendKeys(email);
		js.executeScript("document.getElementById('txtPhone').value='" + ph + "'");
		PAN.sendKeys(pan);
		Adhar.sendKeys(adhar);
	}


	public void AddMDAddressInformation(String countryname, String State, String city, String pin, String address) throws InterruptedException 
	  {
		CountryDD.click();
		WebElement country = driver.findElement(By.xpath("//select[@id='ddlCountry']/option[@label = '" + countryname + "']"));
		country.click();
		StateDD.click();
		WebElement state = driver.findElement(By.xpath("//label[contains(text(), 'State')]/parent::div//following::select/option[@label = '" + State + "']"));
		state.click();
		City.sendKeys(city);
		Pin.sendKeys(pin);
		Address.sendKeys(address);
		
	  }
	public void SelectServices()
	{
		
	}

 }

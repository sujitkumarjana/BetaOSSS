package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

//@Author: Shyam 

public class MasterDistributorPage extends BaseClass
{
    //Using this because the Phone no field was not working with SendKeys()
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Intializing the web elements
	
	@FindBy(xpath="//button[contains(text(),'Actions')]")WebElement ActionBtn;
	@FindBy(xpath="//a[contains(text(),'Add New')]")WebElement AddNewbtn;
	@FindBy(xpath="//input[@placeholder='First Name']")WebElement FirstName;
	@FindBy(xpath="//input[@placeholder='Last Name']")WebElement LastName;
	@FindBy(xpath="//input[@placeholder='Enter a valid email address']")WebElement Email;
	@FindBy(xpath="//input[@id='txtPhone']") WebElement Phone;
	@FindBy(xpath="//input[@placeholder='PAN Number']") WebElement PAN;
	@FindBy(xpath="//input[@placeholder='Aadhar Number']") WebElement Adhar;
	@FindBy(xpath="//span[@id='select2-ddlCountry-container']")WebElement CountryDD;
    @FindBy(xpath="//input[@class='select2-search__field']")WebElement CountryDD_SearchBox;
	

	
	// Creating the constructor of MasterDistributorPage
	public MasterDistributorPage()
	{
	  //Initilizing the Page Factory
	  PageFactory.initElements(driver, this);
	}	
	
	// Actions or Methods
	
	public void ClickOnAddNew()
	{
	 ActionBtn.click();
	 AddNewbtn.click();
	}
	
	public void AddMDPersonalInformation(String FName, String LName, String email,String ph, String pan, 
			String adhar)
	
	{
	  FirstName.sendKeys(FName);
	  LastName.sendKeys(LName);
	  Email.sendKeys(email);
	  js.executeScript("document.getElementById('txtPhone').value='"+ph+"'");
	  PAN.sendKeys(pan);
	  Adhar.sendKeys(adhar);
	}

   public void AddMDAddressInformation(String countryname) throws InterruptedException
   {
	   CountryDD.click();
	   Thread.sleep(1000);
	   CountryDD_SearchBox.sendKeys(countryname);
	   Thread.sleep(2000);
	   
	  List<WebElement> CountryList = driver.findElements(By.xpath("//select[@id='ddlCountry']/option"));
	  int CountryListSize = CountryList.size();
	 // System.out.println("Total no of Coutries are: " +CountryListSize);
	  
	  String flag = "F";
	  
	  for(int i=0; i<CountryListSize; i++)
	  {
		 String cname = CountryList.get(i).getText();
		 
		 if(cname.equals(countryname))
		 {
			CountryList.get(i).sendKeys(Keys.ENTER);
			flag="T";
			break;
		 }
		  
	  }
		 if(flag.equals("F"))
		 {
		   System.out.println("No  Such Country found in the Country List");
		 }
	  
   }
		
}

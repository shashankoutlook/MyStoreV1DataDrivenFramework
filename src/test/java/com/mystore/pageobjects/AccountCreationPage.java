package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
	
	//1.Create Object Of WebDriver
	WebDriver ldriver;
	
	//Constructor
	public AccountCreationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify WebElement
	//TitleMr
	@FindBy(id="id_gender1")
	WebElement titleMr;
	
	@FindBy(id="customer_firstname")
	WebElement Custfirstname;
	
	@FindBy(id="customer_lastname")
	WebElement Custlastname;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement SubmitAccbtn;
	
	//Identify WebELement
			//
			@FindBy(xpath="//span[text()='Add my first address']")
			WebElement addmyfirstadress;
			
			public void addmyfirstaddress() {
				addmyfirstadress.click();
			}
			@FindBy(id="firstname")
			WebElement addfirstName;
			
			public void addfirstName(String afname) {
				addfirstName.sendKeys(afname);
			}
			
			@FindBy(id="lastname")
			WebElement addLastnameadr;
			public void addLastname(String alname) {
				addLastnameadr.sendKeys(alname);
			}

			//address1
			@FindBy(id="address1")
			WebElement address1;
			public void addaddress1(String adrr) {
				address1.sendKeys(adrr);
			}

			@FindBy(id="city")
			WebElement city;
			public void addcity(String cty) {
				city.sendKeys(cty);
			}
			//id_state
			@FindBy(id="id_state")
			WebElement state;
			public void selectState(String text)
			{
				Select obj = new Select(state);
				obj.selectByVisibleText(text);
			}

			@FindBy(id="postcode")
			WebElement postcode;
			
			public void postalcode(String post) {
				postcode.sendKeys(post);
			}
			@FindBy(id="id_country")
			WebElement country;
			public void selectCountry(String text)
			{
				Select obj = new Select(country);
				obj.selectByVisibleText(text);
			}
			//phone_mobile
			@FindBy(id="phone_mobile")
			WebElement phone_mobile;

			//alias
			@FindBy(id="alias")
			WebElement alias;

			public void enterMobilePhone(String mobile)
			{
				phone_mobile.sendKeys(mobile);
			}

			public void enterAlias(String text)
			{
				alias.clear();
				alias.sendKeys(text);
			}
			@FindBy(id="submitAddress")
			WebElement submitaddress;

			public void clicksubmitaddress()
			{
				submitaddress.click();
			}

	
	public void SelectitleMr()
	{
		titleMr.click();
	}
	public void EnterCustomerFirstName(String fname)
	{
		Custfirstname.sendKeys(fname); 
	}
	public void EnterCustomerlastName(String lname)
	{
		Custlastname.sendKeys(lname); 
	}
	public void EnterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void EnterSubmitAcc()
	{
		SubmitAccbtn.click();
	}
}

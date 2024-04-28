package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	//1.Create Object of WebDriver
	//ldriver==>local driver
	WebDriver ldriver;
	
	
	public IndexPage(WebDriver rdriver)
	{
		//Local Driver initializing 
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	//Identify WebElement
	@FindBy(linkText="Sign in") 
	WebElement signin;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	WebElement tshirtMenu;
	//Identify Action on WebElement
	public void clickOnsignin() {
		signin.click();
	}
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}
	public void clickOnTShirtMenu()
	{
		tshirtMenu.click();
	}

}

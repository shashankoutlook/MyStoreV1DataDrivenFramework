package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserAccountPage {
	

	//1.Create Object Of WebDriver
	WebDriver ldriver;
	
	//Constructor
	public RegisterUserAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//identify webelements
		@FindBy(xpath = "//a[@title='View my customer account']") 
		WebElement userName;

		@FindBy(linkText = "Sign out")
		WebElement signOut;
		
		@FindBy(name ="search_query")
		WebElement searchBox;

		@FindBy(name ="submit_search")
		WebElement submit_search;

		@FindBy(linkText = "Women")
		WebElement WomenMenu;

		@FindBy(linkText="T-shirts")
		WebElement TShirtMenu;
		
		
		public void EnterDataInSearchBox(String searchKey)
		{
			searchBox.sendKeys(searchKey);
		}

		
		public void ClickOnSearchButton()
		{
			submit_search.click();

		}

		
		public void MouseOverTShirtMenu()
		{
			Actions actions=new Actions(ldriver);
			actions.moveToElement(WomenMenu).moveToElement(TShirtMenu).click().perform();
		}
		public void clickOnSignOut()
		{
			signOut.click();
		}
		
		//Wont be Void because string will return username as string.
		public String getUserName()
		{
			String text = userName.getText();

			return text;
		}

	

}

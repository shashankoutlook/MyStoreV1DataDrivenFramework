package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	//1.Create Object of WebDriver
		//ldriver==>local driver
		WebDriver ldriver;
		
		//Constructor
		public MyAccountPage(WebDriver rdriver)
		{
			//Local Driver initializing 
			ldriver=rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//Identify WebElement
		@FindBy(id="email_create") 
		WebElement CreateEmailId;
		
		@FindBy(id="SubmitCreate")
		WebElement SubmitCreate;
		
		//Already registered users
		@FindBy(id = "email") 
		WebElement AlregisteredUsersEmail;
		
		@FindBy(id = "passwd") 
		WebElement AlregisteredUsersPwd;
		
		@FindBy(id = "SubmitLogin")
		WebElement AlsubmitLogin;
		
		//Identify Action on WebElement
		public void EnterCreateEmailAddress(String emailAdd) {
			CreateEmailId.sendKeys(emailAdd);
		}
		public void clickSubmitCreate() {
			SubmitCreate.click();
		}
		
		
		//ACTIONS METHODS FOR ALREADY REGISTERED USERS
		
		public void enterEmailAddress(String emailAddress) 
		{
			AlregisteredUsersEmail.sendKeys(emailAddress);
		}

		public void enterPassword(String password) 
		{
			AlregisteredUsersPwd.sendKeys(password);
		}

		
		public void clickSignIn()
		{
			AlsubmitLogin.click();
		}
		


}

package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.Baseclass.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccountPage;
import com.mystore.pageobjects.RegisterUserAccountPage;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDriven extends BaseClass {
	
	
	
		@Test(enabled=false)
		public void verifyRegistrationandLogin() 
		{
			
			//1.OpenUrl
			//As Its an common method for all the test cases need to move to base url 
			
			//driver.get(url);
			//logger.info("url opened");
			
			IndexPage Ip=new IndexPage(driver);
			Ip.clickOnsignin();
			logger.info("Clicked On Signin link");
			MyAccountPage ma=new MyAccountPage(driver);
			
			ma.EnterCreateEmailAddress("hrithikroshan151@gmail.com");
			logger.info("Email Address entered in create Account section");
			
			ma.clickSubmitCreate();
			logger.info("Click on Create Account button");
			
			//Object creation of PageObjects
			AccountCreationPage accPage=new AccountCreationPage(driver);
			accPage.SelectitleMr();
			accPage.EnterCustomerFirstName("hrithik");
			accPage.EnterCustomerlastName("Roshan");
			accPage.EnterPassword("hrithik101100");
			accPage.EnterSubmitAcc();
			accPage.addmyfirstaddress();
			accPage.addfirstName("hrithik");
			accPage.addLastname("roshan");
			accPage.addaddress1("18/8 worli road");
			accPage.addcity("Mumbai");
			accPage.selectState("Alabama");
			accPage.postalcode("0000");
			accPage.enterMobilePhone("10010218");
			accPage.selectCountry("United States");
			accPage.enterMobilePhone("9959318915");
			accPage.enterAlias("home");
			logger.info("entered user details on account creation page.");

			accPage.clicksubmitaddress();
			logger.info("clicked on Save button");
			
			RegisterUserAccountPage regUser=new RegisterUserAccountPage(driver);
			String username=regUser.getUserName();
			Assert.assertEquals("hrithik roshan", username);

			logger.info("***************TestCase Verify Registration and Login ends*****************"); 
		}
		
		
		@Test(dataProvider = "LoginDataProvider")
		
		public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException 
		{
			

			logger.info("***************TestCase Verify Login starts*****************"); 

			IndexPage pg = new IndexPage(driver);

			pg.clickOnsignin();
			logger.info("Clicked on sign in link");

			MyAccountPage myAcpg = new MyAccountPage(driver);

			myAcpg.enterEmailAddress("hrithikroshan151@gmail.com");
			logger.info("Entered email address");

			myAcpg.enterPassword("hrithik101100");
			logger.info("Entered password");

			myAcpg.clickSignIn();
			logger.info("Clicked on sign in link..");


			RegisterUserAccountPage regUser = new RegisterUserAccountPage(driver);
			String userName = regUser.getUserName();


			if(userName.equals("Hrithik Roshan"))
			{
				logger.info("VerifyLogin - Passed");
				regUser.clickOnSignOut();
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("VerifyLogin - Failed");
				captureScreenShot(driver,"VerifyLogin");
				Assert.assertTrue(false);

			}

			logger.info("***************TestCase Verify Login ends*****************"); 


		}


	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}



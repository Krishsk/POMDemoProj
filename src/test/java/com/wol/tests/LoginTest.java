package com.wol.tests;

import com.wol.pages.HomePage;
import com.wol.pages.LoginPage;
import com.wol.runner.TestRunner;

import junit.framework.Assert;

import org.testng.annotations.*;
public class LoginTest extends TestRunner {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest()
	{
		super();
	}

	
	@BeforeMethod
		public void setup()
			{
				initilization();
				loginPage = new LoginPage();
			}
	
	@Test(priority=1)
	public void LoginPageTitle()
	{
		String Title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Web Orders Login");
	}
	
	@Test(priority=2)
	public void LoginCredential()
	{
		homePage =loginPage.LoginCred(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

package com.wol.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wol.pages.HomePage;
import com.wol.pages.LoginPage;
import com.wol.pages.ViewAllOrders;
import com.wol.runner.TestRunner;

public class ViewAllOrdersTest extends TestRunner {

	
	LoginPage loginPage;
	HomePage homePage;
	ViewAllOrders viewAllOrdersPage;
	
	public ViewAllOrdersTest()
	{
		super();
	}

	
	@BeforeMethod
		public void setup()
			{
				initilization();
				loginPage = new LoginPage();
				homePage = new HomePage();
				homePage =loginPage.LoginCred(prop.getProperty("username"), prop.getProperty("password"));
				viewAllOrdersPage = homePage.clickViewAllOrders();
	
			}
	
	
	@Test(priority=1)
	public void validateVAODeletebtn()
	{
		Assert.assertTrue(viewAllOrdersPage.verifyVAODeletebtn(),"The delete button is not working");
	}
	
	@Test(priority=2)
	public void validateVAOHeader()
	{
		String header =viewAllOrdersPage.verifyViewAllOrderTabHeader();
		Assert.assertEquals(header, "List of All Orders","There is a mismatch in VAO Header");
	}
	
	@Test(priority=3)
	public void validateVAODCheckAndUncheckbtn()
	{
		Assert.assertTrue(viewAllOrdersPage.verifyVAOCheckBtn(),"The Check button is not working");
		Assert.assertTrue(viewAllOrdersPage.verifyVAOUnCheckBtn(),"The UnCheck button is not working");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}

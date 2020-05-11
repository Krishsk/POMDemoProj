package com.wol.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wol.pages.HomePage;
import com.wol.pages.LoginPage;
import com.wol.pages.ViewAllOrders;
import com.wol.pages.ViewAllProducts;
import com.wol.runner.TestRunner;
import com.wol.utilities.TestUtil;

public class HomePageTest extends TestRunner{

	LoginPage loginPage;
	HomePage homePage;
	ViewAllOrders viewAllOrdersPage;
	ViewAllProducts viewAllProductsPage;
	public HomePageTest()
	{
		super();
	}

	
	@BeforeMethod
		public void setup()
			{
				initilization();
				loginPage = new LoginPage();
				homePage = new HomePage();
				viewAllOrdersPage = new ViewAllOrders();
				viewAllProductsPage= new ViewAllProducts();
				homePage =loginPage.LoginCred(prop.getProperty("username"), prop.getProperty("password"));
			}
	
	@Test(priority=1)
	public void HomePageURLValidation()
	{
		String url =homePage.verifyHomePageURL();
		Assert.assertEquals(url, TestUtil.homePageURL,"The Home page URL is wrong");		
	}
	@Test(priority=2)
	public void HomePageTitleValidation()
	{
		String title =homePage.verifyPageTitle();
		Assert.assertEquals(title,"Web Orders" ,"The Home page Title is wrong");
	}
	
	@Test(priority=3)
	public void HomePageHeaderValidation()
	{
		Assert.assertTrue(homePage.verifyHomePageHeader(), "The Home page Header is false");		
	}
	
	@Test(priority=4)
	public void ClickViewAllOrders()
	{
		viewAllOrdersPage =homePage.clickViewAllOrders();
	}
	
	@Test(priority=5)
	public void ClickViewAllProducts()
	{
		viewAllProductsPage = homePage.clickViewAllProducts();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

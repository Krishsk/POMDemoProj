package com.wol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wol.runner.TestRunner;

public class HomePage extends TestRunner {
	
	@FindBy(xpath="//div[contains(text(),\"Welcome, Tester! \")]")
	WebElement homePage_username;
	
	@FindBy(xpath="//h1")
	WebElement header1_lable;
	
	@FindBy(xpath="//a[contains(text(),\"View all orders\")]")
	WebElement viewAllOrders_Tab;

	@FindBy(xpath="//a[contains(text(),\"View all products\")]")
	WebElement viewAllProducts_Tab;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyHomePageUserName()
	{
		return homePage_username.isDisplayed();
	}
	
	public boolean verifyHomePageHeader()
	{
		return header1_lable.isDisplayed();
	}
	
	public ViewAllOrders clickViewAllOrders()
	{
		 viewAllOrders_Tab.click();
		 return new ViewAllOrders() ;
	}
	
	public ViewAllProducts clickViewAllProducts()
	{
		 viewAllOrders_Tab.click();
		 return new ViewAllProducts() ;
	}
}

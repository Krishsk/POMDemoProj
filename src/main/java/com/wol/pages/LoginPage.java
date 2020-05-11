package com.wol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wol.runner.TestRunner;

public class LoginPage extends TestRunner {

	//PageFactory --> Object Repository (where init our objects)
	
	@FindBy(id = "ctl00_MainContent_username")
	WebElement userName_txt;
	
	@FindBy(id = "ctl00_MainContent_password")
	WebElement passWord_txt;
	
	@FindBy(id = "ctl00_MainContent_login_button")
	WebElement login_btn;
	
	//Instantiate the Pages by using PageFacory 
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage LoginCred(String user,String pwd)
	{
		userName_txt.sendKeys(user);
		passWord_txt.sendKeys(pwd);
		login_btn.click();
		return new HomePage();
	}
}

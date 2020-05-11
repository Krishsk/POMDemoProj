package com.wol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wol.runner.TestRunner;
import com.wol.utilities.TestUtil;

public class ViewAllOrders extends TestRunner {
	
	
	@FindBy(xpath="//h2")
	WebElement viewAllOrdersTab_lable;
	
	@FindBy(id="ctl00_MainContent_btnDelete")
	WebElement delete_btn;
	
	@FindBy(xpath="//a[@id='ctl00_MainContent_btnCheckAll']")
	WebElement check_btn;
	
	@FindBy(xpath="//a[@id='ctl00_MainContent_btnUncheckAll']")
	WebElement uncheck_btn;
	
	
	public ViewAllOrders()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyVAODeletebtn()
	{
		TestUtil.elementToBeClickable(delete_btn);
		return delete_btn.isDisplayed();
	}
	
	public String verifyViewAllOrderTabHeader()
	{
		return viewAllOrdersTab_lable.getText();
	}
	
	public boolean verifyVAOCheckBtn()
	{
		return check_btn.isDisplayed();
	}
	
	public boolean verifyVAOUnCheckBtn()
	{
		return uncheck_btn.isDisplayed();
	}
	
	
}

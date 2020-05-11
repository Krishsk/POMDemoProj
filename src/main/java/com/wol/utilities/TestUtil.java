package com.wol.utilities;


import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wol.runner.TestRunner;

public class TestUtil extends TestRunner{
	
	public static WebDriverWait wait;
	public static long Page_Timeload = 20;
	public static long Implicit = 10;
	public static long explicit_short = 20;
	public static long explicit_medium = 40;
	public static long explicit_long = 60;
	
	
	public static String homePageURL = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx";
	
	
	public static void elementToBeClickable(WebElement element)
	{
		try {
			wait=new WebDriverWait(driver, explicit_short);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}

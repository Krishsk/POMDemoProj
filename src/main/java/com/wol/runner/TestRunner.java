package com.wol.runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.wol.utilities.TestUtil;
import com.wol.utilities.WebEventListener;

public class TestRunner {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestRunner()
	{
		try
		{
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\harik\\eclipse-workspace\\POM.Sample.Project\\src\\main\\java\\com\\wol\\config\\config.properties");
			prop.load(file);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initilization()
	{
		String browserName = prop.getProperty("browser");
		try {
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\harik\\eclipse-workspace\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Timeload, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
		
	
}

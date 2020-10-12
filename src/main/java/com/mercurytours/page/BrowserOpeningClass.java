package com.mercurytours.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOpeningClass {
	
	public static WebDriver driver;
	
	static String baseurl="http://demo.guru99.com/selenium/newtours/";
	
	public static void OpenBrowser(String Browsername)
	
	{
		if (Browsername.equalsIgnoreCase("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chromedriver\\Newdriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
			else if (Browsername.equalsIgnoreCase("Firefox"))
				
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	   }

	public static void OpenURL()
	
	  {
	     
         driver.get(baseurl);
         driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
         
	  }	

	public static void closebrowser() 
	
	{
		driver.quit();
	
    }

}
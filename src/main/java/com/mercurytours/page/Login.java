package com.mercurytours.page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Login extends BrowserOpeningClass {

	public static void Loginmethod()
	
	{
		driver.findElement(By.name("userName")).sendKeys("demouser");
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.name("submit"));
		
	}
	
	public static void Flightbooking()
	
	{
		driver.findElement(By.linkText("Flights")).click();
		Select passengers=new Select(driver.findElement(By.name("passCount")));
		passengers.selectByVisibleText("2");
	
		Select departure=new Select(driver.findElement(By.name("fromPort")));
		departure.selectByValue("London");
		
		
		Select month=new Select(driver.findElement(By.name("fromMonth")));
		month.selectByValue("10");
		
		Select day=new Select(driver.findElement(By.name("fromDay")));
		day.selectByIndex(15);
		
		Select arrival=new Select (driver.findElement(By.name("toPort")));
		arrival.selectByVisibleText("New York");
		
		Select monthofarrival=new Select(driver.findElement(By.name("toMonth")));
		monthofarrival.selectByValue("10");
		
		Select dayofarrival=new Select(driver.findElement(By.name("toDay")));
		dayofarrival.selectByValue("17");
		
		driver.findElement(By.name("findFlights")).click();
		
		driver.findElement(By.xpath("//img[@src='images/home.gif']")).click();
		
	}
	
	public static void findbrokenlinks() throws IOException
	
	{   
	
		/*	String underConsTitle = "Under Construction: Mercury Tours";
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> linkelements=driver.findElements(By.tagName("a"));
		String[] linktexts=new String[linkelements.size()];
		int i=0;
		
		for(WebElement e:linkelements)
			
		{
			linktexts[i]=e.getText();
			i++;
		}
		
		
		//test each link
		
		for(String t:linktexts)
		{
       
		  driver.findElement(By.linkText(t)).click();
		  if(driver.getTitle().contains(underConsTitle))
		  {
		    System.out.println("\"" + t + "\"" + " is Under construction");
		}
		  
		  else
		  {
			  System.out.println("\"" + t + "\"" + " is working.");
		  }
		  
		 driver.navigate().back();
	*/	  
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List <WebElement> linkelements=driver.findElements(By.tagName("a"));
		System.out.println("Total linka" + linkelements.size() );
		  
		for(int i=0;i<linkelements.size();i++)
			
		{
			   WebElement linktext=linkelements.get(i);
			   String url=linktext.getAttribute("href");
			   VerifylinksActive(url);
			   
		}
		
	}
		public static void VerifylinksActive(String linkurl) throws IOException
		
		{
			try {
				URL urlobj=new URL(linkurl);
			    HttpURLConnection httpurlConnect=( HttpURLConnection)urlobj.openConnection();
			    httpurlConnect.setConnectTimeout(3000);
			    httpurlConnect.connect();
			    
			       if(httpurlConnect.getResponseCode()==200)
			       {
			    	   System.out.println(linkurl + "-" +httpurlConnect.getResponseMessage());
			       }
			       
			       if(httpurlConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
			       {
			    	   System.out.println(linkurl + "-" +httpurlConnect.getResponseMessage() + "-" + HttpURLConnection.HTTP_NOT_FOUND);
			       }
				
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	

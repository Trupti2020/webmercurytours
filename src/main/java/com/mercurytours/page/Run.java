package com.mercurytours.page;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercurytours.page.BrowserOpeningClass;
import com.mercurytours.page.Login;

public class Run extends BrowserOpeningClass {

@BeforeTest

public void OpennBrowser()
{
	OpenBrowser("chrome");
	OpenURL();
   
}

@Test(priority=1)

public void login()

{
	 Login.Loginmethod();
}

@Test(priority=2)

public void Flightbooking()
{
  Login.Flightbooking();
}

@Test(priority=3)

public void finbrokenlinks() throws Exception
{
	Login.findbrokenlinks();
}


@AfterTest

public void closeInstance()

{
	closebrowser();
}
	
}

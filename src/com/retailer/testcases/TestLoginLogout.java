package com.retailer.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.LoginPage;
import com.retailer.pages.MenuOptionPage;

public class TestLoginLogout extends SuperClass
{
	@Test(priority=0)
	public void testAppLaunch()
	{
		String text2 = driver.findElement(By.className("android.widget.TextView")).getText();
		HelperMethods.verifyText("Login", text2);
		System.out.println(text2);
		System.out.println("App Launched Successfully");
	}

	@Test(priority=1) //Retailer login into App
	public void login()
	{
		LoginPage login=new LoginPage(driver);
		login.enterPhoneNo("7000000230");
		login.enterPwd("1234");
		login.clickOnLoginBtn();
		HelperMethods.wait5Sec();
		HelperMethods.wait5Sec();				
		HelperMethods.wait5Sec();
	}
	
	@Test(priority=2)
	public void logout()
	{
		MenuOptionPage obj2=new MenuOptionPage(driver);
		obj2.clickMenu();
		HelperMethods.wait2Sec();
		obj2.clickLogOut();
		
	}

}

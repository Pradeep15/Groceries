package com.retailer.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.LoginPage;

public class TestLogin extends SuperClass
{
	@Test(priority=0)
	public void testAppLaunch()
	{
		String text2 = driver.findElement(By.className("android.widget.TextView")).getText();
		HelperMethods.verifyText("Login", text2);
		System.out.println(text2);
		System.out.println("App Launched Successfully");
	}
	
	
   @Test(priority=2)
   public void testClickOnLoginBtn()
   {
	   LoginPage login=new LoginPage(driver);
	   login.clickOnLoginBtn();
	   String text2 = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/text")).getText();
	   HelperMethods.verifyText("Invalid Mobile Number", text2);
	   System.out.println(text2);
	   HelperMethods.wait5Sec();
   }
   
   @Test(priority=2)
   public void testInvalidLogin()
   {
	   LoginPage login=new LoginPage(driver);
	   login.enterPhoneNo("1234567890");
	   login.enterPwd("2142");
	   login.clickOnLoginBtn();
	   HelperMethods.wait2Sec();
	   String text2 = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/text")).getText();
	   HelperMethods.verifyText("Not a retailer", text2);
	   System.out.println(text2);	   
   }
   
   @Test(priority=3)
   public void testForgotPwd()
   {
	   HelperMethods.wait5Sec();
	   LoginPage login=new LoginPage(driver);
	   login.clickOnForgotPwdBtn();
	   driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/forgot_password_edit_text")).sendKeys("1234567890");
	   driver.findElement(By.className("android.widget.Button")).click();
	   HelperMethods.wait2Sec();

	//   (new WebDriverWait (driver,10)).until(ExpectedConditions.elementToBeSelected(driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/text"))));
	   
	   String text2 = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/text")).getText();
	   HelperMethods.verifyText("Number not registered", text2);
	   System.out.println(text2);
	   
	   
   }
  
}

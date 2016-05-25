package com.retailer.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.LoginPage;
import com.retailer.pages.SignUpPage;
import com.retailer.pages.StoreDetailsPage;

public class TestSignUp extends SuperClass
{
	@Test(priority=0)
	public void testAppLaunch()
	{
		String text2 = driver.findElement(By.className("android.widget.TextView")).getText();
		HelperMethods.verifyText("Login", text2);
		System.out.println(text2);
		System.out.println("App Launched Successfully");
		HelperMethods.wait2Sec();
	}
	
	@Test(priority=1)
	public void signUp()
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickOnSignUpBtn();
		HelperMethods.wait2Sec();
		SignUpPage obj=new SignUpPage(driver);
		obj.enterSignUpDetails("852523452", "23342", "xyz", "bsdash9@gmail.com");	
		HelperMethods.wait5Sec();
		
	}
	
	@Test(priority=2)
	public void uploadImage()
	{
		StoreDetailsPage obj=new StoreDetailsPage(driver);
		obj.clickOnAddStoreImage();
		HelperMethods.wait2Sec();
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/bs_list_title")).click();
		HelperMethods.wait2Sec();
		//Moto e
/*	//	driver.findElement(By.className("android.widget.FrameLayout")).click();
		driver.findElement(By.id("com.motorola.camera:id/main")).click();
		HelperMethods.wait2Sec();
		driver.findElement(By.id("com.motorola.camera:id/review_approve")).click();
		HelperMethods.wait5Sec();
*/
		//Asus
		driver.findElement(By.id("com.asus.camera:id/button_capture")).click();
		HelperMethods.wait2Sec();
		driver.findElement(By.id("com.asus.camera:id/button_used")).click();
		HelperMethods.wait5Sec();
		
	}
	
	@Test(priority=3)
	public void StoreDetails()
	{
		StoreDetailsPage obj=new StoreDetailsPage(driver);
		obj.enterStoreDetails("asda", "addra", "addresa", "areaa", "citya", "statea", "341223");
		HelperMethods.wait5Sec();
	}
	
}
   
 

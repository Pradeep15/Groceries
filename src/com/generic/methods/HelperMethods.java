package com.generic.methods;

import java.util.HashMap;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HelperMethods 
{
	 AndroidDriver driver;
	 
	public HelperMethods(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public static void wait15Sec() 
	{
		  try
		  {
			Thread.sleep(15000);
		  }
		  catch (InterruptedException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	   	}
	}

	public static void wait5Sec() 
	{
		  try
		  {
			Thread.sleep(5000);
		  }
		  catch (InterruptedException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	   	}
	}
	
	public static void wait2Sec() 
	{
		  try
		  {
			Thread.sleep(2000);
		  }
		  catch (InterruptedException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	   	}
	}
	
	public  void explicitWait(WebElement element)
	{
		(new WebDriverWait (driver,30)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static boolean verifyText(String text1,String text2)
		{
			if(text1.contains(text2))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	public void clickBack()
	{
		driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		HelperMethods.wait2Sec();
	}
	
	public  void swipeLeft()
	{
		driver.context("NATIVE_APP"); 
		Dimension size = driver.manage().window().getSize(); 
		int startx = (int) (size.width * 0.8); 
		int endx = (int) (size.width * 0.20); 
		int starty = size.height / 2; 
		driver.swipe(startx, starty, endx, starty, 1000);
	}
	
	public void swipeRight( )
	{
	    driver.context("NATIVE_APP");
	    Dimension size = driver.manage().window().getSize();
	    int startX = (int)(size.width * 0.10);
	    int endX = (int)(size.width * 0.80);
	    int startY = size.height/2;
	    driver.swipe(endX, startY, startX, startY, 3000);
	}
	
	public void swipeUp()
	{
	    driver.context("NATIVE_APP");
	    Dimension size = driver.manage().window().getSize();
	    int starty = (int) (size.height * 0.80);
	    int endy = (int) (size.height * 0.20);
	    int startx = size.width / 2;
	    driver.swipe(startx, starty, startx, endy, 3000);
	}
	
	
	public void swipeUpElement(WebElement element, int duration)
	{
	    int bottomY = element.getLocation().getY()-500;
	    driver.swipe(element.getLocation().getX(), element.getLocation().getY(), element.getLocation().getX(), bottomY, duration);
	}
	
	
	public void swipeMenu()
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		 swipeObject.put("startX", 0.01);
		 swipeObject.put("startY", 0.5);
		 swipeObject.put("endX", 0.5);
		 swipeObject.put("endY", 0.6);
		 swipeObject.put("duration", 2.5);
		 js.executeScript("mobile: swipe", swipeObject);

	}
	
	public void afterClickingCamera()
	{
		//Asus
	/*	driver.findElement(By.id("com.asus.camera:id/button_capture")).click();
		HelperMethods.wait5Sec();
		HelperMethods.wait5Sec();
		driver.findElement(By.id("com.asus.camera:id/button_used")).click();
		HelperMethods.wait5Sec();
		HelperMethods.wait5Sec();
*/
		//ONE
		driver.findElement(By.id("com.oneplus.camera:id/primary_capture_button")).click();
		HelperMethods.wait5Sec();
		HelperMethods.wait5Sec();
		driver.findElement(By.id("com.oneplus.camera:id/review_ok_button")).click();
		HelperMethods.wait5Sec();

	}
	
	public void verifyCreatedProduct(String category,String subCat,String prod)
	{

    	while(driver.findElements(By.xpath("//android.widget.TextView[@text='"+category+"']")).size()==0)
    	{
         	HelperMethods hm=new HelperMethods(driver);
         	hm.swipeLeft();			
		}
    	
     	HelperMethods.wait2Sec();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click();     
   		driver.findElement(By.xpath("//android.widget.TextView[@text='"+subCat+"']")).click();
   		HelperMethods.wait2Sec();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='"+prod+"']"));
		Assert.assertTrue(ele.isDisplayed(), "Product Not created successfully");
		System.out.println(prod+" product created successfully");	
		HelperMethods.wait5Sec();
		driver.findElement(By.className("android.widget.ImageButton")).click();
		HelperMethods.wait2Sec();
	}
	
	public void chooseProduct(String category,String subCat)
	{
    	while(driver.findElements(By.xpath("//android.widget.TextView[@text='"+category+"']")).size()==0)
    	{
         	HelperMethods hm=new HelperMethods(driver);
         	hm.swipeLeft();
         	HelperMethods.wait2Sec();
			
		}
     	HelperMethods.wait2Sec();
    	driver.findElement(By.xpath("//android.widget.TextView[@text='"+category+"']")).click(); 
   		HelperMethods.wait2Sec();
   		driver.findElement(By.xpath("//android.widget.TextView[@text='"+subCat+"']")).click();
   		HelperMethods.wait5Sec();

	}
	
	public void chooseSpecificProduct(String prod)
	{
   		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.TextView[@text='"+prod+"']")).click();
   		HelperMethods.wait5Sec();
	}
	
	public void editSpecificProd(String prod)
	{
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.TextView[@text='"+prod+"']//android.widget.ImageButton[4]")).click();
		
	}
	
	public void swipeElementToLeft(int indexNo)
	{
		
		TouchAction action = new TouchAction((MobileDriver)driver); 
		Dimension size = driver.manage().window().getSize();
		int x1 = (int) (size.width * 0.20);
		WebElement ele = (WebElement) driver.findElementsById("com.retailer.weeklygroceries.retailer:id/sampleView").get(indexNo);
		
		action.longPress(ele).moveTo(x1,580).release().perform();	
		HelperMethods.wait5Sec();
		
	}
	
	public void editOrderDetails()
	{
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/editListItemButton")).click();
	}
	
	public void deleteOrderDetails()
	{
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/deleteListItemButton")).click();
	}
	
	public void clickDismiss()
	{
		driver.findElement(By.xpath("//android.widget.Button[@text='DISMISS']")).click();
		HelperMethods.wait2Sec();
	}
	
	public void clickDone()
	{
		driver.findElement(By.xpath("//android.widget.Button[@text='DONE']")).click();
	}
}

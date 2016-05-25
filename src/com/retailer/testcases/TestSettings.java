package com.retailer.testcases;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.MenuOptionPage;

public class TestSettings extends SuperClass
{
	//private static final Object WebElement = null;

	@Test(priority=0)
	public void modifyDelivery()
	{
		Logger logger=Logger.getLogger("TestSettings");
		PropertyConfigurator.configure("./Log4j.properties");
		HelperMethods.wait5Sec();
		MenuOptionPage mp=new MenuOptionPage(driver);
		mp.clickMenu();
		logger.info("Clicked Menu");
		
		HelperMethods.wait2Sec();
		mp.clickSettings();
		logger.info("Clicked Settings");

		
		HelperMethods.wait2Sec();
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/toggle_button_sun")).click();
		logger.info("Clicked on Sunday");

		String text1 = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/days_text_view")).getText();

		Assert.assertTrue(text1.equalsIgnoreCase("Sunday"),"Something went wrong!");
	
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/days_text_view")).click();
		
		WebElement element = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']"));
		HelperMethods hm=new HelperMethods(driver);
	//	hm.swipeUp();
		hm.swipeUpElement(element, 3000);
		HelperMethods.wait5Sec();
		
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='3']")).click();
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='4']")).click();
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']")).click();
		logger.info("Sunday Delivery Timings setting is done");

		HelperMethods.wait5Sec();
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/toggle_button_mon")).click();
		logger.info("Clicked on Monday");

		
		String text2=driver.findElement(By.xpath("//android.widget.TextView[@text='Monday']")).getText();
        Assert.assertTrue(text2.equalsIgnoreCase("Monday"), "Something went wrong!");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Monday']")).click();
        
        WebElement ele = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']"));
        
        hm.swipeUpElement(ele, 4000);
        HelperMethods.wait2Sec();
      
       
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='3']")).click();
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='4']")).click();
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']")).click();
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='6']")).click();
		logger.info("Monday Delivery Timings is done");

        HelperMethods.wait2Sec();
        driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/save_settings_button")).click();
		logger.info("Clicked on Save Button");

        HelperMethods.wait5Sec();

	}
	
	@Test(priority=1)
	public void chooseCity()
	{
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/action_areas")).click();
		HelperMethods.wait2Sec();
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/cityWideCheckBox")).click();
    	HelperMethods.wait2Sec();


    	@SuppressWarnings("unchecked")
		List<WebElement> list1 = driver.findElementsByClassName("android.widget.RelativeLayout");
    	System.out.println(list1.size());
    	for(int i=0;i<list1.size();i++)
    	{
    		
    		//System.out.println(list1.get(i).getText());
    		list1.get(i).click();
    		HelperMethods.wait2Sec();
    		
    	}
    	
    	HelperMethods.wait5Sec();
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/saveButton")).click();
	
		
		
	}

}

package com.retailer.testcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.InventoryPage;
import com.retailer.pages.MenuOptionPage;
import com.retailer.pages.NewProductPage;

public class TestCreateOtherProducts extends SuperClass
{
	@Test(priority=1)
	public void testValidation()
	{
		HelperMethods.wait5Sec();				

		MenuOptionPage obj=new MenuOptionPage(driver);
		obj.clickMenu();
		HelperMethods.wait5Sec();

		obj.clickInventory();
		HelperMethods.wait2Sec();

		InventoryPage obj2=new InventoryPage(driver);
		obj2.clickOnPlusBtn();
		HelperMethods.wait5Sec();
		
		obj2.clickCreate();
		
		HelperMethods.wait5Sec();
		
		NewProductPage obj3=new NewProductPage(driver);
		obj3.clickSave();
		//HelperMethods.wait2Sec();
		
		String text1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Product name cannot be empty']")).getText();
        Assert.assertTrue(text1.contains("Product name cannot be empty"), "Error occured");
        
		obj3.enterProductName("XYZ");
		obj3.clickSave();
	//	HelperMethods.wait2Sec();
		String text2 = driver.findElement(By.xpath("//android.widget.TextView[@text='MRP cannot be empty']")).getText();
        Assert.assertTrue(text2.contains("MRP cannot be empty"), "Error occured");

        obj3.enterMRP("150");
		obj3.clickSave();
		//HelperMethods.wait2Sec();
		String text3 = driver.findElement(By.xpath("//android.widget.TextView[@text='Image is not present']")).getText();
        Assert.assertTrue(text3.contains("Image is not present"), "Error occured");
        
        driver.findElement(By.className("android.widget.ImageButton[@index='0']")).click();

		
		
		

	}

	@Test(priority=2, enabled=false) //creation of new product
	public void createProduct()
	{
		
		HelperMethods.wait5Sec();				

		MenuOptionPage obj=new MenuOptionPage(driver);
		obj.clickMenu();
		HelperMethods.wait5Sec();

		obj.clickInventory();
		HelperMethods.wait2Sec();

		InventoryPage obj2=new InventoryPage(driver);
		obj2.clickOnPlusBtn();
		HelperMethods.wait5Sec();
		
		obj2.clickCreate();
		
		HelperMethods.wait5Sec();
		
		NewProductPage obj3=new NewProductPage(driver);
		obj3.clickCamera();
		HelperMethods hm=new HelperMethods(driver);
		hm.afterClickingCamera();
		obj3.enterProductName("Himalayan FaceWash");
		HelperMethods.wait2Sec();
		obj3.enterMRP("150");
		obj3.enterSalePrice("130");
		HelperMethods.wait2Sec();
		obj3.chooseCategory("1");
		HelperMethods.wait2Sec();
		obj3.chooseSubCategory("3");
		HelperMethods.wait2Sec();
	//	driver.hideKeyboard();
		HelperMethods.wait2Sec();
		obj3.clickSave();	
		HelperMethods.wait15Sec();
		
	}
	
	@Test(priority=3)
	public void verifyCreatedProduct()
	{
		HelperMethods hm=new HelperMethods(driver);
		hm.verifyCreatedProduct("Personal Care", "face care", "Himalayan FaceWash");

 	}	
}


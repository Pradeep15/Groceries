package com.retailer.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.InventoryPage;
import com.retailer.pages.MenuOptionPage;

public class TestCreateOtherGlobalProduct extends SuperClass
{
	@Test(priority=2) //creation of new product
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
		HelperMethods.wait2Sec();
		
		obj2.chooseAddfromGlobal();
		HelperMethods.wait2Sec();

		obj2.clickImport();
		
		HelperMethods.wait5Sec();
		HelperMethods hm=new HelperMethods(driver);
		hm.chooseProduct("Others", "Mobile Recharge");
		
		hm.chooseSpecificProduct("Bsnl - Mobile Recharge");
		
		HelperMethods.wait15Sec();
		driver.findElement(By.className("android.widget.ImageButton")).click();
		HelperMethods.wait5Sec();
		driver.findElement(By.className("android.widget.ImageButton")).click();

	}
	
	@Test(priority=3)
	public void verifyGlobalProduct()
	{	
		HelperMethods hm=new HelperMethods(driver);
		hm.verifyCreatedProduct("Others", "Mobile Recharge", "Bsnl - Mobile Recharge");
		
	}	
	
 

}

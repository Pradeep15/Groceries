package com.retailer.testcases;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.InventoryPage;
import com.retailer.pages.LoginPage;
import com.retailer.pages.MenuOptionPage;
import com.retailer.pages.NewProductPage;

public class TestCreateGlobalProduct extends SuperClass
{
  	
/*	@Test(priority=1) //Retailer login into App
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
*/
	@Test(priority=2) //creation of new product
	public void createProduct()
	{
		Logger logger = Logger.getLogger("TestCreateGlobalProduct");
		PropertyConfigurator.configure("./Log4j.properties");
		HelperMethods.wait5Sec();				

		MenuOptionPage obj=new MenuOptionPage(driver);
		obj.clickMenu();
		logger.info("Clicked Menu");
		HelperMethods.wait2Sec();

		obj.clickInventory();
		logger.info("Clicked Inventory");

		HelperMethods.wait2Sec();

		InventoryPage obj2=new InventoryPage(driver);
		obj2.clickOnPlusBtn();
		logger.info("Clicked Plus button");

		HelperMethods.wait2Sec();
		
		obj2.chooseAddfromGlobal();
		logger.info("Clicked Global option");

		HelperMethods.wait2Sec();

		obj2.clickImport();
		logger.info("Clicked Import");

		
		HelperMethods.wait5Sec();
		HelperMethods hm=new HelperMethods(driver);
		hm.chooseProduct("cigarattes & alcohol", "Wine");
		logger.info("Clicked cigrate category");

		
		hm.chooseSpecificProduct("Carl Jung Merlot Red Wine 750ml");
		logger.info("Clicked Carl Jung Merlot Red Wine 750ml");

		HelperMethods.wait5Sec();
		
		driver.findElement(By.className("android.widget.ImageButton")).click();
		HelperMethods.wait2Sec();
		driver.findElement(By.className("android.widget.ImageButton")).click();
		HelperMethods.wait2Sec();

	}
	


	@Test(priority=3)
	public void verifyGlobalProduct()
	{
		HelperMethods.wait15Sec();
		
		HelperMethods hm=new HelperMethods(driver);
		hm.verifyCreatedProduct("cigarattes & alcohol", "Wine", "Carl Jung Merlot Red Wine 750ml");
		
	}	
	
	@Test(priority=4)
	public void editProduct()
	{
		HelperMethods.wait15Sec();


		HelperMethods hm=new HelperMethods(driver);
		hm.chooseProduct("cigarattes & alcohol", "Wine");
		
	//	driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.TextView[@text='Carl Jung Merlot Red Wine 750ml']//android.widget.ImageButton[@index='3']")).click();
	//	hm.editSpecificProd("Carl Jung Merlot Red Wine 750ml");
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_image_text_view")).click();
		HelperMethods.wait5Sec();
		NewProductPage obj3=new NewProductPage(driver);
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/item_name_edittext")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		obj3.enterProductName("Carl Jung Merlot Red Wine 750ml");
		HelperMethods.wait2Sec();
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/item_mrp_editText")).sendKeys(Keys.chord(Keys.CONTROL,"a"));		
		obj3.enterMRP("500");
		HelperMethods.wait2Sec();
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/item_salesprice_editText")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		obj3.enterSalePrice("470");
		HelperMethods.wait2Sec();
		//driver.hideKeyboard();
		
		HelperMethods.wait2Sec();
		obj3.clickSave();	
		HelperMethods.wait15Sec();
		driver.findElement(By.className("android.widget.ImageButton")).click();
		HelperMethods.wait2Sec();
		
	}
	
	@Test(priority=5)
	public void verifyEditedProduct()
	{
		HelperMethods hm=new HelperMethods(driver);
		hm.verifyCreatedProduct("cigarattes & alcohol", "Wine", "Carl Jung Merlot Red Wine 750ml");
	}
	
	@Test(priority=6)
	public void deleteProduct()
	{
		HelperMethods hm=new HelperMethods(driver);
		hm.chooseProduct("cigarattes & alcohol", "Wine");
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/delete_image_text_view")).click();
		HelperMethods.wait2Sec();
		driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
		System.out.println("Product Deleted successfully");	
		HelperMethods.wait5Sec();
		driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
	}
}


	
		
	




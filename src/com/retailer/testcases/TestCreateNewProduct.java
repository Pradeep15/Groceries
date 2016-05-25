package com.retailer.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.InventoryPage;
import com.retailer.pages.LoginPage;
import com.retailer.pages.MenuOptionPage;
import com.retailer.pages.NewProductPage;

public class TestCreateNewProduct extends SuperClass
{

	@Test(priority=1) //Retailer login into App
	public void login()
	{
		LoginPage login=new LoginPage(driver);
		login.enterPhoneNo("7000000230");
		login.enterPwd("1234");
		login.clickOnLoginBtn();
		HelperMethods.wait15Sec();
	}

	@Test(priority=2) //creation of new product
	public void createProduct()
	{
		HelperMethods.wait5Sec();
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
		obj3.enterProductName("Pepsodent");
		HelperMethods.wait2Sec();
		obj3.enterMRP("100");
		obj3.enterSalePrice("80");
		HelperMethods.wait2Sec();
		obj3.chooseCategory("0");
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
		hm.verifyCreatedProduct("Oral Care", "Mouth Wash", "Pepsodent");
		
	}
	
	@Test(priority=4)
	public void editProduct()
	{
		HelperMethods hm=new HelperMethods(driver);
		hm.chooseProduct("Oral Care", "Mouth Wash");
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_image_text_view")).click();
		HelperMethods.wait5Sec();
		NewProductPage obj3=new NewProductPage(driver);
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/item_name_edittext")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		obj3.enterProductName("Pepsodent1");
		HelperMethods.wait2Sec();
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/item_mrp_editText")).sendKeys(Keys.chord(Keys.CONTROL,"a"));		
		obj3.enterMRP("105");
		HelperMethods.wait2Sec();
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/item_salesprice_editText")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		obj3.enterSalePrice("85");
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
		hm.verifyCreatedProduct("Oral Care", "Mouth Wash", "Pepsodent1");

/*		//driver.findElement(By.xpath("//android.widget.TextView[@text='Oral Care']")).click();
	//	driver.findElement(By.xpath("//android.widget.TextView[@text='tooth brush']")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='Pepsodent1']"));
		Assert.assertTrue(ele.isDisplayed(), "Product created successfully");
		System.out.println("Product Edited successfully");	
		HelperMethods.wait5Sec();*/
		
	}
	
	@Test(priority=6)
	public void deleteProduct()
	{
		HelperMethods hm=new HelperMethods(driver);
		hm.chooseProduct("Oral Care", "Mouth Wash");
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/delete_image_text_view")).click();
		HelperMethods.wait2Sec();
		driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
		System.out.println("Product Deleted successfully");	
		HelperMethods.wait5Sec();
		driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
	}

   
}

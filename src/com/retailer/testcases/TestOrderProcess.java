package com.retailer.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.methods.HelperMethods;
import com.generic.methods.SuperClass;
import com.retailer.pages.MenuOptionPage;
import com.retailer.pages.OrdersPage;

public class TestOrderProcess extends SuperClass
{
	@Test(priority=0)
	public void rejectOrder()
	{
		
		HelperMethods.wait5Sec();				

		MenuOptionPage obj=new MenuOptionPage(driver);
		obj.clickMenu();
		HelperMethods.wait2Sec();
		obj.clickOrders();
		HelperMethods.wait2Sec();
		
		OrdersPage op=new OrdersPage(driver);
			
		driver.findElement(By.xpath("//android.widget.TextView[@text='Pending']")).click();
		
		HelperMethods.wait2Sec();
		op.clickViewCart();
		HelperMethods.wait2Sec();
		op.clickReject();
		
		HelperMethods hm=new HelperMethods(driver);
		hm.clickBack();
		hm.clickBack();
		
	}
	
	@Test(priority=1)
	public void acceptOrder()
	{
		HelperMethods hm=new HelperMethods(driver);
		HelperMethods.wait2Sec();
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout//android.widget.TextView[@text='Rejected']")).click();
		HelperMethods.wait2Sec();
	
		OrdersPage op=new OrdersPage(driver);
		op.clickViewCart();
		op.clickAccept();
		hm.clickBack();
		hm.clickBack();
		
	}
	
	@Test(priority=2)
	public void incrementOrder()
	{
		HelperMethods.wait5Sec();
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.LinearLayout//android.widget.TextView[@text='Accepted']")).click();
		HelperMethods.wait2Sec();
	
		OrdersPage op=new OrdersPage(driver);
		op.clickViewCart();
		
		HelperMethods hm=new HelperMethods(driver);	 
		HelperMethods.wait2Sec();
		 
		hm.swipeElementToLeft(0);
		hm.editOrderDetails();
		
		hm.clickDismiss();
		hm.editOrderDetails();
		
		
		String a1 = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_cart_mrp_amount_textview")).getText();	
		String a2 = a1.substring(2,4);
		int a3 = Integer.parseInt(a2);
		System.out.println("MRP value of product is "+a3);
		int a4=a3*2;
		String text1 = "" + a4;
		
		
		//increment quantity
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/incrementCartButton")).click();
		HelperMethods.wait2Sec();
		
		String no = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/quantityEditText")).getText();
		System.out.println("No of quantity is "+no);
		
		String b=driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_cart_price_edittext")).getText();
		String text2 = b.substring(2,4);
		System.out.println("Price value after increaing quantity is "+text2);
		int text3=Integer.parseInt(text2);
			
		Assert.assertTrue(text1.contains(text2), "Price Value is not incrementing");
		System.out.println("Price value is incrementing properly");
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_cart_discount")).sendKeys(Keys.chord(Keys.CONTROL,"a"));

		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_cart_discount")).sendKeys("8");
		String total = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_cart_total_amount_textview")).getText();
		String total1 = total.substring(2,4);

		int disValue=text3-8;
		String disValue1=""+disValue;
		System.out.println("Total price after discount "+disValue1);
		
		Assert.assertTrue(total1.contentEquals(disValue1), "Total value is wrong after discount given");
		System.out.println("Total value is showing properly");
		hm.clickDone();	
		
		WebElement quantitiyNo = (WebElement)driver.findElementsById("com.retailer.weeklygroceries.retailer:id/quantityTextViewItem").get(0);
	    String value1 = quantitiyNo.getText();
	    Assert.assertTrue(value1.equalsIgnoreCase(no), "Quantity value is not updating in Order Details page");
		

	}
	
	@Test(priority=3)
	public void decrementOrder()
	{
		HelperMethods.wait2Sec();		
		HelperMethods hm=new HelperMethods(driver);	
		hm.swipeElementToLeft(0);
		hm.editOrderDetails();
		//String quantity1 = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/quantityEditText")).getText();
		String mrp=driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_cart_mrp_amount_textview")).getText();
   
		HelperMethods.wait2Sec();

		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/decrementCartButton")).click();
		HelperMethods.wait2Sec();
		
		String quantity2 = driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/quantityEditText")).getText();
		String price2=driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/edit_cart_price_edittext")).getText();
        HelperMethods.wait2Sec();
        
		Assert.assertTrue(quantity2.contains("1"), "product decrement is not happening properly");
		Assert.assertTrue(mrp.contains(price2), "Price Value is not updating after quantity decrementing");
		
		HelperMethods.wait5Sec();
		hm.clickDone();	

	}
	
	@Test(priority=4)
	public void deleteOrder2()
	{
		HelperMethods hm=new HelperMethods(driver);
		
		hm.swipeElementToLeft(1);
		hm.deleteOrderDetails();
		
		driver.findElement(By.xpath("//android.widget.Button[@text='NO']")).click();
		HelperMethods.wait2Sec();
		hm.deleteOrderDetails();
		
		driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
		HelperMethods.wait5Sec();
		
		
	}
	
	@Test(priority=5)
	public void updateOrder()
	{
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/update_changes_button")).click();
		HelperMethods.wait5Sec();
		HelperMethods.wait5Sec();

		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/out_for_delievery_button")).click();
		HelperMethods.wait5Sec();
		
		driver.findElement(By.id("com.retailer.weeklygroceries.retailer:id/delivered_button")).click();
		HelperMethods.wait5Sec();
		
		HelperMethods hm=new HelperMethods(driver);
		hm.clickBack();
		hm.clickBack();

	}
	

}


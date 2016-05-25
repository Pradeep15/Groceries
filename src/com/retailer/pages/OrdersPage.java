package com.retailer.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.generic.methods.HelperMethods;

public class OrdersPage
{
	AndroidDriver driver;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout")
	private WebElement orderList;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/view_cart_btn")
	private WebElement viewCartBtn;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/reject_button")
	private WebElement rejectBtn;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/accept_button")
	private WebElement acceptBtn;

	
	public OrdersPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);

	}
	
	public void clickSpecificOrder()
	{
		orderList.click();
		HelperMethods.wait2Sec();
	}
	
	public void clickViewCart()
	{
		viewCartBtn.click();
		HelperMethods.wait2Sec();
	}
	
	public void clickReject()
	{
		rejectBtn.click();
		HelperMethods.wait5Sec();
	}
	
	public void clickAccept()
	{
		acceptBtn.click();
		HelperMethods.wait5Sec();
	}

}

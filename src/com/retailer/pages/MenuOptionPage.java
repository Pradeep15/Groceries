package com.retailer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.methods.HelperMethods;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuOptionPage
{
	AndroidDriver driver;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	private WebElement menuBtn;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='1']")
	private WebElement ordersBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Inventory']")
	private WebElement inventoryBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Quick Inventory']")
	private WebElement quickInventoryBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Customers']")
	private WebElement customersBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Settings']")
	private WebElement setingsBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Feedback']")
	private WebElement feedbackBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='WeeklyMonthly Fee']")
	private WebElement feeBtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Invite']")
	private WebElement inviteBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Logout']")
	private WebElement logOutBtn;
	
	
	public MenuOptionPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	public void clickMenu()
	{
		 menuBtn.click();
	}
	
	public void clickOrders()
	{
		ordersBtn.click();
	}
	
	public void clickInventory()
	{
		inventoryBtn.click();
		
	}
	
	public void clickSettings()
	{
		setingsBtn.click();
	}
	
	public void clickLogOut()
	{
		logOutBtn.click();
		HelperMethods.wait2Sec();
		driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
		HelperMethods.wait5Sec();
	}

}

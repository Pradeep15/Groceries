package com.retailer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class InventoryPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/add_products_btn")
	private WebElement plusBtn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='CREATE']")
	private WebElement createBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add from global']")
	private WebElement globalRadioBtn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='IMPORT']")
	private WebElement importBtn;
	
	
	public InventoryPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
	}
	
	
	public void clickOnPlusBtn()
	{
		plusBtn.click();
	}
	
	public void chooseAddfromGlobal()
	{
		globalRadioBtn.click();
	}
	
	public void clickImport()
	{
		importBtn.click();
	}
	
	public void clickCreate()
	{
		createBtn.click();
	}
	


}

package com.retailer.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.generic.methods.HelperMethods;

public class StoreDetailsPage
{
	AndroidDriver driver;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/storeNameEditText")
	private WebElement storeNameTxtBox;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/addressLine1EditText")
	private WebElement addressLine1Txtbox;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/addressLine2EditText")
	private WebElement addressLine2TxtBox;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/addressAreaEditText")
	private WebElement areaTxtBox;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/addressCityEditText")
	private WebElement cityTxtBox;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/addressStateEditText")
	private WebElement stateTxtBox;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/addressPincodeEditText")
	private WebElement pincodeTxtBox;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/nextButton")
	private WebElement saveBtn;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/editStoreImageButton")
	private WebElement addStoreImageBtn;
	

	
	public StoreDetailsPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void clickOnAddStoreImage()
	{
		addStoreImageBtn.click();
		
	}
	
	public void enterStoreDetails(String storeName,String address1,String address2,String area,String city,String state,String pincode)
	{
		
		storeNameTxtBox.sendKeys(storeName);
		driver.hideKeyboard();
		//HelperMethods.wait2Sec();


		addressLine1Txtbox.sendKeys(address1);
		driver.hideKeyboard();
		//HelperMethods.wait2Sec();


		addressLine2TxtBox.sendKeys(address2);
		driver.hideKeyboard();
	//	HelperMethods.wait2Sec();


		areaTxtBox.sendKeys(area);
		driver.hideKeyboard();
		//HelperMethods.wait2Sec();


		cityTxtBox.sendKeys(city);
		driver.hideKeyboard();
		//HelperMethods.wait2Sec();


		stateTxtBox.sendKeys(state);
		driver.hideKeyboard();

		pincodeTxtBox.sendKeys(pincode);
		driver.hideKeyboard();

		HelperMethods.wait2Sec();
		saveBtn.click();
	}

  
}

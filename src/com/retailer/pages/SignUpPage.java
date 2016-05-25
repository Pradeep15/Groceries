package com.retailer.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.generic.methods.HelperMethods;

public class SignUpPage
{
	AndroidDriver driver;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/edittext_phone")
	private WebElement phoneNo;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/edittext_password")
	private WebElement password;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/edittext_fullname")
	private WebElement fullName;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/emailEditText")
	private WebElement emailID;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/nextButton")
	private WebElement signUpBtn; 
	
	public SignUpPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//driver.hideKeyboard();

	}
	
	public void enterSignUpDetails(String no,String pwd,String name,String email)
	{
		//driver.hideKeyboard();

		phoneNo.sendKeys(no);
		//driver.hideKeyboard();
		
		password.sendKeys(pwd);
		//driver.hideKeyboard();
		
		fullName.sendKeys(name);
		driver.hideKeyboard();

		emailID.sendKeys(email);
	//	driver.hideKeyboard();

		HelperMethods.wait5Sec();
		signUpBtn.click();
		

	}

}

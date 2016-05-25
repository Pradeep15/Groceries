package com.retailer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/edittext_phone")
	private WebElement phoneNo;
	
	@AndroidFindBy(id="edittext_password")
	private WebElement password;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/login_button")
	private WebElement loginBtn;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/forgot_password_text_view")
	private WebElement forgotPwdBtn;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/signup")
	private WebElement signUpBtn;
	
	public LoginPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void enterPhoneNo(String num)
	{
		phoneNo.sendKeys(num);
	}
	
	public void enterPwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
	public void clickOnSignUpBtn()
	{
		signUpBtn.click();
	}
	
	public void clickOnForgotPwdBtn()
	{
		forgotPwdBtn.click();
	}
	

}

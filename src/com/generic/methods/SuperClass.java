package com.generic.methods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class SuperClass
{
	public AndroidDriver driver;
	
	@BeforeClass
	public void launchApp() throws MalformedURLException
	{
		Logger logger=Logger.getLogger("SuperClass");
		PropertyConfigurator.configure("./Log4j.properties");
		
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
	//	capabilities.setCapability("deviceName", "X1 min");
	//	capabilities.setCapability("platformVersion", "4.4.2");

	//	capabilities.setCapability("deviceName", "ASUS_Z010D");
	//  capabilities.setCapability("platformVersion", "5.0.2");
	  	
		capabilities.setCapability("deviceName", "ONE E1003");
		capabilities.setCapability("platformVersion", "5.1.1");
		  	
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("appPackage", "com.retailer.weeklygroceries.retailer");
 		capabilities.setCapability("appActivity", "com.retailer.weeklygroceries.retailer.activities.LoginActivity");

		
		File file=new File("./apkFiles/grossary_retailer.apk");
		capabilities.setCapability("app", file.getAbsolutePath());

		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("Implicit wait given");

		
		String text2 = driver.findElement(By.className("android.widget.TextView")).getText();
		HelperMethods.verifyText("Login", text2);
		logger.info("App Launched Successfully");

		
/*		LoginPage login=new LoginPage(driver);
		login.enterPhoneNo("7000000230");
		login.enterPwd("1234");
		login.clickOnLoginBtn();
		HelperMethods.wait15Sec();
*/
	}
	
	@AfterClass
	public void closeApp()
	{
	/*	HelperMethods.wait5Sec();
		MenuOptionPage obj2=new MenuOptionPage(driver);
		obj2.clickOnMenu();
		HelperMethods.wait2Sec();
		obj2.clickOnLogOut();
		HelperMethods.wait5Sec();
		
		String str1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).getText();
		Assert.assertTrue(str1.equalsIgnoreCase("Login"), "LogOut failed");
		System.out.println("User Logout successfully");
	*/
	   driver.quit();	
	}

}

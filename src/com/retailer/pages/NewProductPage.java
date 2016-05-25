package com.retailer.pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.generic.methods.HelperMethods;

public class NewProductPage
{
	AndroidDriver driver;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/item_pic")
	private WebElement cameraBtn;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/item_name_edittext")
	private WebElement productName;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/item_mrp_editText")
	private WebElement mrp;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/item_salesprice_editText")
	private WebElement salePrice;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/item_category_spinner")
	private WebElement categoryDrpDwn;

	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/item_sub_category_spinner")
	private WebElement subCategoryDrpDwn;
	
	@AndroidFindBy(id="com.retailer.weeklygroceries.retailer:id/save_button")
	private WebElement saveBtn;
	
	public NewProductPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
	}
	
	public void clickCamera()
	{
		cameraBtn.click();
	}
	
	public void enterProductName(String prodName)
	{
		//productName.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		productName.sendKeys(prodName);
	}
	
	
	public void enterMRP(String mrpValue)
	{
		//mrp.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		mrp.sendKeys(mrpValue);
	}
	
	public void enterSalePrice(String sale)
	{
		//salePrice.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		salePrice.sendKeys(sale);
	}
	

	public void chooseCategory(String cat)
	{
		categoryDrpDwn.click();
		HelperMethods.wait2Sec();
		driver.findElement(By.xpath("//android.widget.TextView[@index='"+cat+"']")).click();
    }
        
	
	
	public void chooseSubCategory(String subCat)
	{
		subCategoryDrpDwn.click();
		HelperMethods.wait2Sec();
		driver.findElement(By.xpath("//android.widget.TextView[@index='"+subCat+"']")).click();
		
/*		List<WebElement> all = driver.findElements(By.className("android.widget.TextView"));
        for(WebElement a : all)
        {	
		    String list = a.getText();
            if (list.equalsIgnoreCase(subCat)) 
            {
            	a.click();
                break;
            }
        }
*/
		
	}
	
	public void clickSave()
	{
		saveBtn.click();
	}

	
	

}

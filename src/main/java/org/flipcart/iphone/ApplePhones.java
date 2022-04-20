package org.flipcart.iphone;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplePhones extends BaseClass{

	public ApplePhones() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	
	private WebElement iPhones;

	public WebElement getiPhones() {
		return iPhones;
	}
}

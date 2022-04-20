package org.flipcart.iphone;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPhonePOM  extends BaseClass{
	
	public SearchPhonePOM() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@type='text']")
	
	private WebElement SearchPhone;

	public WebElement getSearchPhone() {
		return SearchPhone;
	}

}

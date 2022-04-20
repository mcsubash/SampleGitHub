package org.flipcart.iphone;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloseWindowPOM extends BaseClass {
	
	public CloseWindowPOM() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	
	private WebElement closeWindow;

	public WebElement getCloseWindow() {
		return closeWindow;
	}
	
	

}

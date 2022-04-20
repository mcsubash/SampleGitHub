package java.adactin.pom.pages;


import java.org.baseclass.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass {
	public SelectHotel() {
		
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="radiobutton_0")
private WebElement btnSelect;

@FindBy(id="continue")
 private WebElement btnContinue;

@FindBy(id="cancel")
 private WebElement btnCancel;

public WebElement getBtnSelect() {
	return btnSelect;
}

public WebElement getBtnContinue() {
	return btnContinue;
}

public WebElement getBtnCancel() {
	return btnCancel;
}

public void selectHotel() {
//	SelectHotel sh=new SelectHotel();
	
	buttonClick(getBtnSelect());
	buttonClick(getBtnContinue());
	
	

}

}

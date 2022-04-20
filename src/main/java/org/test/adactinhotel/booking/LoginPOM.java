package org.test.adactinhotel.booking;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM extends BaseClass {
	
	public LoginPOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement txtUsername;

	public WebElement getTxtUsername() {
		return txtUsername;
	}
	
	@FindBy(id="password")
	private WebElement txtPassword;

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	@FindBy(id="login")
	private WebElement btnLogin;

	public WebElement getBtnLogin() {
		return btnLogin;
	}

public void LoginPOM() {

	LoginPOM al=new LoginPOM();
	sendKeys(al.txtUsername, "SubashTest");
	sendKeys(al.txtPassword, "Mukund@123");
	buttonClick(al.getBtnLogin());
	


}
}

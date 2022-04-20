package java.adactin.pom.pages;


import java.org.baseclass.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinLogin extends BaseClass {
	
	public AdactinLogin(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement txtUsername;

	public WebElement getTxtUsername() {
		return txtUsername;
	}
	
	@FindBy(xpath="//*[@id=\"password\"]")
	private WebElement txtPassword;

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	@FindBy(xpath="//*[@id=\"login\"]")
	private WebElement btnLogin;

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void AdactinLogin() {
		
		AdactinLogin al=new AdactinLogin();			
		
		sendKeys(al.txtUsername, "SubashTest");
		sendKeys(al.txtPassword, "Mukund@123");
		buttonClick(al.getBtnLogin());
		
	}
	

	

}

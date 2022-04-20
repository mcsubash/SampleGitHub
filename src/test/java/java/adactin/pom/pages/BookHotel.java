package java.adactin.pom.pages;


import java.org.baseclass.BaseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel extends BaseClass {
	
	public BookHotel() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first_name")
	private WebElement FirstName;
	
	@FindBy(id="last_name")
	private WebElement LastName;
	
	@FindBy(id="address")
	private WebElement BillAddress;
	
	@FindBy(id="cc_num")
	private WebElement CreCardNo;
	
	@FindBy(id="cc_type")
	private WebElement CreCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement ExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement ExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement Cvv;
	
	@FindBy(id="book_now")
	private WebElement BtnBookNow;
	
	@FindBy(id="order_no")
	public WebElement OrderNo;
	
	@FindBy(id="search_hotel")
	private WebElement searchHotel;
	
	
	
	public WebElement getFirstName() {
		return FirstName;
	}
	public WebElement getLastName() {
		return LastName;
	}
	public WebElement getBillAddress() {
		return BillAddress;
	}
	public WebElement getCreCardNo() {
		return CreCardNo;
	}
	public WebElement getCreCardType() {
		return CreCardType;
	}
	public WebElement getExpMonth() {
		return ExpMonth;
	}
	public WebElement getExpYear() {
		return ExpYear;
	}
	public WebElement getCvv() {
		return Cvv;
	}
	public WebElement getBtnBookNow() {
		return BtnBookNow;
	}
	public WebElement getOrderNo() {
		return OrderNo;
	}
	
	public void bookHotel() throws InterruptedException {
		BookHotel bh=new BookHotel();
		
		sendKeys(bh.FirstName, "FN tester");
		sendKeys(bh.LastName, "LN tester");
		sendKeys(bh.BillAddress, "New Zealand");
		sendKeys(bh.CreCardNo, "1234567812345678");
		selectByVisibleText(bh.CreCardType,"VISA");
		selectByVisibleText(bh.ExpMonth,"December");
		selectByVisibleText(bh.ExpYear,"2022");
		sendKeys(bh.Cvv,"123");
		buttonClick(bh.BtnBookNow);	
		implicitlyWait(10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", bh.searchHotel);
		
		implicitlyWait(10);
		String attribute = getAttribute(OrderNo);
		//Sing orderno =OrderNo.getText();
		System.out.println("Your Order Number is "+attribute);
		
		
		
	}	

}

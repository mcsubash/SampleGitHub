package org.test.adactinhotel.booking;

import org.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdactinHotel extends BaseClass {
	
	
	@BeforeClass
	public static void beforeClass() {
	browserLaunch("chrome");
	urlLaunch("http://adactinhotelapp.com/");
	System.out.println("BeforeClass");
}
    
  @Test (priority = 1)
  
  public void LoginPOM() {
	  
     LoginPOM al=new LoginPOM();
     
 	sendKeys(al.getTxtUsername(), "SubashTest");
 	sendKeys(al.getTxtPassword(), "Mukund@123");
 	buttonClick(al.getBtnLogin());	  
  System.out.println("Test 1-LoginPOM");
	}
  @Test (priority = 2)
  
    public void RoomBooking() {
		
		RoomBooking rb=new RoomBooking();
		
				sendKeys(rb.getLocation(), "London");
				sendKeys(rb.getSelectHotel(), "Hotel Sunshine");
				sendKeys(rb.getRoomType(), "Super Deluxe");
				sendKeys(rb.getNoOfRooms(), "3-Three");
				jsSendKeys(rb.getChkIn(), "09/04/2022" );
				jsSendKeys(rb.getChkOut(), "12/04/2022" );
				sendKeys(rb.getAdultsPerRoom(), "4-Four");
				sendKeys(rb.getKidsPerRoom(), "2-Two");
				buttonClick(rb.getBtnSearch());			
				System.out.println("Test 2-Room Booking");		
	}
@Test (priority = 3)

public void SelectHotel() {
SelectHotel sh=new SelectHotel();
	
	buttonClick(sh.getBtnSelect());
	buttonClick(sh.getBtnContinue());
	System.out.println("Test 3-SelectHotel");
	
}

@Test (priority = 4)

public void BookHotel()  {
	BookHotel bh=new BookHotel();
	
	sendKeys(bh.getFirstName(), "FN tester");
	sendKeys(bh.getLastName(), "LN tester");
	sendKeys(bh.getBillAddress(), "New Zealand");
	sendKeys(bh.getCreCardNo(), "1234567812345678");
	selectByVisibleText(bh.getCreCardType(),"VISA");
	selectByVisibleText(bh.getExpMonth(),"December");
	selectByVisibleText(bh.getExpYear(),"2022");
	sendKeys(bh.getCvv(),"123");
	buttonClick(bh.getBtnBookNow());	
	implicitlyWait(10);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", bh.getSearchHotel());
	
	implicitlyWait(10);
	
	String attribute = getAttribute(bh.getOrderNo());
	//Sing orderno =OrderNo.getText();
	System.out.println("Test 4-Book Hotel");
	System.out.println("Your Order Number is "+attribute);
		
}	

}//classends

package org.verify.adactin;

import org.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Ignore;
import org.test.adactinhotel.booking.LoginPOM;
import org.test.adactinhotel.booking.RoomBooking;
import org.test.adactinhotel.booking.SelectHotel;
import org.test.adactinhotel.booking.BookHotel;

public class VerifyAdactinHotel extends BaseClass {
	
	static SoftAssert s=new SoftAssert();
	@BeforeClass
	public static void beforeClass() {
    	
	browserLaunch("chrome");
	urlLaunch("http://adactinhotelapp.com/");
	//verify URL
	String currentUrl = getCurentUrl();
	boolean cond1 = currentUrl.contains("adactinhotel");
	
	System.out.println(cond1);
	s.assertTrue(cond1,"Verify url");
	System.out.println("BeforeClass");
	s.assertAll();
}
   
  @Test (priority = 1)
  
  public void LoginPOM() throws InterruptedException {
	  
	  
     LoginPOM al=new LoginPOM();
     //verify username
 	sendKeys(al.getTxtUsername(), "SubashTest"); 		
 	String atUser = getAttribute(al.getTxtUsername());
 	System.out.println(atUser);
 	s.assertEquals(atUser, "SubashTest", "Verify UserName");
 		 	 	
 	//verify pass
 	sendKeys(al.getTxtPassword(), "Mukund@123");
 	String atPass = getAttribute(al.getTxtPassword());
 	s.assertEquals(atPass, "Mukund@123", "Verify Password"); 	
 	
 	//verify valid or invalid
 	buttonClick(al.getBtnLogin());	
 	Thread.sleep(3000);
 	String url = driver.getCurrentUrl();
 	boolean cond2 = url.contains("SearchHotel.php");
 	s.assertTrue(cond2, "Verify Login valid or invalid");
 	System.out.println("Login valid or invalid " +cond2);
  	
 	System.out.println();
  System.out.println("Test 1-LoginPOM");
  s.assertAll();
	}
  
  @Ignore 
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
  @Ignore  
@Test (priority = 3)

public void SelectHotel() {
SelectHotel sh=new SelectHotel();
	
	buttonClick(sh.getBtnSelect());
	buttonClick(sh.getBtnContinue());
	System.out.println("Test 3-SelectHotel");
	
}

  @Ignore 
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

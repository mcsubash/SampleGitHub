package java.org.adactin;

import org.testng.annotations.Test;

import java.adactin.pom.pages.AdactinLogin;
import java.adactin.pom.pages.BookHotel;
import java.adactin.pom.pages.RoomBooking;
import java.adactin.pom.pages.SelectHotel;
import java.org.baseclass.BaseClass;

import org.testng.annotations.BeforeClass;

public class AdactinHotelBooking extends BaseClass {
    
	@BeforeClass
		public static void beforeClass() {
		browserLaunch("chrome");
		urlLaunch("http://adactinhotelapp.com/");
	}
	 
	
	@Test
	public void login () throws InterruptedException {
				
		AdactinLogin alog = new AdactinLogin();
		alog.AdactinLogin();

		RoomBooking rb = new RoomBooking();
		rb.roomBooking();

		SelectHotel sh = new SelectHotel();
		sh.selectHotel();

		BookHotel bh = new BookHotel();
		bh.bookHotel();
			
	}
	
	
@Test(enabled = false)

	
	public void roomBooking() {

   RoomBooking rb=new RoomBooking();
   rb.roomBooking();

	}
@Test(enabled = false)

	
	public void selectHotel() {
		SelectHotel sh=new SelectHotel();
		sh.selectHotel();		

	}
	
	
	
	
}//classends

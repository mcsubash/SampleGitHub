
package java.org.adactin;


import java.adactin.pom.pages.AdactinLogin;
import java.adactin.pom.pages.BookHotel;
import java.adactin.pom.pages.RoomBooking;
import java.adactin.pom.pages.SelectHotel;
import java.org.baseclass.BaseClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



	public class AdactinBooking extends BaseClass {
	    
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
		
		
			
		
		
	}//classends

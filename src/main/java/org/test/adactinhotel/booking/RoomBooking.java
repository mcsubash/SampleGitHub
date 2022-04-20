package org.test.adactinhotel.booking;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomBooking extends BaseClass {
	
	public RoomBooking() {
		
    PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement selectHotel;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="room_nos")
	private WebElement noOfRooms;
	
	@FindBy(id="datepick_in")
	private WebElement chkIn;
	
	@FindBy(id="datepick_out")
	private WebElement chkOut;
	
	@FindBy(id="adult_room")
	private WebElement adultsPerRoom;
	
	@FindBy(id="child_room")
	private WebElement kidsPerRoom;

	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	@FindBy(id="Reset")
	private WebElement btnReset;
	
	
	public WebElement getLocation() {
		return location;
	}
	public WebElement getSelectHotel() {
		return selectHotel;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNoOfRooms() {
		return noOfRooms;
	}
	public WebElement getChkIn() {
		return chkIn;
	}
	public WebElement getChkOut() {
		return chkOut;
	}
	public WebElement getAdultsPerRoom() {
		return adultsPerRoom;
	}
	public WebElement getKidsPerRoom() {
		return kidsPerRoom;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	public WebElement getBtnReset() {
		return btnReset;
	}

	public void RoomBooking() {
		
		RoomBooking rb=new RoomBooking();
		
				sendKeys(rb.location, "London");
				sendKeys(rb.selectHotel, "Hotel Sunshine");
				sendKeys(rb.roomType, "Super Deluxe");
				sendKeys(rb.noOfRooms, "3-Three");
				jsSendKeys(rb.chkIn, "09/04/2022" );
				jsSendKeys(rb.chkOut, "12/04/2022" );
				sendKeys(rb.adultsPerRoom, "4-Four");
				sendKeys(rb.kidsPerRoom, "2-Two");
				buttonClick(rb.btnSearch);
				
						
				

	}
	
}

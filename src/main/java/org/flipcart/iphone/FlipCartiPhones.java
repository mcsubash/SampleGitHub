package org.flipcart.iphone;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipCartiPhones extends BaseClass {
	
	@BeforeClass
	public static void beforeClass () {
		
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		implicitlyWait(10);
		System.out.println("BeforeClass");		
			
	}
	
@Test(priority=1)

public void CloseWindowPOM() {
	
	CloseWindowPOM close=new CloseWindowPOM();
	
	buttonClick(close.getCloseWindow());
	System.out.println("Test1");
}

@Test(priority=2)

public void SearchPhonePOM() {
	
	SearchPhonePOM sp=new SearchPhonePOM();	
	sendKeys(sp.getSearchPhone(), "iphones"+Keys.ENTER);		
}

@Test(priority=3)

public void printiPhones() {
	
		
//	//String attribute = getAttribute(phoneName.getPhoneSE());
//	String phoneSEName = getText(phoneName.getPhoneSE());
//	System.out.println("Phone Name: "+phoneSEName);
//	
//	String phoneSEPrice = getText(phoneName.getPhoneSEPrice());
//	System.out.println("PhoneSE Price: "+phoneSEPrice);
	
	List<WebElement> allProduct = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
System.out.println(allProduct);
	int size = allProduct.size();
	System.out.println(size);
	System.out.println("======List of Phone Names======");
	for(int i=0; i<24; i++) {
		WebElement text = allProduct.get(i);
		String phnoneName = text.getText();
		System.out.println(phnoneName);
		
	}

	List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	int countPrize = allPrice.size();
	System.out.println("Count of Price: "+countPrize);
	
	System.out.println("==========Get all the Price Details============");
	for(int i=0; i<allPrice.size(); i++) {
		
		WebElement price = allPrice.get(i);
		String allPriceDetails = price.getText();
		String s =allPriceDetails;
			s=s.substring(1);
			if(s.contains(",")) {
			s=s.replace(",", ""); 
			}
			//System.out.println(s);
			int priceDetails = Integer.parseInt(s);
			System.out.println(priceDetails);
			List<Integer> li = new LinkedList<>();
			li.add(priceDetails);
			Collections.sort(li);
			System.out.println(li);
			
			
			
	}
	
}



}//classend

package java.org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	// method 1
	public static WebDriver driver;

//	    public static WebDriver browserLaunch(String browserName) {
//		
//	    if(browserName.equals("chrome")) {
//	    	
//	    	WebDriverManager.chromedriver().setup();
//	    	driver = new ChromeDriver();
//	    }
//	    
//	    else if(browserName.equals("firefox")) {
//	    	
//	    	WebDriverManager.firefoxdriver().setup();
//	    	driver = new FirefoxDriver();
//	    }
//	    
//	    else{
//	    	
//	    	System.out.println("Invalid Browser");
//	    }
	public static WebDriver browserLaunch(String browserName) {
		switch (browserName) {

		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:

			System.out.println("Invalid Browser");
		}

		return driver;
	}

	// method 2 //URL Launch

	public static void urlLaunch(String url) {

		driver.get(url);
		driver.manage().window().maximize();
	}

	// Wait method 3
	public static void implicitlyWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

//Send Keys	Method 4
	public static WebElement findElement(String locatorName, String locatorValue) {

		WebElement value = null;
		if (locatorName.equals("id")) {

			value = driver.findElement(By.id(locatorValue));
		}

		else if (locatorName.equals("name")) {
			value = driver.findElement(By.name(locatorValue));
		}

		else if (locatorName.equals("xpath")) {

			value = driver.findElement(By.xpath(locatorName));

		}

		return value;
	}

	// Send Keys Method 5

	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}

//click 	Method 6

	public static void buttonClick(WebElement e) {
		e.click();

	}

//get Current url 	Method 7  
	public static String getCurentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

//get Title 	Method 8

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// quite Method 9

	public static void quit() {
		driver.quit();

	}

//getText 	Method 10

	public static String getText(WebElement e) {
		String text = e.getText();
		return text;

	}

//getText 	Method 11

	public static String getAttribute(WebElement e) {

		String attribute = e.getAttribute("value");
		return attribute;

	}

//Actions
//moveToElement Method 12

	public static void moveToElement(WebElement e) {

		Actions act = new Actions(driver);
		act.moveToElement(e).perform();

	}

//dragAndDrop Method 13

	public static void dragAndDrop(WebElement src, WebElement dest) {

		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}

//clcikAndHold Method 14

	public static void clickAndHold(WebElement src, WebElement dest) {

		Actions act = new Actions(driver);
		act.clickAndHold(src).moveToElement(dest).release().perform();

	}

//doubleClick Method 15

	public static void doubleClick(WebElement e) {
		Actions act = new Actions(driver);
		act.doubleClick(e).perform();
	}

//doubleClick Method 16

	public static void contextClick(WebElement e) {

		Actions act = new Actions(driver);
		act.contextClick(e).perform();

	}

	// Action Click

	public static void actionClick(WebElement e) {

		Actions a = new Actions(driver);
		a.click().perform();

	}

	// javascript js sendkeys

	public void jsSendKeys(WebElement e, String value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + value + "')", e);
	}
//Alert	    
// Switch to Alert  Method 17

	public static void switchToAlert(WebElement e) {

		Alert simple = driver.switchTo().alert();
		simple.accept();
	}

//selectByIndex Method 18

	public static void selectByIndex(WebElement e, int index) {

		Select s = new Select(e);
		s.selectByIndex(index);
	}

//selectByValue Method 19

	public static void selectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByValue(value);
	}

//selectByVisibleText Method 20

	public static void selectByVisibleText(WebElement e, String text) {
		Select s = new Select(e);
		s.selectByVisibleText(text);
	}

//isMultiple Method 21

	public static Boolean isMultiple(WebElement e) {
		Select s = new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;
	}

//All values Method 22

	public static List<WebElement> getAllOptions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		return options;
	}
//OptionsSize Method 23

	public static Integer size(WebElement e) {

		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		int size = options.size();
		return size;

	}

	public static void switchWindow() {

		String oldWin = driver.getWindowHandle();
		Set<String> allWin = driver.getWindowHandles();
		for (String eachWin : allWin) {

			if (!oldWin.equals(allWin)) {

				driver.switchTo().window(eachWin);
			}

		}

	}

//Excel Method 24

	public static String ExcelRead(String name, String sheet, int rowNo, int cellNo) throws IOException {

		File loc = new File("D:\\eclipse-workspace\\MavenProject\\src\\test\\resources\\" + name + ".xlsx");

		FileInputStream fi = new FileInputStream(loc);

		Workbook w = new XSSFWorkbook(fi);

		Sheet s = w.getSheet(sheet);

		Row row = s.getRow(rowNo);
		Cell cell = row.getCell(cellNo);

		// to get all values
		String value = null;
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row1 = s.getRow(i);

			for (int j = 0; j < row1.getPhysicalNumberOfCells(); j++) {
				Cell cell3 = row1.getCell(j);
				// System.out.println(cell3);

				// STRING CONVERSION
				int type = cell.getCellType();
				// type 1 -- String
				// type 0 -- Number and Date

				if (type == 1) {
					value = cell.getStringCellValue();

				} else {
					if (DateUtil.isCellDateFormatted(cell)) {
						value = new SimpleDateFormat("dd-MMM-YYYY").format(cell.getDateCellValue());

					} else {
						value = String.valueOf((long) cell.getNumericCellValue());
					}

				}

			} // forloop
		} // forloop

		return value;
	} // method ends

}// classends

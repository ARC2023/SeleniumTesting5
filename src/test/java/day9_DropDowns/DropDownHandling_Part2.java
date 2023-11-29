package day9_DropDowns;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import day7_JavaScriptExecutorMethods.jsexecutor;

public class DropDownHandling_Part2 {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();// object creation
		option.addArguments("--start-maximized");// Adding pre-conditon
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver(option);// passing the variable to driver
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");//load the url
		
		WebElement dropDown = driver.findElement(By.name("Month"));		
		jsexecutor.scrollToElement(driver, dropDown);
		
		
		Select select_month = new Select(dropDown);
		
		System.out.println("Whether the drop down is multi select ?:"+select_month.isMultiple());
		
		select_month.selectByIndex(3);
		select_month.selectByValue("Aug");
		select_month.selectByVisibleText("September");
		select_month.selectByIndex(4);
		select_month.selectByValue("Jan");
		select_month.selectByVisibleText("November");
		System.out.println("*********************First selected option*********************");
		System.out.println(select_month.getFirstSelectedOption().getText());		
		System.out.println("*********************All selected option*********************");
		lister(select_month.getAllSelectedOptions());
		System.out.println("*********************All available option*********************");
		lister(select_month.getOptions());
		Thread.sleep(3000);
		System.out.println("*********************De-select methods*********************");
		/*select_month.deselectByIndex(3);
		Thread.sleep(3000);
		select_month.deselectByValue("Aug");
		Thread.sleep(3000);
		select_month.deselectByVisibleText("September");
		Thread.sleep(3000);*/
		System.out.println("*********************De-select All method*********************");
		select_month.deselectAll();
	}
	
	
	
	public static void lister(List<WebElement> listers) {
		
		for(WebElement ele: listers) {
			
			System.out.println(ele.getText()); 
			
		}
	}
}

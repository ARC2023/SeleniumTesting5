package day9_DropDowns;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandling_Part1 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();// object creation
		option.addArguments("--start-maximized");// Adding pre-conditon
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver(option);// passing the variable to driver
		driver.get("https://www.facebook.com/");//load the url
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(4000);
		WebElement day=driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
		
		Select selectDay=new Select(day);
		Select selectMonth=new Select(month);
		Select selectYear=new Select(year);
				
		selectDay.selectByIndex(7);
		selectMonth.selectByValue("6");
		selectYear.selectByVisibleText("2020");
		
		Thread.sleep(5000);
		
		String dob = "26-12-1993";
		
		String[] dob_arr =dob.split("-");
		
		dropDownByVisibleText(day,dob_arr[0]);
		dropDownByValue(month, dob_arr[1]);
		dropDownByVisibleText(year,dob_arr[2]);
		

		Thread.sleep(5000);
		
		dropDownByList(selectDay.getOptions(), "25");
		dropDownByList(selectMonth.getOptions(), "Feb");
		dropDownByList(selectYear.getOptions(),"2002");
	}
	
	public static void dropDownByList(List<WebElement> lister,String value) {
		
		for(WebElement ele:lister) {
			
			if(ele.getText().equals(value)) {
				ele.click();
				break;
				
			}else {
				System.out.println("Move Ahead Not the required value");
			}
			
			
		}
		
	}
	
	

	public static void dropDownByVisibleText(WebElement values,String option) {		
		Select selectMenu=new Select(values);
		selectMenu.selectByVisibleText(option);
	}
	public static void dropDownByValue(WebElement values,String option) {		
		Select selectMenu=new Select(values);
		selectMenu.selectByValue(option);
	}
	public static void dropDownByVisibleText(WebElement values,int option) {		
		Select selectMenu=new Select(values);
		selectMenu.selectByIndex(option);
	}
	
}

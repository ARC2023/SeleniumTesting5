package day9_DropDowns;

import java.util.ArrayList;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import day7_JavaScriptExecutorMethods.jsexecutor;

public class DropDownHandling_Part3 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();// object creation
		option.addArguments("--start-maximized");// Adding pre-conditon
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver(option);// passing the variable to driver
		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1");// load the url
		WebElement dropDownButton = driver.findElement(By.id("btndropdown"));
		jsexecutor.clickOnElement(dropDownButton, driver);
		Thread.sleep(3000);
		/*bootStrapDD("jQuery", driver);
		bootStrapDD("HTML", driver);
		bootStrapDD("Bootstrap", driver);
		Thread.sleep(5000);
		bootStrapDDBtn("Clear", driver) ;
		
		ArrayList<String> ddms= new ArrayList<String>(Arrays.asList("jQuery","HTML","Bootstrap","CSS","JavaScript"));
		
		bootStrapDD(ddms, driver);*/

		bootStrapDDSS("HTML", driver);
		
	}

	public static void bootStrapDDSS(String str, WebDriver driver) throws InterruptedException {

		
			List<WebElement> label = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//label"));
			
			for(int i=0;i<label.size();i++) {
				
				if(label.get(i).getText().equals(str)) {
					driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li//label["+i+"]//input")).click();
					
				}
				
			}
			
			
			
		

	}
	
	
	public static void bootStrapDD(ArrayList<String> str, WebDriver driver) throws InterruptedException {

		for (String ss : str) {
			WebElement clickDD = driver.findElement(By.xpath("//input[@value='" + ss + "']"));
			jsexecutor.clickOnElement(clickDD, driver);
			Thread.sleep(2000);
		}

	}

	public static void bootStrapDD(String value, WebDriver driver) {

		WebElement clickDD = driver.findElement(By.xpath("//input[@value='" + value + "']"));
		jsexecutor.clickOnElement(clickDD, driver);
	}

	public static void bootStrapDDBtn(String value, WebDriver driver) {

		WebElement clickDD = driver.findElement(By.xpath("//button[@value='" + value + "']"));
		jsexecutor.clickOnElement(clickDD, driver);
	}

}

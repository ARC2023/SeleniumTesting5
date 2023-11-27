package day8_Frameshandling;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import day7_JavaScriptExecutorMethods.jsexecutor;

public class FramesHandling {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		ChromeOptions option = new ChromeOptions();// object creation
		option.addArguments("--start-maximized");// Adding pre-conditon
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver(option);// passing the variable to driver

		driver.get("https://demo.guru99.com/test/guru99home/");//load the url
		/*
		// iframes by using xpath or id or name
		WebElement frame = driver.findElement(By.id("a077aa5e"));//get xpath or id or name of iframe
		driver.switchTo().frame(frame);// switch to the iframe
		//driver.switchTo().frame("a077aa5e");
		
		// Get the xpath of the element on which you will perform click or enter actions
		WebElement clicker = driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
		Thread.sleep(3000);
		jsexecutor.scrollToElement(driver, clicker);		
		jsexecutor.clickOnElement(clicker, driver);
		
		*/
		// iframes by using index
		
		List<WebElement> framesList = driver.findElements(By.tagName("iframe"));
		
		System.out.println("Size of frames: "+framesList.size());
		
		for(int i=0;i<framesList.size()-1;i++) {
			
			try {
			driver.switchTo().frame(i);
            List<WebElement> countItem = driver.findElements(By.xpath("/html/body/a"));
            int count = countItem.size();
            if(count>0)
            	System.out.println("Counter when iframe identified "+count);
			
			driver.switchTo().defaultContent();
			}catch(Exception e) {
				System.out.println("failed frame");
			}
			
		}
		
		
		
		
	}

}

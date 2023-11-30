package day10_ismthods;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class isEnableDisabledDisplayed {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();// object creation
		option.addArguments("--start-maximized");// Adding pre-conditon
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver(option);// passing the variable to driver
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");//load the url
		
		
		WebElement selected= driver.findElement(By.xpath("//input[@value='option-3']"));		
		WebElement displayed= driver.findElement(By.xpath("//input[@value='option-1']"));
		WebElement Enabled= driver.findElement(By.xpath("//input[@value='cabbage']"));
		WebElement Enabled2= driver.findElement(By.xpath("//input[@value='pumpkin']"));
		
		
		System.out.println(selected.isSelected());
		System.out.println(displayed.isSelected());
		System.out.println(displayed.isDisplayed());
		System.out.println(Enabled.isEnabled());
		System.out.println(Enabled2.isEnabled());


	}

}

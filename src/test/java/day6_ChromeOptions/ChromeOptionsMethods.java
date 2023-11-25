package day6_ChromeOptions;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsMethods {

	
	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();// object creation
		
		option.addArguments("--start-maximized");// Adding pre-conditon		
		
		option.addArguments("--incognito");
		
		option.setExperimentalOption("excludeSwitches",
				Arrays.asList("disable-popup-blocking","enable-automation"));
		
		option.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(option);// passing the variable to driver
		
		driver.get("https://www.naukri.com/");
		
		
		
	}
	
	
}

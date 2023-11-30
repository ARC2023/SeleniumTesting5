package day10_QuitNClose;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import day7_JavaScriptExecutorMethods.jsexecutor;

public class quitNclose {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();// object creation
		option.addArguments("--start-maximized");// Adding pre-conditon
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		// option.setAcceptInsecureCerts(true);
		option.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver(option);// passing the variable to driver

		driver.get("https://demo.guru99.com/popup.php");

		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));

		jsexecutor.clickOnElement(clickHere, driver);

		Thread.sleep(4000);

		//.close();
		System.out.println(driver);
		//driver.quit();
		System.out.println(driver);
	}
}

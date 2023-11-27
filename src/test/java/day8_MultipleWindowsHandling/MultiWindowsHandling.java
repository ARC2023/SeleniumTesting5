package day8_MultipleWindowsHandling;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import day7_JavaScriptExecutorMethods.jsexecutor;

public class MultiWindowsHandling {

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

		String mainWindow = driver.getWindowHandle();// Get the id of main window

		Set<String> allWindowId = driver.getWindowHandles();// Get the id of all window including main window

		Iterator<String> itr = allWindowId.iterator();// iterate it

		while (itr.hasNext()) {

			String Windows = itr.next(); // store the first iteration value in a variable 

			if (!Windows.equalsIgnoreCase(mainWindow)) { // check if it matches the main window if yes then ignore

				driver.switchTo().window(Windows);
				
				try {

					WebElement emailId = driver.findElement(By.xpath("//input[@name='emailid']"));
					WebElement submitBtn = driver.findElement(By.xpath("//input[@name='btnLogin']"));

					jsexecutor.enterValueInTextBox(emailId, driver, "arcautomation2023@gmail.com");

					jsexecutor.clickOnElement(submitBtn, driver);
					
					Thread.sleep(8000);
					
					driver.close();

				} catch (Exception e) {

					System.out.println("Wrong Window");
					driver.close();
				}

			}

		}
		
		driver.switchTo().window(mainWindow);
		Thread.sleep(4000);
		jsexecutor.clickOnElement(clickHere, driver);
		
		

	}

}

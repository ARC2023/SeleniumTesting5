package day7_JavaScriptExecutorMethods;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class jsexecutor {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();// object creation

		option.addArguments("--start-maximized");// Adding pre-conditon

		option.addArguments("--incognito");

		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));

		option.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(option);// passing the variable to driver

		driver.get("https://www.naukri.com/");

		WebElement loginbtn = driver.findElement(By.xpath("//a[@id='login_Layer']"));

		//colorChange(loginbtn, driver, "rgb(51,51,51)");
		//borderCreation(loginbtn, driver);
		//flashing(loginbtn, driver);
		//generateAlert(driver,"Test Case Pass");
		/*
		clickOnElement(loginbtn, driver);
		Thread.sleep(2000);
		WebElement enterUN = driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"));
		enterValueInTextBox(enterUN, driver, "arcautomation@gmail.com");
		Thread.sleep(2000);
		refreshPageJS(driver);
		System.out.println("Driver methods");
		System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("JS methods");
		
		getURL(driver);
		getTitle(driver);
		//retriveInnerTextOfPage(driver);		
		*/		
		//hideElement(driver, loginbtn);
		
		//modifyElement(driver, loginbtn, "Sign Into Naukri");
		
		//getElementInnerText(driver, loginbtn);
		/*clickOnElement(loginbtn, driver);
		Thread.sleep(2000);
		WebElement enterUN = driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"));
		enterValueInTextBox(enterUN, driver, "arcautomation@gmail.com");
		Thread.sleep(2000);
		retrieveValueOfElement(driver, enterUN);
		*/
		
		
		WebElement ele=driver.findElement(By.xpath("(//span[text()='IT Services'])[1]"));
		//scrollToHeight(driver);
		
		scrollToElement(driver, ele);
	}

	public static void colorChange(WebElement etr, WebDriver driver, String color) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", etr);
		Thread.sleep(1000);
	}

	public static void flashing(WebElement etr, WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String backGroundColor = etr.getCssValue("backgroundColor");

		System.out.println("BackGround Color of Element -->" + backGroundColor);

		for (int i = 0; i < 10; i++) {
			colorChange(etr, driver, "rgb(51,51,51)");
			colorChange(etr, driver, backGroundColor);
		}
	}
	
	public static void borderCreation(WebElement etr, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px solid red'", etr);
	}
	
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "');");
	}

	public static void clickOnElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void enterValueInTextBox(WebElement element, WebDriver driver, String UN) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + UN + "';", element);
	}

	public static void refreshPageJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	public static void getURL(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Title of page by one way-->" + js.executeScript("return document.URL;").toString());
		String title = (String) js.executeScript("return document.URL;");
		System.out.println("Title of page by other way-->" + title);
	}

	public static void getTitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("URL of page by one way-->" + js.executeScript("return document.title;").toString());
		String title = (String) js.executeScript("return document.title;");
		System.out.println("URL of page by other way-->" + title);
	}

	public static void retriveInnerTextOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Inner Text of page by one way-->"
				+ js.executeScript("return document.documentElement.innerText;").toString());
		String title = (String) js.executeScript("return document.documentElement.innerText;");
		System.out.println("Inner Text of page by other way-->" + title);
	}

	
	
	
	public static void hideElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='none';", element);
	}
	
	public static void hideElement(WebDriver driver, List<WebElement> element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		for(WebElement ele:element) {
		js.executeScript("arguments[0].style.display='none';", ele);
		System.out.println("Mission Done");
		}
	}

	
	
	public static void modifyElement(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerText = '" + value + "';", element);
	}
	public static void getElementInnerText(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innerText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
		System.out.println("Inner Text of Element: "+innerText);
	}
	public static String retrieveValueOfElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) js.executeScript("return arguments[0].value;", element);
		System.out.println("Value from Element-->" + value);
		return value;
	}
	
	
	
	public static void scrollToHeight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		System.out.println("Scrolled to element");
	}

	
}

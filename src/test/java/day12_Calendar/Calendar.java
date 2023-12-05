package day12_Calendar;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import day7_JavaScriptExecutorMethods.jsexecutor;

public class Calendar {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement datTextBox = driver.findElement(By.xpath("//input[@id='first_date_picker']"));

		// 1. JavaScrip Executor
		/*
		 * dateByJS(driver, "12/12/2023", datTextBox);
		 * 
		 * // 2. Send Keys Thread.sleep(2000); datTextBox.clear();
		 * datTextBox.sendKeys("12/26/2023");
		 */

		// 3. Calendar Logic
		
		selectDate("24","February","2022"); 
	}

	public static void selectDate(String date,String month,String year) {
		int yearinput = Integer.parseInt(year);
		WebElement datTextBox = driver.findElement(By.xpath("//input[@id='first_date_picker']"));
		wait.until(ExpectedConditions.visibilityOf(datTextBox));
		datTextBox.click();
		WebElement datePicker = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
		wait.until(ExpectedConditions.visibilityOf(datePicker));
		String MonthYear = datePicker.getText();
		System.out.println("Month and Year from Ui: "+MonthYear);
		
		
		String[] spillter = MonthYear.split(" ");
		String monthFromScreen = spillter[0];
		String yearFromScreen = spillter[1];
		int yearFromScreenInteger = Integer.parseInt(yearFromScreen);
		System.out.println(monthFromScreen);
		System.out.println(yearFromScreen);
		
		             // January       December      && 2024           2023  
		while(      !(month.equals(monthFromScreen) && year.equals(yearFromScreen))              ) {
			
			
			if(yearinput>yearFromScreenInteger) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			//        2021    <  =       2021
			}else if(yearinput<=yearFromScreenInteger){
				
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}			
			
			MonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			System.out.println("Month and Year from Ui: "+MonthYear);		
			spillter = MonthYear.split(" ");
			monthFromScreen = spillter[0];
			yearFromScreen = spillter[1];
			yearFromScreenInteger = Integer.parseInt(yearFromScreen);
			System.out.println(monthFromScreen);
			
		}
		
		try {
			
			
            WebElement dateSelector = driver.findElement(By.xpath("//a[text()='"+date+"']"));
			jsexecutor.scrollToElement(driver, dateSelector);
			jsexecutor.clickOnElement(dateSelector, driver);
			
			
			
		}catch(Exception e) {
			
			
		}
		
		
		
		
		
		
		
	}

	public static void dateByJS(WebDriver driver, String date, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
	}
}

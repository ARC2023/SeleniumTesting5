package day10_ScreenShots;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class ScreenShot {
	
	static WebDriver driver;
	static int counter =1;
	public static void main(String[] args) throws IOException {
		ChromeOptions option = new ChromeOptions();// object creation
		option.addArguments("--start-maximized");// Adding pre-conditon
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--disable-popup-blocking");
		 driver = new ChromeDriver(option);// passing the variable to driver
		driver.get("https://www.facebook.com/");//load the url
		takeScreenshot("FaceBook page Loaded");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		takeScreenshot("Create New Account");
		
	}
	
	
	
	
	
	
	public static void takeScreenshot(String ssname) throws IOException {
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy_hh-mm-ss");
		String dateTime1 = dateTime.format(format);
		System.out.println(dateTime1);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File
				("C:\\Users\\glend\\eclipse-workspace\\SeleniumTesting5\\screenshot\\"+dateTime1+"_"+counter+"_"+ssname+".jpg");
		
		FileUtils.copyFile(src,destination);
		System.out.println("Screenshot taken");
		counter++;
	}
}

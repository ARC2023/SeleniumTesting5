package day4_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseBehaviour {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nseindia.com/");		
		WebElement marketData= driver.findElement(By.xpath("//a[text()='Market Data']"));
		
		
		Actions mouse = new Actions(driver);
		
		// 1. Hover 
		Thread.sleep(4000);
		mouse.moveToElement(marketData).build().perform();
		
		// 2. Click
		Thread.sleep(2000);
		WebElement premarket= driver.findElement(By.xpath("//a[text()='Pre-Open Market']"));
		mouse.click(premarket).build().perform();
		System.out.println("Clicked");
		
		

	}

}

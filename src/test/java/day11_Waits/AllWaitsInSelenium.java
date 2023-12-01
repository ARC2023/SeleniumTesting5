package day11_Waits;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllWaitsInSelenium {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.naukri.com/");
		// Implicit waits
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); 		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		//1. Visibility		
		
			WebElement login = wait.until(ExpectedConditions.visibilityOf
					(driver.findElement(By.id("login_Layer"))));								
			List<WebElement> dropDownList = wait.until(ExpectedConditions.visibilityOfAllElements
					(driver.findElements(By.id("login_Layer"))));
			/*WebElement login1 =	wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("")));
			List<WebElement> dropDownList1=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
					(By.xpath("")));
			String companyName="";
			String xpath="//a[text()='"+companyName+"']    //parent::td//preceding-sibling::td//button";
			
			wait.until(ExpectedConditions.
			visibilityOfNestedElementsLocatedBy(By.id("livePreTable"),By.xpath("[text()='"+companyName+"']")));
			wait.until(ExpectedConditions.
			visibilityOfNestedElementsLocatedBy(login1, By.xpath("")));
				*/
			
			// 2. Invisibility
			
			System.out.println(wait.until(ExpectedConditions.invisibilityOf(login)));
			System.out.println(wait.until(ExpectedConditions.invisibilityOfAllElements(dropDownList)));
			System.out.println(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("login_Layer"))));
			System.out.println(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("login_Layer"), "login")));
		
			// 3. Alert 
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			
			alert.accept();
			alert.dismiss();
			alert.getText();
			
			// 4. Element selection state
			
			
			
	}

}

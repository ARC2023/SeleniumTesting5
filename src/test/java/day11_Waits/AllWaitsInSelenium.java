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
		/*
			WebElement login = wait.until(ExpectedConditions.visibilityOf
					(driver.findElement(By.id("login_Layer"))));								
			List<WebElement> dropDownList = wait.until(ExpectedConditions.visibilityOfAllElements
					(driver.findElements(By.id("login_Layer"))));
			WebElement login1 =	wait.until(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("")));
			List<WebElement> dropDownList1=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
					(By.xpath("")));
			String companyName="";
			String xpath="//a[text()='"+companyName+"']    //parent::td//preceding-sibling::td//button";
			
			wait.until(ExpectedConditions.
			visibilityOfNestedElementsLocatedBy(By.id("livePreTable"),By.xpath("[text()='"+companyName+"']")));
			wait.until(ExpectedConditions.
			visibilityOfNestedElementsLocatedBy(login1, By.xpath("")));
				
			
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
			*/
			// 4. Element selection state
			
			//driver.get("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
			
			//WebElement ele= driver.findElement(By.xpath("//input[@value='option-3']"));
			/*
			System.out.println(wait.until(ExpectedConditions.elementSelectionStateToBe
					(By.xpath("//input[@value='option-3']"), true)));
			System.out.println(wait.until(ExpectedConditions.elementSelectionStateToBe
					(ele, false)));
			
			
			// 5. Element Clickable State
			wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='cabbage']"))).click();
			
			// 6. Element Selected
			
			System.out.println(wait.until(ExpectedConditions.elementToBeSelected(ele)));
			System.out.println(wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@value='option-2']"))));
			
			
			// 7. Frames
			
			driver.get("https://demo.guru99.com/test/guru99home/");
			driver.switchTo().frame("a077aa5e");
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("a077aa5e"));
			driver.findElement(By.xpath("/html/body/a")).click();
			
			// 8. Presence of Element
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("")));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
			wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath(""),By.id("")));
			wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(ele,By.xpath("")));
			
			*/
			// 9. Text to be present
			WebElement login= driver.findElement(By.id("login_Layer"));
			login.click();
			//System.out.println(wait.until(ExpectedConditions.textToBePresentInElement(login, "Login")));
			//System.out.println(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("register_Layer"), "Reegister")));
			WebElement un=driver.findElement(By.xpath("//*[@id='root']/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input"));
			un.sendKeys("arc@gmail.com");
			System.out.println(wait.until(ExpectedConditions.textToBePresentInElementValue(un, "aarc@gmail.com")));
			
	}

}

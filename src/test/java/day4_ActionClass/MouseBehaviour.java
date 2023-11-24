package day4_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import net.bytebuddy.implementation.bytecode.ShiftLeft;

public class MouseBehaviour {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Actions mouse = new Actions(driver);
/*
		// 1. Hover
		driver.get("https://www.nseindia.com/");
		WebElement marketData = driver.findElement(By.xpath("//a[text()='Market Data']"));

		Thread.sleep(4000);
		mouse.moveToElement(marketData).build().perform();

		// 2. Click
		Thread.sleep(2000);
		WebElement premarket = driver.findElement(By.xpath("//a[text()='Pre-Open Market']"));
		mouse.click(premarket).build().perform();
		System.out.println("Clicked");

		// 3. Drag and Drop traditional way

		driver.get("https://jqueryui.com/droppable/");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		WebElement drag= driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement drop= driver.findElement(By.xpath("//p[text()='Drop here']"));
			
		//mouse.clickAndHold(drag).moveToElement(drop).release().build().perform();
		
		mouse.dragAndDrop(drag, drop).build().perform();

		// 4. Right Click

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightCLick = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Thread.sleep(2000);
		mouse.contextClick(rightCLick).build().perform();
		
		
		// 5. Double Click

		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
	
		WebElement doubleClick = driver.findElement(By.xpath("//h2[text()='Dropdown Menu(s)']"));
		Thread.sleep(2000);
		mouse.doubleClick(doubleClick).build().perform();
		*/
		
		// 6. ScrollToElement
		driver.get("http://www.facebook.com/");
		WebElement scroller = driver.findElement(By.xpath("//span[contains(text(),' Meta © 2023')]"));

		mouse.scrollToElement(scroller).doubleClick(scroller).build().perform();
		
		/*
		// 7. Send Keys 		
		driver.get("http://www.facebook.com/");
		WebElement Email = driver.findElement(By.xpath("//input[@id='email']"));

		//mouse.sendKeys(Email, "Bharti Hatwar").build().perform();
		
		
		// 8. Composite Action 
		
		mouse.
		moveToElement(Email).
		keyDown(Email,Keys.SHIFT).
		sendKeys(Email,"bharti hatwar").
		keyUp(Email,Keys.SHIFT).
		contextClick(Email).
		build().
		perform();
		*/
		
		
	}

}

package day5_HandlingAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		
		WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));

		submit.click();
		
		Thread.sleep(3000);
		
		org.openqa.selenium.Alert alert =   driver.switchTo().alert();
		
		// 1. Accept  & // 3. Get Text
		if(alert.getText().equals("Do you really want to delete this Customer?")) {
			alert.accept();			
		}
		Thread.sleep(3000);
		if(alert.getText().equals("Customer Successfully Delete!")) {
			alert.accept();			
		}	
		
		// 2. Dismiss
		
		//submit.click();
		//Thread.sleep(3000);
		if(alert.getText().equals("Do you really want to delete this Customer?")) {
			alert.dismiss();			
		}
		
		// 4. Send values
		
		alert.sendKeys("Kajal");
		
		// 5. Upload Files
		driver.get("https://html.com/input-type-file/");
		
		WebElement upload = driver.findElement(By.xpath("//input[@id='fileupload']"));
		
		upload.sendKeys("C:\\Users\\glend\\Downloads\\Manual Interview Questions-Set 1 - Full (1).pdf");
		
		// 6. Handling basic Authentication

		driver.get("https://the-internet.herokuapp.com/basic_auth");
				
		Thread.sleep(2000);
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}

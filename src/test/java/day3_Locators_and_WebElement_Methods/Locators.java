package day3_Locators_and_WebElement_Methods;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.*;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		/*driver.get("https://www.saucedemo.com/");
		
		By un = By.id("user-name");// Locator by ID
		By pw = By.name("password"); // Locator by Name
		By loginbtn = By.id("login-button");// Locator by Class name
		
		WebElement un_ele = driver.findElement(un);
		WebElement pw_ele = driver.findElement(pw);
		WebElement loginbtn_ele = driver.findElement(loginbtn);
		
		un_ele.click();
		un_ele.clear();
		un_ele.sendKeys("standard_user");
		Thread.sleep(5000);
		un_ele.clear();
		Thread.sleep(5000);
		un_ele.sendKeys("standard_user");
		
		String str = un_ele.getAttribute("value");
		
		System.out.println(str);
		
		pw_ele.click();
		pw_ele.clear();
		pw_ele.sendKeys("secret_sauce");
		
		Thread.sleep(5000);
		loginbtn_ele.click();
		
		
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		By links = By.linkText("Create your Amazon account");// Link text
		
		WebElement link_ele=driver.findElement(links);
		link_ele.click();
		Thread.sleep(5000);
		By partial_links = By.partialLinkText("Sign ");// Partial Link text
		WebElement partial_link_ele=driver.findElement(partial_links);
		partial_link_ele.click();
		*/
		// X path 
		
		// 1. how to create an x path
		/*driver.get("https://www.saucedemo.com/");		
		By un_xpath = By.xpath("//input[@placeholder='Username']");
		driver.findElement(un_xpath).sendKeys("ARC Institute");
		
		// 2. Indexing
		By indexing = By.xpath("(//input[@class='input_error form_input'])[2]");
		// 3. And/Or Operator
		By and_or = By.xpath("//input[@class='input_error form_input' and @placeholder='Password' or @id='password']");
		*/// 4. text()
		//div[text()='Swag Labs']
		// 5. contains()
		//input[contains(@id,'user')]
		//input[contains(@id,'pass')]
		//div[contains(text(),'Swag')]
		// 6. starts-with()
		driver.get("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
		
		Thread.sleep(2000);
		
		List<WebElement> ele= driver.findElements(By.xpath("//a[starts-with(text(),'TATA')]"));
				
		for(WebElement rt: ele) {
			System.out.println(rt.getText());
		}
		
		// 7. axes - more than 5 types of axes
				//https://demo.guru99.com/v1/index.php
		// 7.1 following
		//input[@name='uid']//following::input
		// 7.2 preceding
		//input[@name='btnReset']//preceding::input
		// 7.3 ancestor
		//input[@name='btnReset']//ancestor::tr
		// 7.4 descendant
		//(//table[@align='center'])[2]//descendant::input
		// 7.5 parent
		
		// 7.6 following-sibling
		
		// 7.7 preceding-sibling
		
		// 8. Dynamic X path
		
		
		
		
	}
	public void dynamicXpath(String companyName) {
		String str = "//a[text()='"+companyName+"']//parent::td//preceding-sibling::td//button";
		}
////a[text()='HDFCBANK']//ancestor::tr//td//button
}

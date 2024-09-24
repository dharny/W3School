package com.W3School;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {
	
	// LaunchingApplication
	
	//groups available = Main / home / navbar
	
	//static Driver 
	static WebDriver driver;
	
	@Parameters ({"Browser"})
	@Test (priority = 2 , groups ="Main")
	public void LaunchingApplication(String BrowserChoice) { //browserChoice (specify parameter)
				
		//launch Driver 
		//Chrome Driver 
		if (BrowserChoice.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			options.addArguments("--start-maximized"); 
			driver = new ChromeDriver(options);
		}
		
		//Edge Driver 
		else if (BrowserChoice.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");  //options.addArguments("--headless");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
		}
		//Firefox Driver 
		else {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			driver = new FirefoxDriver();
		}
		
		String application_url = "https://www.w3schools.com/";
		driver.get(application_url);		
	}
	
	@DataProvider (name = "Search_data")
	public Object[][] testDataProvider() {
		Object tdata[][] = {{"HTML"},{"CSS"},{"JAVASCRIPT"}};
		return tdata ;
	}
	
	@Test (priority = 4 , dataProvider = "Search_data" , groups = "home")
	public void test(String td) {		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions action = new Actions(driver);
		WebElement top_div = driver.findElement(By.xpath("//div [@id = 'menubtn_container'] // following :: a [text() = '"+td+"']"));
		action.contextClick(top_div).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).sendKeys(Keys.ESCAPE).build().perform();
		System.out.println(td);		
		
	}
	
	@Test (priority = 6 ,  groups = "home" )
	public void Dark_mode () {
		ArrayList <String> window_handles =  new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(window_handles.get(0));		
		driver.findElement(By.id("tnb-dark-mode-toggle-btn")).click();;
	}
	
	
	@Test (priority = 7 ,  groups = "home" )
	public void all_nav_elements() {
		
		ArrayList <String> window_handles =  new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(window_handles.get(0));	
		
		List<WebElement> all_nav_elements = driver.findElements(By.xpath("//a[@class='ga-nav']"));
		//for
		for (WebElement x : all_nav_elements) {
				String str = x.getText();
				System.out.println(str);			
		} //for ends
	}
	
	//@Test (priority = 6 )
	
	
}

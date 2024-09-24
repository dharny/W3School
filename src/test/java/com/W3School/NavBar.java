package com.W3School;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.W3School.reRun.MyReRunAnalyzer;

public class NavBar extends Home  {
	
	@Test (priority = 8 , groups = "navbar" )
	public void navbar_tutorials() {
		
		ArrayList <String> window_handles =  new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(window_handles.get(0));	
		
		driver.findElement(By.id("navbtn_tutorials")).click();
		
		List<WebElement> nav_titles = driver.findElements(By.xpath("//h3[@class='tnb-nav-section-title']"));
		//for
		for (WebElement x : nav_titles) {
			if(x.isDisplayed()) {
				String str = x.getText();
				System.out.println(str);
			}
			
		} //for ends
		
	}
	
	//navbtn_services
	@Test (priority = 10 , groups = "navbar" )
	public void navbar_services() {
		
		
		driver.findElement(By.id("navbtn_services")).click();
		
		List<WebElement> nav_titles = driver.findElements(By.xpath("//h4"));
		//for
		for (WebElement x : nav_titles) {
			if(x.isDisplayed()) {
				String str = x.getText();
				System.out.println(str);
			}
			
		} //for ends
		
	}
	
	@Test (priority = 10 , groups = "navbar" , retryAnalyzer = MyReRunAnalyzer.class)
	public void navbar_plus() {
		
		// fail due to multiple elements 
		driver.findElement(By.id("//h3[text() = 'Unlock Powerful Features']//  preceding :: a[@href = '/plus/index.php'] ")).click();
		
		driver.findElement(By.id("plans-toggle-pricing")).click();

	}
	

	
}

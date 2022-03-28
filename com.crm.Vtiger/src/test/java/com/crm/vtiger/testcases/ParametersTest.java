package com.crm.vtiger.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTest {

	@Test
	public void getCreadentialsDuringRunTime() {
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		String URL = System.getProperty("url");
		System.out.println(URL);
		String USERNAME = System.getProperty("username");
		System.out.println(USERNAME);
		String PASSWORD = System.getProperty("password");
		System.out.println(PASSWORD);
		WebDriver driver=null;
		
		 if(BROWSER.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup(); driver=new ChromeDriver(); }else
		  if(BROWSER.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); }else {
		  System.out.println("mention valid browser"); }
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.get(URL); driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click(); Actions action=new
		  Actions(driver); WebElement path =
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		  action.moveToElement(path).perform();
		  driver.findElement(By.linkText("Sign Out")).click(); 
		  driver.quit();
		 
	}
}

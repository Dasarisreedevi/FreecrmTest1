package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Azure1 {
	

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(" https://apa-dev.azurewebsites.net/");
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	@Test(priority = 1)
	public void loginPositive() {
		driver.findElement(By.name("Email")).sendKeys("test-user@se.com");
		driver.findElement(By.name("Password")).sendKeys("Welcome@2020");
		driver.findElement(By.xpath("//se-button[@class='display-block hydrated']")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "EAPA";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test(priority = 2)
	public void loginNegative1() {
		driver.findElement(By.name("Email")).sendKeys("ertert");
		driver.findElement(By.name("Password")).sendKeys("123432");
		driver.findElement(By.xpath("//se-button[@class='display-block hydrated']")).click();
		String errortext = driver.findElement(By.xpath("//div[text()='Incorrect Email or Password.']")).getText();
		String expectedTitle = "Incorrect Email or Password.";
		Assert.assertEquals(errortext, expectedTitle);

	}

	@Test(priority = 3)
	public void loginNegative2() {
		driver.findElement(By.name("Email")).sendKeys("234321");
		driver.findElement(By.name("Password")).sendKeys("Welcomeyut");
		driver.findElement(By.xpath("//se-button[@class='display-block hydrated']")).click();
		String errortext = driver.findElement(By.xpath("//div[text()='Incorrect Email or Password.']")).getText();
		String expectedTitle = "Incorrect Email or Password.";
		Assert.assertEquals(errortext, expectedTitle);
	}

	@Test(priority = 4)
	public void loginNegative3() {
		driver.findElement(By.name("Email")).sendKeys("");
		driver.findElement(By.name("Password")).sendKeys("1234321");
		driver.findElement(By.xpath("//se-button[@class='display-block hydrated']")).click();
		String errortext = driver.findElement(By.xpath("//div[text()='Incorrect Email or Password.']")).getText();
		String expectedTitle = "Incorrect Email or Password.";
		Assert.assertEquals(errortext, expectedTitle);

	}

	@Test(priority = 5)
	public void loginNegative4() {
		driver.findElement(By.name("Email")).sendKeys("wera12321");
		driver.findElement(By.name("Password")).sendKeys(" ");
		driver.findElement(By.xpath("//se-button[@class='display-block hydrated']")).click();
		String errortext = driver.findElement(By.xpath("//div[text()='Incorrect Email or Password.']")).getText();
		String expectedTitle = "Incorrect Email or Password.";
		Assert.assertEquals(errortext, expectedTitle);

	}

	@Test(priority = 6)
	public void loginNegative5() {
		driver.findElement(By.name("Email")).sendKeys("awse123@#$");
		driver.findElement(By.name("Password")).sendKeys(" ");
		driver.findElement(By.xpath("//se-button[@class='display-block hydrated']")).click();
		String errortext = driver.findElement(By.xpath("//div[text()='Incorrect Email or Password.']")).getText();
		String expectedTitle = "Incorrect Email or Password.";
		Assert.assertEquals(errortext, expectedTitle);
	}

	@Test(priority = 7)
	public void loginNegative6() {
		driver.findElement(By.name("Email")).sendKeys(" ");
		driver.findElement(By.name("Password")).sendKeys(" ");
		driver.findElement(By.xpath("//se-button[@class='display-block hydrated']")).click();
		String errortext = driver.findElement(By.xpath("//div[text()='Incorrect Email or Password.']")).getText();
		String expectedTitle = "Incorrect Email or Password.";
		Assert.assertEquals(errortext, expectedTitle);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("browser open");

		loginPage = new LoginPage();
		

	}

	@Test(priority = 2)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		log.info("valid Title");
		// Assert.assertEquals(title, "COGMENTO");
	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	log.info("valid username and password");
	Thread.sleep(3000);
	}
	
		
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser closed");
	}

}
   
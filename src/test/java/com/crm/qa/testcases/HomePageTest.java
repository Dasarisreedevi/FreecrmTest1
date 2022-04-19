package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		 //contactsPage = new ContactsPage();
		 //testUtil = new TestUtil();
		loginPage = new LoginPage();
		// homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title not matched");
		// assertEquals(homePageTitle, "CRMPRO", "Home Page title not matched");

	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		//testUtil.switcToWindow();;
	homePage.verifyCorrectUserName();
	}

	@Test(priority = 3)

	public void verifyContactsLinkTest() {
		//testUtil.switcToWindow();;
		 homePage.clickOnContactLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

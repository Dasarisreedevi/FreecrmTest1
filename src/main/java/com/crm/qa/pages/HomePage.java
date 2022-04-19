package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[text()='Manikanta A']")
	WebElement userNameLable;

	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsLink;

	// @FindBy(xpath="//div[@class='header item']")
	// WebElement logo;

	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//span[text()='Tasks']")
	WebElement taskLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();

	}

	public ContactsPage clickOnContactLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TaskPage clickOnTaskLink() {
		taskLink.click();
		return new TaskPage();
	}

}

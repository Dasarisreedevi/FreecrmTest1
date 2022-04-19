package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailId;
	

	@FindBy(xpath="//input[@name='password']")
	WebElement password1;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUp;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	} 
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public HomePage login(String email,String pwd) {
		emailId.sendKeys(email);
		password1.sendKeys(pwd);
		loginBtn.click();
		//signUp.click();
		return new HomePage();
		
	}
	
	
	



}

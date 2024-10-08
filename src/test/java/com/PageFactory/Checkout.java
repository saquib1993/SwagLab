package com.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Checkout {
	
	WebDriver driver;
	
	@FindBy(id="checkout")
	WebElement btn_checkout;
	
	@FindBy(id="first-name")
	WebElement fname;
	
	@FindBy(id="last-name")
	WebElement lname;
	
	@FindBy(id="postal-code")
	WebElement zip;
	
	@FindBy(id="continue")
	WebElement btn_continue;
	
	@FindBy(id="finish")
	WebElement btn_finish;
	@FindBy (xpath="//h2[@class='complete-header']")
	WebElement success;
	
	public Checkout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Click_Checkout() {
		btn_checkout.click();
	}
	
	public void Enter_info() {
		fname.sendKeys("Syed");
		lname.sendKeys("Saquib");
		zip.sendKeys("1234");
	}
	
	public void click_continue() {
		btn_continue.click();
	}
	
	public void click_finish() {
		btn_finish.click();
	}
	
	public void verify_order_placed() {
		String actTitle="Thank you for your order!";
		String expTitle=success.getText();
		
		Assert.assertEquals(actTitle, expTitle);
	}

}

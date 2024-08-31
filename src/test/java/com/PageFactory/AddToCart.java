package com.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;



public class AddToCart {
	
	WebDriver driver;

	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement item_1;

	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement  item_2;

	@FindBy(id="shopping_cart_container")
	WebElement cart;

	@FindBy(xpath="//a[@id='item_4_title_link']/div[1]")
	WebElement verify_item_1;

	@FindBy(xpath="//a[@id='item_0_title_link']/div[1]")
	WebElement verify_item_2;

	public AddToCart(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	
	public void addItems() {
		item_1.click();
		item_2.click();
	}

	public void click_on_cart() {
		cart.click();
	}

	public void verify_cart() {
		String item1="Sauce Labs Backpack";
		String item2="Sauce Labs Bike Light";
		System.out.println("item 1 is " +verify_item_1.getText());
		System.out.println("item 2 is " +verify_item_2.getText());
		Assert.assertEquals(item1, verify_item_1.getText());
		Assert.assertEquals(item2, verify_item_2.getText());
		
	
			
				
	}

}

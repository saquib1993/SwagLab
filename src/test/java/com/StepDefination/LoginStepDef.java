package com.StepDefination;



import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;

import com.PageFactory.AddToCart;
import com.PageFactory.Checkout;
import com.PageFactory.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	WebDriver driver = Hooks.driver;
	LoginPage lp;
	AddToCart ac;
	Checkout co;
	
	@Given("User is on Login Page")
	
	public void user_is_on_login_page() {
	    
	    driver.get("https://www.saucedemo.com/");
	    Hooks.test.log(Status.INFO, "Navigated to Login Page");
	      
	}

	@When("User entered {string} and {string}")
	public void user_entered_and(String username, String pass, DataTable data) {
		lp= new LoginPage(driver); 
		  
		   lp.enterUsernamePass(username, pass, data);
		   Hooks.test.log(Status.INFO, "Entered username and password");
	}

	@Then("User is on product page")
	public void user_is_on_product_page() {
	  lp.clickButton();
	  Hooks.test.log(Status.PASS, "User successfully logged in and navigated to the product page");
	   
	}
	
	// Add to Cart 
	
	@Given("User add items in cart")
	public void user_add_items_in_cart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 ac= new AddToCart(driver);
		ac.addItems();
		Hooks.test.log(Status.INFO, "User added items in cart");
	    
	}

	@When("User click on cart button")
	public void user_click_on_cart_button() {
	   ac.click_on_cart();
	   Hooks.test.log(Status.INFO, "User click on cart button");
	}

	@Then("User Verify Items")
	public void user_verify_items() {
		
		String item1="Sauce Labs Backpack";
		String item2="Sauce Labs Bike Light";
		System.out.println("item 1 is " +ac.verify_item_1.getText());
		System.out.println("item 2 is " +ac.verify_item_2.getText());
		Assert.assertEquals(item1, ac.verify_item_1.getText());
		Assert.assertEquals(item2, ac.verify_item_2.getText());
		 Hooks.test.log(Status.PASS, "User successfully added items in cart.");
	}
	
	// Checkout and Payment
	@Given("User is on cart")
	public void user_is_on_cart() {
		ac= new AddToCart(driver);
		ac.addItems();
		ac.click_on_cart();
		Hooks.test.log(Status.INFO, "User navigated to cart");
		
		
	}
	
	@When("User click on checkout button")
	public void user_click_on_checkout_button() {
		co= new Checkout(driver);
		co.Click_Checkout();
		Hooks.test.log(Status.INFO, "User click on checkout button");
		 
	}

	@When("User enter checkout info")
	public void user_enter_checkout_info() {
	   co.Enter_info();
	   Hooks.test.log(Status.INFO, "User enter checkout info");
	  
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
	    co.click_continue();
	}

	@When("User click on Finish")
	public void user_click_on_finish() {
	   co.click_finish();
	   Hooks.test.log(Status.INFO, "User click on Finish");
	}

	@Then("User is on  successfull order Page")
	public void user_is_on_successfull_order_page() {
		String actTitle="Thank you for your order!";
		String expTitle=co.success.getText();
		
		Assert.assertEquals(actTitle, expTitle);
		Hooks.test.log(Status.PASS, "User successfully placed order.");
	}



	
	

}

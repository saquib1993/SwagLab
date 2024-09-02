package com.StepDefination;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.PageFactory.AddToCart;
import com.PageFactory.Checkout;
import com.PageFactory.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	WebDriver driver = new ChromeDriver();
	LoginPage lp;
	AddToCart ac;
	Checkout co;
	
	@Given("User is on Login Page")
	
	public void user_is_on_login_page() {
	    
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    
	}

	@When("User entered {string} and {string}")
	public void user_entered_and(String username, String pass, DataTable data) {
		lp= new LoginPage(driver); 
		  
		   lp.enterUsernamePass(username, pass, data);
	}

	@Then("User is on product page")
	public void user_is_on_product_page() {
	  lp.clickButton();
	   
	}
	
	// Add to Cart 
	
	@Given("User add items in cart")
	public void user_add_items_in_cart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 ac= new AddToCart(driver);
		ac.addItems();
	    
	}

	@When("User click on cart button")
	public void user_click_on_cart_button() {
	   ac.click_on_cart();
	}

	@Then("User Verify Items")
	public void user_verify_items() {
	    ac.verify_cart();
	}
	
	// Checkout and Payment
	@Given("User is on cart")
	public void user_is_on_cart() {
		ac= new AddToCart(driver);
		ac.addItems();
		ac.click_on_cart();
	}
	
	@When("User click on checkout button")
	public void user_click_on_checkout_button() {
		co= new Checkout(driver);
		co.Click_Checkout();
	}

	@When("User enter checkout info")
	public void user_enter_checkout_info() {
	   co.Enter_info();
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
	    co.click_continue();
	}

	@When("User click on Finish")
	public void user_click_on_finish() {
	   co.click_finish();
	}

	@Then("User is on  successfull order Page")
	public void user_is_on_successfull_order_page() {
	    co.verify_order_placed();
	}



	
	

}

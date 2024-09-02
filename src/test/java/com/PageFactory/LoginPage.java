package com.PageFactory;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;




public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement uname;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement login;
	
	@FindBy(className="title")
	WebElement title;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsernamePass(String username, String pass, DataTable log) {
		 List<Map<String,String >>  data = log.asMaps(String.class, String.class);
		    System.out.println("derails are"+data);
		    username = data.get(0).get("username");
		    pass = data.get(0).get("pass");
		    //System.out.println("derails 2 are"+data.get(0).get("username"));
		uname.sendKeys(username);
		password.sendKeys(pass);
	}
	
	public void clickButton() {
		login.click();
		String Actual = title.getText();
		System.out.println(Actual);
		String exp = "Products";
		Assert.assertEquals(Actual,exp);
		
		
		
	
}
}



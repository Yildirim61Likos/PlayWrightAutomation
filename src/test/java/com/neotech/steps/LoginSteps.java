package com.neotech.steps;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods{

	@When("I enter user name")
	public void i_enter_user_name() 
	{
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILE_PATH);
	    login.userNameInput.fill(ConfigsReader.getProperty("username"));
	}
	@When("I enter password")
	public void i_enter_password() 
	{
		
		login.passwordInput.fill(ConfigsReader.getProperty("password"));
	}
	@When("i click the submit button")
	public void i_click_the_submit_button() 
	{
		login.loginButton.click();
	}
	@Then("I validate the url")
	public void i_validate_the_url() throws InterruptedException 
	{
	    Thread.sleep(2000);
	    
	    String url=page.url();
	    System.out.println(url);
	    Thread.sleep(2000);
	}
	@Then("I validate the title")
	public void i_validate_the_title() throws InterruptedException 
	{
	    String title=page.title();
	    System.out.println(title);
	    
	    
	    page.waitForLoadState();
	    
	}



}

package com.neotech.steps;

import org.junit.Assert;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashSteps extends CommonMethods{

	
	@Given("I logged in")
	public void i_logged_in() 
	{
	    
		login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password") );
		
		
		// we can open the new tab here 
		
		Page page3=brContext.newPage();
		
		page3.navigate("https://selectorshub.com/");
		
		
		
		// we can open the new browser here 
		
		BrowserContext brContext2=browser.newContext();
		
		Page page2=brContext2.newPage();
		
		page2.navigate("https://selectorshub.com/");
		
	}
	
	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() 
	{
		page.waitForLoadState();
	   boolean isTrue= dash.dashName.isVisible();
	   Assert.assertTrue(isTrue);
	   
	}
	

}

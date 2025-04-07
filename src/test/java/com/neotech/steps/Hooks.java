package com.neotech.steps;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{

	
	@Before
	public static void openTheBrowser() throws InterruptedException 
	{
		setUp();
	}
	
	
	@After
	public static void closeTheBrowser(Scenario scenario) 
	{
	    byte[] pic = null;

	    try {
	        if (BaseClass.page != null)
	        {
	            if (scenario.isFailed()) 
	            {
	                pic = CommonMethods.takeScreenshot("failed/" + scenario.getName(), BaseClass.page);
	            } else {
	                pic = CommonMethods.takeScreenshot("passed/" + scenario.getName(), BaseClass.page);
	            }

	            scenario.attach(pic, "image/png", scenario.getName());
	        }
	    } catch (Exception e) {
	        System.out.println("⚠️ Screenshot failed: " + e.getMessage());
	    }

	    tearDown(); // Clean up Playwright
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

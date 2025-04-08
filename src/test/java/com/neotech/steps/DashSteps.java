package com.neotech.steps;

import org.junit.Assert;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.neotech.testbase.BaseClass;
import com.neotech.testbase.PageInitializer;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashSteps extends CommonMethods {

    @Given("I logged in")
    public void i_logged_in() 
    {
        PageInitializer.login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

        // Open a new tab in the current browser context
       Page page3 = BaseClass.getPage().context().newPage();
       page3.navigate("https://selectorshub.com/");

        // Open a new browser context and a page in it
       BrowserContext brContext2 = BaseClass.getPage().context().browser().newContext();
       Page page2 = brContext2.newPage();
       page2.navigate("https://selectorshub.com/");
    }

    @Then("I validate the outcomes")
    public void i_validate_the_outcomes() 
    {
        BaseClass.getPage().waitForLoadState();
        
        boolean isTrue = PageInitializer.dash.dashName.isVisible();
        Assert.assertTrue(isTrue);
    }
} 


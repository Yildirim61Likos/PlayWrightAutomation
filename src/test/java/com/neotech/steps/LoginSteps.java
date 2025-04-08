package com.neotech.steps;

import org.junit.Assert;

import com.neotech.testbase.BaseClass;
import com.neotech.testbase.PageInitializer;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends CommonMethods{
	@When("I enter user name")
    public void i_enter_user_name() {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILE_PATH);
        PageInitializer.login.userNameInput.fill(ConfigsReader.getProperty("username"));
    }

    @When("I enter password")
    public void i_enter_password() {
        PageInitializer.login.passwordInput.fill(ConfigsReader.getProperty("password"));
    }

    @When("i click the submit button")
    public void i_click_the_submit_button() {
        PageInitializer.login.loginButton.click();
    }

    @Then("I validate the url")
    public void i_validate_the_url() throws InterruptedException {
        Thread.sleep(1000);
        String url = BaseClass.getPage().url();
        Assert.assertEquals("https://hrm.neotechacademy.com/auth/validateCredentials", url);
        System.out.println("✅ URL Validated: " + url);
    }

    @Then("I validate the title")
    public void i_validate_the_title() throws InterruptedException {
        String title = BaseClass.getPage().title();
        Assert.assertEquals("Dashboard", title);
        System.out.println("✅ Title Validated: " + title);
        BaseClass.getPage().waitForLoadState();
    }
}
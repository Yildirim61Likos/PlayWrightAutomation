package com.neotech.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.neotech.utils.CommonMethods;

public class LoginPage extends CommonMethods {

	Page page;
	
    // Locators
    public Locator userNameInput;
    public Locator passwordInput;
    public Locator loginButton;

    // Constructor
    public LoginPage(Page page) 
    {
        this.page = page;
        userNameInput = page.locator("//input[@placeholder='Username']");
        passwordInput = page.locator("//input[@id='txtPassword']");
        loginButton = page.locator("//button[@type='submit']");
    }

    // Optional helper method
    public void login(String userName, String password) 
    {
        userNameInput.fill(userName);
        passwordInput.fill(password);
        loginButton.click();
    }
	
	

}

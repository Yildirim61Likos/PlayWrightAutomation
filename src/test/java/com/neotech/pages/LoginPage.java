package com.neotech.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.neotech.testbase.BaseClass;

public class LoginPage {

    private Page page;
    public Locator userNameInput;
    public Locator passwordInput;
    public Locator loginButton;

    public LoginPage() 
    {
        this.page = BaseClass.getPage();
        userNameInput = page.locator("//input[@placeholder='Username']");
        passwordInput = page.locator("//input[@id='txtPassword']");
        loginButton = page.locator("//button[@type='submit']");
    }

    public void login(String userName, String password) 
    {
        userNameInput.fill(userName);
        passwordInput.fill(password);
        loginButton.click();
    }
}



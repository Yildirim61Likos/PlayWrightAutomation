package com.neotech.testbase;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.*;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

public class BaseClass {

	    private static Playwright playwright;
	    private static Browser browser;
	    private static BrowserContext context;
	    private static Page page;

	    public static void setUp() 
	    {
	        ConfigsReader.readProperties(Constants.CONFIGURATION_FILE_PATH);
	        String browserType = ConfigsReader.getProperty("browser");
	        playwright = Playwright.create();

	        switch (browserType.toLowerCase()) 
	        {
	            case "chrome":
	                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
	                break;
	            case "firefox":
	                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	                break;
	            case "webkit":
	                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
	                break;
	            case "chromium":
	                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	                break;
	            default:
	                throw new RuntimeException("Unsupported browser: " + browserType);
	        }

	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = (int) screenSize.getWidth();
	        int height = (int) screenSize.getHeight();

	        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
	        page = context.newPage();

	        page.navigate(ConfigsReader.getProperty("url"));
	        PageInitializer.initialize();
	    }

	    public static Page getPage() 
	    {
	        return page;
	    }

	    public static Browser getBrowser() 
	    {
	        return browser;
	    }

	    public static BrowserContext getContext() 
	    {
	        return context;
	    }

	    public static Playwright getPlaywright() 
	    {
	        return playwright;
	    }

	    public static void tearDown() 
	    {
	        if (page != null) page.close();
	        if (context != null) context.close();
	        if (browser != null) browser.close();
	        if (playwright != null) playwright.close();
	    }
	}
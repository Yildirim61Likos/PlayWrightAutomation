package com.neotech.testbase;



import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;


public class BaseClass {

	
	public static Playwright playwright;
	public static Browser browser;
	public static BrowserContext brContext;
	public static Page page;
	
	public static void setUp() throws InterruptedException 
	{
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILE_PATH);
		
		String browserType=ConfigsReader.getProperty("browser");
		
		System.out.println(browserType);
		
		playwright = Playwright.create(); 
		
		switch(browserType.toLowerCase()) 
		{
		case"chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		case"firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case"webkit":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case"chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
			default:
				System.out.println("Please paas the right browser name !");
				break;
				
		}
		
		brContext =browser.newContext();
		page=brContext.newPage();
		
		String website=ConfigsReader.getProperty("url");
		//System.out.println("This is the URL COMING FROM jENKINS !!!  "+System.getProperty("WebUrl"));
		//driver.get(System.getProperty(website));
		page.navigate(website);
		
		Thread.sleep(1000);
		
		PageInitializer.initialize();
		
	}
	
	
	public static void tearDown() 
	{
		
		page.context().browser().close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

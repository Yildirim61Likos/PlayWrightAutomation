package com.neotech.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.neotech.utils.CommonMethods;

public class DashBoardPage extends CommonMethods {


    Page page;
	
	//i[normalize-space()='keyboard_arrow_down']
	
	public Locator dashName;
	

    // Constructor
    public DashBoardPage(Page page) 
    {
        this.page = page;
        dashName = page.locator("//img[@class='circle account-photo']");
        
    }

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

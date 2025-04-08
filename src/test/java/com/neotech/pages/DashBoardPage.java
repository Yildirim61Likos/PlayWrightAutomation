package com.neotech.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommonMethods;

public class DashBoardPage extends CommonMethods {


    private Page page;
	
	//i[normalize-space()='keyboard_arrow_down']
	
	public Locator dashName;
	

    // Constructor
    public DashBoardPage() 
    {
    	this.page = BaseClass.getPage();
        dashName = page.locator("//img[@class='circle account-photo']");
        
    }

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.neotech.testbase;

import com.neotech.pages.LoginPage;

public class PageInitializer extends BaseClass {

	public static LoginPage login;
	
	public static void initialize() 
	{
		login=new LoginPage(BaseClass.page);
		
	}
	
	
	
	
}
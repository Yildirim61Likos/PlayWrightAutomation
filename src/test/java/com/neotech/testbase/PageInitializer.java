package com.neotech.testbase;

import com.neotech.pages.DashBoardPage;
import com.neotech.pages.LoginPage;

public class PageInitializer extends BaseClass {

	public static LoginPage login;
	public static DashBoardPage dash;
	public static void initialize() 
	{
		login = new LoginPage(BaseClass.page);
		dash =new DashBoardPage(BaseClass.page);
	}
	
	
	
	
}
package com.neotech.testbase;

import com.neotech.pages.DashBoardPage;
import com.neotech.pages.LoginPage;

public class PageInitializer 
{
    public static LoginPage login;
    public static DashBoardPage dash;

    public static void initialize() 
    {
        login = new LoginPage();
        dash = new DashBoardPage();
    }
}

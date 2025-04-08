package com.neotech.steps;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void openTheBrowser() throws InterruptedException {
        BaseClass.setUp();
    }

    @After
    public void closeTheBrowser(Scenario scenario) {
        byte[] pic = null;
        try {
            if (BaseClass.getPage() != null) {
                if (scenario.isFailed()) {
                    pic = CommonMethods.takeScreenshot("failed/" + scenario.getName(), BaseClass.getPage());
                } else {
                    pic = CommonMethods.takeScreenshot("passed/" + scenario.getName(), BaseClass.getPage());
                }
                scenario.attach(pic, "image/png", scenario.getName());
            }
        } catch (Exception e) {
            System.out.println("⚠️ Screenshot failed: " + e.getMessage());
        }
        BaseClass.tearDown();
    }
}

	
	
	

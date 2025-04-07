package com.neotech.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.microsoft.playwright.Page;
import com.neotech.testbase.PageInitializer;

public class CommonMethods extends PageInitializer{

	
	
	 public static byte[] takeScreenshot(String path, Page page) throws IOException
	 {
	        // ✅ Format timestamp
		 
	        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	        String fileName = path + "_" + timestamp + ".png";

	        // ✅ Define full path to save the screenshot
	        
	        Path destination = Paths.get(Constants.SCREENSHOT_PATH, fileName);

	        // ✅ Save screenshot to disk
			page.screenshot(new Page.ScreenshotOptions().setPath(destination));

	        // ✅ Return screenshot as byte[] (for Cucumber report)
	        return page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
	    }
	 
	public static String getTimeStamp() 
	{
		
		Date date =new Date();
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		return s.format(date);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

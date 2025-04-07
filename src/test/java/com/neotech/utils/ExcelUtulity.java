package com.neotech.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtulity {

	
	private static Workbook book;
	
	private static Sheet sheet;
	
	private static void openExcel(String path) 
	{
		try 
		{
		  FileInputStream fis=new FileInputStream(path);
		  book=new XSSFWorkbook(fis);
		}catch(IOException a)
		{
			a.printStackTrace();
		}
	}
	
	
	
	private static void loadSheet(String sheetName) 
	{
		sheet=book.getSheet(sheetName);
	}
	
	
	private static int rowCount() 
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	private static int columnCount(int index) 
	{
		return sheet.getRow(index).getLastCellNum();
	}
	
	private static String getCellData(int indexr,int indexc)
	{
		return sheet.getRow(indexr).getCell(indexc).toString();
				
	}
	
	
	public static Object[][] excelIntoArray(String path,String sheetName)
	{
		openExcel(path);
		loadSheet(sheetName);
		
		int rowR=rowCount();
		int colC=columnCount(0);
		
		Object[][] data=new Object[rowR-1][colC];
		for(int row=1; row<rowR; row++) 
		{
			for(int col=0; col<colC; col++) 
			{
				data[row-1][col] =getCellData(row,col);
			}
		}
		return data;
	}
	
	
	
	public static List<Map<String,String>> excelIntoListofmap(String path,String sheetName)
	{
		openExcel(path);
		loadSheet(sheetName);
		
		List<Map<String,String>> listmap=new ArrayList<>();
		for(int row=1; row<rowCount(); row++) 
		{
			Map<String,String> map=new LinkedHashMap<>();
			
			for(int col=0; col<columnCount(row); col++ )
			{
					String key=getCellData(0,col);
					String value=getCellData(row,col);
					map.put(key, value);
			}
			
			listmap.add(map);
		}
		return listmap;
	}
	
	
	
	
	
	
}

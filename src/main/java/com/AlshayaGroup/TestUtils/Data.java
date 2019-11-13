package com.AlshayaGroup.TestUtils;


import org.testng.annotations.DataProvider;

import com.AlshayaGroup.TestSetup.TestSetup;

public class Data extends TestSetup {
	
	@DataProvider
	public Object[][] getDataSimple() {
		

		String sheetName = "TestData";
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
	
		//System.out.println(rowNum);
		//System.out.println(colNum);
		
		Object[][] data= new Object[rowNum-1][colNum];
		
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {


				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
			}
			
		}
		return data;
		
	}
	

	@DataProvider
	public Object[][] getDataSecondSheet() {
		

		String sheetName = "SecondSheet";
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
	
		System.out.println(rowNum);
		System.out.println(colNum);
		
		Object[][] data= new Object[rowNum-1][colNum];
		
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {


				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
			}
			
		}
		return data;
		
	}

	
	
}

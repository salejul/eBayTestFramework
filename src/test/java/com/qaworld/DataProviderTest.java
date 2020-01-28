package com.qaworld;

import org.testng.annotations.DataProvider;

import com.qaworld.lib.ReadExcelDataLib;

public class DataProviderTest {


  @DataProvider
  public Object[][] dataProvider1() {
    
	String fileName = "C:\\Users\\DmoDe\\ECWSpaces\\framework\\TestDataExcel\\TestData.xlsx";  
  	ReadExcelDataLib excel = new ReadExcelDataLib();
  	return excel.GetExcelData(fileName, "Sheet1", 3);
  }
}

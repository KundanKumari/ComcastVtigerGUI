package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
//pass three argument to connect the excel sheet return
	public String getDataFromExcel(String sheetName, int rowNum,int celNum ) throws Throwable, IOException {
		
        FileInputStream fis1=new FileInputStream("./testdata/Org.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
public int getRowcount(String sheetName) throws Throwable, IOException {
		
        FileInputStream fis1=new FileInputStream("./testdata/Org.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		int rowcount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
}
public void setDataIntoExcel(String sheetName, int rowNum,int celNum, String data) throws Throwable  {
	
    FileInputStream fis1=new FileInputStream("./testdata/Org.xlsx");
	Workbook wb= WorkbookFactory.create(fis1);
	wb.getSheet(sheetName).getRow(rowNum).getLastCellNum();
	wb.close();

	
    FileOutputStream fos=new FileOutputStream("./testdata/Org.xlsxs");
	wb.write(fos);
	wb.close();
}}
package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName,int rownum,int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./testData/textScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		String data=row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testData/textScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName,int rownum,int cellNum,String data) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testData/textScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	    wb.getSheet(sheetName).getRow(rownum).createCell(cellNum);
	    
	    FileOutputStream fos=new FileOutputStream("./testData/textScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}

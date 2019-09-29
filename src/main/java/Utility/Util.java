package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Basictest.BasicTest;


public class Util extends BasicTest{
	
			
	public static String value;
	public static String readExcel(String columnname,String UserType) {
		
		
		try {
			FileInputStream file = new FileInputStream(prop.getProperty("path"));
			@SuppressWarnings("resource")
			XSSFWorkbook wr = new XSSFWorkbook(file);
			XSSFSheet sh = wr.getSheet(prop.getProperty("env"));
			int row = sh.getPhysicalNumberOfRows();
			//System.out.println(row);
			
			
				for(int j=0;j<row;j++) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>" + sh.getRow(j).getCell(0).getStringCellValue());
					if((sh.getRow(j).getCell(0).getStringCellValue()).equalsIgnoreCase(UserType)) {
						System.out.println(UserType);
						int col = sh.getRow(0).getPhysicalNumberOfCells();
						for(int i=0;i<col;i++) {
							String s=sh.getRow(0).getCell(i).getStringCellValue();
							if(s.equals(columnname)) {
								System.out.println(columnname);
								 value = sh.getRow(j).getCell(i).getStringCellValue();
							}
						}
					}
				}
			}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(value);
		return value;
	}	
}

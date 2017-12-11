package pl.edu.agh.mwo.java2;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {
	public static void main (String[] args) {
		System.out.println("Welcome!");
		Workbook wb = new XSSFWorkbook();
		
		// create new sheet
		Sheet sheet = wb.createSheet("sheet name");
		
		// create columns
		for (int i=0;i<10;i++) {
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(i);
		}
		
		
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("workbook.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

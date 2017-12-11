package pl.edu.agh.mwo.java2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SudokuBoardChecker {
	private Workbook workbook;
	
	public SudokuBoardChecker(Workbook workbook) {
		this.workbook = workbook;
	}
	
	public boolean verifyBoardStructure(int sheetIndex) {
		
		System.out.println("Checking Sudoku Excel File..");
		
		Sheet sheet = workbook.getSheetAt(sheetIndex);
		
		for (int rowIndex = 0; rowIndex<9; rowIndex++) {
			
			for (int columnIndex = 0; columnIndex<9; columnIndex++) {
	
				Row row = sheet.getRow(rowIndex);
				//System.out.println(row);
				if (row == null) {
					return false;
				} else {
					Cell cell = row.getCell(columnIndex);
					CellType cellType = cell.getCellTypeEnum();
					switch (cellType) {
						case BLANK:
							System.out.print(" |"); 
							break;
						case BOOLEAN: 
							System.out.print("incorrect value at column: " + cell.getColumnIndex() + " row: " + cell.getRowIndex()); 
							break;
						case STRING:
							System.out.print("incorrect String value at column: " + cell.getColumnIndex() + " row: " + cell.getRowIndex()); 
							break;
						case NUMERIC: 
							System.out.print((int)cell.getNumericCellValue() + "|"); 
							break;
						case FORMULA:
							System.out.print("incorrect formula found at column: " + cell.getColumnIndex() + " row: " + cell.getRowIndex()); 
							break;
						case ERROR:
							System.out.print("General error at: " + cell.getColumnIndex() + " row: " + cell.getRowIndex()); 
							break;
						default:
							return false;
					}
				}
			}
			System.out.println("\n- - - - - - - - - ");
		}
		return true;
	}
	
/*	public Set<Integer> importBoardStructure(int sheetIndex) {
	
		Set<Integer> set = new HashSet<>(
			Arrays.asList(new Integer[] { -1.0, 0.0, 1.0 }));
	

		return set
	}
	*/
	
	public static void main (String[] args) {
		
		try {
			
			Workbook sudokuWorkbook = WorkbookFactory.create(new File("sudoku.xlsx"));
			
			SudokuBoardChecker sudokuBoardChecker = new SudokuBoardChecker(sudokuWorkbook);
			
			sudokuBoardChecker.verifyBoardStructure(4);
			
			
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			
			e.printStackTrace();
			
		}
	}
}

package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String[][] readExcelData(String sheetName) {
	    String[][] data = null;
	    try {
	        FileInputStream fis = new FileInputStream("testdata/TestData.xlsx");
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	        data = new String[rowCount - 1][colCount];

	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                if (cell != null) {
	                    switch (cell.getCellType()) {
	                        case STRING:
	                            data[i - 1][j] = cell.getStringCellValue();
	                            break;
	                        case NUMERIC:
	                            data[i - 1][j] = String.valueOf((long) cell.getNumericCellValue());
	                            break;
	                        case BOOLEAN:
	                            data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
	                            break;
	                        case FORMULA:
	                            data[i - 1][j] = cell.getCellFormula();
	                            break;
	                        default:
	                            data[i - 1][j] = "";
	                    }
	                } else {
	                    data[i - 1][j] = "";
	                }
	            }
	        }

	        workbook.close();
	        fis.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return data;
	}

}

package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {


	public static int getRowCount(String xlPath, String sheetName) {
		int rc = 0;
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			rc = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {

		}
		return rc;
	}

	public static String getCellValue(String xlPath, String sheetName, int row, int cell) {
		String value = "";

		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheetName).getRow(row).getCell(cell);
			value = c.getStringCellValue();
		} catch (Exception e) {

		}
		return value;
	}

}

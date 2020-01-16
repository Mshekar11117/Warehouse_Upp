package utilities;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.SuperTestNG;

public class XlApiTest extends SuperTestNG {

	String cellValue;

	public XlApiTest(String xlpath1) throws Exception {
		fis = new FileInputStream(xlpath1);
		if (xlpath1.contains(".xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else {
			wb = new HSSFWorkbook(fis);
		}

		fis.close();
	}

	public String getCellDataByColName(String sheetName, String colName, int rowNum) {
		try {
			int colNum = -1;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(6);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}

			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(colNum);

			if (cell.getCellTypeEnum() == CellType.STRING) {
				cellValue = String.valueOf(cell.getStringCellValue());
//				System.out.println("Name---" + cellValue);
			}

			else if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date date = cell.getDateCellValue();
				cellValue = df.format(date);
//				System.out.println("Date---" + cellValue);
			}

			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				DataFormatter data = new DataFormatter();
				cellValue = data.formatCellValue(cell);
//				cellValue = String.valueOf(cell.getNumericCellValue());
//				System.out.println("Numeric and formula---" + cellValue);
			}

			else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
			return cellValue;
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column Name " + colName + " does not exist in Excel";
		}
	}

	public String getCellDataByColNum(String sheetName, int colNum, int rowNum) {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel";
		}
	}

	public String HSSFgetCellDataByColNum(String sheetName, int colNum, int rowNum) {
		try {

			HSSFSheet sheet = wb.getSheet(sheetName);
			HSSFRow row = sheet.getRow(rowNum);
			HSSFCell cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel";
		}
	}

	public String HSSFgetCellDataByColName(String sheetName, String colName, int rowNum) {
		try {
			int colNum = -1;
			HSSFSheet sheet = wb.getSheet(sheetName);
			HSSFRow row = sheet.getRow(rowNum);
			row = sheet.getRow(0);
			for (int i = 1; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum = i;
			}

			row = sheet.getRow(rowNum - 1);
			if(row==null)
				return "";
			HSSFCell cell = row.getCell(colNum);
			if(cell==null)
				return "";
			
			if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
				
			}

			else if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date date = cell.getDateCellValue();
				cellValue = df.format(date);
//				System.out.println("Date---" + cellValue);
			}

			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				/*
				 * DataFormatter data = new DataFormatter(); cellValue =
				 * data.formatCellValue(cell);
				 */
				cellValue = String.valueOf(cell.getNumericCellValue());
//				System.out.println("Numeric and formula---" + cellValue);
			}

			else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
			return cellValue;
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column Name " + colName + " does not exist in Excel";
		}
	}

	public int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}

	public int HFFSgetRowCount(String sheetName) {
		HSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}

	public int getColumnCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(6);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	public int HSSFgetColumnCount(String sheetName) {
		HSSFSheet sheet = wb.getSheet(sheetName);
		HSSFRow row = sheet.getRow(6);
		int colCount = row.getLastCellNum();
		return colCount;
	}

}

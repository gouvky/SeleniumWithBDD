package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLUtility{

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileInputStream fis;
	public FileOutputStream fos;
	int rowCount;
	int colCount;
	String data;
	String path = null;

	public XLUtility(String path) {
		this.path = path;
	}

		public String getcellData(String sheetName, int rowNum, int colNum) {

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);

			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);

			DataFormatter format = new DataFormatter();

			try {
				//Returns the formatted value of a cell as a String regardless of the cell type
				data = format.formatCellValue(cell);
			} catch (Exception e) {

				data = "";
				e.printStackTrace();		
			}
			fis.close();
			workbook.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}
}
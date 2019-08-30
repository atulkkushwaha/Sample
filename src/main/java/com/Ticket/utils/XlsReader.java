package com.Ticket.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Ticket.FileFormat.ITIL;

public class XlsReader {
	private static final String FILE_PATH = "C:\\Users\\AT381322\\Desktop\\AndhraBank\\ABTEJ\\Ticket2XLS\\ITIL.xlsx";

	public static void main(String[] args) {
		System.out.println(getRequestListFromExcel());
	}

	public static List<ITIL> getRequestListFromExcel() {
		List<ITIL> studentList = new ArrayList<ITIL>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILE_PATH);

			// Using XSSF for xlsx format, for xls use HSSF
			Workbook workbook = new XSSFWorkbook(fis);
			int numberOfSheets = workbook.getNumberOfSheets();

			// looping over each workbook sheet
			for (int i = 0; i < numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<?> rowIterator = sheet.iterator();

				// iterating over each row
				while (rowIterator.hasNext()) {
					ITIL itil = new ITIL();
					Row row = (Row) rowIterator.next();
					if (row.getRowNum() != 0) {
						Iterator<?> cellIterator = row.cellIterator();

						// Iterating over each cell (column wise) in a particular row.
						while (cellIterator.hasNext()) {
							Cell cell = (Cell) cellIterator.next();
							if (cell.getColumnIndex() == 0) {
								itil.setId(String.valueOf(cell.toString()));
							}
							if (cell.getColumnIndex() == 1) {
								itil.setDate(String.valueOf(cell.toString()));
							}
							if (cell.getColumnIndex() == 2) {
								itil.setSR_ID(String.valueOf(cell.getStringCellValue()));
							}
							if (cell.getColumnIndex() == 3) {
								itil.setSubject(String.valueOf(cell.getStringCellValue()));
							}
							if (cell.getColumnIndex() == 4) {
								itil.setStatus(String.valueOf(cell.getStringCellValue()));
							}
							if (cell.getColumnIndex() == 5) {
								itil.setEngineer(String.valueOf(cell.getStringCellValue()));
							}
							if (cell.getColumnIndex() == 6) {
								itil.setDescription(String.valueOf(cell.getStringCellValue()));
							}
						}
						studentList.add(itil);
					}
				}
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return studentList;
	}
}
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

import com.Ticket.FileFormat.HealthRep;

public class XlsReaderHR {
	private static final String FILE_PATH = "C:\\Users\\AT381322\\Desktop\\AndhraBank\\WSR\\May_2019\\May_2019\\";

	
	public static void main(String[] args) {
		
		String fileName;
		String date;
		for(int i=1;i<31;i++) {
			if(i<10) {
				date = "0"+i+"_05_2019";
			}else {
				date = i+"_05_2019";
			}
			
			fileName = "Windows_Health Report_"+date+".xlsx";
			System.out.println(getRequestListFromExcel(date,fileName));			
		}
	}

	public static List<HealthRep> getRequestListFromExcel(String date, String fileName) {
		List<HealthRep> healthRepLS = new ArrayList<HealthRep>();
		FileInputStream fis = null;
		String fileP =  FILE_PATH + fileName;
		try {
			fis = new FileInputStream(fileP);

			// Using XSSF for xlsx format, for xls use HSSF
			Workbook workbook = new XSSFWorkbook(fis);
			int numberOfSheets = workbook.getNumberOfSheets();

			// looping over each workbook sheet
//			for (int i = 0; i < numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(0);
				Iterator<?> rowIterator = sheet.iterator();

				
				List<Float> APP1CPU = new ArrayList<Float>();
				List<Float> APP1RAM = new ArrayList<Float>();
				List<Float> APP1CDrive = new ArrayList<Float>();
				
				List<Float> APP2CPU = new ArrayList<Float>();
				List<Float> APP2RAM = new ArrayList<Float>();
				List<Float> APP2CDrive = new ArrayList<Float>();
				
				List<Float> DB2CPU = new ArrayList<Float>();
				List<Float> DB2RAM = new ArrayList<Float>();
				List<Float> DB2CDrive = new ArrayList<Float>();
				
				
				
				
				// iterating over each row
				while (rowIterator.hasNext()) {
					Row row = (Row) rowIterator.next();
					if (row.getRowNum() != 0 && row.getRowNum() != 1 && row.getRowNum() != 2) {
						Iterator<?> cellIterator = row.cellIterator();

						// Iterating over each cell (column wise) in a particular row.
						while (cellIterator.hasNext()) {
							Cell cell = (Cell) cellIterator.next();
							
//							APP 1 CPU RAM CDRIVE
							if (cell.getColumnIndex() == 2) {
								APP1CPU.add((float) cell.getNumericCellValue());
							}
							if (cell.getColumnIndex() == 3) {
								APP1RAM.add((float) cell.getNumericCellValue());
							}							
							if (cell.getColumnIndex() == 4) {
								APP1CDrive.add((float) cell.getNumericCellValue());
							}
							
//							APP 2 CPU RAM CDRIVE
							if (cell.getColumnIndex() == 7) {
								APP2CPU.add((float) cell.getNumericCellValue());
							}
							if (cell.getColumnIndex() == 8) {
								APP2RAM.add((float) cell.getNumericCellValue());
							}							
							if (cell.getColumnIndex() == 9) {
								APP2CDrive.add((float) cell.getNumericCellValue());
							}
							
							
//							DB2  CPU RAM CDRIVE
							if (cell.getColumnIndex() == 12) {
								DB2CPU.add((float) cell.getNumericCellValue());
							}
							if (cell.getColumnIndex() == 13) {
								DB2RAM.add((float) cell.getNumericCellValue());
							}							
							if (cell.getColumnIndex() == 14) {
								DB2CDrive.add((float) cell.getNumericCellValue());
							}
							
						}
					}
				}

				System.out.println("*****************************************************************************************************");
				System.out.println(date);
				System.out.println("CPU1");
				System.out.println("Max CPU : " + Utility.findMax(APP1CPU)+ " ::: "+"Min CPU : " + Utility.findMin(APP1CPU));
				System.out.println("Max RAM : " + Utility.findMax(APP1RAM)+ " ::: "+"Min RAM : " + Utility.findMin(APP1RAM));
				System.out.println("Max C-D : " + Utility.findMax(APP1CDrive)+ " ::: "+"Min C-D : " + Utility.findMin(APP1CDrive));

				System.out.println("CPU2");
				System.out.println("Max CPU : " + Utility.findMax(APP2CPU)+ " ::: "+"Min CPU : " + Utility.findMin(APP2CPU));
				System.out.println("Max RAM : " + Utility.findMax(APP2RAM)+ " ::: "+"Min RAM : " + Utility.findMin(APP2RAM));
				System.out.println("Max C-D : " + Utility.findMax(APP2CDrive)+ " ::: "+"Min C-D : " + Utility.findMin(APP2CDrive));

				System.out.println("DB2");
				System.out.println("Max CPU : " + Utility.findMax(DB2CPU)+ " ::: "+"Min CPU : " + Utility.findMin(DB2CPU));
				System.out.println("Max RAM : " + Utility.findMax(DB2RAM)+ " ::: "+"Min RAM : " + Utility.findMin(DB2RAM));
				System.out.println("Max C-D : " + Utility.findMax(DB2CDrive)+ " ::: "+"Min C-D : " + Utility.findMin(DB2CDrive));
				System.out.println("*****************************************************************************************************");
			
//			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return healthRepLS;
	}
}

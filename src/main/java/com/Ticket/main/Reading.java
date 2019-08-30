package com.Ticket.main;

import java.util.List;

import com.Ticket.FileFormat.ITIL;
import com.Ticket.utils.DBConnect;
import com.Ticket.utils.XlsReader;

public class Reading {
	
	public static void main(String args[]) {
//		Reading from XLSX file
		List<ITIL> ITILList = XlsReader.getRequestListFromExcel();
		System.out.println(ITILList);
		
//		insertTo DB
//		DBConnect.insertQueryPS(ITILList);
		
//		Printing to JSON
		String ITILJson= DBConnect.listToJson(ITILList);
		System.out.println(ITILJson); 
	}
}
package com.downurl.ltdownload.utils;

public class testexcel {

	public static void main(String[] args) {
		String filepath = "E:\\1234.xlsx";
		try {
			ExcelTools.readExcelWithTitle2(filepath);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

}

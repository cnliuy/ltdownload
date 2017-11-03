package com.downurl.ltdownload.utils;

public class testexcel {

	public static void main(String[] args) {
		String filepath = "E:\\1234.xlsx";
		//E:\OdriveFiles\OneDrive\CU2017\联通TV\客服系统\数据\prm2\113
		filepath = "E:\\OdriveFiles\\OneDrive\\CU2017\\联通TV\\客服系统\\数据\\prm2\\113\\1.xlsx";
		try {
			ExcelTools.readExcelWithTitle2(filepath);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

}

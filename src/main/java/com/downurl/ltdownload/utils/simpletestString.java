package com.downurl.ltdownload.utils;

import java.math.BigDecimal;
 

public class simpletestString {
	
	public static void main(String[] args) {
//		String  value = "abc@123)VALUES (1231";
//		//value = "abc#123";
//		int i = value.indexOf(")VALUES (");
//		if(i>0){
//			//有字符串  依据正则表达式切分
//			String a[] = value.split("\\)VALUES \\("); 			
//			System.out.println(a[0]);
//			System.out.println(a[1]);
//		}else{
//			//-1
//			System.out.println("没有@这个字符串");
//		}
		
		String retotal = "9999.99";
		BigDecimal num = new BigDecimal(20000);
		BigDecimal retotalnum = new BigDecimal(retotal);
		System.out.println(retotal);
		if ((retotalnum.compareTo(num) == -1)){
	    	System.out.println(111111);
		}
		
	}
	

}

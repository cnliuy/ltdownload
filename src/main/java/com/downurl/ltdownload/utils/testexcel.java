package com.downurl.ltdownload.utils;

import java.io.IOException;
import java.util.ArrayList;

public class testexcel {

	public static void main(String[] args) {
		
		ArrayList<String> list ;
		String filepath = "E:\\1234.xlsx";
		int[] intArray = {1,3,5,7,8,9,13};  //
		int[] intArray2 = {1,3,5,7,8,9,12};  //
		int[] intArray3 = {2,3,5,6,7,8,9};  //
		
//		//E:\OdriveFiles\OneDrive\CU2017\联通TV\客服系统\数据\prm2\113
//		filepath = "E:\\OdriveFiles\\OneDrive\\CU2017\\联通TV\\客服系统\\数据\\prm2\\113\\1.xlsx";
//		try {
//			ExcelTools.readExcelWithTitle2(filepath);
//			
//		} catch (Exception e) {			
//			e.printStackTrace();
//		}
		
//		filepath = "E:\\OdriveFiles\\OneDrive\\CU2017\\联通TV\\客服系统\\数据\\prm2\\2\\2.xlsx";
//		try {
//			ExcelTools.readExcelWithTitle2(filepath);
//			
//		} catch (Exception e) {			
//			e.printStackTrace();
//		}
		
		//E:\OdriveFiles\OneDrive\CU2017\联通TV\客服系统\数据\prm2\113
		
	

		
//		filepath = "E:\\OdriveFiles\\OneDrive\\CU2017\\联通TV\\客服系统\\数据\\prm2\\2\\2.xlsx";
//		try {
//			list  = ExcelTools.readExcelWithTitle_nomal(filepath, intArray2); 
//			for(int i=0; i<list.size(); i++)    {   
//			     String a = list.get(i);   
//			     System.out.println(a);
//			}  
//			
//			
//		} catch (Exception e) {			
//			e.printStackTrace();
//		}
		
//		filepath = "E:\\OdriveFiles\\OneDrive\\CU2017\\联通TV\\客服系统\\数据\\prm2\\3\\4.xls";
//		try {
//			//ExcelTools.readExcelWithTitle2(filepath);
//			list  = ExcelTools.readExcelWithTitle_nomal(filepath, intArray3); 
//			for(int i=0; i<list.size(); i++){   
//			     String a = list.get(i);   
//			     System.out.println(a);
//			}  
//			
//		} catch (Exception e) {			
//			e.printStackTrace();
//		}
		
		/**
		 * ---------------------------------------------------
		 *   上面为分别打印到 system.out中
		 *   
		 *   下面代码为 凑成一个大list后 ，打印到一个文件中
		 * 
		 * ---------------------------------------------------
		 * */
		
		
		filepath = "E:\\OdriveFiles\\OneDrive\\CU2017\\联通TV\\客服系统\\数据\\prm2\\113\\1.xlsx";
		ArrayList<String> listtotxt = new ArrayList<String>();
		try {			
			listtotxt  = ExcelTools.readExcelWithTitle_nomal(filepath, intArray); 
			for(int i=0; i<listtotxt.size(); i++)    {   
			     String a = listtotxt.get(i);   
			     System.out.println(a);
			} 			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		filepath = "E:\\OdriveFiles\\OneDrive\\CU2017\\联通TV\\客服系统\\数据\\prm2\\2\\2.xlsx";
		ArrayList<String> listtotxt2 = new ArrayList<String>();;
		try {			
			listtotxt2  = ExcelTools.readExcelWithTitle_nomal(filepath, intArray2); 
			for(int i=0; i<listtotxt2.size(); i++)    {   
			     String a = listtotxt2.get(i);   
			     System.out.println(a);
			} 			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		filepath = "E:\\OdriveFiles\\OneDrive\\CU2017\\联通TV\\客服系统\\数据\\prm2\\3\\4.xls";
		ArrayList<String> listtotxt3 = new ArrayList<String>();
		try {			
			listtotxt3  = ExcelTools.readExcelWithTitle_nomal(filepath, intArray3); 
			for(int i=0; i<listtotxt3.size(); i++)    {   
			     String a = listtotxt3.get(i);   
			     System.out.println(a);
			} 			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		listtotxt.addAll(listtotxt2);
		listtotxt.addAll(listtotxt3);
		
		ArrayList<String> listtotxtall = listtotxt;
		//生成带序号的内容
		ArrayList<String> newlisttotxtall  = new ArrayList<String>();
		
		for(int allline=0; allline<listtotxtall.size(); allline++)    {  
			
			 String newlinstr="";
			 
		     String linstr= listtotxtall.get(allline);  
		     
		     /**
		      * 每行内容类似  下面
		      * INSERT INTO public.cus_application_list(application_name,product_id,service_name,product_name,
		      *                         product_code,cp, expenses_type)VALUES 
		      *                       ('赛车总动员3：极速挑战','sfsczdy3jstz','IPTV增值全国华数按次业务','IPTV增值全国华数按次5元产品',
		      *                       '2400016200','华数','5元/次',);
		      * 
		      * 提取 )VALUES ( 特征
		      *                       (
		      * */
		     

     		String splitstr =")VALUES ("; 
     		
     		int i = linstr.indexOf(splitstr);
     		if(i>0){
     			//有字符串   依据正则表达式切分
     			String a[] = linstr.split("\\)VALUES \\("); 
     			newlinstr = a[0]+splitstr+allline+","+a[1];    
     			newlisttotxtall.add(newlinstr);
     			//System.out.println(a[0]);
     			//System.out.println(a[1]);
     		}else{
     			//-1
     			//System.out.println("没有@这个字符串");
     		}  
		    System.out.println(newlinstr);
		} 			
		
		//写到txt文件中
		try {
			ForFile.writeFileContinu_Chixu(newlisttotxtall);
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}

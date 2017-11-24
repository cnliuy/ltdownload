package com.downurl.ltdownload.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

public class ExcelTools {
	
	/** 
	 * 参考 http://blog.csdn.net/augus6/article/details/51463478
	 *  java读写excel（POI，支持xls和xlsx两种格式）
	 * 
	 * 
	 * 适用于第一行是标题行的excel，例如 
	 * 姓名   年龄  性别  身高 
	 * 张三   25  男   175 
	 * 李四   22  女   160 
	 * 每一行构成一个map，key值是列标题，value是列值。没有值的单元格其value值为null 
	 * 返回结果最外层的list对应一个excel文件，第二层的list对应一个sheet页，第三层的map对应sheet页中的一行 
	 * @throws Exception  
	 */  
	public static List<List<Map<String, String>>> readExcelWithTitle(String filepath) throws Exception{  
	    String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());  
	    InputStream is = null;  
	    Workbook wb = null;  
	    try {  
	        is = new FileInputStream(filepath);  
	          
	        if (fileType.equals("xls")) {  
	            wb = new HSSFWorkbook(is);  
	        } else if (fileType.equals("xlsx")) {  
	            wb = new XSSFWorkbook(is);  
	        } else {  
	            throw new Exception("读取的不是excel文件");  
	        }  
	          
	        List<List<Map<String, String>>> result = new ArrayList<List<Map<String,String>>>();//对应excel文件  
	          
	        int sheetSize = wb.getNumberOfSheets();  
	        for (int i = 0; i < sheetSize; i++) {//遍历sheet页  
	            Sheet sheet = wb.getSheetAt(i);  
	            List<Map<String, String>> sheetList = new ArrayList<Map<String, String>>();//对应sheet页  
	              
	            List<String> titles = new ArrayList<String>();//放置所有的标题  
	              
	            int rowSize = sheet.getLastRowNum() + 1;  
	            for (int j = 0; j < rowSize; j++) {//遍历行  
	                Row row = sheet.getRow(j);  
	                if (row == null) {//略过空行  
	                    continue;  
	                }  
	                int cellSize = row.getLastCellNum();//行中有多少个单元格，也就是有多少列  
	                if (j == 0) {//第一行是标题行  
	                    for (int k = 0; k < cellSize; k++) {  
	                        Cell cell = row.getCell(k);  
	                        titles.add(cell.toString());  
	                    }  
	                } else {//其他行是数据行  
	                    Map<String, String> rowMap = new HashMap<String, String>();//对应一个数据行  
	                    for (int k = 0; k < titles.size(); k++) {  
	                        Cell cell = row.getCell(k);  
	                        String key = titles.get(k);  
	                        String value = null;  
	                        if (cell != null) {  
	                            value = cell.toString();  
	                            System.out.print(value+",");
	                        }  
	                        rowMap.put(key, value);  
	                    }  
	                    sheetList.add(rowMap);  
	                }  
	            }  
	            System.out.println();
	            result.add(sheetList);  
	        }  
	          
	        return result;  
	    } catch (FileNotFoundException e) {  
	        throw e;  
	    } finally {  
	        if (wb != null) {  
	            wb.close();  
	        }  
	        if (is != null) {  
	            is.close();  
	        }  
	    }  
	}  
	
	
	
	/** 
	 * 调整
	 * 
	 * be using 实际使用的
	 * @throws Exception  
	 */  
	public static void readExcelWithTitle2(String filepath) throws Exception{  
	    String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());  
	    InputStream is = null;  
	    Workbook wb = null;  
	    try {  
	        is = new FileInputStream(filepath);  
	          
	        if (fileType.equals("xls")) {  
	            wb = new HSSFWorkbook(is);  
	        } else if (fileType.equals("xlsx")) {  
	            wb = new XSSFWorkbook(is);  
	        } else {  
	            throw new Exception("读取的不是excel文件");  
	        }  
	          
	        
	          
	        int sheetSize = wb.getNumberOfSheets();         
	        Sheet sheet = wb.getSheetAt(0);  
	        List<Map<String, String>> sheetList = new ArrayList<Map<String, String>>();//对应sheet页  
	              
	        List<String> titles = new ArrayList<String>();//放置所有的标题  
	              
	        int rowSize = sheet.getLastRowNum() + 1;  
	        System.out.println("总行数："+rowSize);
	        for (int j = 0; j < rowSize; j++) {//遍历行  
	            Row row = sheet.getRow(j);  
	            if (row == null) {//略过空行  
	                   continue;  
	            }  
                int cellSize = row.getLastCellNum();//行中有多少个单元格，也就是有多少列  
                if (j == 0) {//第一行是标题行  
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        titles.add(cell.toString());  
                    }  
                } else {//其他行是数据行  
                    Map<String, String> rowMap = new HashMap<String, String>();//对应一个数据行  
                    String  linestr ="";
                    //for (int k = 0; k < titles.size(); k++) {  
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        //String key = titles.get(k);  
                        String value = null;  
                        if (cell != null) {  
                            value = cell.toString();  
                            /**
                             * 将列转为 文本形式后，避免 科学计数(如 2.423000E7等)的读取方式。
                             * 可以读取处实际的数字 ，如 24000203 
                             * 目前见到的最简单的方法：
                             * HSSFCell cell = row.getCell(0);
                             * if(cell.getCellType == HSSFCell.CELL_TYPE_NUMERIC){
                             *     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                             *     String cellValue = cell.toString();
                             * }
                             * */
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            value = cell.getStringCellValue();
                            linestr =linestr+value+",";
                            //System.out.print(value+",");
                        }  
                        //rowMap.put(key, value);  
                    }  
                    //sheetList.add(rowMap);  
                    System.out.println(linestr);
                }  
            }  
            
           
       

        
	    
	    } catch (FileNotFoundException e) {  
	        throw e;  
	    } finally {  
	        if (wb != null) {  
	            wb.close();  
	        }  
	        if (is != null) {  
	            is.close();  
	        }  
	    }  
	}  
	
	
	/** 
	 * 调整3 new
	 * 
	 * intArray 列的数组，从0列开始计数,被选中的列,如传入 {2.3} 为 excel的 第3和第4列的内容
	 * 
	 * be using 实际使用的
	 * @throws Exception  
	 */  
	public static ArrayList<String> readExcelWithTitle_nomal(String filepath , int[] intArray) throws Exception{  
		ArrayList<String> list = new ArrayList<String>();
	    String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());  
	    InputStream is = null;  
	    Workbook wb = null;  
	    try {  
	        is = new FileInputStream(filepath);  
	          
	        if (fileType.equals("xls")) {  
	            wb = new HSSFWorkbook(is);  
	        } else if (fileType.equals("xlsx")) {  
	            wb = new XSSFWorkbook(is);  
	        } else {  
	            throw new Exception("读取的不是excel文件");  
	        }          
	        
	          
	        int sheetSize = wb.getNumberOfSheets();         
	        Sheet sheet = wb.getSheetAt(0);  
	        List<Map<String, String>> sheetList = new ArrayList<Map<String, String>>();//对应sheet页  
	              
	        List<String> titles = new ArrayList<String>();//放置所有的标题  
	              
	        int rowSize = sheet.getLastRowNum() + 1;  
	        System.out.println("总行数："+rowSize);
	        for (int j = 0; j < rowSize; j++) {//遍历行  
	            Row row = sheet.getRow(j);  
	            if (row == null) {//略过空行  
	                   continue;  
	            }  
                int cellSize = row.getLastCellNum();//行中有多少个单元格，也就是有多少列  
                if (j == 0) {//第一行是标题行  
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        titles.add(cell.toString());  
                    }  
                }else{//其他行是数据行  
                	
                    Map<String, String> rowMap = new HashMap<String, String>();//对应一个数据行  
                    String  linestr ="";
                    //for (int k = 0; k < titles.size(); k++) {  
                    //k是列 
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        //String key = titles.get(k);  
                        String value = null;  
                        if (cell != null) {  
                            value = cell.toString();  
                            /**
                             * 将列转为 文本形式后，避免 科学计数(如 2.423000E7等)的读取方式。
                             * 可以读取处实际的数字 ，如 24000203 
                             * 目前见到的最简单的方法：
                             * HSSFCell cell = row.getCell(0);
                             * if(cell.getCellType == HSSFCell.CELL_TYPE_NUMERIC){
                             *     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                             *     String cellValue = cell.toString();
                             * }
                             * */
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            value = cell.getStringCellValue();
                            
                            for(int intA = 0; intA < intArray.length; intA++){  
                            	if(intArray[intA] == k){
                            		
                            		
                            		//value = "abc#123";
                            		int i = value.indexOf("@");
                            		if(i>0){
                            			//有字符串
                            			String a[] = value.split("@"); 	
                            			value= a[0];
                            			//System.out.println(a[0]);
                            			//System.out.println(a[1]);
                            		}else{
                            			//-1
                            			//System.out.println("没有@这个字符串");
                            		}  
                            		
                            		linestr =linestr+"\'"+value+"\',";
                            	}
                            }                        
                            
                            //System.out.print(value+",");
                        }  
                        //rowMap.put(key, value);  
                    }  
                    //sheetList.add(rowMap);  
                    //System.out.println(linestr);
                    String strline = "INSERT INTO public.cus_application_list(application_name,product_id,service_name,product_name,product_code,cp, expenses_type)VALUES ("+linestr+");";
                    list.add(strline);
                }  
            }         
	    
	    } catch (FileNotFoundException e) {  
	        throw e;  
	    } finally {  
	        if (wb != null) {  
	            wb.close();  
	        }  
	        if (is != null) {  
	            is.close();  
	        }  
	    } 
	    
	    return list;
	}  
	
	

}

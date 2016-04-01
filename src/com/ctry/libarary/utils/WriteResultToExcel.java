package com.ctry.libarary.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteResultToExcel {
	
	static String path;
	public static void writeResult(String...args){
		path = "E:/Users/Administrator/workspace/Ctry/testResult/TestResults.xlsx";
		
		
		try{

		File f1 = new File(path);
        InputStream in=new FileInputStream(f1);
		XSSFWorkbook wb = new XSSFWorkbook(in);
		Sheet sheet =wb.getSheet(args[0]);
		Row header = sheet.createRow(Integer.parseInt(args[1]));
		for(int i=0;i<args.length-1;i++){
		Cell cell = header.createCell(i,Integer.parseInt(args[1]));
		cell.setCellValue(args[i+1]);
//		System.out.println("+++++++++++"+args[i+1]);
		}
	    OutputStream stream = new FileOutputStream(f1);
	    wb.write(stream);
	    in.close();
        stream.close();
		wb.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}

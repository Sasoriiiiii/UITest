package com.ctry.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ctry.libarary.utils.DriverFactory;
import com.ctry.libarary.utils.UITest;
import com.ctry.libarary.utils.WriteResultToExcel;

public class TestDriver extends UITest{			
//		WebDriver dr=DriverFactory.getChromeDriver();
//		try{
//		dr.get("http://192.168.0.51/portal");
//		dr.findElement(By.name("loginName")).sendKeys("21010844");
//		dr.findElement(By.name("loginPwd")).sendKeys("123456");
//		dr.findElement(By.id("loginBtn")).click();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		String testid="2";
		String testname="TestDriver";
		String testresult="failed";
		String description="";
		
		@Before
	    public void init(){
			
		}	
		@Test
		public void loginByDrivers(){
		try{
		WebDriver dr=DriverFactory.getIEDriver();
		
		dr.get("http://192.168.0.51/portal");
		dr.findElement(By.name("loginName")).sendKeys("21010844");
		dr.findElement(By.name("loginPwd")).sendKeys("123456");
		dr.findElement(By.id("loginBtn")).click();
		
		WriteResultToExcel.writeResult(testid,testname,testresult,description);
		
		}catch(Exception e){
			e.printStackTrace();
			WriteResultToExcel.writeResult(testid,testname,testresult,e.toString());
		}
	}		
		@After
		public void stop(){
			
		}
}
	


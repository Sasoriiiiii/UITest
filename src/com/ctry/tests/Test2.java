package com.ctry.tests;

import org.testng.annotations.Test;

import com.ctry.libarary.utils.DriverFactory;
import com.ctry.libarary.utils.UITest;
import com.ctry.libarary.utils.WriteResultToExcel;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test2 extends UITest{
	
//	WebDriver dr=DriverFactory.getChromeDriver();
//	try{
//	dr.get("http://192.168.0.51/portal");
//	dr.findElement(By.name("loginName")).sendKeys("21010844");
//	dr.findElement(By.name("loginPwd")).sendKeys("123456");
//	dr.findElement(By.id("loginBtn")).click();
//	}catch(Exception e){
//		e.printStackTrace();
//	}
	String testid="2";
	String testname="Test2";
	String testresult="failed";
	String description="";
	String sheetname="chiweisong";
	
  @Test
    public void loginByDrivers(){
		try{
		WebDriver dr=DriverFactory.getIEDriver();
		super.init(dr);
		dr.get("http://192.168.0.51/portal");
		dr.findElement(By.name("loginName")).sendKeys("21010844");
		dr.findElement(By.name("loginPwd")).sendKeys("123456");
		dr.findElement(By.id("loginBtn")).click();
		boolean b=dr.findElement(By.linkText("[ ÍË ³ö ]"))!=null;//ÅÐ¶ÏÊÇ·ñµÇÂ½³É¹¦
		if(b){
			testresult="success";
			}else{
				description="µÇÂ½Ê§°Ü";
			}
		WriteResultToExcel.writeResult(testid,testname,testresult,description,sheetname);
		super.stop();
		Assert.assertTrue(b, description);
		}catch(Exception e){
			e.printStackTrace();
			WriteResultToExcel.writeResult(testid,testname,testresult,e.toString(),sheetname);
			super.stop();
			Assert.assertTrue(false, "Òì³£");
		}
	}		
  @BeforeTest
    public void init(){
		
	}
  @AfterTest
	public void stop(){
		
	}

}

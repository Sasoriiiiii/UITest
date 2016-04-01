package com.ctry.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ctry.libarary.utils.UITest;
import com.ctry.libarary.utils.WriteResultToExcel;
import com.ctry.libarary.actions.CommonLogin;


public class Test1Login extends UITest{
	
	WebDriver driver=new FirefoxDriver();
	String testid="1";
	String testname="Test1Login";
	String testresult="failed";
	String description="";
	@Before
	public void init()
	{
		super.init(driver);
		CommonLogin.setDriver(driver);
	}
	@Test
	public void loginByUerName() throws Exception
	{
		try{
		    CommonLogin.login();
			if(driver.findElement(By.linkText("[ ÍË ³ö ]"))!=null){
				testresult="success";
				}
				WriteResultToExcel.writeResult(testid,testname,testresult,description);
			
		}catch(Exception e){
			WriteResultToExcel.writeResult(testid,testname,testresult,e.toString());
		}
		//System.out.println(testresult);
	}

	@After
	public void stop() {
		super.stop();
	}

}

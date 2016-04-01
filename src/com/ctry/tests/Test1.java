package com.ctry.tests;



import com.ctry.libarary.actions.CommonLogin;
import com.ctry.libarary.utils.TestngRetry;
import com.ctry.libarary.utils.UITest;
import com.ctry.libarary.utils.WriteResultToExcel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Test1 extends UITest{
	
	String testid="1";
	String testname="Test1";
	String testresult="failed";
	String description="";
	String sheetname="chiweisong";
	
	
  @Test(retryAnalyzer = TestngRetry.class)
  public void loginByUerName()
	{
		try{
			WebDriver driver=new FirefoxDriver();
			super.init(driver);
			CommonLogin.setDriver(driver);
		    CommonLogin.login("21010852","123456");
		    boolean b=driver.findElement(By.linkText("[ ÍË ³ö ]"))!=null;//ÅÐ¶ÏÊÇ·ñµÇÂ½³É¹¦
//		    boolean b=false;                                          //Ê§°Ü
//		    boolean b=driver.findElement(By.linkText("[ 123 ]"))!=null;//Òì³£
			if(b){
				testresult="success";
				}else{
					description="µÇÂ½Ê§°Ü";
				}
				WriteResultToExcel.writeResult(testid,testname,testresult,description,sheetname);
				super.stop();
				Assert.assertTrue(b, description);
				
		}catch(Exception e){
			WriteResultToExcel.writeResult(testid,testname,testresult,e.toString(),sheetname);
			super.stop();
			Assert.assertTrue(false, "Òì³£");
		}
		//System.out.println(testresult);
	}
  @BeforeTest
  public void init() {

//	  System.out.println("++++++++");
  }

  @AfterTest
  public void stop() {
		
  }


}

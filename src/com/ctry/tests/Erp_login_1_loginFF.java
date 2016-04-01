package com.ctry.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ctry.libarary.actions.CommonLogin;
import com.ctry.libarary.utils.UITest;
import com.ctry.libarary.utils.WriteResultToExcel;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.tests.Erp_login_1_loginFF.java
 * @ClassName:    Erp_login_1_loginFF
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��3�� ����4:41:12
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��3�� ����4:41:12 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class Erp_login_1_loginFF extends UITest {
	
	String sheetname="Erp_login";
	String testid="1";
	String testname="Erp_login_1_loginFF";
	String testresult="failed";
	String description="";
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("MM-dd HH:mm");
	String time=format.format(date);
  @Test
  public void loginByFireFox() {
	  try{
	    WebDriver driver=new FirefoxDriver();
		super.init(driver);
		CommonLogin.setDriver(driver);
	    CommonLogin.login("21010852","123456");
	    boolean b=driver.findElement(By.linkText("[ �� �� ]"))!=null;
	    if(b){
			testresult="success";
			}else{
				description="��½ʧ��";
			}
			WriteResultToExcel.writeResult(sheetname,testid,testname,testresult,description,time);
			super.stop();
			Reporter.log("����"+testname+"ͨ��");
			Assert.assertTrue(b, description);
			
	  }catch(Exception e){
			WriteResultToExcel.writeResult(sheetname,testid,testname,testresult,"�쳣",time);
			super.stop();
			Reporter.log(e.toString());
			Assert.assertTrue(false, "�쳣");
		  
	  }
  }
  
  @BeforeTest
  public void init() {

  }

  @AfterTest
  public void stop() {
		
  }
}

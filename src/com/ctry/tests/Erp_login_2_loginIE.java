package com.ctry.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ctry.libarary.utils.DriverFactory;
import com.ctry.libarary.utils.UITest;
import com.ctry.libarary.utils.WriteResultToExcel;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.tests.Erp_login_2_loginIE.java
 * @ClassName:    Erp_login_2_loginIE
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��3�� ����4:44:58
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��3�� ����4:44:58 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class Erp_login_2_loginIE extends UITest{
	
	String sheetname="Erp_login";
	String testid="2";
	String testname="Erp_login_2_loginFF";
	String testresult="failed";
	String description="";
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("MM-dd HH:mm");
	String time=format.format(date);
	
  @Test
    public void loginByDrivers(){
		try{
		WebDriver dr=DriverFactory.getIEDriver();
		super.init(dr);
		dr.get("http://192.168.0.51/portal");
		dr.findElement(By.name("loginName")).sendKeys("21010844");
		dr.findElement(By.name("loginPwd")).sendKeys("123456");
		dr.findElement(By.id("loginBtn")).click();
		boolean b=dr.findElement(By.linkText("[ �� �� ]"))!=null;//�ж��Ƿ��½�ɹ�
		if(b){
			testresult="success";
			}else{
				description="��½ʧ��";
			}
		WriteResultToExcel.writeResult(sheetname,testid,testname,testresult,description,time);
		super.stop();
		Assert.assertTrue(b, description);
		}catch(Exception e){
			e.printStackTrace();
			WriteResultToExcel.writeResult(sheetname,testid,testname,testresult,"�쳣",time);
			super.stop();
			Reporter.log(e.toString());
			Assert.assertTrue(false, "�쳣");
		}
	}		
  @BeforeTest
    public void init(){
		
	}
  @AfterTest
	public void stop(){
		
	}

}

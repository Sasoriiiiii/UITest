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
import com.ctry.libarary.actions.SwitchMenu;
import com.ctry.libarary.utils.DriverFactory;
import com.ctry.libarary.utils.UITest;
import com.ctry.libarary.utils.WriteResultToExcel;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.tests.Erp_dish_3_switchDC.java
 * @ClassName:    Erp_dish_3_switchDC
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��3�� ����4:08:41
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��3�� ����4:08:41 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class Erp_dish_3_switchDC extends UITest{
	
	String sheetname="Erp_dish";
	String testid="3";
	String testname="Erp_dish_3_switchDC";
	String testresult="failed";
	String description="";
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("MM-dd HH:mm");
	String time=format.format(date);
  @Test
  public void swichDishCategory() {
	  try{
	    WebDriver driver=DriverFactory.getChromeDriver();
		super.init(driver);
		CommonLogin.setDriver(driver);
	    CommonLogin.login("http://www.smartpos.top/portal/","61011437","123456");
	    SwitchMenu.setDriver(driver);
	    SwitchMenu.swichDishCategory();
	    /***
	     * ҳ���б��ⲿ���ǲ�Ʒ-��Ʒ���࣬��Ϊ����ͨ��������ʧ��
	     */
	    boolean b1=driver.findElement(By.xpath("//h3[@class='rel ovf  js_header']/span[1]")).getText().equals("��Ʒ");
	    boolean b2=driver.findElement(By.xpath("//h3[@class='rel ovf  js_header']/span[2]")).getText().equals("��Ʒ����");
	    boolean b=b1&&b2;
	    System.out.println(b);
	    if(b){
			testresult="success";
			}else{
				description="ʧ��";
			}
			WriteResultToExcel.writeResult(sheetname,testid,testname,testresult,description,time);
			super.stop();
			Assert.assertTrue(b, description);
			
	  }catch(Exception swichDishCategoryFailed){
			WriteResultToExcel.writeResult(sheetname,testid,testname,testresult,"�쳣",time);
			swichDishCategoryFailed.printStackTrace();
			super.stop();
			Reporter.log(swichDishCategoryFailed.toString());
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

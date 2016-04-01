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
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月3日 下午4:08:41
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月3日 下午4:08:41 
 * @UpdateRemark: 说明本次修改内容  
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
	     * 页面中标题部分是菜品-菜品分类，认为测试通过，否则失败
	     */
	    boolean b1=driver.findElement(By.xpath("//h3[@class='rel ovf  js_header']/span[1]")).getText().equals("菜品");
	    boolean b2=driver.findElement(By.xpath("//h3[@class='rel ovf  js_header']/span[2]")).getText().equals("菜品分类");
	    boolean b=b1&&b2;
	    System.out.println(b);
	    if(b){
			testresult="success";
			}else{
				description="失败";
			}
			WriteResultToExcel.writeResult(sheetname,testid,testname,testresult,description,time);
			super.stop();
			Assert.assertTrue(b, description);
			
	  }catch(Exception swichDishCategoryFailed){
			WriteResultToExcel.writeResult(sheetname,testid,testname,testresult,"异常",time);
			swichDishCategoryFailed.printStackTrace();
			super.stop();
			Reporter.log(swichDishCategoryFailed.toString());
			Assert.assertTrue(false, "异常");
		  
	  }
  }
  
  @BeforeTest
  public void init() {

  }

  @AfterTest
  public void stop() {
	
  }
}

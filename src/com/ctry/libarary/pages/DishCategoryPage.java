package com.ctry.libarary.pages;
import org.openqa.selenium.WebDriver;
import com.ctry.libarary.utils.BasePage;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.libarary.pages.DishCategoryPage.java
 * @ClassName:    DishCategoryPage
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月15日 上午9:49:20
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月15日 上午9:49:20 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class DishCategoryPage extends BasePage {
	
	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public DishCategoryPage(WebDriver driver) throws Exception {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
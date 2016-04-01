package com.ctry.libarary.pages;
import org.openqa.selenium.WebDriver;
import com.ctry.libarary.utils.BasePage;
import com.ctry.libarary.utils.Locator;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.libarary.pages.NavigationTreePage.java
 * @ClassName:    NavigationTreePage
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��15�� ����9:49:03
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��15�� ����9:49:03 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class NavigationTreePage extends BasePage{
	
	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public NavigationTreePage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	Locator dishButton=new Locator("dishButton");
	Locator dishCategoryButton=new Locator("dishCategoryButton");
	
	public void clickOnDishButton() throws Exception {
		click(dishButton);
	}
	public void clickOnDishCategoryButton() throws Exception {
		click(dishCategoryButton);
	}


}

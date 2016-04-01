package com.ctry.libarary.actions;
import org.openqa.selenium.By;
/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.libarary.actions.SwitchMenu.java
 * @ClassName:    SwitchMenu
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��3�� ����3:51:42
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��3�� ����3:51:42 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
import org.openqa.selenium.WebDriver;
import com.ctry.libarary.pages.NavigationTreePage;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.libarary.actions.SwitchMenu.java
 * @ClassName:    SwitchMenu
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��15�� ����9:50:17
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��15�� ����9:50:17 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class SwitchMenu {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	static NavigationTreePage NavigationTreePage;

	public static void swichDishCategory() throws Exception {
		NavigationTreePage = new NavigationTreePage(getDriver());
		NavigationTreePage.clickOnDishButton();
		NavigationTreePage.clickOnDishCategoryButton();
		driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
//        return (LoginPage) PageFactory.getPage(LoginPage.class, getDriver());

    }


	public static void setDriver(WebDriver driver) {
		SwitchMenu.driver = driver;
	}

}

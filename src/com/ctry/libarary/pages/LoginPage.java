package com.ctry.libarary.pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.ctry.libarary.utils.BasePage;
import com.ctry.libarary.utils.Locator;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.libarary.pages.LoginPage.java
 * @ClassName:    LoginPage
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��15�� ����9:48:21
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��15�� ����9:48:21 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class LoginPage extends BasePage{
	
	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage(WebDriver driver,String url) throws Exception {
		super(driver);	
		driver.get(url);
	}
	
	//Locator logoSmartpos = new Locator("logoSmartpos");
	Locator loginNameInputBox = new Locator("loginNameInputBox");              //�û��������
	Locator loginPasswordInputBox = new Locator("loginPasswordInputBox");      //���������
	Locator loginButton = new Locator("loginButton");                          //��½��ť

	/**
	 * @param name
	 * @throws Exception
	 * @Description:���û���������������û���
	 */
	public void typeNameInputBox(String name) throws Exception {
		type(loginNameInputBox, name);
	}

	public void typePasswordInputBox(String password) throws Exception {
		type(loginPasswordInputBox, password);
	}

	public void clickOnLoginButton() throws Exception {
		click(loginButton);
	}

	public void waitForPageLoad() {
		super.getDriver().manage().timeouts()
				.pageLoadTimeout(30, TimeUnit.SECONDS);
	}


}


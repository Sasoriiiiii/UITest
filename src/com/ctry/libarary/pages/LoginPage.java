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
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月15日 上午9:48:21
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月15日 上午9:48:21 
 * @UpdateRemark: 说明本次修改内容  
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
	Locator loginNameInputBox = new Locator("loginNameInputBox");              //用户名输入框
	Locator loginPasswordInputBox = new Locator("loginPasswordInputBox");      //密码输入框
	Locator loginButton = new Locator("loginButton");                          //登陆按钮

	/**
	 * @param name
	 * @throws Exception
	 * @Description:向用户名输入框中输入用户名
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


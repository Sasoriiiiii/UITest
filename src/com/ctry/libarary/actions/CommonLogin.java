package com.ctry.libarary.actions;
import org.openqa.selenium.WebDriver;
import com.ctry.libarary.pages.LoginPage;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  Ctry
 * @Package:      com.ctry.libarary.actions.CommonLogin.java
 * @ClassName:    CommonLogin
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月15日 上午9:50:01
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月15日 上午9:50:01 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class CommonLogin {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	static LoginPage loginPage;

	/**
	 * @param url
	 * @param name
	 * @param password
	 * @throws Exception
	 * @Description:
	 */
	public static void login(String url,String name,String password) throws Exception{
		
        loginPage = new LoginPage(getDriver(),url);
        loginPage.waitForPageLoad();
        loginPage.typeNameInputBox(name);
        loginPage.typePasswordInputBox(password);
        loginPage.clickOnLoginButton();
//        return (LoginPage) PageFactory.getPage(LoginPage.class, getDriver());
	}
	
	/**
	 * @param name
	 * @param password
	 * @throws Exception
	 */
	public static void login(String name, String password)
            throws Exception {
		String url="http://192.168.0.51/portal";
		CommonLogin.login(url, name,password);
    }
	
	/**
	 * @throws Exception
	 */
	public static void login() throws Exception {
		CommonLogin.login("21010829", "123456");
	}

	public static void setDriver(WebDriver driver) {
		CommonLogin.driver = driver;
	}
}


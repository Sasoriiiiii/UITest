package com.ctry.libarary.utils;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctry.libarary.utils.Locator.ByType;
import com.ctry.libarary.utils.Locator;

public class BasePage {

	protected WebDriver driver;
    // protected String[][] locatorMap;
    HashMap<String, Locator> locatorMap;
    String path = "E:/Users/Administrator/workspace/Ctry/testElement/UILibrary.xml";
//    protected Log log = new Log(this.getClass());

	protected BasePage(WebDriver driver) throws Exception {
		this.driver = driver;
//        log.debug(this.getClass().getCanonicalName());
        // locatorMap = ReadExcelUtil.getLocatorMap();
        locatorMap = XmlUtils.readXMLDocument(path,this.getClass().getCanonicalName());
	}

	protected void type(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		e.sendKeys(values);
	}

	protected void click(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		e.click();
	}
    protected void select(Locator locator, String value) throws Exception {
        WebElement e = findElement(driver, locator);
        Select select = new Select(e);

        try {
//            log.info("select by Value " + value);
            select.selectByValue(value);
        } catch (Exception notByValue) {
//            log.info("select by VisibleText " + value);
            select.selectByVisibleText(value);
        }
    }

    protected void alertConfirm() {
        Alert alert = driver.switchTo().alert();
        try {
            alert.accept();
        } catch (Exception notFindAlert) {
            throw notFindAlert;
        }
    }

    protected void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        try {
            alert.dismiss();
        } catch (Exception notFindAlert) {
            throw notFindAlert;
        }
    }

    protected String getAlertText() {
        Alert alert = driver.switchTo().alert();
        try {
            return alert.getText();
        } catch (Exception notFindAlert) {
            throw notFindAlert;
        }
    }
	protected void clickAndHold(Locator locator) throws IOException {
		WebElement e = findElement(driver, locator);
		Actions actions = new Actions(driver);
		actions.clickAndHold(e).perform();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(Locator locator) throws IOException {
		return getElement(this.getDriver(), locator);
	}

	/**
	 * get by parameter
	 * 
	 * @author Young
	 * @param driver
	 * @param locator
	 * @return
	 * @throws IOException
	 */
	public WebElement getElement(WebDriver driver, Locator locator)throws IOException {
		locator= getLocator(locator.getElement());
		WebElement e;
			switch (locator.getBy()) {
		
			case xpath:
				e = driver.findElement(By.xpath(locator.getElement()));
				break;
			case id:
				e = driver.findElement(By.id(locator.getElement()));
				break;
			case name:
				e = driver.findElement(By.name(locator.getElement()));
				break;
			case cssSelector:
				e = driver.findElement(By.cssSelector(locator.getElement()));
				break;
			case className:
				e = driver.findElement(By.className(locator.getElement()));
				break;
			case tagName:
				e = driver.findElement(By.tagName(locator.getElement()));
				break;
			case linkText:
				e = driver.findElement(By.linkText(locator.getElement()));
				break;
			case partialLinkText:
				e = driver.findElement(By.partialLinkText(locator.getElement()));
				break;
			default:
				e = driver.findElement(By.id(locator.getElement()));
			}
	
		return e;
	
	}

	public boolean isElementPresent(WebDriver driver, Locator myLocator,
			int timeOut) throws IOException {
		final Locator locator = getLocator(myLocator.getElement());
		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		isPresent = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return findElement(d, locator);
			}
		}).isDisplayed();
		return isPresent;
	}

	/**
	 * This Method for check isPresent Locator
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 * @throws IOException
	 */
	public boolean isElementPresent(Locator locator, int timeOut)
			throws IOException {
		return isElementPresent(driver,locator, timeOut);
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement findElement(WebDriver driver, final Locator locator) {
		WebElement element = (new WebDriverWait(driver, locator.getWaitSec()))
				.until(new ExpectedCondition<WebElement>() {

					@Override
					public WebElement apply(WebDriver driver) {
						try {
							return getElement(driver, locator);
						} catch (IOException e) {
							return null;
						}

					}

				});
		return element;

	}


	public Locator getLocator(String locatorName) throws IOException {

//		for (int i = 0; i < locatorMap.length; i++) {
//			if (locatorMap[i][0].endsWith(locatorName)) {
//
//				locator.setElementname(locatorMap[i][1]);
//
//				break;
//			}
//		}
		Locator locator;
        locator = locatorMap.get(locatorName);
        if (locator == null) {
            locator = new Locator(locatorName);
        }
		return locator;

	}
	
}

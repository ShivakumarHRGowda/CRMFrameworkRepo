package com.comcast.crm.generic.webdriverutility;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	//implicitly wait
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	//Explicitly wait
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//switch to new browser tab
	public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			String windowID=it.next();
			driver.switchTo().window(windowID);
			
			String actURL=driver.getTitle();
			if(actURL.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	//switch to frame
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//switch to alert
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	//dropDown actions
	public void select(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void select(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	
	//Action -mouseOverActions
	public void mouseMoveOnElement(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
}

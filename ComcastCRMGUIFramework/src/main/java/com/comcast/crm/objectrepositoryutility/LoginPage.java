package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

//Rule-1 : POM class creation
public class LoginPage extends WebDriverUtility {
    WebDriver driver;
    
  //Rule-2: Object Identification
    @FindBy(name="user_name")
    private WebElement usernameEdt;
    
    @FindBy(name="user_password")
    private WebElement passwordEdt;
    
    @FindBy(id="submitButton")
    private WebElement loginBtn;

    //Rule-3: Object Initialization
    
    public LoginPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    //Rule-4:Object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
    
	//Rule-5:Object Utilization
    public void loginToApp(String url,String username,String password) {
    	waitForPageLoad(driver);
    	driver.get(url);
    	usernameEdt.sendKeys(username);
    	passwordEdt.sendKeys(password);
    	loginBtn.click();
    }

}

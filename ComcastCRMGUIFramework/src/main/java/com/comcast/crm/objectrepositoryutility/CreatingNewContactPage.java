package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility{

	WebDriver driver;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContBtn;
	
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateContBtn() {
		return createContBtn;
	}
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	WebElement lookWPBtn;
	
	@FindBy(id="search_txt")
	WebElement searchEdt;
	
	@FindBy(name="search")
	WebElement searchBtn;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	WebElement saveBtn;
	
	@FindBy(id="mouseArea_Organization Name")
	WebElement verifyOrgName;
	
	public void createContachOrg() {
		lookWPBtn.click();
		switchToTabOnTitle(driver, "module=Accounts");
	}
	
	
	
}

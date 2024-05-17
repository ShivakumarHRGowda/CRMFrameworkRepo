package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility{
	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();

	@FindBy(name ="accountname")
	private WebElement accountanameEdt;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	@FindBy(name="industry")
	private WebElement industryEdt;
	
	@FindBy(name="accounttype")
	private WebElement typeEdt;
	
	@FindBy(id="phone")
	private WebElement phoneEdt;
	
	@FindBy(className = "detailedViewTextBox")
	private WebElement orgVerifyTxt;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement verifyIndustry;
	
	@FindBy(id="mouseArea_Type")
	private WebElement verifyType;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement verifyPhone;
	
	@FindBy(xpath = "//img[@title='Search in Organizations...']")
	private WebElement searchBtn;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="search_field")
	private WebElement searchField;
	
	@FindBy(xpath = "//input[@name='submit' and @type='button']")
	private WebElement submitBtn;

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getOrgVerifyTxt() {
		return orgVerifyTxt;
	}

	public WebElement getIndustryEdt() {
		return industryEdt;
	}

	public WebElement getTypeEdt() {
		return typeEdt;
	}

	
	public WebElement getAccountanameEdt() {
		return accountanameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getVerifyIndustry() {
		return verifyIndustry;
	}


	public WebElement getVerifyType() {
		return verifyType;
	}
	
	public WebElement getVerifyPhone() {
		return verifyPhone;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}


	public WebElement getSearchField() {
		return searchField;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public void createNewOrg(String orgName) {
		accountanameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createNewOrg(String orgName,String industry,String type) {
		accountanameEdt.sendKeys(orgName);
		wLib.select(industryEdt, industry);
		wLib.select(typeEdt, type);
		saveBtn.click();
	} 
	
	public void createNewOrg(String orgName,String phoneNum) {
		accountanameEdt.sendKeys(orgName);
		phoneEdt.sendKeys(phoneNum);
		saveBtn.click();
	} 
	
	public void searchText(String orgName) throws InterruptedException {
		searchTextEdt.sendKeys(orgName);;
		Thread.sleep(3000);
		wLib.select(searchField, "Organization Name");
		submitBtn.click();
		
	}
	
	public void deleteOrg(String orgName) {
		  driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		    switchToAlertAndAccept(driver);
		    
	}
	
}

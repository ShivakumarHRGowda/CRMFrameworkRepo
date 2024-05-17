package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility{
	WebDriver driver;
	
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement endDateEdt;
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement verifyLastname;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement verifyStartDate;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement verifyEndDate;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getVerifyLastname() {
		return verifyLastname;
	}

	public WebElement getVerifyStartDate() {
		return verifyStartDate;
	}

	public WebElement getVerifyEndDate() {
		return verifyEndDate;
	}
	
	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContact(String lastName,String startDate,String endDate) {
		lastNameEdt.sendKeys(lastName);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);	
		saveBtn.click();
	}
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	WebElement clickPlusBtn;
	
	@FindBy(id="search_txt")
	WebElement searchTxt;
	
	@FindBy(name="search_field")
	WebElement searchSelect;
	
	@FindBy(name="search")
	WebElement searchBtn;

	@FindBy(id="mouseArea_Organization Name")
    WebElement	verifyOrgName;
	
	public WebElement getClickPlusBtn() {
		return clickPlusBtn;
	}

	public void setClickPlusBtn(WebElement clickPlusBtn) {
		this.clickPlusBtn = clickPlusBtn;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public void setSearchTxt(WebElement searchTxt) {
		this.searchTxt = searchTxt;
	}

	public WebElement getSearchSelect() {
		return searchSelect;
	}

	public void setSearchSelect(WebElement searchSelect) {
		this.searchSelect = searchSelect;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}

	public WebElement getVerifyOrgName() {
		return verifyOrgName;
	}

	public void createContactwithOrg(String orgName,String lastName) throws InterruptedException {
		clickPlusBtn.click();
		switchToTabOnTitle(driver, "module=Accounts");
		searchTxt.sendKeys(orgName);
		//select(searchSelect, "accountname");
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	    switchToTabOnTitle(driver, "module=Contacts");
	    lastNameEdt.sendKeys(lastName);
	    saveBtn.click();
	}
}

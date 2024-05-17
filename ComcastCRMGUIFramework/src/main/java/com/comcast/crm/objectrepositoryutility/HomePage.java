package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
    WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(xpath =  "(//a[text()='Contacts'])[1]")
	private WebElement contactLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logOutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singoutLink;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getLogOutImg() {
		return logOutImg;
	}

	public WebElement getSingoutLink() {
		return singoutLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public void createCampaign() {
		wLib.mouseMoveOnElement(driver,moreLink);
		campaignsLink.click();
	}
	
	public void singOut() {
		wLib.mouseMoveOnElement(driver, logOutImg);
		singoutLink.click();
	}
	
}

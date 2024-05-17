package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement craeteProductImgBtn;

	public WebElement getCraeteProductImgBtn() {
		return craeteProductImgBtn;
	}

}

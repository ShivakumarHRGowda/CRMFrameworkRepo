package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOraganizationsPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;

public class CreateOrganizationTest extends BaseClass {
	@Test //(groups = "smoketest")
	public void createOrganizationTest() throws Throwable {
		// reading test script data from excel & generate the random number
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// step-2:navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step-3:click on "Create organization" Button
		CreatingNewOraganizationsPage op = new CreatingNewOraganizationsPage(driver);
		op.getCreateneworgBtn().click();

		// step-4:enter all the details & create new Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.createNewOrg(orgName);

		// verify Header OrgName info Expected result
		String accOrgName = oip.getOrgVerifyTxt().getText();
		boolean status= accOrgName.contains(orgName);
		 Assert.assertEquals(status, true);

	}

	@Test //(groups = "regressiontest")
	public void createOrganizationWithIndustriesTest() throws Throwable {
		// reading test script data from excel
		String orgName = eLib.getDataFromExcel("org", 5, 2) + jLib.getRandomNumber();
		String industries = eLib.getDataFromExcel("org", 5, 3);
		String type = eLib.getDataFromExcel("org", 5, 4);

		System.out.println(orgName + " " + industries + " " + type);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		CreatingNewOraganizationsPage cop = new CreatingNewOraganizationsPage(driver);
		cop.getCreateneworgBtn().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.createNewOrg(orgName, industries, type);

		// verify Header Industry info Expected Result
		String actualIndustrie = oip.getVerifyIndustry().getText();
        boolean statusIndustries=actualIndustrie.contains(industries);
		Assert.assertEquals(statusIndustries, true);

		String actualType = oip.getVerifyType().getText();
		boolean statusType=actualType.contains(type);
		Assert.assertEquals(statusType, true);
	}

	@Test //(groups = "regressiontest")
	public void createOrganizationWithPhoneNumTest() throws Throwable {
		// reading test script data from excel
		String orgName = eLib.getDataFromExcel("org", 9, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 9, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		CreatingNewOraganizationsPage cop = new CreatingNewOraganizationsPage(driver);
		cop.getCreateneworgBtn().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.createNewOrg(orgName, phoneNumber);

		// verify Header phoneNumber info Expected Result
		String actualPhoneNum = oip.getVerifyPhone().getText();
		if (actualPhoneNum.contains(phoneNumber)) {
			UtilityClassObject.getTest().log(Status.PASS,phoneNumber + " information is Created==PASS");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL,phoneNumber + " information is Created==FAIL");
		}
	}
}

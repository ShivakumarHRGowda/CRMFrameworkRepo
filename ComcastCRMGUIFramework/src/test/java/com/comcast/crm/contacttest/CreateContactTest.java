package com.comcast.crm.contacttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOraganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImplClass.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = "smoketest")
	public void createContactTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from exel");
		// reading test script data from excel
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.getCreateContBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.createContact(lastName);

		 //verify Header phoneNumber info Expected Result
		String actualLatName = cip.getVerifyLastname().getText();
		Assert.assertEquals(true, actualLatName.contains(lastName));
//		if (actualLatName.contains(lastName)) {
//			UtilityClassObject.getTest().log(Status.PASS,lastName + "information is Created==PASS");
//		} else {
//			UtilityClassObject.getTest().log(Status.FAIL,lastName +" information is not Created==FAIL");
//		}
	}

	@Test //(groups = "regressiontest")
	public void createContactWithDataFormatTest() throws Throwable {
		// reading test script data from excel
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver); 
		hp.getContactLink().click();

		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.getCreateContBtn().click();

		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYMMDD(30);
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.createContact(lastName, startDate, endDate);

		// verify Header phoneNumber info Expected Result
//		String actualLatName = cip.getVerifyLastname().getText();
//		if (actualLatName.contains(lastName)) {
//			test.log(Status.PASS,lastName + " information is Created==PASS");
//		} else {
//			test.log(Status.FAIL,lastName + " information is not Created==FAIL");
//		}
//
//		String actualStartDate = cip.getVerifyStartDate().getText();
//		if (actualStartDate.contains(startDate)) {
//			test.log(Status.PASS,startDate + " information is Created==PASS");
//		} else {
//			test.log(Status.FAIL,startDate + " information is not Created==FAIL");
//		}
//
//		String actualEndDate = cip.getVerifyEndDate().getText();
//		if (actualEndDate.contains(endDate)) {
//			test.log(Status.PASS,endDate + " information is Created==PASS");
//		} else {
//			test.log(Status.FAIL,endDate + " information is not Created==FAIL");
//		}
	}

	@Test //(groups = "regressiontest")
	public void createContactWithOrg() throws Throwable {
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("contact", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		CreatingNewOraganizationsPage op = new CreatingNewOraganizationsPage(driver);
		op.getCreateneworgBtn().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.createNewOrg(orgName);

		//String accOrgName = oip.getOrgVerifyTxt().getText();
//		if (accOrgName.contains(orgName)) {
//			test.log(Status.PASS,orgName + " name is Verified == PASS");
//		} else {
//			test.log(Status.FAIL,orgName + " name is not Verified == Fail");
//		}
        Thread.sleep(3000);
		hp.getContactLink().click();
    
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.getCreateContBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.createContactwithOrg(orgName, lastName);

		String actorgName = cip.getVerifyOrgName().getText();
//		if (actorgName.contains(orgName)) {
//			test.log(Status.PASS,orgName + " orgname is verified ===PASS");
//		} else {
//			test.log(Status.FAIL,orgName + " orgNAme is not verified ===FAIL");
//		}

	}
}

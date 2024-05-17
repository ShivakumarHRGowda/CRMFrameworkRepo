package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOraganizationsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;

public class DeleteOrgTest extends BaseClass{
	
	@Test
	public void deleteOrgTest() throws Throwable {
		
		// reading test script data from excel & generate the random number
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		
        //step-2:navigate to Organization module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		 //step-3:click on "Create organization" Button
		CreatingNewOraganizationsPage op=new CreatingNewOraganizationsPage(driver);
		op.getCreateneworgBtn().click();
		
		 //step-4:enter all the details & create new Organization
		   OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		   oip.createNewOrg(orgName);
		   
		 //verify Header OrgName info Expected result
		     String accOrgName=oip.getOrgVerifyTxt().getText();
		     if(accOrgName.contains(orgName)) {
		    	 System.out.println(orgName+" name is Verified == PASS");
		     }else{
		    	 System.out.println(orgName+" name is not Verified == Fail");
		     }
		     
		//go back to organization page
		     hp.getOrgLink().click();
		     
		//search for organization
		    oip.searchText(orgName);
		  
		 oip.deleteOrg(orgName);  
		   
	}
}

package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class Invoice1Test extends BaseClass {
	@Test //(retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListImpClass.class)
	public void createInvoiceTest1() {
		//String expTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		System.out.println("execute createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}

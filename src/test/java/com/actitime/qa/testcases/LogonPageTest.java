package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.util.TestUtil;

public class LogonPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	String sheetName = "Users";
	TestUtil testUtil;
	
	
	
	public LogonPageTest() {
		super();
	}
	
	
	@BeforeClass
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	
	@Test(priority = 1)
	public void loginPageLogoTest() {
		
	boolean flag= loginPage.validateActiTimeLogo();
	Assert.assertTrue(flag);
		
	}
	
	
	@DataProvider
	public Object[][] getactiTimeTestData() {
		Object data[][]=testUtil.getTestData(sheetName);
		
		return data;
		
		
		
	}
	@Test(priority = 2,dataProvider="getactiTimeTestData")
	public void loginTest(String userName, String password) {
		
		homePage = loginPage.loging(userName, password);
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}

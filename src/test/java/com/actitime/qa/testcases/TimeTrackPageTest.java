package com.actitime.qa.testcases;

import com.actitime.qa.pages.TimeTrackPage;
import com.actitime.qa.util.TestUtil;
import org.testng.annotations.*;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;

public class TimeTrackPageTest extends TestBase{

    LoginPage loginPage;
    HomePage homePage;
    TimeTrackPage timeTrackPage;
    String sheetName = "Employees";
    TestUtil testUtil;

    public TimeTrackPageTest() {
        super();

    }

    @BeforeClass
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        timeTrackPage=homePage.clickOnApproveTimeTrackLink();

    }

    @DataProvider
    public Object[][] getactiTimeTestData() {
        Object data[][]=testUtil.getTestData(sheetName);

        return data;


    }

    @Test(priority = 1,dataProvider="getactiTimeTestData")
    public void approveTimeTrackTest(String empName) {
        timeTrackPage.tickOnReadyForApprovalChkBox(empName);
        timeTrackPage.clickOnApproveButton();

    }

    @Test(priority = 2,dataProvider="getactiTimeTestData")
    public void revokeTimeTrackTest(String empName) {
        timeTrackPage.clickOnRevoke(empName);
    }


    @AfterClass
    public void tearDown() {

        driver.quit();
    }


}

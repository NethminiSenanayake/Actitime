package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ReportsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class ReportsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ReportsPage reportsPage;
    public ReportsPageTest() {
        super();

    }

    @BeforeClass
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        reportsPage=homePage.clickOnReportsLink();

    }

    @Test(priority = 1)
    public void reportsPageTitleTest() {

        String actualTitle= reportsPage.validateReportsPageTitle();
        Assert.assertEquals(actualTitle,"Reports Dashboard");

    }

    @Test(priority = 2)
    public void viewPastMonthsReportTest() {
        reportsPage.clickOnPastMonthsLeavesReport();
        reportsPage.validateReportName();

    }
    @Test(priority = 3)
    public void closePastMonthsReportTest() {

        reportsPage.clickOnCloseReport();

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

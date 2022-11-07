package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.actitime.qa.util.TestUtil;

public class UserPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;

    String sheetName = "Employees";
    TestUtil testUtil;

    public UserPageTest() {
        super();

    }

    @BeforeClass
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        usersPage=homePage.clickOnUsers();

    }

    @Test(priority = 1)
    public void reviewLeavesTest(){
        usersPage.clickOnSickDaysSettings();

    }

    @DataProvider
    public Object[][] getactiTimeTestData() {
        Object data[][]=testUtil.getTestData(sheetName);
        return data;

    }

    @Test(priority = 2,dataProvider="getactiTimeTestData")
    public void verifyControlOffTest(String employeeName) {

        usersPage.clickOnControlON(employeeName);
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

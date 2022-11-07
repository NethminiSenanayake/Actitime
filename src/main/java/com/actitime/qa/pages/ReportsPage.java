package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReportsPage extends TestBase  {

    @FindBy(xpath= "//td[@class='pagetitle']")
    WebElement reportsPageTitle;

    @FindBy(id = "reportConfig_119")
    WebElement pastMonthsLeavesBox;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/div[2]/div[@class='reportName']")
    WebElement reportName;

    @FindBy(id = "createChartLightbox_cancelBtn")
    WebElement closeBtn;


    public ReportsPage() {

        PageFactory.initElements(driver, this);
    }

    public String validateReportsPageTitle() {

        return reportsPageTitle.getText();
    }

    public ReportsPage clickOnPastMonthsLeavesReport() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", pastMonthsLeavesBox);
        pastMonthsLeavesBox.click();
        return this;

    }

    public Boolean validateReportName() {
        return reportName.isDisplayed();

    }

    public ReportsPage clickOnCloseReport() {
        closeBtn.click();
        return this;

    }
	
}

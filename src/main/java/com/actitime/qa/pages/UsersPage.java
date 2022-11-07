package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestBase  {
    @FindBy(xpath = "//div[@id='userListTabs']/div[1]/div[3]/div[1]")
    WebElement sickDaysSettings;

    public UsersPage() {

        PageFactory.initElements(driver, this);
    }

    public UsersPage clickOnSickDaysSettings() {
        sickDaysSettings.click();
        return this;

    }

    public UsersPage clickOnControlON(String userName) {
        WebElement controlToggle=driver.findElement(By.xpath("//span[contains(text(),'"+userName+"')]/../../../../../../../../td[25]/div[1]"));
        controlToggle.click();
        return this;

    }

}

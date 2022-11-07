package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrackPage extends TestBase {

        @FindBy(xpath= "//td[text()='Approve Time-Track']")
        WebElement approveTimeTrackTitle;

        @FindBy(id = "approveButton")
        WebElement approveButton;

        public TimeTrackPage() {

            PageFactory.initElements(driver, this);
        }

        public String validateReportsPageTitle() {

            return approveTimeTrackTitle.getText();
        }

        public TimeTrackPage tickOnReadyForApprovalChkBox(String empName) {
            WebElement readyForApprovalChkBox=driver.findElement(By.xpath("//div[contains(text(),'"+empName+"')]/../../../../tr[3]/td[7]/input"));
            readyForApprovalChkBox.click();
            return this;

        }
        public TimeTrackPage clickOnApproveButton() {
            approveButton.click();
            return this;

        }

        public TimeTrackPage clickOnRevoke(String empName) {
            for(int i=0; i<=2;i++){
                try{
                    WebElement revokeTimeTrack=driver.findElement(By.xpath("//div[contains(text(),'"+empName+"')]/../../../../tr[3]/td[6]/a[contains(text(),'revoke')]"));
                    revokeTimeTrack.click();
                    break;
                }
                catch(Exception e){
                    e.getMessage();
                }
            }
            return this;

        }



    }




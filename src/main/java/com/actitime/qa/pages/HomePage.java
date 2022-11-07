package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;


public class HomePage extends TestBase {

	//Page Factory - Object Repository
	
		@FindBy(xpath = "//a[@class='content tasks']")
		WebElement taskLink;
		
		@FindBy(xpath = "//a[@class='content reports']")
		WebElement reportsLink;
		
		@FindBy(xpath = "//div[@id='logo_aT']")
		WebElement actitimeLogo;

		@FindBy(linkText = "Approve Time-Track")
		WebElement approveTimeTrackLink;

		@FindBy(id = "container_users")
		WebElement usersLink;

		
		//initialization
		
		public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
		
		
		//Action/Methods
		
		public Boolean validateActiTimeLogo() {
			return actitimeLogo.isDisplayed();
		}
		
		
        public ReportsPage clickOnReportsLink() {
	         reportsLink.click();
	         return new ReportsPage();
			
		}

		public TimeTrackPage clickOnApproveTimeTrackLink() {
		approveTimeTrackLink.click();
		return new TimeTrackPage();

	}
		public UsersPage clickOnUsers() {
		usersLink.click();
		return new UsersPage();

	}

}
	


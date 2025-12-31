package org.learn.vendorPortalPages;

import org.learn.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPageElements extends AbstractBasePage {

    protected DashboardPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "monthly-earning")
    protected WebElement monthlyEarnings;

    @FindBy(id = "annual-earning")
    protected WebElement annualEarnings;

    @FindBy(id = "profit-margin")
    protected WebElement profitMargin;

    @FindBy(id = "available-inventory")
    protected WebElement availableInventory;

    @FindBy(css = "input[type=Search]")
    protected WebElement searchTextBox;

    @FindBy(id = "dataTable_info")
    protected WebElement searchResultsCount;

    @FindBy(css = "img.img-profile.rounded-circle")
    protected WebElement profileImage;

    @FindBy(xpath = "//a[@data-target='#logoutModal']")
    protected WebElement dropdownLogout;

    @FindBy(xpath = "//a[text()='Logout']")
    protected WebElement secessionLogout;

    @Override
    protected boolean isAt() {
        return wait.until(ExpectedConditions.visibilityOf(monthlyEarnings)).isDisplayed();
    }

    protected boolean searchTextBox() {
        return wait.until(ExpectedConditions.visibilityOf(searchTextBox)).isDisplayed();
    }

    protected boolean secessionLogoutButton() {
        return wait.until(ExpectedConditions.visibilityOf(secessionLogout)).isDisplayed();
    }
}

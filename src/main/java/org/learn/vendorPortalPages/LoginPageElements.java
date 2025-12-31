package org.learn.vendorPortalPages;

import org.learn.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageElements extends AbstractBasePage {

    protected LoginPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    protected WebElement userNameTextBox;

    @FindBy(id = "password")
    protected WebElement passwordTextBox;

    @FindBy(id = "login")
    protected WebElement loginButton;

    @Override
    protected boolean isAt() {
        return wait.until(ExpectedConditions.visibilityOf(userNameTextBox)).isDisplayed();
    }
}

package org.learn.flightReservationPages;

import org.learn.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPageElements extends AbstractBasePage {

    //APP1: https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html
    //APP2: https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html

    public RegistrationPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    protected WebElement firstName;

    @FindBy(id = "lastName")
    protected WebElement lastName;

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(name = "street")
    protected WebElement street;

    @FindBy(name = "city")
    protected WebElement city;

    @FindBy(id = "inputState")
    protected WebElement state;

    @FindBy(name = "zip")
    protected WebElement zip;

    @FindBy(id = "register-btn")
    protected WebElement registerButton;

    @Override
    protected boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.firstName)).isDisplayed();
    }
}

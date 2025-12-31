package org.learn.flightReservationPages;

import org.learn.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPageElements extends AbstractBasePage {

    public ConfirmationPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "go-to-flights-search")
    protected WebElement flightSearchButton;

    @FindBy(css = "#registration-confirmation-section p b")
    protected WebElement firstNameElement;

    @Override
    protected boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.flightSearchButton)).isDisplayed();
    }
}

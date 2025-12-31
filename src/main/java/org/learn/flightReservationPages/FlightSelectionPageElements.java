package org.learn.flightReservationPages;

import org.learn.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightSelectionPageElements extends AbstractBasePage {

    protected FlightSelectionPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='card-header' and contains(text(), 'Departure')]")
    protected WebElement departureHeader;

    @FindBy(xpath = "//div[@class='card-header' and contains(text(), 'Arrival')]")
    protected WebElement arrivalHeader;

    @FindBy(id = "confirm-flights")
    protected WebElement confirmButton;

    @Override
    protected boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.departureHeader)).isDisplayed();
    }
}

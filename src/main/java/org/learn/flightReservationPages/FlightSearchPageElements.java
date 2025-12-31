package org.learn.flightReservationPages;

import org.learn.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightSearchPageElements extends AbstractBasePage {

    protected FlightSearchPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "passengers")
    protected WebElement selectNumberOfPassengers;

    @FindBy(id = "search-flights")
    protected WebElement searchFlightButton;

    @Override
    protected boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.selectNumberOfPassengers)).isDisplayed();
    }
}

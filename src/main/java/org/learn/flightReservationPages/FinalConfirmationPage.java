package org.learn.flightReservationPages;

import org.learn.base.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalConfirmationPage extends AbstractBasePage {

    protected static final Logger logger = LoggerFactory.getLogger(FinalConfirmationPage.class);

    protected FinalConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.card-body > div:nth-child(1) > div:nth-child(2) > p")
    protected WebElement flightConfirmation;

    @FindBy(css = "div.card-body > div:nth-child(2) > div:nth-child(2) > p")
    protected WebElement tax;

    @FindBy(css = "div.card-body > div:nth-child(3) > div:nth-child(2) > p")
    protected WebElement totalPrice;

    @Override
    protected boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmation)).isDisplayed();
    }
}

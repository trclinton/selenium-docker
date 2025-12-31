package org.learn.flightReservationActions;

import org.learn.flightReservationPages.FinalConfirmationPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalConfirmationActions extends FinalConfirmationPage {

    private static final Logger logger = LoggerFactory.getLogger(FinalConfirmationActions.class);

    public FinalConfirmationActions(WebDriver driver) {
        super(driver);
    }

    public boolean waitForThisElementLoad(){
        return this.isAt();
    }

    public void getConfirmationNumber(){
        logger.info("Flight Confirmation # {}", this.flightConfirmation.getText());
    }

    public String getTax(){
        logger.info("Tax: {}", this.tax.getText());
        return this.tax.getText();
    }

    public String getPrice(){
        logger.info("Total Price: {}", this.totalPrice.getText());
        return this.totalPrice.getText();
    }
}

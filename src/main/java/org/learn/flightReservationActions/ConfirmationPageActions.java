package org.learn.flightReservationActions;

import org.learn.flightReservationPages.ConfirmationPageElements;
import org.openqa.selenium.WebDriver;

public class ConfirmationPageActions extends ConfirmationPageElements {

    public ConfirmationPageActions(WebDriver driver){
        super(driver);
    }

    public boolean waitForThisElementLoad(){
        return this.isAt();
    }

    public void clickOnFlightSearchButton(){
        this.flightSearchButton.click();
    }

    public String getFirstName(){
        return this.firstNameElement.getText();
    }
}

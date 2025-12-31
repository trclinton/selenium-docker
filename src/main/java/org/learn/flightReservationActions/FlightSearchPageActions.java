package org.learn.flightReservationActions;

import org.learn.flightReservationPages.FlightSearchPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPageActions extends FlightSearchPageElements {

    public FlightSearchPageActions(WebDriver driver) {
        super(driver);
    }

    public boolean waitForThisElementLoad(){
        return this.isAt();
    }

    public void SelectNumberOfPassengers(String numberOfPassengers){
        Select select = new Select(this.selectNumberOfPassengers);
        select.selectByValue(numberOfPassengers);
    }

    public void FlightSearchButton(){
        this.searchFlightButton.click();
    }
}

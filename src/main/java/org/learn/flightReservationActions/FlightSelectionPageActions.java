package org.learn.flightReservationActions;

import org.learn.flightReservationPages.FlightSelectionPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSelectionPageActions extends FlightSelectionPageElements {

    public FlightSelectionPageActions(WebDriver driver) {
        super(driver);
    }

    public boolean waitForThisElementLoad(){
        return this.isAt();
    }

    public void departureIN(String flight, String class_type){
        String lowerFlight = flight.toLowerCase();
        String lowerClass = class_type.toLowerCase();
        this.departureHeader.findElement(By.xpath("./following-sibling::div//tbody//input[@id='dep-"+lowerFlight+"-"+lowerClass+"']")).click();
    }

    public void ArrivalIN(String flight, String class_type){
        String lowerClass = class_type.toLowerCase();
        this.arrivalHeader.findElement(By.xpath("./following-sibling::div//tbody//th[text()='"+flight+"']/following-sibling::td/input[contains(@id, '"+lowerClass+"')]")).click();
    }

    public void confirmButonClick(){
        this.confirmButton.click();
    }
}

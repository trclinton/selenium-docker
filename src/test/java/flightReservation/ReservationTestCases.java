package flightReservation;

import baseTest.AbstractTest;
import org.learn.flightReservationActions.*;
import org.learn.utilities.Config;
import org.learn.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import vendorPortalTestCases.VendorPortalTestCases;

public class ReservationTestCases extends AbstractTest {

    @Test
    public void customerRegistrationTest(){
        registrationPage.goTo(Config.get(Constants.RESERVATION_URL));
        Assert.assertTrue(registrationPage.waitForThisElementLoad());
        registrationPage.setFirstName(reservationData.firstName());
        registrationPage.setLastName(reservationData.lastName());
        registrationPage.setEmail(reservationData.email());
        registrationPage.setStreet(reservationData.street());
        registrationPage.setCity(reservationData.city());
        registrationPage.setState(reservationData.state());
        registrationPage.setZip(reservationData.zipCode());
        registrationPage.clickRegisterButton();
    }

    @Test(dependsOnMethods = "customerRegistrationTest")
    public void registrationConfirmationTest(){
        Assert.assertTrue(confirmationPage.waitForThisElementLoad());
        Assert.assertEquals(confirmationPage.getFirstName(), reservationData.firstName());
        confirmationPage.clickOnFlightSearchButton();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest(){
        Assert.assertTrue(flightSearchPage.waitForThisElementLoad());
        flightSearchPage.SelectNumberOfPassengers(reservationData.passengerCount());
        flightSearchPage.FlightSearchButton();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void selectFlightsTest(){
        Assert.assertTrue(flightSelectionPage.waitForThisElementLoad());
        flightSelectionPage.departureIN("Qatar", "First");
        flightSelectionPage.ArrivalIN("British Airways", "Business");
        flightSelectionPage.confirmButonClick();
    }

    @Test(dependsOnMethods = "selectFlightsTest")
    public void flightsConfirmationTest(){
        Assert.assertTrue(finalConfirmation.waitForThisElementLoad());
        finalConfirmation.getConfirmationNumber();
        String actualTax = finalConfirmation.getTax();
        String actualPrice = finalConfirmation.getPrice();
        Assert.assertEquals(actualTax, "$89 USD");
        Assert.assertEquals(actualPrice, reservationData.expectedPrice());
    }
}
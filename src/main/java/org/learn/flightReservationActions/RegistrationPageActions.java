package org.learn.flightReservationActions;

import org.learn.flightReservationPages.RegistrationPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageActions extends RegistrationPageElements {

    public RegistrationPageActions(WebDriver driver){
        super(driver);
    }

    public void goTo(String url){
        driver.get(url);
    }

    public boolean waitForThisElementLoad(){
        return this.isAt();
    }

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setStreet(String street) {
        this.street.sendKeys(street);
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setState(String state) {
        Select dropdown = new Select(this.state);
        dropdown.selectByVisibleText(state);
    }

    public void setZip(String zip) {
        this.zip.sendKeys(zip);
    }

    public void clickRegisterButton() {
        this.registerButton.click();
    }
}

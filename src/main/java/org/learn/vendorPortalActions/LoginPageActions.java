package org.learn.vendorPortalActions;

import org.learn.vendorPortalPages.LoginPageElements;
import org.openqa.selenium.WebDriver;

public class LoginPageActions extends LoginPageElements {
    public LoginPageActions(WebDriver driver) {
        super(driver);
    }

    public void goTo(String url){
        driver.get(url);
    }

    public boolean waitForUserNameTextBox(){
        return this.isAt();
    }

    public void setUserName(String userName){
        userNameTextBox.sendKeys(userName);
    }

    public void setPassword(String password){
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}

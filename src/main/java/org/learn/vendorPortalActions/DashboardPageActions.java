package org.learn.vendorPortalActions;

import org.learn.vendorPortalPages.DashboardPageElements;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPageActions extends DashboardPageElements {

    public static final Logger logger = LoggerFactory.getLogger(DashboardPageActions.class);

    public DashboardPageActions(WebDriver driver) {
        super(driver);
    }

    public boolean waitForMonthlyEarnings(){
        return this.isAt();
    }

    public String getMonthlyEarnings(){
        return monthlyEarnings.getText();
    }

    public String getAnnualEarnings(){
        return annualEarnings.getText();
    }

    public String getProfitMargin(){
        return profitMargin.getText();
    }

    public int getAvailableInventory(){
        return Integer.parseInt(availableInventory.getText());
    }

    public void searchText(String text) {
        boolean flag = searchTextBox();
        if (flag)
            searchTextBox.sendKeys(text);
        else
            logger.info("Unable to find: Search Textbox");
    }

    public int searchResultCount(){
        String showingText = searchResultsCount.getText();
        String onlyNum = showingText.replaceAll("\\D+", " ");
        String[] numbers = onlyNum.split(" ");
        return Integer.parseInt(String.valueOf(numbers[2]));
    }

    public void clickOnProfileImage(){
        profileImage.click();
    }

    public void clickOnDropdownLogout(){
        dropdownLogout.click();
    }

    public void clickOnSecessionLogout(){
        boolean flag = secessionLogoutButton();
        if (flag)
            secessionLogout.click();
        else
            logger.info("Unable to find: Secession Logout Button");
    }
}

package vendorPortalTestCases;

import baseTest.AbstractTest;
import com.aventstack.extentreports.Status;
import listners.ExtentTestNGListener;
import org.learn.utilities.Config;
import org.learn.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendorPortalTestCases extends AbstractTest {

    public static Logger logger = LoggerFactory.getLogger(VendorPortalTestCases.class);

    @Test
    public void loginIntoApplicationTest() {
        loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
        ExtentTestNGListener.getTest().log(Status.INFO, Constants.VENDOR_PORTAL_URL);
        Assert.assertTrue(loginPage.waitForUserNameTextBox());
        String userName = data.username();
        String password = data.password();
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "loginIntoApplicationTest")
    public void DashboardTest() {
        Assert.assertTrue(dashBoard.waitForMonthlyEarnings());
        String monthlyEarning = dashBoard.getMonthlyEarnings();
        String annualEarning = dashBoard.getAnnualEarnings();
        String profitMargin = dashBoard.getProfitMargin();
        int inventory = dashBoard.getAvailableInventory();
        List<Object> listOfDashboardParameters = Arrays.asList(monthlyEarning, annualEarning, profitMargin, inventory);
        listOfDashboardParameters.forEach(parm -> {
            ExtentTestNGListener.getTest().log(Status.INFO, parm.toString());
            logger.info("Dashboard Parameters: {}", parm);
        });
        List<Object> expectedListOfDashboardParameters = data.dashParm();
        List<Object> sorted1 = new ArrayList<>(listOfDashboardParameters);
        List<Object> sorted2 = new ArrayList<>(expectedListOfDashboardParameters);
        Assert.assertEquals(sorted2, sorted1);
    }

    @Test(dependsOnMethods = "DashboardTest")
    public void CountSearchResultsTest() {
        dashBoard.searchText(data.searchText());
        int actualCount = dashBoard.searchResultCount();
        logger.info("Number of results: {}", actualCount);
        try {
            Assert.assertEquals(actualCount, data.count());
            ExtentTestNGListener.getTest().log(Status.PASS, "Number of results: " + actualCount);
        } catch (Exception e) {
            ExtentTestNGListener.getTest().log(Status.FAIL, actualCount +" is not equal to the expected count "+ data.count());
        }
    }

    @Test(dependsOnMethods = "CountSearchResultsTest")
    public void logout(){
        dashBoard.clickOnProfileImage();
        dashBoard.clickOnDropdownLogout();
        dashBoard.clickOnSecessionLogout();
        Assert.assertTrue(loginPage.waitForUserNameTextBox());
    }
}

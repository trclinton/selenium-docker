package baseTest;

import com.google.common.util.concurrent.Uninterruptibles;
import org.learn.base.DriverManager;
import org.learn.flightReservationActions.*;
import org.learn.utilities.*;
import org.learn.vendorPortalActions.DashboardPageActions;
import org.learn.vendorPortalActions.LoginPageActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import vendorPortalTestCases.VendorPortalTestCases;

import java.time.Duration;

public abstract class AbstractTest {

    public LoginPageActions loginPage;
    public DashboardPageActions dashBoard;
    public DashboardRecord data;
    public ReservationRecord reservationData;
    public RegistrationPageActions registrationPage;
    public ConfirmationPageActions confirmationPage;
    public FlightSearchPageActions flightSearchPage;
    public FlightSelectionPageActions flightSelectionPage;
    public FinalConfirmationActions finalConfirmation;

    @BeforeSuite
    public void setUpConfigs(){
        Config.initilize();
    }

    @BeforeTest
    @Parameters({"dataPath"})
    public void setDriver(String dataPath, ITestContext context) {

        context.setAttribute(Constants.DRIVER, DriverManager.getDriver());

        this.loginPage = new LoginPageActions(DriverManager.getDriver());
        this.dashBoard = new DashboardPageActions(DriverManager.getDriver());

        this.registrationPage = new RegistrationPageActions(DriverManager.getDriver());
        this.confirmationPage = new ConfirmationPageActions(DriverManager.getDriver());
        this.flightSearchPage = new FlightSearchPageActions(DriverManager.getDriver());
        this.flightSelectionPage = new FlightSelectionPageActions(DriverManager.getDriver());
        this.finalConfirmation = new FinalConfirmationActions(DriverManager.getDriver());
        if(dataPath.contains("ReservationData"))
            this.reservationData = jsonReader.readJSON(ReservationRecord.class, dataPath);
        else if (dataPath.contains("VendorPortalData")) {
            this.data= jsonReader.readJSON(DashboardRecord.class, dataPath);
        }
    }

    @AfterTest
    public void tearDown(){
        DriverManager.quitDriver();
    }

    @AfterMethod
    public void slowDown(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
    }
}

package org.learn.base;

import org.learn.utilities.Config;
import org.learn.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DriverManager {

    private DriverManager() {}

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // ----------------------------------------------------------------------
    // PUBLIC: Get driver (local or remote based on system properties)
    // ----------------------------------------------------------------------
    public static WebDriver getDriver() {
        if (tlDriver.get() == null) {
            tlDriver.set(createDriver());
        }
        return tlDriver.get();
    }

    // ----------------------------------------------------------------------
    // DRIVER FACTORY
    // ----------------------------------------------------------------------
    private static WebDriver createDriver() {

        String browser = Config.get(Constants.BROWSER_TYPE);
        String runMode = Config.get(Constants.EXECUTION_TYPE);
        String hubUrl  = Config.get(Constants.HUB_URL);

        return switch (runMode) {
            case "local" -> createLocalDriver(browser);
            case "remote" -> createRemoteDriver(browser, hubUrl);
            default -> throw new IllegalArgumentException("Invalid runMode: " + runMode);
        };
    }

    // ----------------------------------------------------------------------
    // LOCAL DRIVER FACTORY
    // ----------------------------------------------------------------------
    private static WebDriver createLocalDriver(String browser) {
        WebDriver driver;

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();
                driver = new FirefoxDriver(ffOptions);
                driver.manage().window().maximize();
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

    // ----------------------------------------------------------------------
    // REMOTE DRIVER FACTORY (Selenium Grid)
    // ----------------------------------------------------------------------
    private static WebDriver createRemoteDriver(String browser, String hubUrl) {

        if (!hubUrl.endsWith("/")) {
            hubUrl = hubUrl + "/";
        }

        URL url;
        try {
            url = URI.create(hubUrl).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Hub URL: " + hubUrl, e);
        }

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--remote-allow-origins=*");
                return new RemoteWebDriver(url, chromeOptions);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-dev-shm-usage");
                firefoxOptions.addArguments("--no-sandbox");
                return new RemoteWebDriver(url, firefoxOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--no-sandbox");
                return new RemoteWebDriver(url, edgeOptions);

            default:
                throw new IllegalArgumentException("Unsupported browser for remote: " + browser);
        }
    }

    // ----------------------------------------------------------------------
    // QUIT DRIVER (with ThreadLocal cleanup)
    // ----------------------------------------------------------------------
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
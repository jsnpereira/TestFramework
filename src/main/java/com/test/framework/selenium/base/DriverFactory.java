package com.test.framework.selenium.base;

import com.test.framework.selenium.manager.LocalDriverHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory extends Base {
    private static String seleniumGridHub = "http://localhost:4444/wd/hub";
    private static boolean local = true;

    public static void Initialize(BrowserType browserType) throws MalformedURLException {

        switch (browserType) {
            case Chrome: {
                chromeBrowser();
                break;
            }
            case Firefox: {
                firefoxBrowser();
                break;
            }
            case IE: {
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + browserType);
        }
    }


    private static void firefoxBrowser() throws MalformedURLException {
        if (local){
            System.setProperty(
                    "webdriver.gecko.driver",
                    "geckodriver" + getExtesionValue());
            LocalDriverHelper.setDriver(new FirefoxDriver());
        } else {
            //Open the browser
            System.setProperty("webdriver.gecko.driver", "C:\\chromedriver\\geckodriver.exe");
            DesiredCapabilities capabilities = new DesiredCapabilities().firefox();

            RemoteWebDriver driver = new RemoteWebDriver(new URL(seleniumGridHub), capabilities);
            LocalDriverHelper.setDriver(driver);
        }
    }

    private static void chromeBrowser() throws MalformedURLException {
        if (local){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.setCapability(CapabilityType
                    .ForSeleniumServer
                    .ENSURING_CLEAN_SESSION, true);
            System.setProperty("webdriver.chrome.driver","chromedriver" + getExtesionValue());
            LocalDriverHelper.setDriver(new ChromeDriver(options));
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
            capabilities.setCapability("recordVideo", false);
            capabilities.setCapability("build", "1.4.1");
            capabilities.setCapability("idleTimeout", 150);

            RemoteWebDriver  driver = new RemoteWebDriver(new URL(seleniumGridHub), capabilities);
            LocalDriverHelper.setDriver(driver);
        }

    }

    /**
     * @return Get the extension from win or linux
     */
    public static String getExtesionValue() {
        String extension = "";
        String operationalSystem = System.getProperty("os.name").toLowerCase();

        if (operationalSystem.indexOf("win") >= 0) {
            extension = ".exe";
        }
        return extension;
    }




}

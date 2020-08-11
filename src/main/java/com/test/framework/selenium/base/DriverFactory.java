package com.test.framework.selenium.base;

import com.test.framework.selenium.manager.LocalDriverHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory extends Base {
    private static String nodeSelenium = "http://172.19.0.3:4444/wd/hub";
    private static boolean local = false;

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
            firefoxLocal();
        } else {
            firefoxRemote();
        }
    }

    private static void chromeBrowser() throws MalformedURLException {
        if (local){
           chromeLocal();
        } else {
           chromeRemote();
        }
    }

    private static void chromeLocal(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setCapability(CapabilityType
                .ForSeleniumServer
                .ENSURING_CLEAN_SESSION, true);
        System.setProperty("webdriver.chrome.driver","chromedriver" + getExtensionValue());
        LocalDriverHelper.setDriver(new ChromeDriver(options));
    }

    private static void chromeRemote() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        RemoteWebDriver driver = new RemoteWebDriver(new URL(nodeSelenium), chromeOptions);
        LocalDriverHelper.setDriver(driver);
    }

    private static void firefoxLocal(){
        System.setProperty(
                "webdriver.gecko.driver",
                "geckodriver" + getExtensionValue());
        LocalDriverHelper.setDriver(new FirefoxDriver());
    }

    private static void firefoxRemote() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        RemoteWebDriver driver = new RemoteWebDriver(new URL(nodeSelenium), firefoxOptions);
        LocalDriverHelper.setDriver(driver);
    }

    /**
     * @return Get the extension from win or linux
     */
    public static String getExtensionValue() {
        String extension = "";
        String operationalSystem = System.getProperty("os.name").toLowerCase();

        if (operationalSystem.indexOf("win") >= 0) {
            extension = ".exe";
        }
        return extension;
    }
}

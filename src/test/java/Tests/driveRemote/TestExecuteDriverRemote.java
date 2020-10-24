package Tests.driveRemote;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class TestExecuteDriverRemote {
    private static String nodeSelenium = "http://localhost:4444/wd/hub";
    @Test()
    public void test01() throws MalformedURLException, InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL(nodeSelenium), chromeOptions);
        driver.get("http://www.google.com");
        driver.quit();

    }
}

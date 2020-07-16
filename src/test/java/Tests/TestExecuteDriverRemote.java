package Tests;


import Pages.HomePage;
import Pages.SignInPage;
import Pages.SignUpPage;
import com.test.framework.selenium.manager.PageContext;
import com.test.framework.utils.DataUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class TestExecuteDriverRemote {
    private static String nodeSelenium = "http://172.17.0.2:4444/wd/hub";
    @Test()
    public void test01() throws MalformedURLException, InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL(nodeSelenium), chromeOptions);
        driver.get("http://www.google.com");
        Thread.sleep(10000);
        driver.quit();

    }
}

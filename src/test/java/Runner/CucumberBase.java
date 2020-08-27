package Runner;

import com.test.framework.commons.PathUrls;
import com.test.framework.commons.Settings;
import com.test.framework.selenium.base.Base;
import com.test.framework.selenium.base.BrowserType;
import com.test.framework.selenium.base.DriverFactory;
import com.test.framework.selenium.base.DriverHelper;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class CucumberBase extends Base {

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        DriverFactory.Initialize(Settings.browserType);
        DriverHelper.navigation(Settings.baseURL);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        DriverHelper.QuitDriver();
    }
}

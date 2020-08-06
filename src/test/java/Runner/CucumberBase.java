package Runner;

import com.test.framework.commons.PathUrls;
import com.test.framework.selenium.base.Base;
import com.test.framework.selenium.base.BrowserType;
import com.test.framework.selenium.base.DriverFactory;
import com.test.framework.selenium.base.DriverHelper;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class CucumberBase extends Base {

    @BeforeMethod
    @Parameters("browser")
    public void beforeTest(@Optional("Chrome") String browser) throws MalformedURLException {
        DriverFactory.Initialize(BrowserType.Chrome.valueOf(browser));
        DriverHelper.navigation(PathUrls.HOME);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        DriverHelper.QuitDriver();
    }
}

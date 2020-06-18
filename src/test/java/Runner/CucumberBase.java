package Runner;

import com.test.framework.selenium.base.Base;
import com.test.framework.selenium.base.BrowserType;
import com.test.framework.selenium.base.DriverFactory;
import com.test.framework.selenium.base.DriverHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class CucumberBase extends Base {

    @BeforeClass
    @Parameters("browser")
    public void beforeTest(@Optional("Chrome") String browser) throws MalformedURLException {
        DriverFactory.Initialize(BrowserType.Chrome.valueOf(browser));
        DriverHelper.navigation("http://a.testaddressbook.com/");
    }

    @AfterClass
    public void afterTest(){
        DriverHelper.QuitDriver();
    }
}

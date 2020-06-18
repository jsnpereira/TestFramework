package Tests;


import com.test.framework.selenium.base.Base;
import com.test.framework.selenium.base.BrowserType;
import com.test.framework.selenium.base.DriverFactory;
import com.test.framework.selenium.base.DriverHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest extends Base {

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DriverFactory.Initialize(BrowserType.Chrome);
        DriverHelper.navigation("http://a.testaddressbook.com/");
    }

    @AfterClass
    public void afterClass() {
        DriverHelper.QuitDriver();
    }
}

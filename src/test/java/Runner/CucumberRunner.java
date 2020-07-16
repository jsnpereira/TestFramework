package Runner;

import com.test.framework.selenium.base.Base;
import com.test.framework.selenium.base.BrowserType;
import com.test.framework.selenium.base.DriverFactory;
import com.test.framework.selenium.base.DriverHelper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

import java.net.MalformedURLException;

@CucumberOptions(
        plugin = {"pretty", "json:target/report/cucumber2.json"},
        strict = true,
        features = {"src/test/java/Features/"},
        glue = {"Steps"}
)
public class CucumberRunner extends CucumberBase {
    TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void BeforeClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun =  true)
    public void afterClass(){
        System.out.println("CucumberRunner - after test");
        testNGCucumberRunner.finish();
    }

    @Test(dataProvider = "scenarios")
    public void test(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }
}

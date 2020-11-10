package Runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@CucumberOptions(
        plugin = {"junit:target/cucumber.xml", "pretty", "Listener.ListenerPlugin"},
        features = {"src/test/java/Features/"},
        glue = {"Steps"}
)
public class CucumberRunner extends CucumberBase {
    TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void BeforeClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
    }

    @Test(groups = "Cucumber", description = "Run cucumber feature", dataProvider = "scenarios")
    public void test(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        String featureName = pickleWrapper.getPickle().getName();
        System.out.println("Test method: "+featureName);
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }
}

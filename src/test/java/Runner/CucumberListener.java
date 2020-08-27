package Runner;

import com.test.framework.commons.Settings;
import com.test.framework.utils.ConfigReader;
import com.test.framework.utils.LogUtil;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CucumberListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        Settings.logs = new LogUtil();

        try{
            Settings.logs.createLogFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Settings.logs.write("Starting the configs for tests");
        if (!method.isTestMethod()){
            try {
                ConfigReader.setUpSettings();

                Settings.logs.write("Browser: "+ Settings.browserType.toString());
                Settings.logs.write("URL: "+ Settings.baseURL);
                Settings.logs.write("Grid URL: "+ Settings.gridURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Settings.logs.write("Finish the configs for test");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}

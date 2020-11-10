package com.test.framework.selenium.manager;

import com.aventstack.extentreports.ExtentTest;
import com.test.framework.selenium.base.DriverHelper;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;


public class LocalDriverHelper {

    private static ThreadLocal<RemoteWebDriver> driverThreadLocal = new ThreadLocal<>();

    private static ExtentTest extentTest = null;
    private static Map extentFeatureMap = new HashMap();

    public static RemoteWebDriver driver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(RemoteWebDriver driverThreadLocal) {
        LocalDriverHelper.driverThreadLocal.set(driverThreadLocal);
    }
}

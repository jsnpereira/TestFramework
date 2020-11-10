package com.test.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class TestReport {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> currentTest;
    private static ThreadLocal<ExtentTest> currentTestClass;
    private static Set<String> testCases;

    public static void init(){
        extent = new ExtentReports();
        currentTest = new ThreadLocal<>();
        currentTestClass = new ThreadLocal<>();
        testCases = new HashSet<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String fileName = "report-"+ LocalDateTime.now().format(formatter) + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Paths.get("reports", fileName).toFile())
                .viewConfigurer()
                .viewOrder()
                .as(new ViewName[]{ViewName.TEST, ViewName.DASHBOARD, ViewName.EXCEPTION}).apply();

        extent.attachReporter(sparkReporter);
    }

    public synchronized void createTest(String testCase, String testName){
        if(testCases.add(testCase)){
            ExtentTest test = extent.createTest(Feature.class,testCase);
            currentTestClass.set(test);
        }

        ExtentTest node = currentTestClass.get().createNode(Scenario.class,testName);
        currentTest.set(node);
        extent.flush();
    }

    public void pass(String keyword, String testName) throws ClassNotFoundException {
        currentTest.get().createNode(new GherkinKeyword(keyword), testName).pass("Passed");
        extent.flush();
    }

    public void xFail(String keyword, String testName, String reason) throws ClassNotFoundException {
        currentTest.get().assignCategory("XFAIL");
        skip(keyword,testName, reason);
    }

    public void skip(String keyword, String testName, String reason) throws ClassNotFoundException {
        currentTest.get().createNode(new GherkinKeyword(keyword),testName).skip(reason);
        extent.flush();
    }

    public void fail(String keyword,String testName, String reason) throws ClassNotFoundException {
        currentTest.get().createNode(new GherkinKeyword(keyword),testName).fail(reason);
        extent.flush();
    }

    public void cleanTestCase(){
        currentTest.remove();
        extent.flush();
    }

    public void logImage(String base64Image){
        String message = "<img src=\"data:image/png;base64, "+base64Image+"\" width=\"100%\"/>";
        currentTest.get().log(Status.INFO, message);
        extent.flush();
    }

    public void log(String message){
        currentTest.get().log(Status.INFO, message);
        extent.flush();
    }

    public static void closeThreadLocalCollections(){
        currentTest.remove();
        currentTestClass.remove();
    }
}

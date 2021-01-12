package Listener;

import com.test.framework.utils.TestReport;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class ListenerPlugin implements ConcurrentEventListener {

    private static final TestReport testReport = new TestReport();

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        eventPublisher.registerHandlerFor(TestStepStarted.class, this::onTestStepStarted);

        eventPublisher.registerHandlerFor(TestStepFinished.class, event -> {
            try {
                switch (event.getResult().getStatus()) {
                    case PASSED:
                        onPassedTest(event);
                        break;
                    case SKIPPED:
                        onSkippedTest(event);
                        break;
                    case FAILED:
                        onFailedTest(event);
                        break;
                    default:
                        break;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void onTestRunStarted(TestRunStarted testRunStarted) {
        TestReport.init();
        System.out.println("TEST RUN STARTED AT: " + LocalDateTime.now().toString());
    }

    public void onTestCaseStarted(TestCaseStarted testCaseStarted) {
        String testClass = Paths.get(testCaseStarted.getTestCase().getUri()).getFileName().toString();
        String testName = testCaseStarted.getTestCase().getName();

        testReport.createTest(testClass, testName);
        System.out.println("TEST CASE STARTED -> testClass: " + testClass + " - testName: " + testName);
    }

    public void onTestCaseFinished(TestCaseFinished testCaseFinished) {
        System.out.println("TEST CASE FINISHED: " + testCaseFinished.getTestCase().getName());
        testReport.cleanTestCase();
    }

    public void onTestRunFinished(TestRunFinished testRunFinished) {
        TestReport.closeThreadLocalCollections();
        System.out.println("TEST RUN FINISHED AT: " + LocalDateTime.now().toString());
    }

    public void onTestStepStarted(TestStepStarted testStepStarted) {
        String tcName = testStepStarted.getTestCase().getName();
        String step = null;
        String keyWord = null;
        if (testStepStarted.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) testStepStarted.getTestStep();
            step = testStep.getStep().getText();
            keyWord = testStep.getStep().getKeyword();
            System.out.println("TEST STEP STARTED -> tcName: " + tcName + " - step: " + step + " - KeyWord: " + keyWord);

        }
    }

    public void onPassedTest(TestStepFinished testStepFinished) throws ClassNotFoundException {
        String[] info = getStepInformation(testStepFinished);
        testReport.pass(info[0], info[1]);
    }

    public void onSkippedTest(TestStepFinished testStepFinished) throws ClassNotFoundException {
        String[] info = getStepInformation(testStepFinished);
        String reason = testStepFinished.getResult().getError().getMessage();
        testReport.skip(info[0], info[1], reason);
    }

    public void onFailedTest(TestStepFinished testStepFinished) throws ClassNotFoundException {
        String[] info = getStepInformation(testStepFinished);
        String reason = testStepFinished.getResult().getError().getMessage();
        List<String> tags = testStepFinished.getTestCase().getTags();
        for (String tag : tags) {
            if (tag.toLowerCase().startsWith("@xfail")) {
                testReport.xFail(info[0], info[1], reason);
                return;
            }
        }
        testReport.fail(info[0], info[1], reason);
    }

    private String[] getStepInformation(TestStepFinished testStepFinished) {
        String tcName = testStepFinished.getTestCase().getName();
        String step = null;
        String keyWord = null;
        if (testStepFinished.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) testStepFinished.getTestStep();
            step = testStep.getStep().getText();
            keyWord = testStep.getStep().getKeyword();
            String[] setup = {keyWord, step};

            return setup;
        }
        return new String[0];
    }
}

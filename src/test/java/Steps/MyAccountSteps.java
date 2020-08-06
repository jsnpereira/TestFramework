package Steps;

import Steps.base.MyAccountStepsBase;
import io.cucumber.java.en.Then;

public class MyAccountSteps extends MyAccountStepsBase {
    @Then("I see my account page")
    public void iSeeMyAccountPage() {
        getMyAccountPageContext().checkMyAccountTitle();
    }
}

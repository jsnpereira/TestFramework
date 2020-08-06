package Steps;

import Pages.AuthenticatonPage;
import Pages.MyStorePage;
import Steps.base.MyStoreStepsBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStoreSteps extends MyStoreStepsBase {

    @Given("I see myStore page")
    public void iSeeMyStorePage() {
        setNewCurrentPage(GetInstance(MyStorePage.class));
        getMyStorePageContext().checkPage();
    }

    @When("I click sign in link")
    public void iClickSignInLink() {
        AuthenticatonPage authenticatonPage =  getMyStorePageContext().clickSignIn();
        setNewCurrentPage(authenticatonPage);
    }
}

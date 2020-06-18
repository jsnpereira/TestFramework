package Steps;

import Steps.base.SignInStepsBase;
import com.test.framework.selenium.base.BasePage;
import io.cucumber.java.en.Given;

public class SignInSteps extends SignInStepsBase {
    @Given("I click sign up link")
    public void iClickSignUpLink(){
        BasePage basePage = getSignInPage().clickSignUp();
        setNewPage(basePage);
    }
}

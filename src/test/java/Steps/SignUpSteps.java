package Steps;

import Pages.SignUpPage;
import Steps.base.SignInStepsBase;
import Steps.base.SignUpStepsBase;
import Tests.BaseTest;
import com.test.framework.selenium.base.BasePage;
import com.test.framework.selenium.manager.PageContext;
import com.test.framework.utils.DataUtils;
import io.cucumber.java.en.When;

public class SignUpSteps extends SignUpStepsBase {

    @When("I fill the username and password on fields")
    public void iFillTheUsernameAndPasswordField(){
        String username = DataUtils.createEmail("bart.simpsons+","yopmail.com");
        String password = "@bcd123";
        getSignUp().fillFields(username, password);
    }

    @When("I click sign up button")
    public void iClickSignUpButton(){
        BasePage basePage = getSignUp().clickSignUpButton();
        setNewPage(basePage);
    }


}

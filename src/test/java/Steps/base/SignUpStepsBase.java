package Steps.base;

import Pages.SignUpPage;
import com.test.framework.selenium.manager.PageContext;

public class SignUpStepsBase extends BaseSteps {

    public SignUpPage getSignUp(){
        return PageContext.getCurrentPage().As(SignUpPage.class);
    }
}

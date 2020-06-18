package Steps.base;

import Pages.SignInPage;
import com.test.framework.selenium.manager.PageContext;

public class SignInStepsBase extends BaseSteps {

    public SignInPage getSignInPage(){
        return PageContext.getCurrentPage().As(SignInPage.class);
    }
}

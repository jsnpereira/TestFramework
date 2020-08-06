package Steps.base;

import Pages.AuthenticatonPage;
import com.test.framework.selenium.manager.PageContext;

public class AuthenticateStepsBase extends BaseSteps {

    public AuthenticatonPage getAuthenticationContext(){
        return PageContext.getCurrentPage().As(AuthenticatonPage.class);
    }
}

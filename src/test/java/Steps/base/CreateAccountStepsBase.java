package Steps.base;

import Pages.CreateAccountPage;
import com.test.framework.selenium.manager.PageContext;

public class CreateAccountStepsBase extends BaseSteps {
    public CreateAccountPage getCreateAccountContext() {
        return PageContext.getCurrentPage().As(CreateAccountPage.class);
    }
}

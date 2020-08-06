package Steps.base;

import Pages.MyAccountPage;
import com.test.framework.selenium.manager.PageContext;

public class MyAccountStepsBase extends BaseSteps {
    public MyAccountPage getMyAccountPageContext(){
        return PageContext.getCurrentPage().As(MyAccountPage.class);
    }
}

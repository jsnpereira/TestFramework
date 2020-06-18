package Steps.base;

import Pages.HomePage;
import com.test.framework.selenium.manager.PageContext;

public class HomeStepsBase extends BaseSteps {

    public HomePage getHomePage(){
        return PageContext.getCurrentPage().As(HomePage.class);
    }

}

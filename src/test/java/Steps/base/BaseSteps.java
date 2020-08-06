package Steps.base;

import Tests.BaseTest;
import com.test.framework.selenium.base.BasePage;
import com.test.framework.selenium.manager.PageContext;

public class BaseSteps extends BaseTest {

    public void setNewCurrentPage(BasePage basePage){
        PageContext.setCurrentPage(basePage);
    }
}

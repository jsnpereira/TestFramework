package Steps.base;

import Pages.MyStorePage;
import com.test.framework.selenium.manager.PageContext;

public class  MyStoreStepsBase extends BaseSteps {
    public MyStorePage getMyStorePageContext(){
        return PageContext.getCurrentPage().As(MyStorePage.class);
    }
}

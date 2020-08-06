package Tests;


import Pages.MyStorePage;
import com.test.framework.selenium.manager.PageContext;
import com.test.framework.utils.DataUtils;
import org.testng.annotations.Test;


public class TestFirstExecute extends BaseTest {

    @Test()
    public void test01() throws InterruptedException {


        PageContext.setCurrentPage(GetInstance(MyStorePage.class));
        PageContext.getCurrentPage().As(MyStorePage.class).clickSignIn();




    }
}

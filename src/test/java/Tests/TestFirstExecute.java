package Tests;


import Pages.MyStorePage;
import com.test.framework.selenium.manager.PageContext;
import org.testng.annotations.Test;


public class TestFirstExecute extends BaseTest {

    @Test()
    public void test01() throws InterruptedException {

        System.out.println("Start test");
        PageContext.setCurrentPage(GetInstance(MyStorePage.class));
        PageContext.getCurrentPage().As(MyStorePage.class).clickSignIn();




     }
}

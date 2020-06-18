package Tests;


import Pages.AddressBookPage;
import Pages.HomePage;
import Pages.SignInPage;
import Pages.SignUpPage;
import com.test.framework.selenium.manager.PageContext;
import com.test.framework.utils.DataUtils;
import org.testng.annotations.Test;


public class TestFirstExecute extends BaseTest {

    @Test()
    public void test01() {
        String username = DataUtils.createEmail("bart.simpsons+","yopmail.com");
        String password = "@bcd123";

        PageContext.setCurrentPage(GetInstance(HomePage.class));
        PageContext.getCurrentPage().As(HomePage.class).checkWelcomePage();
        PageContext.setCurrentPage(PageContext.getCurrentPage().As(HomePage.class).clickSignInLink());

        PageContext.setCurrentPage(PageContext.getCurrentPage().As(SignInPage.class).clickSignUp());

        PageContext.getCurrentPage().As(SignUpPage.class).fillFields(username,password);
        PageContext.setCurrentPage(PageContext.getCurrentPage().As(SignUpPage.class).clickSignUpButton());

    }
}

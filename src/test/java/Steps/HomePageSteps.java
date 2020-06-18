package Steps;

import Pages.HomePage;
import Steps.base.HomeStepsBase;
import com.test.framework.selenium.base.BasePage;
import com.test.framework.selenium.manager.PageContext;
import io.cucumber.java.en.Given;

public class HomePageSteps extends HomeStepsBase {

    @Given("I see welcome page")
    public void iSeeWelcomePage(){
        PageContext.setCurrentPage(GetInstance(HomePage.class));
        getHomePage().checkWelcomePage();
    }

    @Given("I click sign in link")
    public void iClickSignInLink(){
       BasePage basePage = getHomePage().clickSignInLink();
       setNewPage(basePage);
    }


}

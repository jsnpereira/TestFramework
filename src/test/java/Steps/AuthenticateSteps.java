package Steps;

import Managers.UserContext;
import Pages.CreateAccountPage;
import Pages.MyAccountPage;
import Steps.base.AuthenticateStepsBase;
import io.cucumber.java.en.And;
import models.User;

public class AuthenticateSteps extends AuthenticateStepsBase {
    @And("I create new email")
    public void iCreateNewEmail() {
        User user = new User();
        UserContext.setCurrentUser(user);
        getAuthenticationContext().inputCreateEmail(UserContext.getCurrentUser().getEmail());
        CreateAccountPage createAccountPage = getAuthenticationContext().clickCreateEmailButton();
        setNewCurrentPage(createAccountPage);
    }

    @And("I sign in the user")
    public void iSignInTheUser() {
        MyAccountPage myAccountPage = getAuthenticationContext().signIn(UserContext.getCurrentUser());
        setNewCurrentPage(myAccountPage);
    }
}

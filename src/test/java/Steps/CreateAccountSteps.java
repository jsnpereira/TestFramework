package Steps;

import Managers.UserContext;
import Pages.MyAccountPage;
import Steps.base.CreateAccountStepsBase;
import com.test.framework.exceptions.NotSelectGender;
import com.test.framework.exceptions.NotSelectLocatorType;
import io.cucumber.java.en.And;

public class CreateAccountSteps extends CreateAccountStepsBase {

    @And("I fill all fields from account")
    public void iFillAllFieldsFromAccount() throws NotSelectGender, NotSelectLocatorType {
        getCreateAccountContext().selectGender(UserContext.getCurrentUser().getGender());
        getCreateAccountContext().enterFirstName(UserContext.getCurrentUser());
        getCreateAccountContext().enterLastName(UserContext.getCurrentUser());
        getCreateAccountContext().enterPassword(UserContext.getCurrentUser());
        getCreateAccountContext().selectDateOfBirth(UserContext.getCurrentUser());
        getCreateAccountContext().enterCompany(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().enterAddressLine1(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().enterAddressLine2(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().enterCity(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().selectState(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().enterPostalCode(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().selectCountry(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().enterAdditionalInformation(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().enterPhone(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().enterMobilePhone(UserContext.getCurrentUser().getAddresses().get(0));
        getCreateAccountContext().enterAddressAlias(UserContext.getCurrentUser().getAddresses().get(0));
    }

    @And("Click Register button")
    public void clickRegisterButton() {
        MyAccountPage myAccountPage = getCreateAccountContext().clickRegisterButton();
        setNewCurrentPage(myAccountPage);
    }
}

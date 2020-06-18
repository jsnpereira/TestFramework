package Steps;

import Steps.base.AddressBookStepsBase;
import io.cucumber.java.en.Then;

public class AddressBookSteps extends AddressBookStepsBase {

    @Then("I see address book page")
    public void iSeeAddressBookPage(){
        getAddressBook().checkUsernameDisplayed();
    }

}

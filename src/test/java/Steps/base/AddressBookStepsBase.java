package Steps.base;

import Pages.AddressBookPage;
import Tests.BaseTest;
import com.test.framework.selenium.manager.PageContext;
import io.cucumber.java.en.Then;

public class AddressBookStepsBase extends BaseTest {

    public AddressBookPage getAddressBook(){
        return PageContext.getCurrentPage().As(AddressBookPage.class);
    }
}

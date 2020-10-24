package Pages;

import com.test.framework.exceptions.NotSelectGender;
import com.test.framework.exceptions.NotSelectLocatorType;
import com.test.framework.selenium.base.BasePage;
import com.test.framework.selenium.base.DriverHelper;
import models.Address;
import models.Gender;
import models.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.ZoneId;

public class CreateAccountPage extends BasePage {

    @FindBy(id = "uniform-id_gender1")
    private WebElement mrRadio;

    @FindBy(id = "uniform-id_gender2")
    private WebElement mrsRadio;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "address1")
    private WebElement addressLine1AddressField;

    @FindBy(id = "address2")
    private WebElement addressLine2AddressField;

    @FindBy(id = "company")
    private WebElement companyAddressField;

    @FindBy(id = "city")
    private WebElement cityAddressField;

    @FindBy(id = "postcode")
    private WebElement postCodeField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobileField;

    @FindBy(id = "other")
    private WebElement otherField;

    @FindBy(id = "alias")
    private WebElement addressAliasField;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    @FindBy(name = "days")
    private WebElement dayOfBirthdayDropdown;

    @FindBy(name = "months")
    private WebElement monthOfBirthdayDropdown;

    @FindBy(xpath = ".//div[@id='uniform-years']//select")
    private WebElement yearOfBirthdayDropdown;

    @FindBy(xpath = ".//select[@id='id_country']/option")
    private WebElement countriesListDropdown;

    @FindBy(xpath = ".//div[@id='uniform-id_country']/span")
    private WebElement countrySelectorField;

    @FindBy(xpath = ".//select[@id='id_state']")
    private WebElement statesDropdownSelect;

    public void selectGender(final Gender gender)
            throws NotSelectGender {
        switch (gender) {
            case MR:
                DriverHelper.waitForElementVisible(mrRadio);
                mrRadio.click();
                break;
            case MRS:
                DriverHelper.waitForElementVisible(mrsRadio);
                mrsRadio.click();
                break;
            default:
                throw new NotSelectGender("Test not select the gender item");
        }

    }

    public void enterFirstName(final User user) {
        DriverHelper.typeTextInput(firstNameField, user.getFirstName());
    }

    public void enterLastName(final User user) {
        DriverHelper.typeTextInput(lastNameField, user.getLastName());
    }


    public void enterPassword(final User user) {
        DriverHelper.typeTextInput(passwordField, user.getPassword());
    }


    public void enterAddressLine1(final Address address) {
        DriverHelper.typeTextInput(addressLine1AddressField, address.getAddressLine1());
    }


    public void enterAddressLine2(final Address address) {
        DriverHelper.typeTextInput(addressLine2AddressField, address.getAddressLine2());
    }

    public void enterCompany(final Address address) {
        DriverHelper.typeTextInput(companyAddressField, address.getCompany());
    }

    public void enterCity(final Address address) {
        DriverHelper.typeTextInput(cityAddressField, address.getCity());
    }


    public void enterPostalCode(final Address address) {
        DriverHelper.typeTextInput(postCodeField, address.getPostalCode());
    }


    public void enterPhone(final Address address) {
        DriverHelper.typeTextInput(phoneField, address.getHomePhone());
    }


    public void enterMobilePhone(final Address address) {
        DriverHelper.typeTextInput(phoneMobileField, address.getMobilePhone());
    }

    public void enterAdditionalInformation(final Address address) {
        DriverHelper.typeTextInput(otherField, address.getAdditionalInformation());
    }

    public void enterAddressAlias(final Address address) {
        DriverHelper.typeTextInput(addressAliasField, address.getAddressAlias());
    }

    public MyAccountPage clickRegisterButton() {
        DriverHelper.waitForElementVisible(submitAccountButton);
        submitAccountButton.click();
        return GetInstance(MyAccountPage.class);
    }


    public void selectDateOfBirth(final User user) {
        LocalDate dateBirth = user.getDateBirth().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        DriverHelper.selectItemOnDropDown(dayOfBirthdayDropdown, String
                .valueOf(dateBirth.getDayOfMonth()));
        DriverHelper.selectItemOnDropDown(monthOfBirthdayDropdown, String
                .valueOf(dateBirth.getMonthValue()));
        DriverHelper.selectItemOnDropDown(yearOfBirthdayDropdown, String
                .valueOf(dateBirth.getYear()));
    }

    public void selectCountry(final Address address) {
        DriverHelper.waitForElementVisible(countriesListDropdown);

        if (!countrySelectorField.getText().equals(address.getCountry())) {
            DriverHelper.selectItemVisibleOnDropDown(countriesListDropdown, address.getCountry());
        }
    }

    public void selectState(final Address address) throws NotSelectLocatorType {
        DriverHelper.scrollToViewElement(statesDropdownSelect);
        DriverHelper.typeTextInput(statesDropdownSelect, address.getState());
      //  DriverHelper.scrollToViewElement(statesDropdownSelect);
      //  DriverHelper.selectItemVisibleOnDropDown(statesDropdownSelect, address.getState());
    }
}

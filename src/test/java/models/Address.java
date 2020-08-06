package models;

import com.test.framework.utils.DataUtils;

/**
 * This class is set the values of the address that the user
 * fill them out on page's field.
 */
public class Address {
    /**
     * First name value.
     */
    private String firstName;
    /**
     * Last name value.
     */
    private String lastName;
    /**
     * Company value.
     */
    private String company;
    /**
     * Address line 1 value.
     */
    private String addressLine1;
    /**
     * Address line 2 value.
     */
    private String addressLine2;
    /**
     * City value.
     */
    private String city;
    /**
     * State of the country.
     */
    private String state;
    /**
     * Postal code value.
     */
    private String postalCode;
    /**
     * country value.
     */
    private String country;
    /**
     *Mobile phone value.
     */
    private String mobilePhone;
    /**
     *Address alias value.
     */
    private String addressAlias;
    /**
     *Home phone value.
     */
    private String homePhone;
    /**
     *Additional information value.
     */
    private String additionalInformation;

    /**
     *The constructor as initial.
     */
    public Address() {
    }

    /**
     * The constructor as initial and fill all the variables.
     * @param firstNameValue set the first name value.
     * @param lastNameValue set the last name value.
     */
    public Address(final String firstNameValue, final String lastNameValue) {
        super();
        this.firstName = firstNameValue;
        this.lastName = lastNameValue;
        this.company = "company_" + DataUtils
                .getNewString(5);
        this.addressLine1 = "Ducktales avenue, 960";
        this.addressLine2 = "home 10";
        this.city = "Springfield";
        this.state = "Alabama";
        this.postalCode = "00000";
        this.country = "United States";
        this.mobilePhone = "+1 91918080";
        this.homePhone = "+1 9808080888";
        this.addressAlias = "reference_"
                + DataUtils.getNewString(5);
        this.additionalInformation = "Test";
    }

    /**
     * @return Get the first name value.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstNameValue  Set the first name value.
     */
    public void setFirstName(final String firstNameValue) {
        this.firstName = firstNameValue;
    }

    /**
     * @return Get the last name value.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastNameValue Set the last name value.
     */
    public void setLastName(final String lastNameValue) {
        this.lastName = lastNameValue;
    }

    /**
     * @return Get the company value.
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param companyValue Set the company value.
     */
    public void setCompany(final String companyValue) {
        this.company = companyValue;
    }

    /**
     * @return Get address line 1 value.
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * @param addressLine1Value Set the address line 1 value.
     */
    public void setAddressLine1(final String addressLine1Value) {
        this.addressLine1 = addressLine1Value;
    }

    /**
     * @return Get the address line 2 value.
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @param addressLine2Value Set the address line 2 value.
     */
    public void setAddressLine2(final String addressLine2Value) {
        this.addressLine2 = addressLine2Value;
    }

    /**
     * @return Get the city value.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param cityValue Set the city value.
     */
    public void setCity(final String cityValue) {
        this.city = cityValue;
    }

    /**
     * @return Get the state value.
     */
    public String getState() {
        return state;
    }

    /**
     * @param stateValue Se the state value.
     */
    public void setState(final String stateValue) {
        this.state = stateValue;
    }

    /**
     * @return Get postal code value.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCodeValue Set the postal code value.
     */
    public void setPostalCode(final String postalCodeValue) {
        this.postalCode = postalCodeValue;
    }

    /**
     * @return Get the country value.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param countryValue Set the country value.
     */
    public void setCountry(final String countryValue) {
        this.country = countryValue;
    }

    /**
     * @return Get the mobile phone value.
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhoneValue Set the mobile phone value.
     */
    public void setMobilePhone(final String mobilePhoneValue) {
        this.mobilePhone = mobilePhoneValue;
    }

    /**
     * @return Get the address alias value.
     */
    public String getAddressAlias() {
        return addressAlias;
    }

    /**
     * @param addressAliasValue Set the address alias value.
     */
    public void setAddressAlias(final String addressAliasValue) {
        this.addressAlias = addressAliasValue;
    }

    /**
     * @return Get the home phone value.
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * @param homePhoneValue Set the home phone value.
     */
    public void setHomePhone(final String homePhoneValue) {
        this.homePhone = homePhoneValue;
    }

    /**
     * @return Get the additional information value.
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformationValue Set the additional information value.
     */
    public void setAdditionalInformation(
            final String additionalInformationValue) {
        this.additionalInformation = additionalInformationValue;
    }

    /**
     * @return Get full address line value: this value is provider
     * from Address line 1 and 2 values.
     */
    public String getFullAdressLine() {
        return this.addressLine1 + " " + this.addressLine2;
    }

    /**
     * @return Get full of the home: This value provider
     * from the city, state and postal code values.
     */
    public String getFullAddressHome() {
        return this.city + ", " + this.state + " " + this.postalCode;
    }
}

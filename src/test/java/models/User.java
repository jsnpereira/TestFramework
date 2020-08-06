package models;

import com.test.framework.utils.DataUtils;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is get the user's information on page.
 */
public class User {
    private Gender gender;
    /**
     * The user's title value.
     */
    private String title;
    /**
     * The user's first name value.
     */
    private String firstName;
    /**
     * The user's last name value.
     */
    private String lastName;
    /**
     * The user's email value.
     */
    private String email;
    /**
     * The user's password value.
     */
    private String password;
    /**
     * The user's date birth value.
     */
    private Date dateBirth;
    /**
     * The user's addresses values.
     */
    private List<Address> addresses;

    /**
     * This constructor as initial have set the user's values.
     */
    public User() {
        this.gender = Gender.MR;
        this.title = "Mr.";
        this.firstName = "John";
        this.lastName = "Doe";
        this.email = DataUtils.createEmail("john.does", "yopmail.com");
        this.password = "@bcd1234";
        LocalDate birth = LocalDate.of(1982, 8, 8);
        this.dateBirth = Date.from(birth.atStartOfDay(
                ZoneId.systemDefault()).toInstant());
        Address address = new Address(firstName, lastName);
        this.addresses = new ArrayList<Address>();
        this.addresses.add(address);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return Get the title value.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param titleValue Set the title value.
     */
    public void setTitle(final String titleValue) {
        this.title = titleValue;
    }

    /**
     * @return Get first name value.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstNameValue Set the first name value.
     */
    public void setFirstName(final String firstNameValue) {
        this.firstName = firstNameValue;
    }

    /**
     * @return Get the last name value
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastNameValue Set the last name value
     */
    public void setLastName(final String lastNameValue) {
        this.lastName = lastNameValue;
    }

    /**
     * @return Get the email value
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param emailValue Set the email value.
     */
    public void setEmail(final String emailValue) {
        this.email = emailValue;
    }

    /**
     * @return Get the password value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param passwordValue Set the password value.
     */
    public void setPassword(final String passwordValue) {
        this.password = password;
    }

    /**
     * @return Get the date of the birth value.
     */
    public Date getDateBirth() {
        return dateBirth;
    }

    /**
     * @param dateBirthValue Set the date of the birth value.
     */
    public void setDateBirth(final Date dateBirthValue) {
        this.dateBirth = dateBirthValue;
    }

    /**
     * @return Get the addresses list values.
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addressesList Set the addresses list values.
     */
    public void setAddresses(final List<Address> addressesList) {
        this.addresses = addressesList;
    }

    /**
     * @return Get the full of name from user.
     */
    public String getFullName() {
        return this.firstName + " " + this.getLastName();
    }
}

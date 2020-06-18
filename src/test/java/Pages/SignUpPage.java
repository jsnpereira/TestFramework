package Pages;

import com.test.framework.selenium.base.DriverHelper;
import com.test.framework.selenium.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(id = "user_email")
    WebElement usernameField;

    @FindBy(id = "user_password")
    WebElement passwordField;

    @FindBy(name = "commit")
    WebElement signUp;

    @FindBy(xpath = ".//div[@class='row']/a")
    WebElement signInLink;

    public void fillFields(String username, String password){
        DriverHelper.waitForElementVisible(usernameField);
        usernameField.sendKeys(username);
        DriverHelper.waitForElementVisible(passwordField);
        passwordField.sendKeys(password);
    }

    public AddressBookPage clickSignUpButton(){
        signUp.click();
        return GetInstance(AddressBookPage.class);
    }

    public void checkRedirectToPage(){
        DriverHelper.redirectTo("/sign_up");
    }
}

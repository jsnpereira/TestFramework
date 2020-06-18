package Pages;


import com.test.framework.selenium.base.DriverHelper;
import com.test.framework.selenium.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "session_email")
    WebElement eUsernameField;
    @FindBy(id = "session_password")
    WebElement ePasswordField;
    @FindBy(name = "commit")
    WebElement eSignInButton;
    @FindBy(xpath = ".//div[@class='row']/a")
    WebElement signUpLink;

    public AddressBookPage fillAndLogIn(String username, String password){
        DriverHelper.waitForElementVisible(eUsernameField);
        eUsernameField.sendKeys(username);
        DriverHelper.waitForElementVisible(ePasswordField);
        ePasswordField.sendKeys(password);
        DriverHelper.waitForElementVisible(eSignInButton);
        eSignInButton.click();
        return GetInstance(AddressBookPage.class);
    }

    public SignUpPage clickSignUp(){
        DriverHelper.waitForElementVisible(signUpLink);
        signUpLink.click();
        return GetInstance(SignUpPage.class);
    }

    public void checkRedirectToPage(){
        DriverHelper.redirectTo("/sign_in");
    }
}

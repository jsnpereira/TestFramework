package Pages;

import com.test.framework.commons.PathUrls;
import com.test.framework.selenium.base.BasePage;
import com.test.framework.selenium.base.DriverHelper;
import models.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticatonPage extends BasePage {
    @FindBy(id = "email_create")
    private WebElement emailCreateField;

    @FindBy(id="SubmitCreate")
    private WebElement createUserButton;

    @FindBy(id ="email")
    private WebElement emailAddressField;

    @FindBy(id="passwd")
    private WebElement passwordField;

    @FindBy(xpath = ".//p[contains(@class,'lost_password')]/a")
    private WebElement forgotPwdLink;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public void inputCreateEmail(String newEmail){
        DriverHelper.waitForElementVisible(emailCreateField);
        DriverHelper.typeTextInput(emailCreateField, newEmail, false);
    }

    public CreateAccountPage clickCreateEmailButton(){
        DriverHelper.waitForElementVisible(createUserButton);
        createUserButton.click();
        DriverHelper.redirectTo(PathUrls.RedirectTo.CREATE_ACCOUNT_PAGE);
        return GetInstance(CreateAccountPage.class);
    }

    public MyAccountPage signIn(User user){
        DriverHelper.waitForElementVisible(emailAddressField);
        DriverHelper.waitForElementVisible(passwordField);
        DriverHelper.waitForElementVisible(signInButton);

        DriverHelper.typeTextInput(emailAddressField, user.getEmail());
        DriverHelper.typeTextInput(passwordField, user.getPassword());
        signInButton.click();
        return GetInstance(MyAccountPage.class);
    }

}

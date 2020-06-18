package Pages;


import com.test.framework.selenium.base.DriverHelper;
import com.test.framework.selenium.base.BasePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "sign-in")
    private WebElement signInLink;

    @FindBy(xpath = ".//div[@id='navbar']//a[1]")
    private WebElement homeLink;

    @FindBy(xpath = ".//div[@id='navbar']/div[2]/span")
    private WebElement currentUser;

    @FindBy(xpath = ".//div[@id='navbar']/div[1]/a[2]")
    private WebElement addressesLink;

    @FindBy(xpath = ".//div[@class='container']//h1")
    private WebElement welcomePageLabel;

    public SignInPage clickSignInLink() {
        DriverHelper.waitForElementVisible(signInLink);
        signInLink.click();
        return GetInstance(SignInPage.class);
    }

    public void checkUserCurrentMenu(String username) {
        DriverHelper.waitForElementVisible(currentUser);
        Assertions.assertThat(currentUser.getText())
                .isEqualTo(username);
    }

    public void checkWelcomePage(){
        DriverHelper.waitForElementVisible(welcomePageLabel);
        Assertions.assertThat(welcomePageLabel.getText()).isEqualTo("Welcome to Address Book");
    }

}

package Pages;


import com.test.framework.selenium.base.BasePage;
import com.test.framework.selenium.base.DriverHelper;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage {
    @FindBy(id = "sign-in")
    private WebElement signInLink;

    @FindBy(xpath = ".//div[@id='navbar']//a[1]")
    private WebElement homeLink;

    @FindBy(xpath = ".//div[@id='navbar']/div[2]/span")
    private WebElement currentUser;

    @FindBy(xpath = ".//div[@id='navbar']/div[1]/a[2]")
    private WebElement addressesLink;

    public void checkUsernameDisplayed(){
        DriverHelper.waitForElementVisible(currentUser);
        Assertions.assertThat(currentUser.getText()).contains("bart.simpsons");
    }


}

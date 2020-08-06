package Pages;

import com.test.framework.commons.Labels;
import com.test.framework.selenium.base.BasePage;
import com.test.framework.selenium.base.DriverHelper;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(className = "page-heading")
    private WebElement myAccountTitle;

    @FindBy(xpath = ".//*[@class='icon-user']")
    private WebElement myAccountInformationButton;

    public void checkMyAccountTitle(){
        DriverHelper.waitForElementVisible(myAccountTitle);
        Assertions.assertThat(myAccountTitle.getText()).isEqualTo(Labels.MyAccount.TITLE);
    }



}

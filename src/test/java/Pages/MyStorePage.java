package Pages;


import com.test.framework.commons.PathUrls;
import com.test.framework.exceptions.NotSelectLocatorType;
import com.test.framework.selenium.base.BasePage;
import com.test.framework.selenium.base.DriverHelper;
import com.test.framework.selenium.base.LocatorType;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStorePage extends BasePage {

    public static final String PRODUCT_ITEM_BY_PRODUCT_NAME =
            ".//ul[@id='homefeatured']//a[contains(text(),'{XXX}')]";
    public static final String ADD_CART_BY_PRODUCT_ITEM =
            ".//ul[@id='homefeatured']//a[contains(text(),'{XXX}')]"
                    + "/../following-sibling::div"
                    + "[@class='button-container']/a[1]";

    @FindBy(xpath = ".//div[@id='layer_cart']//div[@class='button-container']/a")
    private WebElement checkoutButton;

    @FindBy(id = "layer_cart")
    private WebElement checkoutProduct;

    @FindBy(className = "login")
    private WebElement signInLink;

    public void checkPage(){
        Assertions.assertThat(DriverHelper.getCurrentURL()).contains(PathUrls.RedirectTo.HOME_PAGE_PATH);
    }

    public void seeProduct(final String productName)
            throws NotSelectLocatorType {
        WebElement productItem = DriverHelper.getElement(PRODUCT_ITEM_BY_PRODUCT_NAME
                .replace("{XXX}", productName), LocatorType.XPATH);

        DriverHelper.scrollToViewElement(productItem);
        DriverHelper.moveToElement(productItem);
    }

    public void addCartByProduct(final String productName)
            throws NotSelectLocatorType {
        WebElement addCartProductItem = DriverHelper.getElement(ADD_CART_BY_PRODUCT_ITEM
                .replace("{XXX}", productName), LocatorType.XPATH);

        DriverHelper.waitElementBeClicked(addCartProductItem);
        addCartProductItem.click();
    }

    public void seePopUpOpen() throws NotSelectLocatorType {
        DriverHelper.waitForElementVisible(checkoutProduct);
    }

    public void clickCheckOutPopUp() throws NotSelectLocatorType {
        DriverHelper.waitElementBeClicked(checkoutButton);
        checkoutButton.click();
    }

    public AuthenticatonPage clickSignIn(){
        DriverHelper.waitForElementVisible(signInLink);
        signInLink.click();
        DriverHelper.redirectTo(PathUrls.RedirectTo.AUTHENTICATION_PAGE);
        return GetInstance(AuthenticatonPage.class);
    }
}

package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.Matchers.is;

public class CartPage extends ParentPage {
    @FindBy(xpath = ".//*[@id='user-menu']//a[@class='account-info']")
    private WebElement userNameLink;

    @FindBy(xpath = ".//*[@href=\"http://suitster.com/en/checkout/\"]")
    private WebElement buttonProceedToCheckOut;

    @FindBy(xpath = ".//a[text()='×']")
    private WebElement buttonDeleteItem;

    @FindBy(xpath = ".//*[@class='woocommerce-message item-success']//p")
    private WebElement messageOnPopUp;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return actionWithWebElement.getTextFromElement(userNameLink);
    }

    public boolean isProductInCart(String product) {
        return actionWithWebElement.isElementWithXpathShown(".//h6[contains(text(),'" + product + "')]");
    }

    public void clickDeleteProductFromCart(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//h6[contains(text(),'" + product + "')]//..//..//..//a[text()='×']")))).click();
        log.info("Product " + product + " was deleted");
    }

    private String getMessageFromPopUp() {
        return actionWithWebElement.getTextFromElement(messageOnPopUp);
    }

    public void checkMessageOnPopup(String message) {
        Assert.assertThat("Message on popup ", getMessageFromPopUp(), is(message));
    }

}

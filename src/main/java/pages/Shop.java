package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.Matchers.is;

public class Shop extends ParentPage {

    @FindBy(xpath = ".//select[@id='size']")
    private WebElement ddSize;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = ".//*[@class='item-summary']//*[@href='http://suitster.com/cart/']")
    private WebElement buttonCheckOut;

    public Shop(WebDriver driver) {
        super(driver);
    }

    public void clickOnItemInLeftMenuShop(String nameOfItem) {
        WebElement itemMenu = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath(
                        ".//*[@id='sidebar']//li//a[text()='" + nameOfItem.trim() + "']"
                ))));

        actionWithWebElement.clickLink(itemMenu);
        log.info("Link " + nameOfItem + " was clicked");
    }

    public void clickOnProductByName(String nameOfProduct) {
        actionWithWebElement.clickLink(wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath(".//H4[text()='" + nameOfProduct + "']")))));
        log.info("Product " + nameOfProduct + " was clicked");
    }

    public void checkPageWithProductWasOpened(String nameOfProduct) {
        Assert.assertThat("Product with name " + nameOfProduct + " not found ",
                actionWithWebElement.isElementWithXpathShown(".//h1[text()='" + nameOfProduct + "']")
                , is(true));

    }

    public void clickDropDownSize() {
        actionWithWebElement.clickButton(ddSize);
        log.info("DD Size was clicked");
    }

    public void selectValueFromDDSize(String value) {
        actionWithWebElement.selectValueInDD(ddSize, value);
        log.info("Size " + value + " was selected in DD Size");
    }

    public void clickButtonAddToCart() {
        actionWithWebElement.clickButton(buttonAddToCart);
        log.info("Button Add to Cart was clicked");
    }

    public void clickButtonCheckOut() {
        actionWithWebElement.clickButton(buttonCheckOut);
        log.info("Button CheckOut was clicked");
    }

}

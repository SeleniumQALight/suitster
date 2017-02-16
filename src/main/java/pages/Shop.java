package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.is;

public class Shop extends ParentPage {
    public Shop(WebDriver driver) {
        super(driver);
    }

    public void clickOnItemInLeftMenuShop(String nameOfItem) {
        actionWithWebElement.clickLink(driver.findElement(By.xpath(
                ".//*[@id='sidebar']//li//a[text()='" + nameOfItem.trim() + "']"
        )));
        log.info("Link " + nameOfItem + " was clicked");
    }

    public void clickOnProductByName(String nameOfProduct) {
        actionWithWebElement.clickLink(driver.findElement(By.xpath(".//H4[text()='" + nameOfProduct + "']")));
        log.info("Product " + nameOfProduct + " was clicked");
    }

    public void checkPageWithProductWasOpened(String nameOfProduct) {
        Assert.assertThat("Product with name " + nameOfProduct + " not found ",
                actionWithWebElement.isElementWithXpathShown(".//h1[text()='" + nameOfProduct + "']")
                , is(true));

    }
}

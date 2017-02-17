package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithWebElements {
    private WebDriver driver;
    private Logger log;
    private WebDriverWait wait;

    public ActionsWithWebElements(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        wait = new WebDriverWait(driver, 20);
    }

    public void clickButton(WebElement button) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
            log.info("Button was Clicked");
        } catch (TimeoutException te) {
            log.error("Expected condition failed: waiting for visibility of button" + button);
            Assert.fail("Expected condition failed: waiting for visibility of button" + button);
        } catch (Exception e) {
            log.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }

    public void clickLink(WebElement linkElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(linkElement)).click();
            log.info("Link was Clicked");
        } catch (Exception e) {
            log.error("Can not work with Link");
            Assert.fail("Can not work with Link");
        }
    }

    public void enterTextInToInput(WebElement inputElement, String text) {
        try {
            inputElement.clear();
            inputElement.sendKeys(text);
            log.info("Text was entered in input " + text);
        } catch (Exception e) {
            log.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }

    public String getTextFromElement(WebElement element) {
        String textFromElement = "";
        try {
            textFromElement = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        } catch (Exception e) {
            log.error("Can not get text from element");
            Assert.fail("Can not get text from element");
        }
        return textFromElement;
    }

    public boolean isElementWithXpathShown(String locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator)))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectValueInDD(WebElement elementDD, String value){
        try {
            Select select = new Select(elementDD);
            select.selectByValue(value);
        }catch (Exception e){
            log.error("Can not work with DropDown");
            Assert.fail("Can not work with DropDown");
        }
    }

    public void waitUntilElementWithXpathWillBeNotShown(WebElement element) {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }
}

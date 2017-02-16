package libs;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithWebElements {
    WebDriver driver;
    Logger log;
    WebDriverWait wait;

    public ActionsWithWebElements(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        wait = new WebDriverWait(driver, 15);
    }

    public void clickButton(WebElement button) {
        try {
            wait.until(ExpectedConditions.visibilityOf(button));
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
            wait.until(ExpectedConditions.visibilityOf(linkElement)).click();
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
            textFromElement = element.getText();
        } catch (Exception e) {
            log.error("Can not get text from element");
            Assert.fail("Can not get text from element");
        }
        return textFromElement;
    }

    public boolean isElementWithXpathShown(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

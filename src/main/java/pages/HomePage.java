package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='promo-image']//img")
    private WebElement promoImage;

    @FindBy(xpath = ".//*[@class='close']")
    private WebElement buttonClosePromo;

    @FindBy(xpath = ".//a[text()='English']")
    private WebElement linkEnglishLang;

    @FindBy(xpath = ".//*[@id='user-menu']/ul[1]/li/a")
    private WebElement linkRussianLang;

    @FindBy(xpath = ".//nav[@id=\"user-menu\"]//*[contains(@href,'my-account')]")
    private WebElement linkMyAccount;

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public void openPage() {
        driver.get("http://suitster.com/");
//        wait.until(ExpectedConditions.visibilityOf(promoImage));
        log.info("Home Page was opened");
    }

    public void openEnPage() {
        driver.get("http://suitster.com/en/");
        log.info("Home Page was opened");
    }

    public void closePromoPopUp(String browserForIgnoreBug) {
        if (!"iedriver".equals(browserForIgnoreBug)) {
            actionWithWebElement.clickButton(buttonClosePromo);
            log.info("Popup promo was closed English");
        }
    }

    public void clickEnglishLang() {
        actionWithWebElement.clickLink(linkEnglishLang);
        waitInVisible.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//a[text()='English']")));
        log.info("Lang was changed");
    }

    public void clickRussianLang() {
        actionWithWebElement.clickLink(linkRussianLang);
        waitInVisible.until(ExpectedConditions.visibilityOf(linkEnglishLang));
        log.info("Lang was changed to Russion");
    }

    public void clickMyAccountLink(){
        actionWithWebElement.clickLink(linkMyAccount);
        log.info("Link My Account was clicked");
    }

}

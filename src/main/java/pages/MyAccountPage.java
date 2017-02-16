package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.Matchers.is;

public class MyAccountPage extends ParentPage {
    @FindBy(xpath = ".//input[@id='reg_email']")
    WebElement inputEmail;

    @FindBy(id = "reg_password")
    WebElement regPassword;

    @FindBy(id = "reg_password2")
    WebElement regPassword2;

    @FindBy(xpath = ".//input[@name='register']")
    WebElement buttonCreateAcount;

    @FindBy(xpath = ".//*[@class='woocommerce-message item-success']//p")
    WebElement messageOnPopUp;

    @FindBy(xpath = ".//*[@class='woocommerce-message item-success']//a")
    WebElement buttonOkOnPopUp;

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(xpath = ".//*[@id='header-menu']//*[@href='http://suitster.com/shop/']")
    private WebElement linkShop;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void waitPageMyAcountLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
    }

    public void enterTextInEmailInput(String email) {
        actionWithWebElement.enterTextInToInput(inputEmail, email);
    }

    public void enterRegistrationPass(String pass) {
        actionWithWebElement.enterTextInToInput(regPassword, pass);
        log.info(pass + " was inputed in to Pass Input");
    }

    public void enterRepeatRegistartionPass(String passRepeat) {
        actionWithWebElement.enterTextInToInput(regPassword2, passRepeat);
        log.info(passRepeat + " was inputed to Repeat Input");
    }

    public void clickButtonCreateAccount() {
        actionWithWebElement.clickButton(buttonCreateAcount);
        log.info("Button Create Account was clicked");
    }

    public String getMessageFromPopUp() {
        return actionWithWebElement.getTextFromElement(messageOnPopUp);
    }

    public void checkMessageOnPopup(String message) {
        Assert.assertThat("Message on popup ", getMessageFromPopUp(), is(message));
    }

    public void clickOnButtonOkOnPopup() {
        actionWithWebElement.clickButton(buttonOkOnPopUp);
        log.info("Button Ok was clicked on popup");
    }

    public void enterLoginInToInput(String login) {
        actionWithWebElement.enterTextInToInput(userName, login);
        log.info(login + " was inputed in to Login Input");
    }

    public void enterPassInToInputPass(String pass) {
        actionWithWebElement.enterTextInToInput(password, pass);
        log.info(pass + " was inputed in to Input Pass");
    }

    public void clickLoginButton() {
        actionWithWebElement.clickButton(loginButton);
        log.info("Button LogIn was clicked");
    }

    public void clickLinkShop() {
        actionWithWebElement.clickLink(linkShop);
        log.info("Link Shop was clicked");
    }
}

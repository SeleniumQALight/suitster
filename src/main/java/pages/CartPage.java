package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends ParentPage{
    @FindBy (xpath = ".//*[@id='user-menu']//a[@class='account-info']")
    WebElement userNameLink;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName(){
        return actionWithWebElement.getTextFromElement(userNameLink);
    }

}

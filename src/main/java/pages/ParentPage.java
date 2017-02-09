package pages;

import libs.ActionsWithWebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.is;

public class ParentPage {
    WebDriver driver;
    Logger log;
    WebDriverWait wait;
    WebDriverWait waitInVisible;
    ActionsWithWebElements actionWithWebElement;

    public ParentPage (WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,10);
        waitInVisible = new WebDriverWait(driver,5);
        actionWithWebElement = new ActionsWithWebElements(driver);
    }

    public void checkPageTitle (String title){
        Assert.assertThat("Title is not expected " , driver.getTitle(), is(title) );
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}

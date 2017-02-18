package verifyingMyAcountForm;

import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginFromMyAcount extends ParentTest {
    public LoginFromMyAcount(String browser) {
        super(browser);
    }

    @Test
    public void checkEnterOnAcountRu(){
        homePage.openPage();
        homePage.closePromoPopUp(browserForIgnoreBug);
        homePage.clickMyAccountLink();
        myAccountPage.waitPageMyAcountLoaded();
        myAccountPage.checkPageTitle("Мой профиль - Suitster.com");
        myAccountPage.enterLoginInToInput("test@qalight.com");
        myAccountPage.enterPassInToInputPass("1");
        myAccountPage.clickLoginButton();
        myAccountPage.checkMessageOnPopup("Оформление заказа не доступно, пока ваша корзина пуста.");
        myAccountPage.clickOnButtonOkOnPopup();
        checkAC("UserName",cart.getUserName(),"TEST10");

    }

    @Test
    @Ignore
    public void checkEnterOnAcountEn(){
        homePage.openEnPage();
        homePage.closePromoPopUp(browserForIgnoreBug);
        homePage.clickMyAccountLink();
        myAccountPage.waitPageMyAcountLoaded();
        myAccountPage.checkPageTitle("My Account - Suitster");
        myAccountPage.enterLoginInToInput("test@qalight.com");
        myAccountPage.enterPassInToInputPass("1");
        myAccountPage.clickLoginButton();
        myAccountPage.checkMessageOnPopup("Ordering is not available until your shopping cart is empty.");
        myAccountPage.clickOnButtonOkOnPopup();
        checkAC("UserName",cart.getUserName(),"TEST10");

    }
}

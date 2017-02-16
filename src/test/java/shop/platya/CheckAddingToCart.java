package shop.platya;

import org.junit.Test;
import parentTest.ParentTest;

public class CheckAddingToCart extends ParentTest {

    public CheckAddingToCart(String browser) {
        super(browser);
    }


    @Test
    public void checkAddingToCartRu() {
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
        checkAC("UserName", cart.getUserName(), "TEST10");

        myAccountPage.clickLinkShop();
        shop.clickOnItemInLeftMenuShop("Платья");
        shop.clickOnProductByName("Lovers+Friends");
        shop.checkPageWithProductWasOpened("Lovers+Friends1");

    }

}

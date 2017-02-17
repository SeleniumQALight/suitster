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
        shop.checkPageTitle("Онлайн магазин - Suitster.com");
        shop.clickOnItemInLeftMenuShop("Платья");
        shop.checkPageTitle("Купить брендовое платье от ведущих украинских дизайнеров ◆");
        shop.clickOnProductByName("Lovers+Friends");
        shop.checkPageWithProductWasOpened("Lovers+Friends");

        shop.selectValueFromDDSize("S");
        shop.clickButtonAddToCart();

        shop.clickButtonCheckOut();
        shop.checkPageTitle("Корзина - Suitster.com");
        checkAC("Product 'Lovers+Friends' is not in Cart", cart.isProductInCart("Lovers+Friends"), true);
        cart.clickDeleteProductFromCart("Lovers+Friends");

        cart.checkMessageOnPopup("Товар успешно удален из корзины");
    }

}

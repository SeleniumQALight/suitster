package verifyingMyAcountForm;

import parentTest.ParentTest;
import org.junit.Test;

public class CheckRegisterForm extends ParentTest {

    public CheckRegisterForm(String browser) {
        super(browser);
    }

    @Test
    public void checkDiffPassWhenRegistrationEn() {
        homePage.openEnPage();
        homePage.closePromoPopUp(browserForIgnoreBug);
        homePage.clickMyAccountLink();
        myAccountPage.waitPageMyAcountLoaded();
        myAccountPage.checkPageTitle("My Account - Suitster");
        myAccountPage.enterTextInEmailInput("ttt@mail.com");
        myAccountPage.enterRegistrationPass("11111tR");
        myAccountPage.enterRepeatRegistartionPass("21111tR");
        myAccountPage.clickButtonCreateAccount();
        checkAC("Text of error message ", myAccountPage.getErrorMessage(), "* Passwords do not match");

    }

    @Test
    public void checkDiffPassWhenRegistrationRu() {
        homePage.openPage();
        homePage.closePromoPopUp(browserForIgnoreBug);
        homePage.clickMyAccountLink();
        myAccountPage.waitPageMyAcountLoaded();
        myAccountPage.checkPageTitle("Мой профиль - Suitster.com");
        myAccountPage.enterTextInEmailInput("ttt@mail.com");
        myAccountPage.enterRegistrationPass("11111tR");
        myAccountPage.enterRepeatRegistartionPass("21111tR");
        myAccountPage.clickButtonCreateAccount();
        checkAC("Text of error message ", myAccountPage.getErrorMessage(), "* Пароли не совпадают");

    }

}

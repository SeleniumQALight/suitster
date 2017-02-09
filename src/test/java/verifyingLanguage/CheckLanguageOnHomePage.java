package verifyingLanguage;


import parentTest.ParentTest;
import org.junit.Test;

public class CheckLanguageOnHomePage extends ParentTest {

    public CheckLanguageOnHomePage(String driver) {
        super(driver);
    }

    @Test
    public void englishLanguageOnHomePage() {
        homePage.openPage();
        homePage.closePromoPopUp();
        homePage.checkPageTitle("Suitster.com - онлайн магазин модных международных и украинских брендов");
        homePage.clickEnglishLang();
        checkAC("Title is not expected.", homePage.getPageTitle(), "Homepage - Suitster");
    }

    @Test
    public void russianLanguageOnHomePage() {
        homePage.openEnPage();
        homePage.closePromoPopUp();
        homePage.checkPageTitle("Homepage - Suitster");
        homePage.clickRussianLang();
        checkAC("Title is not expected.", homePage.getPageTitle(), "Suitster.com - онлайн магазин модных международных и украинских брендов");
    }
}

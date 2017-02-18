package suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import verifyingLanguage.CheckLanguageOnHomePage;
import verifyingMyAcountForm.CheckRegisterForm;
import verifyingMyAcountForm.LoginFromMyAcount;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CheckLanguageOnHomePage.class,
                CheckRegisterForm.class,
                LoginFromMyAcount.class
        }
)
public class SuitForSmoke {

}





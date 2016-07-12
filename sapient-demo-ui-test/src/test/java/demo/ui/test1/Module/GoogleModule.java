package demo.ui.test1.Module;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import demo.ui.test1.Page.GooglePage;

@DefaultUrl("https://www.etsy.com")
public class GoogleModule extends GooglePage {

    GooglePage gPage;

    @Step
    public void gotoGooglePage() {

        gPage.gotoAppPage();
    }

    @Step
    public void enterSearchKey(String keyword) {
        gPage.enterSearchKeyword(keyword);
        gPage.checkResults();
    }

}

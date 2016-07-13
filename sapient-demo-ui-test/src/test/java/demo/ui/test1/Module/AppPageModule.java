package demo.ui.test1.Module;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import demo.ui.test1.Page.AppPage;

@DefaultUrl("https://www.etsy.com")
public class AppPageModule extends AppPage {

    // public PageModule(WebDriver driver) throws Exception {
    // super(driver);
    // // TODO Auto-generated constructor stub
    // }

    protected static WebDriver driver = new HtmlUnitDriver();

    AppPage gPage;

    @Step
    public void gotoApp(String URL) {

        gPage.gotoAppPage(driver, URL);
    }

    @Step
    public void enterSearchKey(String keyword) {
        gPage.enterSearchKeyword(driver, keyword);
        gPage.checkResults(driver);
    }

}

package demo.ui.test1.Page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends PageObject {
    protected static WebDriver driver;
    protected WebDriverWait waitDriver;

    private String baseURL = "http://demo-live-elis2.uscis.dhs.gov:8080/efile/app/app/iv/#!/";

    @ManagedPages
    private Pages pages;

    @FindBy(name = "alienNum")
    protected static WebElement AnumField;

    @FindBy(id = "input_deptOfStateId")
    protected static WebElement dosIDField;

    @FindBy(id = "addBtn")
    protected static WebElement addBtn;

    @FindBy(id = "continueBtn")
    protected static WebElement continueBtn;

    @FindBy(id = "continue-button")
    protected static WebElement HomecontinueBtn;

    @FindBy(id = "idProofLink")
    protected static WebElement createUSCISAccount;

    @FindBy(id = "ivPayGovBtn")
    protected static WebElement PayGovBtn;

    @FindBy(id = "submitButton")
    WebElement payFeeBtn;

    @FindBy(id = "idProofLink")
    protected static WebElement createUSCISAcctBtn;

    @FindBy(id = "idProofBtn")
    protected static WebElement clickNextBtn;

    // protected static WebDriver driver;
    // protected WebDriverWait waitDriver;
    // @ManagedPages
    // private Pages pages;
    //
    // input[@name='q']

    @FindBy(xpath = "//input[@name='q']")
    protected static WebElement keywordField;

    @FindBy(xpath = "//input[@name='btnK']")
    protected static WebElement searchBtn;

    @FindBy(name = "btnK")
    private WebElement googleSearch;

    @FindBy(xpath = "//a[contains(.,'Publicis.Sapient Overview | Publicis.Sapient')]")
    protected static WebElement searchResultText;

    //
    // public void gotoGoogleApp() {
    // driver.get("http://www.google.com");
    // // open();
    // driver.manage().window().maximize();
    // }
    //
    // public void enterSearchKeyword(String keyword) {
    // element(keywordField).waitUntilVisible();
    // keywordField.sendKeys(keyword);
    // }
    //
    // public GoogleSearchPage clickGoogleSearchButton() {
    // clickOn(googleSearch); // .click();
    // waitABit(200);
    // return this;
    // }
    public void gotoAppPage() {

        // openAt(baseURL);
        open();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        // open("write", null);
        // System.out.println("base url = " + pages.getConfiguration().getBaseUrl());

        setDefaultBaseUrl(baseURL);
    }

    public GooglePage enterSearchKeyword(String keyword) {
        element(keywordField).waitUntilVisible();
        keywordField.sendKeys(keyword);
        return this;
    }

    public GooglePage checkResults() {
        System.out.println("output = " + searchResultText.getText());
        assert ((searchResultText.getText()).contains("Publicis.Sapient Overview | Publicis.Sapient"));
        return this;
    }
}

package demo.ui.test1.Page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppPage extends PageObject {
    protected static WebDriver driver;
    protected WebDriverWait waitDriver;

    private String baseURL = "";

    @ManagedPages
    private Pages pages;

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

    @Test
    public void gotoAppPage(WebDriver driver, String URL) {

        // openAt(baseURL);
        // System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
        // driver = new InternetExplorerDriver();
        // System.setProperty("webdriver.chrome.driver",
        // "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        // System.out.println("base url = " + pages.getConfiguration().getBaseUrl());
        // HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        // driver = new ChromeDriver();

        // driver.manage().window().maximize();
        driver.get(URL);
        System.out.println("browser title = " + driver.getTitle());
        setDefaultBaseUrl(baseURL);
    }

    public AppPage enterSearchKeyword(WebDriver driver, String keyword) {
        // element(keywordField).waitUntilVisible();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("sapient");
        driver.findElement(By.xpath("//input[@value='Google Search']")).click();

        return this;
    }

    public AppPage checkResults(WebDriver driver) {
        System.out.println("output = "
                + driver.findElement(By.xpath("//a[contains(.,'Publicis.Sapient Overview | Publicis.Sapient')]"))
                        .getText());
        WebElement searchRstText = driver.findElement(By
                .xpath("//a[contains(.,'Publicis.Sapient Overview | Publicis.Sapient')]"));
        assert ((searchRstText.getText()).contains("Publicis.Sapient Overview | Publicis.Sapient"));
        return this;
    }
}

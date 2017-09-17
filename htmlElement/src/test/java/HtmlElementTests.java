import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.should;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.timeoutHasExpired;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class HtmlElementTests {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","C:/drivers/geckodriver_17.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

    @Test
    public void fTest() {
        SalaryPage salaryPage = new SalaryPage(driver);
        SalaryResultsPage salaryResultsPage = salaryPage.open()
                .setCalcDate("04/16/2014")
                .setState("California")
                .setGrossPayAmount("20000")
                .selectExcemptFederal()
                .clickCalculateButton();
        assertThat(salaryResultsPage.getNetPayInput(), should(hasText("$346.13"))
                .whileWaitingUntil(timeoutHasExpired(300000)));
        assertThat(salaryResultsPage.getNetPayInput(), hasText("$346.13"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

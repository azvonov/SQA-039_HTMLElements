import blocks.GeneralInformation;
import blocks.SelectCalculationDateAndState;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class SalaryPage {

    WebDriver driver;
    private final String PAGE_URL = "http://www.paycheckcity.com/calculator/salary/";
    private SelectCalculationDateAndState selectCalculationDateAndState;
    private GeneralInformation generalInformation;

    @FindBy(how = How.ID, using = "calculate")
    private WebElement calculateButton;

    public SalaryPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }
    @Step
    public SalaryPage setCalcDate(String date) {
        selectCalculationDateAndState.setCalcDate(date);
        return this;
    }
    @Step
    public SalaryPage setState(String state) {
        selectCalculationDateAndState.setState(state);
        return this;
    }

    @Step
    public SalaryPage open() {
        driver.get(PAGE_URL);
        return this;
    }
    @Step
    public SalaryResultsPage clickCalculateButton() {
        calculateButton.click();
        return new SalaryResultsPage(driver);
    }
    @Step
    public SalaryPage setGrossPayAmount(String value) {
        generalInformation.setGrossPayInput(value);
        return this;
    }
    @Step
    public SalaryPage selectExcemptFederal() {
        generalInformation.selectEmptFederal();
        return this;
    }
}

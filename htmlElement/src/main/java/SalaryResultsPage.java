import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class SalaryResultsPage {
    private final String NET_PAY_RESULT_LOCATOR
            = "id(\"dijit_TitlePane_1_pane\")/ul[1]/li[1]/div[1]/span[2]";

    WebDriver driver;

    @FindBy(how = How.XPATH, using = NET_PAY_RESULT_LOCATOR)
    private WebElement netPayInput;

    public SalaryResultsPage(WebDriver driver) {
        //pure selenium PageFactory
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver,10L).until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(NET_PAY_RESULT_LOCATOR)));

    }

    public String getNetPayText(){
        return netPayInput.getText();
    }
    @Step
    public WebElement getNetPayInput() {
        return netPayInput;
    }
}
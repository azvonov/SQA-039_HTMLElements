import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.concurrent.TimeUnit;

/**
 * Created by Azvonov on 19.05.2014.
 */
public class SalaryResultsPage {
    private final String NET_PAY_RESULT_LOCATOR
            = "id(\"dijit_TitlePane_1_pane\")/ul[1]/li[1]/div[1]/span[2]";

    WebDriver driver;

    @FindBy(how = How.XPATH, using = NET_PAY_RESULT_LOCATOR)
    private WebElement netPayInput;

    public SalaryResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
//        Wait fluentWait = new FluentWait(driver)
//                .withTimeout(300, TimeUnit.SECONDS)
//                .pollingEvery(2, TimeUnit.SECONDS)
//                .ignoring(NoSuchElementException.class);
//        fluentWait.until(ExpectedConditions
//                .visibilityOfElementLocated(By.xpath(NET_PAY_RESULT_LOCATOR)));
    }

    public String getNetPayText(){
        return netPayInput.getText();
    }
    @Step
    public WebElement getNetPayInput() {
        return netPayInput;
    }
}
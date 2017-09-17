package blocks;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Azvonov on 19.05.2014.
 */

@FindBy(id = "heading")
public class SelectCalculationDateAndState extends HtmlElement {

    @FindBy(id="calcDate")
    private TextInput calcDate;

    @FindBy (id="state")
    private TextInput state;

    @FindBy(how= How.XPATH, using="id(\"calculate\")")
    private Button calculateButton;

    public SelectCalculationDateAndState setCalcDate(String date){
        calcDate.clear();
        calcDate.sendKeys(date);
        return this;
    }
    public SelectCalculationDateAndState setState(String state){
        this.state.clear();
        this.state.sendKeys(state);
        return this;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}

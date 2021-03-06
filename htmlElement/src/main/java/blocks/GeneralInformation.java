package blocks;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(id="generalInfo")
public class GeneralInformation extends HtmlElement {

    @FindBy(how = How.ID, using = "generalInformation.grossPayAmount")
    private TextInput grossPayInput;

    @FindBy(how = How.CSS, using = "input[id='generalInformation.exemptFederal1']")
    private CheckBox exemptFederal;


    public GeneralInformation setGrossPayInput(String value) {
        grossPayInput.clear();
        grossPayInput.sendKeys(value);
        return this;
    }

    public GeneralInformation selectEmptFederal(){
        exemptFederal.select();
        return this;
    }
}

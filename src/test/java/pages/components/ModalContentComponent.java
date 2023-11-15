package pages.components;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class ModalContentComponent {

    SelenideElement modal = $(".modal-content"),
            closeButton = $("#closeLargeModal"),
            Text = $("#example-modal-sizes-title-lg"),
            infoUserBody = $(".table-responsive"),
            bodyPage = $(".body-height");

    @Step("Проверка отображения модального окна")
    public ModalContentComponent checkVisible() {
        modal.should(visible);
        return this;
    }

    @Step("Проверка текста {value} успешной регистрации")
    public ModalContentComponent successFormSubmissionText(String value){
        Text.shouldHave(text(value));
        return this;
    }

    @Step("В поле {key} отображается {value}")
    public ModalContentComponent checkResult(String key, String value){
        if (!Configuration.browser.equalsIgnoreCase("firefox")) {
            infoUserBody.$(byText(key)).parent().shouldHave(text(value));
        }

        return this;
    }

    @Step("Проверка отсутствия текста {value} успешной регистрации")
    public ModalContentComponent notHaveFilledForm(String value){
        bodyPage.shouldNotHave(text(value));
        return this;
    }

    public ModalContentComponent clickCloseButton(){
        closeButton.click();
        return this;
    }

    @Step("Модальное окно с данными о регистрации не отображается")
    public ModalContentComponent checkNotBeVisible() {
        modal.should(hidden);
        return this;
    }
}

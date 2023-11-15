package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.deleteFooterAndAdd;
import io.qameta.allure.Step;

import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    String uri = "/automation-practice-form";

    CalendarComponent calendar = new CalendarComponent();
    deleteFooterAndAdd footerAndAdd = new deleteFooterAndAdd();

    SelenideElement titleLabel = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    genderWrapper = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    dateBirth = $("#dateOfBirthInput"),
                    subjectsInput =$("#subjectsInput"),
                    hobbies = $("#hobbiesWrapper"),
                    image = $("#uploadPicture"),
                    currentAddress = $("#currentAddress"),
                    state = $("#stateCity-wrapper"),
                    city = $("#stateCity-wrapper"),
                    submitButton = $("#submit");



    @Step("Открытие страницы регистрации")
    public RegistrationPage openPage(){
        open(uri);
        footerAndAdd.deleteFooterAndAdd();
        return this;
    }

    @Step("Проверка заголовка страницы")
    public RegistrationPage checkTitle(String value){
        titleLabel.shouldHave(text(value));
        return this;
    }

    @Step("Ввод имени {value} в поле 'first name'")
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Ввод фамилии {value} в поле 'last name'")
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввод почты {value} в поле 'email'")
    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбор пола {value} в поле 'gender'")
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Ввод номера {value} в поле 'number'")
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Ввод даты рождения {day} {month} {year} в поле 'birthday'")
    public RegistrationPage setDateBirth(String day, String month, String year){
        dateBirth.click();
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Выбор дисциплины {value} в поле 'subjects'")
    public RegistrationPage setSubjectsInput(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбор хобби {value} в поле 'hobbies'")
    public RegistrationPage setHobbies(String value){
        Selenide.sleep(3000);
        hobbies.$(byText(value)).click();
        return this;
    }

    @Step("Выбор фотографии {value} в поле 'image'")
    public RegistrationPage setImage(String value) {
        if (!Configuration.browser.equalsIgnoreCase("firefox")) {
            image.uploadFromClasspath(value);
        }

        return this;
    }

    @Step("Заполнение текущего адреса {value} в поле 'current address'")
    public RegistrationPage setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    }

    @Step("Выбор штата {value} в поле 'state'")
    public RegistrationPage setState(String value){
        $("#state").click();
        state.$(byText(value)).click();
        return this;
    }

    @Step("Выбор города {value} в поле 'city'")
    public RegistrationPage setCity(String value){
        $("#city").click();
        city.$(byText(value)).click();
        return this;
    }

    @Step("Нажатие на 'submit' для подтверждения регистрации")
    public RegistrationPage submit(){
        submitButton.click();
        return this;
    }
}

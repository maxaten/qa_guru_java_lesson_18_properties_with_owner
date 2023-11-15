package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalContentComponent;
import utils.custom.RandomUtils;


@Tag("registration")
public class RegistrationWithPageObjectsTests extends TestBase {


    RandomUtils genData = new RandomUtils();
    RegistrationPage registrationPage = new RegistrationPage();
    ModalContentComponent modalContentComponent = new ModalContentComponent();

    String title = "Student Registration Form";
    String successSubmissionText = "Thanks for submitting the form";


    @Test
    @DisplayName("Заполнение всех полей в форме")
    void fillFormTest(){
        registrationPage
                .openPage()
                .checkTitle(title)
                .setFirstName(genData.firstName)
                .setLastName(genData.lastName)
                .setUserEmail(genData.email)
                .setGender(genData.gender)
                .setUserNumber(genData.phoneNumber)
                .setDateBirth(genData.day, genData.month, genData.year)
                .setSubjectsInput(genData.subject1)
                .setSubjectsInput(genData.subject2)
                .setHobbies(genData.hobby)
                .setImage(genData.pathImage)
                .setCurrentAddress(genData.currentAddress)
                .setState(genData.state)
                .setCity(genData.city)
                .submit();

        modalContentComponent.checkVisible()
                        .successFormSubmissionText(successSubmissionText)
                        .checkResult("Student Name", (genData.firstName) + " " + (genData.lastName))
                        .checkResult("Student Email", genData.email)
                        .checkResult("Gender", genData.gender)
                        .checkResult("Mobile", genData.phoneNumber)
                        .checkResult("Date of Birth", genData.day + " " + genData.month + "," + genData.year)
                        .checkResult("Subjects", genData.subject1 + ", " + genData.subject2)
                        .checkResult("Hobbies", genData.hobby)
                        .checkResult("Picture", genData.nameImage)
                        .checkResult("Address", genData.currentAddress)
                        .checkResult("State and City", genData.state + " " + genData.city);
    }


    @Test
    @DisplayName("Заполнение обязательных полей")
    void fillingRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName(genData.firstName)
                .setLastName(genData.lastName)
                .setGender(genData.gender)
                .setUserNumber(genData.phoneNumber)
                .setDateBirth(genData.day, genData.month, genData.year)
                .submit();

        modalContentComponent.checkVisible()
                        .successFormSubmissionText(successSubmissionText)
                        .checkResult("Student Name", genData.firstName + " " + genData.lastName)
                        .checkResult("Gender", genData.gender)
                        .checkResult("Mobile", genData.phoneNumber)
                        .checkResult("Date of Birth", genData.day + " " + genData.month + "," + genData.year);
    }


    @Test()
    @DisplayName("Неуспешная регистрация. Заполнение пустых полей")
    void blankFieldsFormTest(){
        registrationPage.openPage()
                .setFirstName(genData.firstName)
                .submit();

        modalContentComponent.checkNotBeVisible()
                .notHaveFilledForm(successSubmissionText);
    }
}

package tretyakovgallery.project.pageObject.lavrus.tretyakov.ru;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormPage {

    // locators - not like I'm using them more than once, but let's create some variables for long names
    SelenideElement profileBtn = $("#profileBtn");
    SelenideElement hrefRegistrationClick = $(".bottom-links").$(byText("Регистрация"));
    SelenideElement emailAddress = $(".form-box > .form-input > .input-field > input");
    SelenideElement getPassword = $(".form-box .form-input:nth-child(2) > .input-field > input");
    SelenideElement getReplayPassword = $(".form-box .form-input:nth-child(3) > .input-field > input");
    SelenideElement lastName = $(".form-box .form-input:nth-child(4) > .input-field > input");
    SelenideElement firstName = $(".form-box .form-input:nth-child(5) > .input-field > input");
    SelenideElement phoneNumber = $(".form-box .form-input:nth-child(6) > .input-field > input");
    SelenideElement btnRegistration = $(".form-box").$(byText("Зарегистрироваться"));
    SelenideElement checkProfileBtn = $("#profileBtn");


    //actions
    public RegistrationFormPage openPage() {
        step("Открываем главную страницу", () -> {
            open("https://lavrus.tretyakov.ru");
            $("title").shouldHave(attribute("text", "Лаврус — просветительский проект Третьяковской галереи о русском искусстве"));
            $(".cookies").$(byText("Понятно")).click();
        });
        return this;
    }

    public RegistrationFormPage profileBtnClick() {
        step("Кликаем по иконке мой профиль, проверяем наличие  заголовка Войти на Лаврус", () -> {
        profileBtn.click();
        $("h3").shouldHave(text("Войти на Лаврус"));
        });
        return this;
    }

    public RegistrationFormPage hrefRegistrationClick() {
        step("Кликаем по ссылке регистрация, проверяем наличие заголовка регистрация", () -> {
        hrefRegistrationClick.click();
        $("h3").shouldHave(text("Регистрация"));
        });
        return this;
    }

    public RegistrationFormPage emailAddress(String value) {
        step("Вводим E-mail", () -> {
        emailAddress.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage getPassword(String value) {
        step("Вводим пароль", () -> {
        getPassword.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage getReplayPassword(String value) {
        step("Вводим повторный пароль", () -> {
        getReplayPassword.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage lastName(String value) {
        step("Вводим фамилию", () -> {
        lastName.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage firstName(String value) {
        step("Вводим имя", () -> {
        firstName.setValue(value);
        });
        return this;
    }

    public RegistrationFormPage phoneNumber(String number) {
        step("Вводим номер телефона", () -> {
        phoneNumber.setValue(number);
        });
        return this;
    }

    public RegistrationFormPage btnRegistrationClick() {
        step("Кликаем по кнопке зарегистрироваться", () -> {
        btnRegistration.shouldBe(visible).click();
        });
        return this;
    }

    public RegistrationFormPage checkProfileBtn() {
        step("Проверяем что регистрация прошла успешно", () -> {
        checkProfileBtn.shouldBe(visible);
        });
        return this;
    }


}

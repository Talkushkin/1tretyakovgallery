package tretyakovgallery.project.pageObject.my.tretyakov.ru;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegFormPage {

    // locators - not like I'm using them more than once, but let's create some variables for long names
    SelenideElement profileBtn = $(".header-right > a");
    SelenideElement hrefRegistrationClick = $(".login").$(byText("пройти регистрацию"));

    SelenideElement firstName = $(".registration-content-right input[name=name]");
    SelenideElement lastName = $(".registration-content-right").$(byText("Фамилия"));
    SelenideElement emailAddress = $(".registration-content-right").$(byText("E-mail"));

    SelenideElement getPassword = $(".registration-content-right").$(byText("Пароль"));
    SelenideElement checkBoxPolicyCLick = $("#reginstr-policy");

    SelenideElement btnRegistration = $(".registration-content-right").$(byText("зарегистрироваться"));
    SelenideElement checkProfileBtn = $(byText("Ваш текущий статус"));

    //actions
    public RegFormPage openPage() {
        step("Открываем главную страницу, проверяем title Моя Третьяковка", () -> {
            open("https://my.tretyakov.ru/app");
            $("title").shouldHave(attribute("text", "Моя Третьяковка"));
        });
        return this;
    }

    public RegFormPage profileBtnClick() {
        step("Кликаем по иконке мой профиль, проверяем наличие заголовка Вход в мою третьяковку", () -> {
        profileBtn.click();
        $("h6").shouldHave(text("Вход в Мою Третьяковку"));
        });
        return this;
    }

    public RegFormPage hrefRegistrationClick() {
        step("Кликаем по ссылке Пройти регистрацию, проверяем заголовок Стать участником", () -> {
        hrefRegistrationClick.shouldBe(visible).hover().click();
        $("h3").shouldHave(text("Стать участником"));
        });
        return this;
    }

    public RegFormPage firstName(String value) {
        step("Вводим имя", () -> {
        firstName.shouldBe(visible).sendKeys(value);
        });
        return this;
    }

    public RegFormPage lastName(String value) {
        step("Вводим фамилию", () -> {
        lastName.parent().sendKeys(value);
        });
        return this;
    }

    public RegFormPage emailAddress(String value) {
        step("Вводим E-mail", () -> {
        emailAddress.parent().sendKeys(value);
        });
        return this;
    }

    public RegFormPage getPassword(String value) {
        step("Вводим Пароль", () -> {
        getPassword.parent().sendKeys(value);
        });
        return this;
    }

    public RegFormPage checkBoxPolicyCLick() {
        step("Кликаем по чек-боксу пользовательского соглашения", () -> {
        checkBoxPolicyCLick.click();
        });
        return this;
    }

    public RegFormPage btnRegistrationClick() {
        step("Кликаем по кнопке зарегистироваться", () -> {
        btnRegistration.shouldBe(visible).click();
        });
        return this;
    }

    public RegFormPage checkProfileBtn() {
        step("Проверяем заголовок Ваш текущий статус", () -> {
        checkProfileBtn.shouldBe(visible);
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
            return this;
        });
        return this;
    }
}

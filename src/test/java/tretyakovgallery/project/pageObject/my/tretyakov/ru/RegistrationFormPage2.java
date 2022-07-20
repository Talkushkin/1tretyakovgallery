package tretyakovgallery.project.pageObject.my.tretyakov.ru;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationFormPage2 {

    // locators - not like I'm using them more than once, but let's create some variables for long names
    SelenideElement profileBtn = $(".header-right > a");
    SelenideElement hrefRegistrationClick = $(".login-bottom text-item--small text--upper > a");

    SelenideElement firstName = $(".registration-content-right .input max:nth-child(1) > input");
    SelenideElement lastName = $(".registration-content-right .input max:nth-child(2) > input");
    SelenideElement emailAddress = $(".registration-content-right .input max:nth-child(3) > input");

    SelenideElement getPassword = $(".registration-content-right .input max:nth-child(4) > input");
    SelenideElement checkBoxPolicyCLick = $("#reginstr-policy");

    SelenideElement btnRegistration = $(".registration-content-right").$(byText("Зарегистрироваться"));
    SelenideElement checkProfileBtn = $("#profileBtn");


    //actions
    public RegistrationFormPage2 openPage() {
        step("Открываем главную страницу", () -> {
            open("https://my.tretyakov.ru/app");
            $("title").shouldHave(attribute("text", "Моя Третьяковка"));
        });
        return this;
    }

    public RegistrationFormPage2 profileBtnClick() {
        profileBtn.click();
        $("h6").shouldHave(text("Вход в Мою Третьяковку"));
        return this;
    }

    public RegistrationFormPage2 hrefRegistrationClick() {
        hrefRegistrationClick.shouldBe(visible).click();
        $("h3").shouldHave(text("Стать участником"));
        return this;
    }

    public RegistrationFormPage2 firstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationFormPage2 lastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationFormPage2 emailAddress(String value) {
        emailAddress.setValue(value);
        return this;
    }

    public RegistrationFormPage2 getPassword(String value) {
        getPassword.setValue(value);
        return this;
    }

    public RegistrationFormPage2 btnRegistrationClick() {
        btnRegistration.shouldBe(visible).click();
        return this;
    }

    public RegistrationFormPage2 checkBoxPolicyCLick() {
        checkBoxPolicyCLick.click();
        return this;
    }

    public RegistrationFormPage2 checkProfileBtn() {
        checkProfileBtn.shouldBe(visible);
        return this;
    }


}

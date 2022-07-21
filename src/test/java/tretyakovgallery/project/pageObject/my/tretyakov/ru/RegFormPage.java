package tretyakovgallery.project.pageObject.my.tretyakov.ru;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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
    SelenideElement emailAddress = $(".registration-content-right .input max:nth-child(3) > input");

    SelenideElement getPassword = $(".registration-content-right .input max:nth-child(4) > input");
    SelenideElement checkBoxPolicyCLick = $("#reginstr-policy");

    SelenideElement btnRegistration = $(".registration-content-right").$(byText("Зарегистрироваться"));
    SelenideElement checkProfileBtn = $("#profileBtn");


    //actions
    public RegFormPage openPage() {
        step("Открываем главную страницу", () -> {
            open("https://my.tretyakov.ru/app");
            $("title").shouldHave(attribute("text", "Моя Третьяковка"));
        });
        return this;
    }

    public RegFormPage profileBtnClick() {
        profileBtn.click();
        $("h6").shouldHave(text("Вход в Мою Третьяковку"));
        return this;
    }

    public RegFormPage hrefRegistrationClick() {
        hrefRegistrationClick.shouldBe(visible).hover().click();
        $("h3").shouldHave(text("Стать участником"));
        return this;
    }

    public RegFormPage firstName(String value) {
        firstName.shouldBe(visible).sendKeys(value);
        return this;
    }

    public RegFormPage lastName(String value) {
        lastName.parent().sendKeys(value);
        return this;
    }

    public RegFormPage emailAddress(String value) {
        emailAddress.setValue(value);
        return this;
    }

    public RegFormPage getPassword(String value) {
        getPassword.setValue(value);
        return this;
    }

    public RegFormPage btnRegistrationClick() {
        btnRegistration.shouldBe(visible).click();
        return this;
    }

    public RegFormPage checkBoxPolicyCLick() {
        checkBoxPolicyCLick.click();
        return this;
    }

    public RegFormPage checkProfileBtn() {
        checkProfileBtn.shouldBe(visible);
        return this;
    }


}

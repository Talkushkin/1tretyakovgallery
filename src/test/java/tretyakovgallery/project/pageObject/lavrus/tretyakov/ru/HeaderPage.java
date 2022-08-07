package tretyakovgallery.project.pageObject.lavrus.tretyakov.ru;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class HeaderPage {

    SelenideElement HeaderTopLinkHrefRead = $(".header-top__menu").$(byText("Читать"));

    //actions
    public HeaderPage headerTopLinkHrefReadClick() {
        step("Кликаем по ссылке Читать, проверяем заголовок страницы h1", () -> {
            HeaderTopLinkHrefRead.click();
            $("h1").shouldBe(text("Читать"));
        });
        return this;
    }
}


package tretyakovgallery.project.pageObject.lavrus.tretyakov.ru;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class OpenPageLavrus {

    public OpenPageLavrus openPage() {
        step("Открываем главную страницу, проверяем title Лаврус — просветительский проект Третьяковской галереи о русском искусстве", () -> {
            open("https://lavrus.tretyakov.ru");
            $("title").shouldHave(attribute("text", "Лаврус — просветительский проект Третьяковской галереи о русском искусстве"));
            $(".cookies").$(byText("Понятно")).click();
        });
        return this;
    }
}

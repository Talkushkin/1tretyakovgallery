package template.project;


import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Owner("Oleg Talkushkin")
@Feature("Авторизация")
@Story("Авторизация через сторонние системы")


public class LambdaTest extends TestBase {
    // RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "Issues";
    private static final int ISSUE_NUMBER = 76;


    @Test
    @AllureId("107084")
    @Tags({@Tag("blocker"), @Tag("smoke")})
    @Severity(BLOCKER)
    @Link(name = "Ссылка", url = "https://github.com/")
    @DisplayName("1 watcher exists in Allure examples repository")
    void testGithubIssue() {

        step("Открываем главную страницу", () -> {
            open("/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим по сыслке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем на таб " + ISSUES, () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем что существует issues с номером " + ISSUE_NUMBER, () -> {
            $(withText("#76")).should(Condition.visible);
        });
    }
}


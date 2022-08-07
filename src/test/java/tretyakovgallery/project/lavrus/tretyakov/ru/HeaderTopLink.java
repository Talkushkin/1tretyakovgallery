package tretyakovgallery.project.lavrus.tretyakov.ru;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tretyakovgallery.project.TestBase;
import tretyakovgallery.project.pageObject.lavrus.tretyakov.ru.OpenPageLavrus;
import tretyakovgallery.project.pageObject.lavrus.tretyakov.ru.HeaderPage;

import static io.qameta.allure.SeverityLevel.NORMAL;


@Owner("Oleg Talkushkin")
@Epic(value = "lavrus.tretyakov.ru")
@Feature(value = "Header Top Link")
@Severity(NORMAL)
@Tag("lavrusTretyakov")
public class HeaderTopLink extends TestBase {

    OpenPageLavrus openPageLavrus = new OpenPageLavrus();
    HeaderPage headerPage = new HeaderPage();

    @Test
    @DisplayName("Successful fill lavrus header top link read test")
    void HeaderTopLinkHrefRead() {
        openPageLavrus.openPage();
        headerPage.headerTopLinkHrefReadClick();
    }
}

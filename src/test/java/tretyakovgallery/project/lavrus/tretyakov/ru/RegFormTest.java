package tretyakovgallery.project.lavrus.tretyakov.ru;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tretyakovgallery.project.TestBase;
import tretyakovgallery.project.data.Generator;
import tretyakovgallery.project.pageObject.lavrus.tretyakov.ru.OpenPageLavrus;
import tretyakovgallery.project.pageObject.lavrus.tretyakov.ru.RegistrationFormPage;


import static io.qameta.allure.SeverityLevel.CRITICAL;
import static java.lang.String.format;

@Owner("Oleg Talkushkin")
@Epic(value = "lavrus.tretyakov.ru")
@Feature(value = "Регистрация")
@Severity(CRITICAL)
@Tag("lavrusTretyakov")
public class RegFormTest extends TestBase {

    OpenPageLavrus openPageLavrus = new OpenPageLavrus();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Generator gen = new Generator();

    //generated or given parameters

    String firstName = gen.getFirstName();
    String lastName = gen.getLastName();
    String email = gen.getEmail();
    String password = gen.getPassword();
    String phoneNumber = gen.getPhoneNumber();

    //expected results
    String expectedFullName = format("%s %s", firstName, lastName);


    @Test
    @DisplayName("Successful fill lavrusTretyakov registration test")
    void execute() {
        openPageLavrus.openPage();
        registrationFormPage.profileBtnClick()
                .hrefRegistrationClick()
                .emailAddress(email)
                .getPassword(password)
                .getReplayPassword(password)
                .lastName(lastName)
                .firstName(firstName)
                .phoneNumber(phoneNumber)
                .btnRegistrationClick()
                .checkProfileBtn();
    }
}
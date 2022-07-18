package tretyakovgallery.project.lavrus.tretyakov.ru;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tretyakovgallery.project.TestBase;
import tretyakovgallery.project.data.Generator;
import tretyakovgallery.project.pageObject.lavrus.tretyakov.ru.RegistrationFormPage;


import static java.lang.String.format;


@Tag("lavrusTretyakov")
public class RegFormTest extends TestBase {
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
    @DisplayName("Successful fill registration test")
    void execute() {
        registrationFormPage.openPage()
                .profileBtnClick()
                .hrefRegistrationClick()
                .emailAddress(email)
                .getPassword(password)
                .getReplayPassword(password)
                .lastName(lastName)
                .firstName(firstName)
                .phoneNumber(phoneNumber)
                .btnRegistrationClick();
    }
}
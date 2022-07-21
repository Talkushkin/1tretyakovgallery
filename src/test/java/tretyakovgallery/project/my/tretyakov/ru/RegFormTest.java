package tretyakovgallery.project.my.tretyakov.ru;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tretyakovgallery.project.TestBase;
import tretyakovgallery.project.data.Generator;
import tretyakovgallery.project.pageObject.my.tretyakov.ru.RegFormPage;


import static java.lang.String.format;

    @Tag("myTretyakov")
    public class RegFormTest extends TestBase {

        RegFormPage registrationFormPage = new RegFormPage();
        Generator gen = new Generator();

        //generated or given parameters

        String firstName = gen.getFirstName();
        String lastName = gen.getLastName();
        String email = gen.getEmail();
        String password = gen.getPassword();

        //expected results
        String expectedFullName = format("%s %s", firstName, lastName);


        @Test
        @DisplayName("Successful fill myTretyakov registration test")
        void execute() {
            registrationFormPage.openPage()
                    .profileBtnClick()
                    .hrefRegistrationClick()
                    .firstName(firstName)
                    .lastName(lastName)
                    .emailAddress(email)
                    .getPassword(password)
                    .checkBoxPolicyCLick()
                    .btnRegistrationClick()
                    .checkProfileBtn();
        }
}

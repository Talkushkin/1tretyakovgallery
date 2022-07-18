package tretyakovgallery.project.data;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;


public class Generator {
    Faker faker = new Faker();

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPassword() {
        return faker.internet().password();
    }

    public String getGender() {
        return StringUtils.capitalize(faker.dog().gender());
    }

    public String getPhoneNumber() {
        String temp =  faker.numerify("##########");
        if ("0".equals(temp.substring(0))) {
            temp = temp.replaceFirst("0", "9");
        }
        return temp;
    }
    public String getAddress() {
        return faker.address().fullAddress();
    }


}

package tretyakovgallery.project;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.BrowserConfig;
import config.SelenoidConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;



import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
//        SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class);
       BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

//        String selenoidLogin = config.selenoidLogin();
//        String selenoidPass = config.selenoidPass();
//        String selenoidUrl = config.selenoidUrl();


//        Configuration.browser = System.getProperty("browser", browserConfig.browser());
//        Configuration.browserVersion = System.getProperty("browserVersion", browserConfig.browserVersion());
//       // Configuration.baseUrl = System.getProperty("baseUrl", browserConfig.baseUrl());
        Configuration.browserSize = System.getProperty("browserSize", browserConfig.browserSize());

        //Configuration.remote = "https://" + selenoidLogin + ":" + selenoidPass + "@" + selenoidUrl;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}

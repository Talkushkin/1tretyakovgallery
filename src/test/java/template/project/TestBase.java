package template.project;

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
        SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class);
        BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String selenoidLogin = config.selenoidLogin();
        String selenoidPass = config.selenoidPass();
        String selenoidUrl = config.selenoidUrl();

        String baseUrl = browserConfig.baseUrl();
        String browserSize = browserConfig.browserSize();
        String browserVersion = browserConfig.browserVersion();
        String browser = browserConfig.browser();


        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;

        Configuration.remote = "https://" + selenoidLogin + ":" + selenoidPass + "@" + selenoidUrl;


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

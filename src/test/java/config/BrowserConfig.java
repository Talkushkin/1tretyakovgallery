package config;

import com.codeborne.selenide.Browser;
import org.aeonbits.owner.Config;

import java.net.URL;


@Config.Sources({
        "classpath:browser.properties"
})

public interface BrowserConfig extends Config {

    @DefaultValue("1920x1080")
    String browserSize();
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("101.0")
    String browserVersion();

    String browserHoldOpen();
    String baseUrl();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}

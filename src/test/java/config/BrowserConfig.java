package config;


import org.aeonbits.owner.Config;




@Config.Sources("classpath:browser.properties")

public interface BrowserConfig extends Config {

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("100")
    String browserVersion();

    String baseUrl();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}

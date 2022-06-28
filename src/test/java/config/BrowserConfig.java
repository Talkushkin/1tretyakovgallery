package config;


import org.aeonbits.owner.Config;




@Config.Sources("classpath:browser.properties")

public interface BrowserConfig extends Config {

    String browserSize();
    String browser();
    String browserVersion();
    String baseUrl();

    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}

package config;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:selenoid.properties")

public interface SelenoidConfig extends Config {

    String selenoidLogin();
    String selenoidPass();
    String selenoidUrl();
}

package ru.lihogub.currencyrate.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "giphy")
public class GiphyProperties {
    private String apiKey;
    private String apiUrl;
}

package ru.lihogub.currencyrate.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "open-exchange")
public class OpenExchangeProperties {
    private String appId;
    private String apiUrl;
    private String baseCurrency;
}

package ru.lihogub.currencyrate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(value = "currency", url = "${open-exchange.api-url}")
public interface CurrencyClient {
    @GetMapping("/currencies.json")
    Map<String, String> findAll();
}

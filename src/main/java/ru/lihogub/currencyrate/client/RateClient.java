package ru.lihogub.currencyrate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lihogub.currencyrate.dto.ExchangeRateDto;

@FeignClient(value = "rate", url = "${open-exchange.api-url}")
public interface RateClient {
    @GetMapping("/historical/{formatDateString}.json")
    ExchangeRateDto getExchangeRate(
            @PathVariable String formatDateString,
            @RequestParam("app_id") String appId,
            @RequestParam String base
    );
}
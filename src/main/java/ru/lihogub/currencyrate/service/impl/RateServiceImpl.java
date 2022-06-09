package ru.lihogub.currencyrate.service.impl;

import org.springframework.stereotype.Service;
import ru.lihogub.currencyrate.client.RateClient;
import ru.lihogub.currencyrate.config.OpenExchangeProperties;
import ru.lihogub.currencyrate.exception.CurrencyNotFound;
import ru.lihogub.currencyrate.service.RateService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;


@Service
public class RateServiceImpl implements RateService {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final String baseCurrencyTicker;
    private final RateClient rateClient;
    private final String appId;

    public RateServiceImpl(RateClient rateClient, OpenExchangeProperties configuration) {
        this.rateClient = rateClient;
        this.appId = configuration.getAppId();
        this.baseCurrencyTicker = configuration.getBaseCurrency();
    }

    @Override
    public Double getRateAtDate(String targetCurrency, Calendar date) {
        return Optional.ofNullable(
                        rateClient
                                .getExchangeRate(formatDate(date), appId, baseCurrencyTicker)
                                .getRates()
                                .get(targetCurrency)
                )
                .orElseThrow(CurrencyNotFound::new);
    }

    private String formatDate(Calendar date) {
        return simpleDateFormat.format(date.getTime());
    }
}

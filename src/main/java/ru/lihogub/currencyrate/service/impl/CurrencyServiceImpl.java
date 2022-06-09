package ru.lihogub.currencyrate.service.impl;

import org.springframework.stereotype.Service;
import ru.lihogub.currencyrate.client.CurrencyClient;
import ru.lihogub.currencyrate.config.OpenExchangeProperties;
import ru.lihogub.currencyrate.dto.CurrencyDto;
import ru.lihogub.currencyrate.exception.CurrencyNotFound;
import ru.lihogub.currencyrate.service.CurrencyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyClient currencyClient;
    private final String baseCurrencyTicker;

    public CurrencyServiceImpl(CurrencyClient currencyClient, OpenExchangeProperties openExchangeProperties) {
        this.currencyClient = currencyClient;
        this.baseCurrencyTicker = openExchangeProperties.getBaseCurrency();
    }

    @Override
    public List<CurrencyDto> findAll() {
        return currencyClient
                .findAll()
                .entrySet()
                .stream()
                .map(entry -> {
                    CurrencyDto currency = new CurrencyDto();
                    currency.setTicker(entry.getKey());
                    currency.setDescription(entry.getValue());
                    return currency;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyDto getBaseCurrency() {
        return findAll()
                .stream()
                .filter(currencyDto -> baseCurrencyTicker.equals(currencyDto.getTicker()))
                .findFirst()
                .orElseThrow(CurrencyNotFound::new);
    }
}

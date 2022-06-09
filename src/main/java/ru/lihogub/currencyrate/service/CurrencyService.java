package ru.lihogub.currencyrate.service;

import org.springframework.stereotype.Service;
import ru.lihogub.currencyrate.dto.CurrencyDto;
import ru.lihogub.currencyrate.exception.CurrencyNotFound;

import java.util.List;

@Service
public interface CurrencyService {
    /**
     * Returns available currencies.
     *
     * @return [..., {ticker: "USD", description: "United States Dollar},...]
     * @author Oleg Lihogub
     */
    List<CurrencyDto> findAll();

    /**
     * Returns current base currency.
     *
     * @return Current base currency, e.g. {ticker: "USD", description: "United States Dollar}
     * @throws CurrencyNotFound If current base currency is invalid.
     * @author Oleg Lihogub
     */
    CurrencyDto getBaseCurrency();
}

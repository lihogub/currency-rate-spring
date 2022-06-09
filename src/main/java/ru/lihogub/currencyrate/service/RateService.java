package ru.lihogub.currencyrate.service;

import org.springframework.stereotype.Service;
import ru.lihogub.currencyrate.exception.CurrencyNotFound;

import java.util.Calendar;

@Service
public interface RateService {
    /**
     * Returns base currency to target currency exchange rate.
     *
     * @param targetCurrency Target currency ticker, e.g. "RUB".
     * @param date           Calendar, which set to the date of interest.
     * @return The exchange rate of specified currencies.
     * @throws CurrencyNotFound If specified ticker does not exist.
     * @author Oleg Lihogub
     */
    Double getRateAtDate(String targetCurrency, Calendar date);
}

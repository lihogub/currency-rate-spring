package ru.lihogub.currencyrate.service;

import ru.lihogub.currencyrate.dto.StatusDto;
import ru.lihogub.currencyrate.exception.CurrencyNotFound;

public interface StatusService {
    /**
     * Returns status by specified currency.
     *
     * @param targetCurrency Target currency ticker, e.g. "RUB".
     * @return {deltaPrice: 15.6, imgUrl: "someUrl"}
     * @throws CurrencyNotFound If specified ticker does not exist.
     * @author Oleg Lihogub
     */
    StatusDto getStatus(String targetCurrency);
}

package ru.lihogub.currencyrate.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.lihogub.currencyrate.client.CurrencyClient;
import ru.lihogub.currencyrate.dto.CurrencyDto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SpringBootTest
class CurrencyServiceImplTest {
    @Autowired
    private CurrencyServiceImpl currencyService;

    @MockBean
    private CurrencyClient currencyClient;

    @AfterEach
    void resetCurrencyClient() {
        Mockito.reset(currencyClient);
    }

    @Test
    void findAllTestOneCurrency() {
        Map<String, String> currencyMapOneEntry = new TreeMap<>();
        currencyMapOneEntry.put("USD", "United States Dollar");

        List<CurrencyDto> expectedOneEntry = List
                .of(
                        new CurrencyDto("USD", "United States Dollar")
                );

        Mockito
                .when(currencyClient.findAll())
                .thenReturn(currencyMapOneEntry);

        Assertions.assertIterableEquals(expectedOneEntry, currencyService.findAll());
    }

    @Test
    void findAllTestManyCurrency() {
        Map<String, String> currencyMapManyEntry = new TreeMap<>();
        currencyMapManyEntry.put("BYN", "Belarusian Ruble");
        currencyMapManyEntry.put("RUB", "Russian Ruble");
        currencyMapManyEntry.put("USD", "United States Dollar");

        List<CurrencyDto> expectedManyEntry = List
                .of(
                        new CurrencyDto("BYN", "Belarusian Ruble"),
                        new CurrencyDto("RUB", "Russian Ruble"),
                        new CurrencyDto("USD", "United States Dollar")
                );

        Mockito
                .when(currencyClient.findAll())
                .thenReturn(currencyMapManyEntry);

        Assertions.assertIterableEquals(expectedManyEntry, currencyService.findAll());
    }
}
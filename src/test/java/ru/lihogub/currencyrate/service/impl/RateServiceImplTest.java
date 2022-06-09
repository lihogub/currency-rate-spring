package ru.lihogub.currencyrate.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import ru.lihogub.currencyrate.client.RateClient;
import ru.lihogub.currencyrate.dto.ExchangeRateDto;

import java.util.Calendar;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(properties = {
        "open-exchange.app-id=123",
        "open-exchange.base-currency=USD",
})
class RateServiceImplTest {
    @Autowired
    private RateServiceImpl rateService;
    @MockBean
    private RateClient rateClient;

    @AfterEach
    void resetRateClient() {
        Mockito.reset(rateClient);
    }

    @Test
    void getRateForTickerTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 2);

        final String expectedFormattedDate = "2022-01-02";
        final String expectedAppId = "123";
        final String baseCurrency = "USD";

        final Double expectedRate = 60.0;
        final String targetCurrency = "RUB";

        ExchangeRateDto mapEntity = new ExchangeRateDto();
        mapEntity.setRates(Map.of(targetCurrency, expectedRate));

        Mockito
                .when(rateClient.getExchangeRate(expectedFormattedDate, expectedAppId, baseCurrency))
                .thenReturn(mapEntity);

        assertNotNull(rateService);
        Double rate = rateService.getRateAtDate(targetCurrency, calendar);

        assertEquals(expectedRate, rate);
    }
}
package ru.lihogub.currencyrate.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.lihogub.currencyrate.dto.StatusDto;
import ru.lihogub.currencyrate.service.GiphyService;
import ru.lihogub.currencyrate.service.RateService;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StatusServiceImplTest {
    @Autowired
    private StatusServiceImpl statusService;

    @MockBean
    private GiphyService giphyService;

    @MockBean
    private RateService rateService;

    @Test
    void getStatusTest() {
        final String TARGET_CURRENCY = "USD";
        final String GIF_URL = "GIF_URL";
        final double PREV_PRICE = 0.0;
        final double CURRENT_PRICE = 100.0;

        Mockito
                .when(rateService.getRateAtDate(ArgumentMatchers.any(String.class), ArgumentMatchers.any(Calendar.class)))
                .thenReturn(CURRENT_PRICE)
                .thenReturn(PREV_PRICE);

        Mockito
                .when(giphyService.getPositiveGifUrl())
                .thenReturn(GIF_URL);

        StatusDto status = statusService.getStatus(TARGET_CURRENCY);

        assertEquals(CURRENT_PRICE - PREV_PRICE, status.getDeltaPrice());
        assertEquals(GIF_URL, status.getGifUrl());
    }
}
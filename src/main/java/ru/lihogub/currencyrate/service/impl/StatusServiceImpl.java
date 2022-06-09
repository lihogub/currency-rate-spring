package ru.lihogub.currencyrate.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lihogub.currencyrate.dto.StatusDto;
import ru.lihogub.currencyrate.service.GiphyService;
import ru.lihogub.currencyrate.service.RateService;
import ru.lihogub.currencyrate.service.StatusService;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final RateService rateService;
    private final GiphyService giphyService;

    @Override
    public StatusDto getStatus(String targetCurrency) {
        Calendar currentDate = Calendar.getInstance();
        Double currentRate = rateService.getRateAtDate(targetCurrency, currentDate);

        Calendar prevDate = Calendar.getInstance();
        prevDate.add(Calendar.DAY_OF_MONTH, -1);
        Double prevRate = rateService.getRateAtDate(targetCurrency, prevDate);

        double deltaPrice = currentRate - prevRate;

        StatusDto statusDto = new StatusDto();
        statusDto.setDeltaPrice(deltaPrice);
        statusDto.setGifUrl(getImgUrlByDelta(deltaPrice));

        return statusDto;
    }

    /**
     * Returns URL to positive or negative gif according to deltaPrice
     */
    private String getImgUrlByDelta(double deltaPrice) {
        return deltaPrice >= 0 ? giphyService.getPositiveGifUrl() : giphyService.getNegativeGifUrl();
    }
}

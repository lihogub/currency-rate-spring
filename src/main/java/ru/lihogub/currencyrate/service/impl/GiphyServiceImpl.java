package ru.lihogub.currencyrate.service.impl;

import org.springframework.stereotype.Service;
import ru.lihogub.currencyrate.client.GiphyClient;
import ru.lihogub.currencyrate.config.GiphyProperties;
import ru.lihogub.currencyrate.service.GiphyService;

@Service
public class GiphyServiceImpl implements GiphyService {
    private final GiphyClient giphyClient;
    private final String apiKey;

    public GiphyServiceImpl(GiphyClient giphyClient, GiphyProperties giphyProperties) {
        this.giphyClient = giphyClient;
        this.apiKey = giphyProperties.getApiKey();
    }

    @Override
    public String getPositiveGifUrl() {
        return getUrlByTag("rich");
    }

    @Override
    public String getNegativeGifUrl() {
        return getUrlByTag("broke");
    }

    private String getUrlByTag(String tag) {
        return giphyClient
                .getRandomByTag(apiKey, tag, "r")
                .getData()
                .getImages()
                .get("fixed_width")
                .getUrl();
    }
}

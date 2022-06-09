package ru.lihogub.currencyrate.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import ru.lihogub.currencyrate.client.GiphyClient;
import ru.lihogub.currencyrate.dto.giphy.GiphyDataResponseDto;
import ru.lihogub.currencyrate.dto.giphy.GiphyImageResponseDto;
import ru.lihogub.currencyrate.dto.giphy.GiphyResponseDto;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(properties = {
        "giphy.api-key=123"
})
class GiphyServiceImplTest {
    @Autowired
    private GiphyServiceImpl giphyService;

    @MockBean
    private GiphyClient giphyClient;

    @Test
    void getPositiveGifUrlTest() {
        final String MY_URL = "my_url";
        final String POSITIVE_TAG = "rich";

        GiphyResponseDto responseDto = new GiphyResponseDto();
        GiphyDataResponseDto dataResponseDto = new GiphyDataResponseDto();
        GiphyImageResponseDto imageResponseDto = new GiphyImageResponseDto();

        responseDto.setData(dataResponseDto);

        imageResponseDto.setUrl(MY_URL);

        dataResponseDto.setImages(Map.of("fixed_width", imageResponseDto));

        Mockito
                .when(giphyClient.getRandomByTag("123", POSITIVE_TAG, "r"))
                .thenReturn(responseDto);

        assertEquals(MY_URL, giphyService.getPositiveGifUrl());
    }
}
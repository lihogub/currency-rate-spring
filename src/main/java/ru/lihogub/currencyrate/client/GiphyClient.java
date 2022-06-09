package ru.lihogub.currencyrate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lihogub.currencyrate.dto.giphy.GiphyResponseDto;


@FeignClient(value = "giphy", url = "${giphy.api-url}")
public interface GiphyClient {
    @GetMapping("/gifs/random")
    GiphyResponseDto getRandomByTag(
            @RequestParam("api_key") String apiKey,
            @RequestParam String tag,
            @RequestParam String rating
    );
}

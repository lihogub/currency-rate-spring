package ru.lihogub.currencyrate.dto.giphy;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GiphyDataResponseDto {
    private Map<String, GiphyImageResponseDto> images;
}

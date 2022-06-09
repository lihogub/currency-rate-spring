package ru.lihogub.currencyrate.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Schema(name = "ExchangeRate")
public class ExchangeRateDto {
    private Map<String, Double> rates;
}

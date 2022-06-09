package ru.lihogub.currencyrate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Currency")
public class CurrencyDto {
    @Schema(description = "Currency ticker", example = "USD")
    private String ticker;
    @Schema(description = "Currency description", example = "United States Dollar")
    private String description;
}

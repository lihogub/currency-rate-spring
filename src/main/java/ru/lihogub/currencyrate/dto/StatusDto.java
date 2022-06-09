package ru.lihogub.currencyrate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Status")
public class StatusDto {
    @Schema(description = "Difference between today and yesterday exchange rate", example = "2.6")
    Double deltaPrice;
    @Schema(description = "Gif URL", example = "https://domain.com/mygif.gif")
    String gifUrl;
}

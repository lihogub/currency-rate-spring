package ru.lihogub.currencyrate.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.lihogub.currencyrate.dto.StatusDto;
import ru.lihogub.currencyrate.service.StatusService;

@RestController
@Tag(name = "Status")
@RequiredArgsConstructor
@RequestMapping("/api")
public class StatusController {
    private final StatusService statusService;

    @GetMapping("/status/{currencyTicker}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Returns status of specified currency ticker")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Ticker does not exist")
    StatusDto getStatusByCurrencyTicker(@PathVariable String currencyTicker) {
        return statusService.getStatus(currencyTicker);
    }
}

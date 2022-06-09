package ru.lihogub.currencyrate.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.lihogub.currencyrate.dto.CurrencyDto;
import ru.lihogub.currencyrate.service.CurrencyService;

import java.util.List;


@RestController
@Tag(name = "Currency")
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("/currencies")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Returns all currencies")
    List<CurrencyDto> getAllCurrencies() {
        return currencyService.findAll();
    }

    @GetMapping("/currencies/base")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Returns current base currency")
    CurrencyDto getBaseCurrency() {
        return currencyService.getBaseCurrency();
    }
}

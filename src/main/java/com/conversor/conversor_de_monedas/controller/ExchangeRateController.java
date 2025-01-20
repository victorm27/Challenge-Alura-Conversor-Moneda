package com.conversor.conversor_de_monedas.controller;

import com.conversor.conversor_de_monedas.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/convert")
    public String convertCurrency(@RequestParam String baseCurrency,
                                  @RequestParam String targetCurrency,
                                  @RequestParam double amount) {
        double convertedAmount = exchangeRateService.convertCurrency(baseCurrency, targetCurrency, amount);

        // Convertir el resultado de double a String
        return amount + " " + baseCurrency + " es igual a " + String.valueOf(convertedAmount) + " " + targetCurrency;
    }
}

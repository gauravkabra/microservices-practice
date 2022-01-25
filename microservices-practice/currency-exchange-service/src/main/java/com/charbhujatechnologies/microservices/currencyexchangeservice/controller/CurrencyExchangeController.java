package com.charbhujatechnologies.microservices.currencyexchangeservice.controller;

import com.charbhujatechnologies.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.charbhujatechnologies.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        // CurrencyExchange currencyExchange = new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(65));

        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }
        return currencyExchange;
    }
}

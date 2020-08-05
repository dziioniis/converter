package com.chat.demo.service.impl;

import com.chat.demo.entity.Currency;
import com.chat.demo.entity.Exchange;
import com.chat.demo.repository.ExchangeRepository;
import com.chat.demo.service.CurrencyService;
import com.chat.demo.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private CurrencyService currencyService;

    @Override
    public double saveExchange(Exchange exchange) {
        boolean refreshCurrencies= currencyService.checkCurrentValueOfCurrencies();
        if(refreshCurrencies){
        currencyService.updateValueOfCurrencies();
        }
        Currency initCurrency= currencyService.findCurrencyByName(exchange.getInitialCurrencyName());
        Currency gettingCurrencny= currencyService.findCurrencyByName(exchange.getGettingCurrencyName());
        exchange.setValueOfInitialCurrency(initCurrency.getValue());
        double sumOfConverting=initCurrency.getValue()/gettingCurrencny.getValue()*exchange.getCount();
        exchange.setSumOfConverting(sumOfConverting);
        exchangeRepository.save(exchange);
        return sumOfConverting;
    }


    @Override
    public Iterable<Exchange> getAllExchanges() {
        return exchangeRepository.findAll();
    }
}

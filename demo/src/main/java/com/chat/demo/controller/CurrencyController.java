package com.chat.demo.controller;

import com.chat.demo.Utils.HTMLUtils;
import com.chat.demo.entity.Currency;
import com.chat.demo.service.CurrencyService;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;


    @GetMapping("/getCurrencies")
    public Iterable<Currency> getCurrencies(){
    return currencyService.getCurrencies();
    }


    @GetMapping("/getCurrenciesNames")
    public Iterable<String> getCurrencyNames(){
        return currencyService.getCurrenciesNames();
    }

}

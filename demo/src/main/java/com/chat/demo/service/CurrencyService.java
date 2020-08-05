package com.chat.demo.service;

import com.chat.demo.entity.Currency;
import org.jsoup.select.Elements;

public interface CurrencyService {
    void saveCurrency(Currency currency);
    Currency createCurrency (Elements elements);
    Iterable<Currency> getCurrencies();
    Iterable<String> getCurrenciesNames();
    void updateValueOfCurrencies();
    Currency findCurrencyByName(String name);
    boolean checkCurrentValueOfCurrencies();
}

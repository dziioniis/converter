package com.chat.demo.service;

import com.chat.demo.entity.Currency;
import com.chat.demo.entity.Exchange;

public interface ExchangeService {
    double saveExchange(Exchange exchange);
    Iterable<Exchange> getAllExchanges();

}

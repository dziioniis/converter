package com.chat.demo.controller;

import com.chat.demo.entity.Exchange;
import com.chat.demo.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;
    @PostMapping("/saveExchange")
    public double saveExchange(@RequestBody Exchange exchange){
       return exchangeService.saveExchange(exchange);
    }
    @GetMapping("/getExchanges")
    public Iterable<Exchange> getExchanges(){
        return exchangeService.getAllExchanges();
    }
}

package com.chat.demo.service.impl;

import com.chat.demo.Utils.HTMLUtils;
import com.chat.demo.entity.Currency;
import com.chat.demo.entity.User;
import com.chat.demo.repository.CurrencyRepository;
import com.chat.demo.service.CurrencyService;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Value("${url}")
    private String url;
    @Override
    public void saveCurrency(Currency currency) {
    currencyRepository.save(currency);
    }

    @Override
    public Currency createCurrency(Elements elements) {
        List<Currency> currencies=new ArrayList<>();
        Currency currency = null;
        for (Element element : elements) {
            switch (element.tagName()) {
                case "Valute":
                    currency = new Currency();
                    break;

                case "NumCode":
                    currency.setNumCode(Integer.parseInt(element.text()));
                    break;

                case "CharCode":
                    currency.setCharCode(element.text());
                    break;

                case "Nominal":
                    currency.setNominal(Integer.parseInt(element.text()));
                    break;

                case "Name":
                    currency.setName(element.text());
                    break;
                case "Value":
                    String str= element.text().replace(',','.');
                    currency.setValue(Double.parseDouble(str));
                    saveCurrency(currency);
                    break;
            }
        }
            return null;
        }

    @Override
    public Iterable<Currency> getCurrencies() {
        return currencyRepository.findAll();

    }

    @Override
    public Iterable<String> getCurrenciesNames() {
        if(checkCurrentValueOfCurrencies()!=true) {
        createCurrency(HTMLUtils.parseHTML(url));}
        return currencyRepository.findAllNames();
    }

    @Override
    public void updateValueOfCurrencies() {
        String name=null;
        Double value=null;
       Elements elements= HTMLUtils.parseHTML(url);
        for (Element element : elements) {
            switch (element.tagName()) {
                case "Name":
                    name=element.text();
                    break;
                case "Value":
                    String str= element.text().replace(',','.');
                    value=Double.parseDouble(str);
                    currencyRepository.updateValueOfCurrency(value,name);
                    break;
            }
        }
    }

    @Override
    public Currency findCurrencyByName(String name) {
        return currencyRepository.findByName(name);
    }

    @Override
    public boolean checkCurrentValueOfCurrencies() {
        Elements elements= HTMLUtils.parseHTML(url);
        Element element=elements.first();
        Date date = new Date();
        SimpleDateFormat dateFor = new SimpleDateFormat("dd.MM.yyyy");
        String stringDate= dateFor.format(date);
        return  element.attr("Date").equals(stringDate);

    }
}


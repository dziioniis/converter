package com.chat.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="exchange")
public class Exchange {
    private String initialCurrencyName;
    private double valueOfInitialCurrency;
    private int count;
    private String gettingCurrencyName;
    private double sumOfConverting;
    private String data;

    @Override
    public String toString() {
        return "Exchange{" +
                "initialCurrencyName='" + initialCurrencyName + '\'' +
                ", valueOfInitialCurrency=" + valueOfInitialCurrency +
                ", count=" + count +
                ", gettingCurrencyName='" + gettingCurrencyName + '\'' +
                ", sumOfConverting=" + sumOfConverting +
                ", data='" + data + '\'' +
                ", id=" + id +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInitialCurrencyName() {
        return initialCurrencyName;
    }

    public void setInitialCurrencyName(String initialCurrencyName) {
        this.initialCurrencyName = initialCurrencyName;
    }

    public double getValueOfInitialCurrency() {
        return valueOfInitialCurrency;
    }

    public void setValueOfInitialCurrency(double valueOfInitialCurrency) {
        this.valueOfInitialCurrency = valueOfInitialCurrency;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getGettingCurrencyName() {
        return gettingCurrencyName;
    }

    public void setGettingCurrencyName(String gettingCurrencyName) {
        this.gettingCurrencyName = gettingCurrencyName;
    }

    public double getSumOfConverting() {
        return sumOfConverting;
    }

    public void setSumOfConverting(double sumOfConverting) {
        this.sumOfConverting = sumOfConverting;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
